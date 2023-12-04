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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("name").trim();
        String email = req.getParameter("email");
        String password = req.getParameter("password").trim();
        String rePass = req.getParameter("re_pass").trim();
        String contact = req.getParameter("contact").trim();
        String hashPassword = hashPassword(password);

        User user = new User(username,email,hashPassword,contact,"1");
        System.out.println(user);
        HttpSession session = req.getSession();
        UserDAO dao = new UserDAO(DBConnect.getConnection());
        if (password.length() <= 7) {
            session.setAttribute("failedRegister","Vui lòng nhập mật khẩu có ít nhất 8 kí tự");
            resp.sendRedirect("account/registration.jsp");
        } else if (!password.equals(rePass)) {
            session.setAttribute("failedRegister","Mật khẩu không trùng khớp");
            resp.sendRedirect("account/registration.jsp");
        } else {
            boolean isAdd = dao.registerUser(user);
            if (isAdd) {
                session.setAttribute("successRegister","Đăng kí thành công");
                resp.sendRedirect("account/registration.jsp");
            } else {
                session.setAttribute("failedRegister","Hệ thống đang gặp lỗi vui lòng thử lại sau");
                resp.sendRedirect("account/registration.jsp");
            }
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ nếu cần thiết
        }
        return null;
    }
}
