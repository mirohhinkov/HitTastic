<%@page import="miroslav.model.Song"%>
<%@page import="miroslav.controller.SongController"%>
<%@page import="miroslav.utils.html.ITable"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/head.jsp" %>
    <title>songs</title>
    <style>
        #songs {
            display: none;
        }
    </style>
</head>
<body>
    <header>
        <%@include file="include/nav.jsp" %>      
    </header>
    <%
            out.print(INav.WELCOME);
            out.print(INav.MAIN);
    %>
    <%@include file="include/searchBar.jsp" %>
    <% 
    out.print("<h2>Songs List</h2>");
    if (!state.getAddedToCart())
        SongController.search();
    out.print("<p>" + state.getMessage() + "</p>");
    if (!state.getSongs().isEmpty()) {
        out.print(ITable.tableHead.replace("%TABLE%", ITable.songRow));

        for (int i = 0; i < state.getSongs().size(); i++) {
            Song song = state.getSongs().get(i);
            out.print(ITable.songRow
                .replace("Artist", song.getArtist().getName())
                .replace("Name", song.getTitle())
                .replace("Price", "" + song.getPrice())
                .replace("  ", ITable.href.replace("%I%", "" + i)));
        }
        out.print(ITable.tableEnd);
        out.print(INav.END_MAIN);
    }
    state.setAddedToCart(false);
    %>

</body>
</html>