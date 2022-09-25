<%--
    Created on : 25 Sept 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>
<%@page import="miroslav.controller.CartController"%>
<%@page import="miroslav.model.SongOrder"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
    <link rel="stylesheet" href="libs/css/table.css" />
</head>
<body>
    <%@include file="include/nav.jsp" %>

    <%
        out.print(INav.WELCOME);

        out.print(INav.MAIN);
        out.print("<h2>You can download mp3 files of your physical order using the provided links:</h2>");
        for (SongOrder order : state.getCart().getSongOrders().values()) {
            out.print("<a href=\"#\">" + order.getSong().getTitle() +"</a><br>");
        }
        CartController.clearCart();
    %>
</body>