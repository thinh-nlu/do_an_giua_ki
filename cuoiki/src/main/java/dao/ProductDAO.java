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
    private final Connection con;

    public ProductDAO(Connection con) {
        this.con = con;
    }

    public boolean addProduct(Product p) {
        boolean isAdd = false;
        query = "insert into products(title,image,price,unit,categoryId,keyword,status,insertDate,quantity,unitPrice,descrip) " +
                "values(?,?,?,?,?,?,?,NOW(),?,?,?)";
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
            ps.setString(10,p.getDescription());
            int i = ps.executeUpdate();

            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public List<Product> searchProduct(String title) {
        List<Product> list = new ArrayList<>();
        Product p;
        query = "SELECT id, title, image, price, unit, category_id, keyword, status, date_insert, quantity, unit_price, description FROM products WHERE title LIKE ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + title + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getString("price"));
                p.setUnit(rs.getString("unit"));
                p.setCategoryId(rs.getString("category_id"));
                p.setKeyword(rs.getString("keyword"));
                p.setStatus(rs.getString("status"));
                p.setDateInsert(rs.getTimestamp("date_insert"));
                p.setQuantity(rs.getString("quantity"));
                p.setUnitPrice(rs.getString("unit_price"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        Product p = null;
        query = "SELECT id, title, image, price, unit, category_id, keyword, status, date_insert, quantity, unit_price, description FROM products";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getString("price"));
                p.setUnit(rs.getString("unit"));
                p.setCategoryId(rs.getString("category_id"));
                p.setKeyword(rs.getString("keyword"));
                p.setStatus(rs.getString("status"));
                p.setDateInsert(rs.getTimestamp("date_insert"));
                p.setQuantity(rs.getString("quantity"));
                p.setUnitPrice(rs.getString("unit_price"));
                p.setDescription(rs.getString("description"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getRecords(int start, int total) {
        List<Product> products = new ArrayList<>();
        Product p = null;
        query = "SELECT id, title, image, price, unit, category_id, keyword, status, date_insert, quantity, unit_price, description FROM products LIMIT ?, ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, start - 1);
            ps.setInt(2, total);
            rs = ps.executeQuery();
            while (rs.next()){
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getString("price"));
                p.setUnit(rs.getString("unit"));
                p.setCategoryId(rs.getString("category_id"));
                p.setKeyword(rs.getString("keyword"));
                p.setStatus(rs.getString("status"));
                p.setDateInsert(rs.getTimestamp("date_insert"));
                p.setQuantity(rs.getString("quantity"));
                p.setUnitPrice(rs.getString("unit_price"));
                p.setDescription(rs.getString("description"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


    public Product getProductById(int id) {
        Product product = null;
        query = "SELECT id, title, image, price, unit, category_id, keyword, status, date_insert, quantity, unit_price, description FROM products WHERE id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setImage(rs.getString("image"));
                product.setPrice(rs.getString("price"));
                product.setUnit(rs.getString("unit"));
                product.setCategoryId(rs.getString("category_id"));
                product.setKeyword(rs.getString("keyword"));
                product.setStatus(rs.getString("status"));
                product.setDateInsert(rs.getTimestamp("date_insert"));
                product.setQuantity(rs.getString("quantity"));
                product.setUnitPrice(rs.getString("unit_price"));
                product.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }


    public boolean updateProduct(Product p) {
        boolean isUpdate = false;
        query = "UPDATE products SET title = ?, price = ?, unit = ?, categoryId = ?, keyword = ?, quantity = ?, unitPrice = ?, descrip = ? WHERE id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,p.getTitle());
            ps.setString(2,p.getPrice());
            ps.setString(3,p.getUnit());
            ps.setString(4,p.getCategoryId());
            ps.setString(5,p.getKeyword());
            ps.setString(6,p.getQuantity());
            ps.setString(7,p.getUnitPrice());
            ps.setString(8,p.getDescription());
            ps.setInt(9,p.getId());
            int i = ps.executeUpdate();
            isUpdate = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUpdate;
    }

    public boolean deleteProduct(int id) {
        boolean isDelete = false;
        query = "delete from products where id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            isDelete = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }
    public List<Product> getProductsByCategory(String categoryId) {
        List<Product> products = new ArrayList<>();
        query = "SELECT id, title, image, price, unit, category_id, keyword, status, date_insert, quantity, unit_price, description FROM products WHERE category_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setTitle(rs.getString("title"));
                    product.setImage(rs.getString("image"));
                    product.setPrice(rs.getString("price"));
                    product.setUnit(rs.getString("unit"));
                    product.setCategoryId(rs.getString("category_id"));
                    product.setKeyword(rs.getString("keyword"));
                    product.setStatus(rs.getString("status"));
                    product.setDateInsert(rs.getTimestamp("date_insert"));
                    product.setQuantity(rs.getString("quantity"));
                    product.setUnitPrice(rs.getString("unit_price"));
                    product.setDescription(rs.getString("description"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO(DBConnect.getConnection());
        List<Product> list = dao.searchProduct("bac ha");
        System.out.println(list);
    }

    public boolean updateQuantity(Product product, int quantity) {
        boolean isUpdate = false;
        query = "update products set quantity = ? where id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(product.getQuantity()) - quantity);
            ps.setInt(2,product.getId());
            int i = ps.executeUpdate();
            isUpdate = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUpdate;
    }
    public int CountProducts() {
        int rowCount = 0;
        query = "select count(*) from products";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowCount;
    }
}
