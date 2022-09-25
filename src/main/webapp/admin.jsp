<%--
    Created on : 30 Aug 2022, 12:00:32
    Author     : Erika Miranda
--%>
<%@page import="miroslav.utils.html.ICart"%>

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
        if (state.getAdmin() == null)
            response.sendRedirect("login.jsp");
    %>
        <a href="allUsers.jsp"><button>Show Users</button></a>
        <a href="updateUserForm.jsp"><button>Edit User</button></a>
        <a href="logoutAdmin.jsp"><button>LogOut</button></a>