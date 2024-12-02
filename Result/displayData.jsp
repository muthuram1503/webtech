<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Student Result</title>
</head>
<body>
    <center><h2>Student Result</h2>
    <table border="1">
        <tr>
            <th>Reg.no</th>
            <th>Name</th>
            <th>Subject 1</th>
            <th>Subject 2</th>
            <th>Subject 3</th>

        </tr>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("resultSet");
    
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("regno") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("sub1") %></td>
            <td><%= rs.getInt("sub2") %></td>
            <td><%= rs.getInt("sub3") %></td>
        </tr>
        <%
            }
        %>
    </table></center>
</body>
</html>
