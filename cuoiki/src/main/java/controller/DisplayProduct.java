package controller;

import dao.ProductDAO;
import database.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet("/list-products")
public class DisplayProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("admin/list-products.jsp").forward(req,resp);
        ProductDAO dao = new ProductDAO(DBConnect.getConnection());
        List<Product> list = dao.getAllProduct();
        req.setAttribute("list",list);
    }
}
