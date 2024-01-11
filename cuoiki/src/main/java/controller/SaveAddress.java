package controller;

import dao.AddressDAO;
import database.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Address;
import model.User;
import java.util.List;

import java.io.IOException;

@WebServlet("/saveAddress")
public class SaveAddress extends HttpServlet {
    AddressDAO dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = new AddressDAO(DBConnect.getConnection());
        boolean isAdd = false;
        List<Address> listAddress = dao.getAllAddress();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("success");
        Address a;
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String address = req.getParameter("address");
        String saveInfo = req.getParameter("save-info");
        if (saveInfo == null) saveInfo = "nosave";
        String paymentMethod = req.getParameter("paymentMethod");

        a = new Address(user.getId(), firstName, lastName, email, contact, address, saveInfo, paymentMethod);

        for (Address d: listAddress) {
            if (user.getId() != d.getUserId()) {
                isAdd = dao.insertToAddress(a);
            } else {
                isAdd = dao.updateAddress(d);
            }
        }
        if(isAdd) {
            session.setAttribute("saveAddressText", "Bạn đã cập nhật thông tin thành công");
            session.setAttribute("address", a);
        } else {
            session.setAttribute("saveAddressText", "Hệ thống đang gặp lỗi. Vui lòng thử lại sau");
        }
        System.out.println(req.getContextPath());

        resp.sendRedirect(req.getContextPath()+"/createOrder");
    }
}
