package dao;

import database.DBConnect;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String query = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;

    public ProductDAO(Connection con) {
        this.con = con;
    }

    public boolean addProduct(Product p) {
        boolean isAdd = false;
        query = "insert into products(title,image,price,unit,categoryId,keyword,status,insertDate,quantity,unitPrice) " +
                "values(?,?,?,?,?,?,?,NOW(),?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,p.getTitle());
            ps.setString(2,p.getImage());
            ps.setString(3,p.getPrice());
            ps.setString(4,p.getUnit());
            ps.setString(5,p.getCategoryId());
            ps.setString(6,p.getKeyword());
            ps.setString(7,p.getStatus());
            ps.setString(8,p.getQuantity());
            ps.setString(9,p.getUnitPrice());
            int i = ps.executeUpdate();

            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        Product p = null;
        query = "select * from products";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                p = new Product();
                p.setId(rs.getInt(1));
                p.setTitle(rs.getString(2));
                p.setImage(rs.getString(3));
                p.setPrice(rs.getString(4));
                p.setUnit(rs.getString(5));
                p.setCategoryId(rs.getString(6));
                p.setKeyword(rs.getString(7));
                p.setStatus(rs.getString(8));
                p.setDateInsert(rs.getTimestamp(9));
                p.setQuantity(rs.getString(10));
                p.setUnitPrice(rs.getString(11));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO(DBConnect.getConnection());
        List<Product> list = dao.getAllProduct();
        System.out.println(list);
    }
}
