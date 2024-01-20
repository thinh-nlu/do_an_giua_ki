package dao;

import database.DBConnect;
import model.OrderDetail;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        query = "insert into order_detail(order_id, product_id, quantity) value (?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,o.getOrderId());
            ps.setInt(2,o.getproductId());
            ps.setInt(3,o.getQuantity());
            int i = ps.executeUpdate();
            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd;
    }

    public List<OrderDetail> getDetailOfOrder(int orderId) {
        List<OrderDetail> list = new ArrayList<>();
        OrderDetail orderDetail;
        query = "select * from order_detail od where od.order_id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,orderId);
            rs = ps.executeQuery();
            while(rs.next()) {
                orderDetail = new OrderDetail();
                orderDetail.setId(rs.getInt(1));
                orderDetail.setOrderId(rs.getInt(2));
                orderDetail.setProductId(rs.getInt(3));
                orderDetail.setQuantity(rs.getInt(4));
                list.add(orderDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void main(String[] args) {
        OrderDetailDAO dao = new OrderDetailDAO(DBConnect.getConnection());
        List<OrderDetail> orderDetails =  dao.getDetailOfOrder(2);
        System.out.println(orderDetails);
    }
}
