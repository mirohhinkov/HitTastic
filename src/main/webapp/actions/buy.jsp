<%--
    Created on : 22 Sep 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>
<%@page import="miroslav.utils.State"%>
<%@page import="miroslav.controller.CartController"%>

<%
    if (State.getInstance().getUser() == null) {
        response.sendRedirect("../login.jsp");
    } else {
        if (CartController.buyCart()) {
            State.getInstance().setMessage("Order placed successfully");
            response.sendRedirect("../download.jsp");
        } else {
            State.getInstance().setMessage("Something went wrong");
            response.sendRedirect("../songs.jsp");
        }
    }
%>
