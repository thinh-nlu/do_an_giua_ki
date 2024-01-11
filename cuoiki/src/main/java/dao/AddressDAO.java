package dao;

import model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO {
    private String query = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;

    public AddressDAO(Connection con) {
        this.con = con;
    }

    public boolean insertToAddress(Address d) {
        boolean isAdd = false;
        query = "insert into address(user_id, first_name, last_name, address, method_payment, email, save_info, contact) values" +
                " (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,d.getUserId());
            ps.setString(2,d.getFirstName());
            ps.setString(3,d.getLastName());
            ps.setString(4,d.getAddress());
            ps.setString(5,d.getPaymentMethod());
            ps.setString(6,d.getEmail());
            ps.setString(7, d.getSaveInfo());
            ps.setString(8,d.getContact());

            int i = ps.executeUpdate();
            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd;
    }
}
