<%@page import="miroslav.utils.State"%>
<%@page import="miroslav.model.Song"%>
<%@page import="miroslav.service.cart.CartService"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%@include file="include/state.jsp" %>
        <%

            state.setAddedToCart(true);
            int index = Integer.parseInt(request.getParameter("id"));
            Song song = state.getSongs().get(index);
            Long songId = Long.valueOf(song.getId());
            CartService cartService = new CartService();

            if (state.getCart().getSongOrders().get(songId) == null) {
                cartService.addSong(song, 1);
                state.setMessage("Song " +
                                   state
                                   .getSongs()
                                   .get(index)
                                   .getTitle() + " added to your Cart");
            } else {
               cartService.increase(song);
            }


            response.sendRedirect("songs.jsp");
        %>
    </body>
</html>