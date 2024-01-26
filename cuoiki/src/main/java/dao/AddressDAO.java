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
        query = "insert into address(user_id, first_name, last_name, address, method_payment, email, contact) values" +
                " (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,d.getUserId());
            ps.setString(2,d.getFirstName());
            ps.setString(3,d.getLastName());
            ps.setString(4,d.getAddress());
            ps.setString(5,d.getPaymentMethod());
            ps.setString(6,d.getEmail());
            ps.setString(7,d.getContact());

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
                ps.setInt(1,a.getUserId());
                ps.setString(2,a.getFirstName());
                ps.setString(3,a.getLastName());
                ps.setString(4,a.getAddress());
                ps.setString(5,a.getPaymentMethod());
                ps.setString(6,a.getEmail());
                ps.setString(7,a.getContact());
                list.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Address getAddressByUserId(int id) {
        Address a=null;
        query = "select * from address where user_id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            rs= ps.executeQuery();
            while(rs.next()) {
                a = new Address();
                a.setUserId(rs.getInt(1));
                a.setFirstName(rs.getString(2));
                a.setLastName(rs.getString(3));
                a.setAddress(rs.getString(4));
                a.setPaymentMethod(rs.getString(5));
                a.setEmail(rs.getString(6));
                a.setContact(rs.getString(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
}
