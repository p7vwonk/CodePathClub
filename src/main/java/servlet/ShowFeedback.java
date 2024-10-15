package main.java.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ShowFeedback", value = "/ShowFeedback")
public class ShowFeedback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("/jsp/header.jsp").include(request, response);

        PrintWriter out = response.getWriter();
        Connection con = DBConnection.connectDB("club");
        if (con == null) {
            out.println("<font color='red'>Connection error</font>");
        } else {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from feedback");
                while (rs.next()) {
                    String time = rs.getString("time");
                    String content = rs.getString("content");
                    out.println(time + "<br>" + content + "<br><br>");
                }
                DBConnection.disconnectDB(rs, stmt, con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        request.getRequestDispatcher("/jsp/footer.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}