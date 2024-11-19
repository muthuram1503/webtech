import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/showCookies")
public class showCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
                
        Cookie[] cookies = request.getCookies();
                
        String name = "Not Set";
        String age = "Not Set";
        String department = "Not Set";
                
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "name":
                        name = cookie.getValue();
                        break;
                    case "age":
                        age = cookie.getValue();
                        break;
                    case "department":
                        department = cookie.getValue();
                        break;
                }
            }
        }

       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                
        out.println("<html><head>");
        out.println("<title>Home Page</title>");
        out.println("</head><body>");
                
        out.println("<p>Your name is: " + name + "</p>");
        out.println("<p>Your age is: " + age + "</p>");
        out.println("<p>Your department is: " + department + "</p>");
        out.println("</body></html>");
    }
}