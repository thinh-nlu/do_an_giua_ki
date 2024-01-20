package dao;

import model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDAO {
    private String query = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection con;

    public OrderDetailDAO(Connection con) {
        this.con = con;
    }

    public boolean insertToOrderDetail(OrderDetail o) {
        boolean isAdd = false;
        query = "insert into order_detail(order_id, product_id) value (?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,o.getOrderId());
            ps.setInt(2,o.getproductId());
            int i = ps.executeUpdate();
            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd;
    }
}
