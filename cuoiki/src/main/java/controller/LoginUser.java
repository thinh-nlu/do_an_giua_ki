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

@WebServlet("/login")
public class LoginUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name").trim();
        String password = req.getParameter("password").trim();

        UserDAO dao = new UserDAO(DBConnect.getConnection());
        User user = dao.getUserByUsername(username);
        String passwordHashFromDB = user.getPassword();
        String passwordHash = hashPassword(password);
        HttpSession session = req.getSession();
        if (user == null) {
            session.setAttribute("failed","Tài khoản không tồn tại");
            resp.sendRedirect("account/login.jsp");
        } else if (!passwordHash.equals(passwordHashFromDB)) {
            session.setAttribute("failed","Mật khẩu không chính xác");
            resp.sendRedirect("account/login.jsp");
        } else {
            session.setAttribute("success",user);
            resp.sendRedirect("index.jsp");
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
