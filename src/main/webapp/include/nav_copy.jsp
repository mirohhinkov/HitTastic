<%-- Author Miroslav Hinkov --%>

<%@page import="miroslav.utils.State"%>
<%@page import="erika.model.User"%>
<%@page import="erika.service.UserService"%>
<%@page import="java.util.List"%>


    <%
        State state = State.getInstance();
    %>
<nav>


    <form id="songs" action="songs.jsp">
        <input class="menu_item" type="submit" value="Songs">
    </form>
    <form id="cart" action="cart.jsp">
        <input class="menu_item" type="submit" value="Cart">
    </form>
    <form id="login" action="login.jsp">
        <input class="menu_item" type="submit" value="<%
            
                   out.print((state.getUser() == null) ? "Login" : "Logout");
                   
               %>">
    </form>
    <form id="admin" action="adminLogin.jsp">
        <input class="menu_item" type="submit" value="Admin Login">
    </form>
</nav>