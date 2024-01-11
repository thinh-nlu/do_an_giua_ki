package dao;

import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
