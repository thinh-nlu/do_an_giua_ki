package controller;

        import dao.UserDAO;
        import database.DBConnect;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        import jakarta.servlet.http.HttpSession;
        import model.User;

        import java.io.IOException;


@WebServlet("/updateAccount")
public class UpdateAccount extends HttpServlet {

    UserDAO dao = new UserDAO(DBConnect.getConnection());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        String email = req.getParameter("email");
        HttpSession session = req.getSession();

        if (name == null || name.isEmpty() || contact == null || contact.isEmpty() || email == null || email.isEmpty()) {

            session.setAttribute("failedUpdateAccount", "Vui lòng nhập đầy đủ thông tin");
            resp.sendRedirect("tien_ich/my-account.jsp");
            return;
        }

        User u = dao.getUserById(id);

        if (u.getName().equals(name) && u.getContact().equals(contact)
                && u.getEmail().equals(email)) {
            session.setAttribute("failedUpdateAccount", "Chưa có dữ liệu nào được cập nhật");
            session.removeAttribute("successUpdateAccount");
            resp.sendRedirect("tien_ich/my-account.jsp");
            return;
        }else {
            u.setName(name);
            u.setEmail(email);
            u.setContact(contact);
        }



        if (checkChangingUser(u, id)) {
            boolean isUpdate = dao.updateUser(u);
            if (isUpdate) {
                session.setAttribute("successUpdateAccount", "Cập nhật thông tin thành công");
                session.setAttribute("success", u);
                session.removeAttribute("failedUpdateAccount");
                resp.sendRedirect("tien_ich/my-account.jsp");
            } else {
                session.setAttribute("failedUpdateAccount", "Cập nhật thông tin thất bại");
                resp.sendRedirect("tien_ich/my-account.jsp");
            }
        }
    }

    private boolean checkChangingUser(User u, int id) {
        User user = dao.getUserById(id);
        if(!user.equals(u)) return true;
        return false;
    }
}


