<%--
    Created on : 31 Aug 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>
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

        String buttonTxt = "";
        if (state.getUser() == null) {
            buttonTxt = ICart.BUY_LINK;
        } else {
            boolean enoughUserBalance = (state.getUser().getBalance() - CartController.cartPrice()) >= 0;
            buttonTxt = (enoughUserBalance) ? ICart.BUY_LINK : ICart.BUY_TOPUP;
        }

        out.print(ICart.BUY.replace("%1%", buttonTxt));
        out.print(INav.END_MAIN);
    %>
</body>
</html>