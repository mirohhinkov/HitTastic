    String action = request.getParameter("action");
    Long id =  Long.parseLong(request.getParameter("id"));

    Controller.manageCart(id, action);
    response.sendRedirect("cart.jsp");