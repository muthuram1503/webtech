<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="model.Question" %>

<%
    List<Question> questions = (List<Question>) session.getAttribute("questions");
    Integer index = (Integer) session.getAttribute("index");
    if (index == null) index = 0;

    if (index >= questions.size()) {
        response.sendRedirect("result.jsp");
        return;
    }

    Question question = questions.get(index);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Exam</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
     <h1>Your Exam</h1>
     <div class="question-section">
    <h3>Question <%= (index + 1) %>: <%= question.getQuestionText() %></h3></div>
<div class="options">
    <form action="ExamServlet" method="post">
        <input type="radio" name="answer" value="A" required> <%= question.getOptionA() %><br>
        <input type="radio" name="answer" value="B"> <%= question.getOptionB() %><br>
        <input type="radio" name="answer" value="C"> <%= question.getOptionC() %><br>
        <input type="radio" name="answer" value="D"> <%= question.getOptionD() %><br></div>
        <button type="submit">Next</button>
</div>
    </form>
</body>
</html>
