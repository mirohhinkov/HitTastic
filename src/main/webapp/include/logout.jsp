<%--
    Created on : 22 Sept 2022, 12:00:32
    Author     : Erika Miranda
--%>
<%@page import="miroslav.service.cart.CartService"%>
<%@include file="include/nav.jsp" %>
<%
        CartService cartService = new CartService();

        state.setUser(null);
        cartService.clearCart();
        response.sendRedirect("songs.jsp");
%>