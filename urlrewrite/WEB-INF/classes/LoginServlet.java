import java.io.IOException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get the form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Encode using Base64
        String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Redirect with encoded parameters
        String redirectURL = "HomePageServlet?username=" + encodedUsername + "&password=" + encodedPassword;
        response.sendRedirect(redirectURL);
    }
}
