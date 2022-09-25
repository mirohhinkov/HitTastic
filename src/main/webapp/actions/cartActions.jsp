<%--
    Created on : 10 Sep 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>
    <%@page import="miroslav.controller.CartController"%>

    <%
    String action = request.getParameter("action");
    Long id =  Long.parseLong(request.getParameter("id"));

    CartController.actionsHandler(id, action);
    response.sendRedirect("../cart.jsp");
    %>