<%@page import="miroslav.model.Song"%>
<%@page import="miroslav.controller.SongController"%>
<%@page import="miroslav.utils.html.ITable"%>
<%@page import="miroslav.utils.html.ISongsHTML"%>
<%@page import="miroslav.utils.UserInputUtils"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
    <title>songs</title>
</head>
<body>
    <%@include file="include/nav.jsp" %>
    <%
            out.print(INav.WELCOME_START);
                %>
                <%@include file="include/searchBar.jsp" %>
                <%
            out.print(INav.WELCOME_END);
            out.print(INav.MAIN);
    out.print(ISongsHTML.SONG_PAGE_TITLE);
    if (!state.getAddedToCart())
        SongController.search();
    out.print(ISongsHTML.MESSAGE.replace("%1", state.getMessage()));
    if (!state.getSongs().isEmpty()) {
        out.print(ISongsHTML.FLEX_CONTAINER);

        for (int i = 0; i < state.getSongs().size(); i++) {
            Song song = state.getSongs().get(i);
            String title = (song.getTitle().length() > 22) ?
                UserInputUtils.trimName(song.getTitle()) :
                song.getTitle();
            int availableQty = SongController.availableQuantity(song);
            String className = (availableQty > 0) ? "" : "red";
            String href = (availableQty > 0) ? "addToCart.jsp?id=" + i : "#";
            String btnText = (availableQty > 0) ? "ADD TO CART" : "OUT OF STOCK";
            out.print(ISongsHTML.CARD
                .replace("%1", song.getUrl())
                .replace("%2", song.getTitle())
                .replace("%3", song.getArtist().getName())
                .replace("%4", title)
                .replace("%5", href)
                .replace("%6", className)
                .replace("%7", btnText)
                );
        }
        out.print(ISongsHTML.DIV_END);
        out.print(INav.END_MAIN);
    }
    state.setAddedToCart(false);
    %>

</body>
</html>