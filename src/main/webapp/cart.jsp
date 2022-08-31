<%@page import="miroslav.model.SongOrder"%>
<%@page import="miroslav.utils.html.ICartTable"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
        <style>
        #cart {
            display: none;
        }
    </style>
    <link rel="stylesheet" href="libs/css/table.css" />
</head>
<body>
    <header>
        <%@include file="include/nav.jsp" %>
    </header>

    <%
        out.print(INav.WELCOME);
        out.print(INav.MAIN);
            out.print("<h2>Your Cart</h2>");
            out.print(ICartTable.HEAD);
            for (SongOrder order : state.getCart().getSongOrders().values()) {
                out.print(ICartTable.ROW
                    .replace("%1%", order.getSong().getArtist().getName())
                    .replace("%2%", order.getSong().getTitle())
                    .replace("%3%", "" + order.getQuantity())
                    .replace("#1", "actions/cartActions.jsp?id=" + order.getSong().getId() + "&action=inc")
                    .replace("#2", "actions/cartActions.jsp?id=" + order.getSong().getId() + "&action=dec")
                    .replace("#3", "actions/cartActions.jsp?id=" + order.getSong().getId() + "&action=del"));
            }
            out.print(ICartTable.END_TABLE);
        out.print(INav.END_MAIN);
    %>
</body>
</html>