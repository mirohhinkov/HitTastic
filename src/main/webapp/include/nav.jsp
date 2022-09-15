<%-- Author Miroslav Hinkov --%>

<%@page import="miroslav.utils.State"%>
<%@page import="miroslav.utils.html.INav"%>
<%@page import="erika.model.User"%>
<%@page import="erika.service.UserService"%>
<%@page import="java.util.List"%>

    <%
        State state = State.getInstance();
    %>
    <header>
    <%
        String log = (state.getUser() == null) ? "Login" : "Logout";
        out.print(INav.NAV.replace("%LOG%", log));
    %>
    </header>