import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Question;


@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Question> questions = new ArrayList<>(); // Use generics

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineExamDB", "root", "aravind@2004")) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM questions");

            while (rs.next()) {
                Question question = new Question(
                    rs.getInt("question_id"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_option").charAt(0)
                );
                questions.add(question); // Adding Question object to the typed list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("questions", questions);
        session.setAttribute("score", 0);
        session.setAttribute("index", 0);
        response.sendRedirect("exam.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked") // Suppress unchecked cast warning if necessary
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        if (questions == null) {
            questions = new ArrayList<>();
        }

        Integer indexObj = (Integer) session.getAttribute("index");
        int index = (indexObj != null) ? indexObj : 0;

        Integer scoreObj = (Integer) session.getAttribute("score");
        int score = (scoreObj != null) ? scoreObj : 0;

        String answer = request.getParameter("answer");
        if (answer != null && answer.equals(String.valueOf(questions.get(index).getCorrectOption()))) {
            score++;
            session.setAttribute("score", score);
        }

        index++;
        session.setAttribute("index", index);
        response.sendRedirect("exam.jsp");
    }
}
