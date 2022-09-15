<%@page import="miroslav.model.SongOrder"%>
<%@page import="miroslav.utils.html.ICart"%>
<%@page import="miroslav.controller.CartController"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
    <link rel="stylesheet" href="libs/css/table.css" />
</head>
<body>
    <%@include file="include/nav.jsp" %>

    <%
        out.print(INav.WELCOME);
        out.print(INav.MAIN);
            out.print(ICart.TITLE);
            out.print(ICart.HEAD);
            for (SongOrder order : state.getCart().getSongOrders().values()) {
                out.print(ICart.ROW
                    .replace("%1%", order.getSong().getArtist().getName())
                    .replace("%2%", order.getSong().getTitle())
                    .replace("%3%", "" + order.getQuantity())
                    .replace("%4%", "" + order.getSong().getPrice())
                    .replace("#1", "actions/cartActions.jsp?id=" + order.getSong().getId() + "&action=inc")
                    .replace("#2", "actions/cartActions.jsp?id=" + order.getSong().getId() + "&action=dec")
                    .replace("#3", "actions/cartActions.jsp?id=" + order.getSong().getId() + "&action=del"));
            }
            out.print(ICart.PRICE_ROW.replace("%1", String.format( "%.2f", CartController.cartPrice())));
            out.print(ICart.END_TABLE);
        out.print(INav.END_MAIN);
    %>
</body>
</html>