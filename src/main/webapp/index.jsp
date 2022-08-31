<%@page import="miroslav.utils.html.INav"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/head.jsp" %>
    </head>
    <body>
        <%@include file="include/nav.jsp" %>
        
        <%
            out.print(INav.WELCOME);
            out.print(INav.MAIN);
            out.print("<h2>Hello to HitTastic</h2>");
            out.print(INav.END_MAIN);
        %>
    </body>
</html>
