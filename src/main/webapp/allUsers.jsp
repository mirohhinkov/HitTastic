<%--
    Created on : 26 Aug 2022, 12:00:32
    Author     : Erika Miranda
--%>
<%@page import="java.util.List"%>
<%@page import="erika.model.User"%>
<%@page import="erika.service.UserService"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
</head>
<body>
    <%@include file="include/nav.jsp" %>

    <%
        out.print(INav.WELCOME);
        out.print(INav.MAIN);
        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();
    %>
    <table border="1">
        <tr>
            <td>Full Name</td>
            <td>E-mail</td>
            <td>Balance</td>
        </tr>
        <% for (User user : users) { %>
            <tr>
                <td><% out.print(user.getFullName()); %></td>
                <td><% out.print(user.getEmail()); %></td>
                <td><% out.print(user.getBalance()); %></td>
            </tr>
        <% } %>
    </table>




</body>
</html>