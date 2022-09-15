    <%@page import="miroslav.controller.CartController"%>

    <%
    String action = request.getParameter("action");
    Long id =  Long.parseLong(request.getParameter("id"));

    CartController.actionsHandler(id, action);
    response.sendRedirect("../cart.jsp");
    %>