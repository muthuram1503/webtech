<%@ page import="javax.servlet.http.HttpSession" %>

<%
    // Retrieve the score from the session (using the implicit session object)
    Integer score = (Integer) session.getAttribute("score");

    // If no score is found, default to 0
    if (score == null) {
        score = 0;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Result Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Your Score: <%= score %></h1>
</body>
</html>
