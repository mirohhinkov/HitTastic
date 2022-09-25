<%--
    Created on : 26 Aug 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>

<%@page import="miroslav.utils.State"%>
<%@page import="miroslav.utils.html.INav"%>

    <%
        State state = State.getInstance();
    %>
    <header>
    <%
        String log = (state.getUser() == null) ? "Login" : "Logout";
        String orders = (state.getUser() == null) ? "" : INav.ORDERS;
        out.print(INav.NAV
            .replace("%LOG%", log)
            .replace("%ORDERS%", orders)
            .replace("%JSP%", log.toLowerCase())
            );
    %>
    </header>