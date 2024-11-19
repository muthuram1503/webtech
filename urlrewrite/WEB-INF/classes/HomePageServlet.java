import java.io.IOException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve and decode parameters
        String encodedUsername = request.getParameter("username");
        String encodedPassword = request.getParameter("password");

        String username = new String(Base64.getDecoder().decode(encodedUsername));
        String password = new String(Base64.getDecoder().decode(encodedPassword));

        // Display the decoded parameters
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Welcome to the Home Page</h1>");
        response.getWriter().println("<p>Username: " + username + "</p>");
        response.getWriter().println("<p>Password: " + password + "</p>");
        response.getWriter().println("</body></html>");
    }
}
