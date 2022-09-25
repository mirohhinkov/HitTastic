<%--
    Created on : 10 Sep 2022, 12:00:32
    Author     : Erika Miranda
--%>
<%@page import="erika.service.UserService"%>
<%@page import="miroslav.utils.State"%>
<%@page import="erika.model.User"%>
<%

    String email = (String) request.getParameter("email");
    String password = (String) request.getParameter("password");

    UserService userService = new UserService();
    State state = State.getInstance();

    User user = userService.findUserByEmail(email);
        String link = "";
        String message = "";

        if (user == null || !user.getPassword().equals(password)) {
            message = "Invalid credentials";
            link = "loginForm.jsp";
        } else {
            if (user.isAdmin()) {
                state.setAdmin(user);
                link = "admin.jsp";
            } else {
                state.setUser(user);
                link = "cart.jsp";
            }
        }
        state.setMessage(message);
        response.sendRedirect(link);

%>