<%@page import="java.util.List"%>
<%@page import="erika.model.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
        <style>
        #login {
            display: none;
        }
    </style>
</head>
<body>
    <header>
        <%@include file="include/nav.jsp" %>
    </header>
    <h1>Login</h1>
    <%-- Test for DB connection --%>
    <%
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