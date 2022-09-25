<%--
    Created on : 10 Sep 2022, 12:00:32
    Author     : Erika Miranda
--%>
<%@page import="java.util.List"%>
<%@page import="erika.model.User"%>
<%@page import="erika.service.UserService"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
    <title>songs</title>
</head>
<body>
    <%@include file="include/nav.jsp" %>
    <%
            out.print(INav.WELCOME);
            out.print(INav.MAIN);

        UserService userService = new UserService();
        if (state.getUser() == null) {
            response.sendRedirect("loginForm.jsp");
        }

    %>





</body>
</html>