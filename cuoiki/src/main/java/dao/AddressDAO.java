package dao;

import model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    private String query = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection con;

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

    public List<Address> getAllAddress() {
        List<Address> list = new ArrayList<>();
        Address a;
        query = "select * from address";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                a = new Address();
                a.setId(rs.getInt(1));
                a.setUserId(rs.getInt(2));
                a.setFirstName(rs.getString(3));
                a.setLastName(rs.getString(4));
                a.setAddress(rs.getString(5));
                a.setPaymentMethod(rs.getString(6));
                a.setEmail(rs.getString(7));
                a.setSaveInfo(rs.getString(8));
                a.setContact(rs.getString(9));
                list.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public boolean updateAddress(Address d) {
        boolean isUpdate = false;
        query = "UPDATE address SET first_name = ?, last_name = ?, address = ?, method_payment = ?, email = ?, save_info = ?, contact = ? WHERE user_id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,d.getFirstName());
            ps.setString(2,d.getLastName());
            ps.setString(3,d.getAddress());
            ps.setString(4,d.getPaymentMethod());
            ps.setString(5,d.getEmail());
            ps.setString(6,d.getSaveInfo());
            ps.setString(7,d.getContact());
            ps.setInt(8,d.getUserId());

            int i = ps.executeUpdate();
            isUpdate = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUpdate;
    }
}