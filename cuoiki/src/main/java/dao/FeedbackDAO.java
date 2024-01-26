package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Feedback;


public class FeedbackDAO {
    private String query = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection con;

    public FeedbackDAO(Connection con) {
        this.con = con;
    }

    public boolean addFeedback(Feedback feedback) {
        boolean isAdd = false;
        query = "insert into feedback(name,email,message,created,productID) " + "values(?,?,?,NOW(),?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, feedback.getName());
            ps.setString(2, feedback.getEmail());
            ps.setString(3, feedback.getMessage());
            ps.setInt(4, feedback.getProductID());

            int i = ps.executeUpdate();

            isAdd = i == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();
        Feedback feedback = null;
        query = "select * from feedback order by id desc";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setName(rs.getString("name"));
                feedback.setEmail(rs.getString("email"));
                feedback.setMessage(rs.getString("message"));
                feedback.setCreated(rs.getTimestamp("created"));
                feedback.setProductID(rs.getInt("productID"));

                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return feedbacks;
    }

    public List<Feedback> getTop3Feedback(int id) {
        List<Feedback> feedbacks = new ArrayList<>();
        Feedback feedback = null;
        query = "select * from feedback where productID = ? order by id desc limit 3";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setName(rs.getString("name"));
                feedback.setEmail(rs.getString("email"));
                feedback.setMessage(rs.getString("message"));
                feedback.setCreated(rs.getTimestamp("created"));
                feedback.setProductID(rs.getInt("productID"));

                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return feedbacks;
    }

    public static void main(String[] args) {
        FeedbackDAO feedbackDAO = new FeedbackDAO(DBConnect.getConnection());
        System.out.println(feedbackDAO.getTop3Feedback(165));
    }
}
