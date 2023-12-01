package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    private String query = "";
    private PreparedStatement ps;
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
}
