<%--
    Created on : 10 Sep 2022, 12:00:32
    Author     : Erika Miranda
--%>
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
        String className="";
        if (!state.getMessage().isEmpty()) {
            out.print("<p class=\"" + className + "\">" + state.getMessage() + "</p>");
            state.setMessage("");
        }
    %>
    <form method="POST" action="loginUser.jsp">
        <div id="login-form">
        <p>Email:</p>
        <input id="email" type="email" name="email">
        <p>Password:</p>
        <input id="password" type="password" name="password">
        <br>
        <input type="submit" value="Login">
    </form>

    <% out.print(INav.END_MAIN); %>