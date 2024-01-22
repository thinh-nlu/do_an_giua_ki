package dao;

import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private String query = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection con;

    public OrderDAO(Connection con) {
        this.con = con;
    }

    public boolean insertOrder(Order o) {
        boolean isAdd = false;
        query = "insert into orders(user_id, invoice_number, amount_due, order_date, order_status) " +
                "value(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,o.getUserId());
            ps.setString(2,o.getInvoiceNumber());
            ps.setString(3,o.getAmountDue());
            ps.setTimestamp(4,o.getOrderDate());
            ps.setString(5,o.getOrderStatus());
            int i = ps.executeUpdate();
            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd;
    }

    public Order getOrderByInvoiceNumber(String invoiceNumber) {
        Order o = null;
        query = "select * from orders where invoice_number = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,invoiceNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                o = new Order();
                o.setId(rs.getInt(1));
                o.setUserId(rs.getInt(2));
                o.setInvoiceNumber(rs.getString(3));
                o.setAmountDue(rs.getString(4));
                o.setOrderDate(rs.getTimestamp(5));
                o.setOrderStatus(rs.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    public Order getOrderById(int id) {
        Order o = null;
        query = "select * from orders where id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                o = new Order();
                o.setId(rs.getInt(1));
                o.setUserId(rs.getInt(2));
                o.setInvoiceNumber(rs.getString(3));
                o.setAmountDue(rs.getString(4));
                o.setOrderDate(rs.getTimestamp(5));
                o.setOrderStatus(rs.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    public boolean updateStatus(int orderId) {
        boolean isUpdate = false;
        query = "update orders set order_status = ? where id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,"complete");
            ps.setInt(2,orderId);
            int i = ps.executeUpdate();
            isUpdate = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUpdate;
    }

    public List<Order> getListOrderByUser(int userId) {
        List<Order> list = new ArrayList<>();
        Order o;
        query = "select * from orders where user_id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            while(rs.next()) {
                o = new Order();
                o.setId(rs.getInt(1));
                o.setUserId(rs.getInt(2));
                o.setInvoiceNumber(rs.getString(3));
                o.setAmountDue(rs.getString(4));
                o.setOrderDate(rs.getTimestamp(5));
                o.setOrderStatus(rs.getString(6));
                list.add(o);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}