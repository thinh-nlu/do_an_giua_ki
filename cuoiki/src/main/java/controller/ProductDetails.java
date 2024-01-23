package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;


import dao.ProductDAO;
import database.DBConnect;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/product-details")
public class ProductDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        ProductDAO productDAO = new ProductDAO(DBConnect.getConnection());
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("product", productDAO.getProductById(id));
        request.getRequestDispatcher("/shop-detail.jsp").forward(request, response);
    }



}
