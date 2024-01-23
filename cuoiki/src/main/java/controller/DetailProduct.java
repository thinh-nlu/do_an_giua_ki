package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


import dao.ProductDAO;
import database.DBConnect;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/product-detail")
public class DetailProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailProduct() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        ProductDAO productDAO = new ProductDAO(DBConnect.getConnection());
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("productDetail", productDAO.getProductById(id));
        response.sendRedirect("shop-detail.jsp");
    }



}
