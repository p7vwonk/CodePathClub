package main.java.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "FeedbackServlet", value = "/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String content = request.getParameter("feedback");
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = formatter.format(currentDate);

        PrintWriter out = response.getWriter();
        Connection con = DBConnection.connectDB("club");
        if (con == null) {
            out.println("<font color='red'>Connection error</font><br>");
        } else {
            out.println("<font color='green'>Connection Successful</font><br>");
            try {
                PreparedStatement ps = con.prepareStatement("insert into feedback(time, content) values(?,?)");
                System.out.println("stmt");
                ps.setString(1, time);
                ps.setString(2, content);
                ps.executeUpdate();
                System.out.println("exe");
                DBConnection.disconnectDB(null, ps, con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            out.println("<a href='/club/ShowFeedback'>View all feedbacks.</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}