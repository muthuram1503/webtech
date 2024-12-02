import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Result", "root", "12345678");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String regno=request.getParameter("regno");
        String dob=request.getParameter("dob");

        try (Connection conn = getConnection()) {
      
            String query = "SELECT regno, name, sub1,sub2,sub3  FROM students where regno=? and dob=?"; // Your SQL query
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,regno);
            stmt.setString(2,dob);
            ResultSet rs = stmt.executeQuery();

            request.setAttribute("resultSet", rs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayData.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database connection error.");
        }
    }
}
