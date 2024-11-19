import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

// Define servlet URL mapping using annotations
public class SecondPage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.println("<h1>Hello, World!</h1>");

        HttpSession session = request.getSession(false);

        if (session != null) {
            out.println("<h1>Session Page 2</h1>");
            out.println("<p>your name is : "+ session.getAttribute("username") +"</p>");
            out.println("<p>your session id is : "+ session.getId() +"</p>");
        }
        else{
            out.println("<script>");
            out.println("alert('invalid');");
            out.println("window.location.href = 'welcome.html';");
            out.println("</script>");
        }
    }
}

