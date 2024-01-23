package controller;

import dao.FeedbackDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;


import dao.ProductDAO;
import database.DBConnect;
import model.Feedback;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/product-detail")
public class ProductDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO(DBConnect.getConnection());
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("product", productDAO.getProductById(id));
        request.getRequestDispatcher("/shop-detail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("feedback")) {
            doPost_Feedback(request, response);
        }
    }

    protected void doPost_Feedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        int id = Integer.parseInt(request.getParameter("id"));
        FeedbackDAO feedbackDAO = new FeedbackDAO(DBConnect.getConnection());
        Feedback feedback = new Feedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setMessage(message);
        feedback.setCreated(new Timestamp(id));
        feedback.setProductID(id);
        if(feedbackDAO.addFeedback(feedback)) {
            request.getSession().setAttribute("msgFeedback", "Cảm ơn quý khách đã đóng góp ý kiến. Chúc quý khách 1 ngày tốt lành.");
            response.sendRedirect("product-details?id=" + id);
        } else {
            request.getSession().setAttribute("msgFeedback", "Để lại bình luận không thành công.");
            response.sendRedirect("product-details?id=" + id);
        }


    }



}
