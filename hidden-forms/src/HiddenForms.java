import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;


public class HiddenForms extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
        
                String name = request.getParameter("name");
                String age = request.getParameter("age");
                String depart = request.getParameter("dept");
        
                String keyCount = request.getParameter("keyCount");
                String timer = request.getParameter("timer");
                String subTime = request.getParameter("subTime");

                out.println("<html><body>");
                out.println("<h1>User Details </h1>");
                out.println("<p>name:"+name+"<p>");
                out.println("<p>age:"+age+"<p>");
                out.println("<p>department:"+depart+"<p>");

                out.println("<h1>Hidden Details </h1>");
                out.println("<p>no. of Key presses: "+keyCount+"<p>");
                out.println("<p>Time to fill: "+ timer +" seconds<p>");
                out.println("<p>sunmitted at : "+ subTime +"<p>");
        
        
	
    }
}