<%-- 
    Document   : search.jsp
    Created on : 26 Aug 2022, 12:00:32
    Author     : miro
--%>

<%@page import="miroslav.utils.State"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            String filter = request.getParameter("songsSearch");
            State state = State.getInstance();
            state.setFilter(filter);
            response.sendRedirect("songs.jsp");
        %>
    </body>
</html>
