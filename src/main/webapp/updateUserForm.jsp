<%--
    Created on : 15 Sep 2022, 12:00:32
    Author     : Erika Miranda
--%>
<%@page import="erika.model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
</head>
<body>
    <%@include file="include/nav.jsp" %>

    <%
        User user = state.getUser();
        // if no user logged in redirect to login form
        if (user == null)
            response.sendRedirect("login.jsp");

        out.print(INav.WELCOME);
        out.print(INav.MAIN);

    %>
    <form method="POST" action="updateUser.jsp">
        <div id="update-form">
        <p>User Full Name:</p>
        <input id="name" type="text" name="name" value=<% out.print(user.getFullName()); %> >
        <p>Email:</p>
        <input id="email" type="email" name="email" value=<% out.print(user.getEmail()); %> >
        <p>Password:</p>
        <input id="password" type="password" name="password">
        <br>
        <p>Top up:</p>
        <input id="topup" type="number" name="topup">
        <input type="submit" value="Update">
    </form>

    <% out.print(INav.END_MAIN); %>