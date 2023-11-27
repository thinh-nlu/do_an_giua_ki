package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    private String query = "";
    private PreparedStatement ps;
    private Connection con;

    public ProductDAO(Connection con) {
        this.con = con;
    }

    public boolean addProduct(Product p) {
        boolean isAdd = false;
        query = "insert into products(title,image,price,unit,categoryId,keyword,status,insertDate,quantity) " +
                "values(?,?,?,?,?,?,?,NOW(),?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,p.getTitle());
            ps.setString(2,p.getImage());
            ps.setString(3,p.getUnit());
            ps.setString(4,p.getUnit());
            ps.setString(5,p.getCategoryId());
            ps.setString(6,p.getKeyword());
            ps.setString(7,p.getStatus());
            ps.setString(9,p.getQuantity());
            int i = ps.executeUpdate();

            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }
}
