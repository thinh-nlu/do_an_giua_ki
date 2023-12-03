package dao;

import database.DBConnect;
import model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private String query = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public boolean registerUser(User user) {
        boolean isAdd = false;
        query = "insert into users(username,email,password,contact,isAdmin,date) values (?,?,?,?,?,NOW())";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getContact());
            ps.setString(5,user.getIsAdmin());

            int i = ps.executeUpdate();
            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public User getUserByUsername(String username) {
        User user = new User();
        query = "select * from users where username = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setContact(rs.getString(5));
                user.setIsAdmin(rs.getString(6));
                user.setTimestamp(rs.getTimestamp(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
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

    public static void main(String[] args) {
        UserDAO dao = new UserDAO(DBConnect.getConnection());
        User user = dao.getUserByUsername("a");
        System.out.println(user);
    }
}
