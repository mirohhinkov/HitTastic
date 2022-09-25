<%-- 
    Created on : 26 Aug 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>

<%@page import="miroslav.utils.State"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            String filter = request.getParameter("songsSearch");
            State state = State.getInstance();
            state.setFilter(filter);
            response.sendRedirect("songs.jsp");
        %>
