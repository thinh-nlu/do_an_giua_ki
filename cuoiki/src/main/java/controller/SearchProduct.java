package controller;

import dao.ProductDAO;
import dao.UserDAO;
import database.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/searchProduct")
public class SearchProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        ProductDAO dao = new ProductDAO(DBConnect.getConnection());
        List<Product> products = dao.getAllProduct();
        List<Product> display = new ArrayList<>();
        HttpSession session = req.getSession();
        boolean found = false;
        if (!products.isEmpty()) {
            for (Product p : products) {
                String[] keywordArr = p.getKeyword().split(",");
                if (Arrays.asList(keywordArr).contains(keyword)) {
                    display.add(p);
                    found = true;
                }
            }
        }
        if(!found) {
            session.setAttribute("searchListFailed", "Không tìm thấy sản phẩm");
        } else {
            session.setAttribute("searchListSuccess", display);
        }
        resp.sendRedirect("gallery.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean searchResultAvailable = session.getAttribute("searchResultAvailable") != null &&
                (boolean) session.getAttribute("searchResultAvailable");
        if (searchResultAvailable) {
            List<Product> searchResult = (List<Product>) session.getAttribute("searchListSuccess");
            session.removeAttribute("searchListSuccess");

            req.setAttribute("searchResult", searchResult);
        }

        req.getRequestDispatcher("gallery.jsp").forward(req, resp);
    }
}

