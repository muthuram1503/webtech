// Necessary imports for servlet, database connection, and error handling
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


@WebServlet("/login")
public class FirstPage extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        response.setContentType("text/html");
        
        
        PrintWriter out = response.getWriter();

        try{

        String username = request.getParameter("username");
        String password = request.getParameter("password");

            HttpSession session = request.getSession();

            Integer loginCount = (Integer) session.getAttribute("loginCount");
            if (loginCount == null) {
                loginCount = 0;
            }


            if (username.equals("muthuram") && password.equals("webtech")) {
                session.setAttribute("username", username);

                loginCount++;
                session.setAttribute("loginCount", loginCount);


                out.println("<h1>Session Page 1</h1>");
                out.println("<h1>Welcome "+session.getAttribute("username")+"</h1>");
                out.println("<p>your session id is : "+ session.getId() +"</p>");
                out.println("<p>Session created at : "+ new Date(session.getCreationTime()) +"</p>");
                out.println("<p>Visited Count : "+ loginCount +"</p>");


                out.println("<form action='check'> <input type='submit' value='check session'> </form>");

                // response.sendRedirect("welcome.html?sessionId="+session.getId());
            } else {
               // out.println("Invalid username or password.");
               //response.sendRedirect("index.html");
               out.println("<script>");
               if (session != null) {
                    session.invalidate();
                }
               out.println("alert('wrong password');");
                out.println("window.location.href = 'index.html';");
                out.println("</script>");
            }
            
            

        } catch (Exception e) {
            
            out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
