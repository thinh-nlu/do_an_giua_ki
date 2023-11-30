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
import java.sql.Timestamp;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePass = req.getParameter("re_pass");
        String contact = req.getParameter("contact");

        User user = new User(username,email,password,contact,"1");
        System.out.println(user);
        HttpSession session = req.getSession();
        UserDAO dao = new UserDAO(DBConnect.getConnection());
        if (password.length() <= 7) {
            session.setAttribute("failed","Vui lòng nhập mật khẩu có ít nhất 8 kí tự");
            resp.sendRedirect("account/registration.jsp");
        } else if (!password.equals(rePass)) {
            session.setAttribute("failed","Mật khẩu không trùng khớp");
            resp.sendRedirect("account/registration.jsp");
        } else {
            boolean isAdd = dao.registerUser(user);
            if (isAdd) {
                session.setAttribute("success","Đăng kí thành công");
                resp.sendRedirect("account/registration.jsp");
            } else {
                session.setAttribute("failed","Hệ thống đang gặp lỗi vui lòng thử lại sau");
                resp.sendRedirect("account/registration.jsp");
            }
        }
    }
}
