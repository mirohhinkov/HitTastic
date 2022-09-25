<%--
    Created on : 26 Aug 2022, 12:00:32
    Author     : Miroslav Hinkov
--%>
<section id="search">
    <form action="/search.jsp">
      <label for="songsSearch">Search by song name or author:</label>
      <input type="search" id="songsSearch" name="songsSearch" value=
            <%= (state.getFilter() == null) ? "" : state.getFilter() %>>
      <input type="submit" value="Search">
    </form>
</section>