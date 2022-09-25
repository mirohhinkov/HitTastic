<%--
    Created on : 25 Sep 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>
<%@page import="miroslav.controller.CartController"%>
<%@page import="miroslav.model.SongOrder"%>
<%@page import="miroslav.model.OrderDetails"%>
<%@page import="java.util.*"%>


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
        out.print("<h2>" + state.getUser().getFullName() +" Orders</h2>");
        List<OrderDetails> userOrders = CartController.findCurrentUserOrders();
        for (OrderDetails ord : userOrders) {
        out.print("Order ID: " + ord.getOrderId() + ", Date: " + ord.getOrderDate() +
            ", Song: " + ord.getTitle()+"</br>");
        }
    %>
</body>