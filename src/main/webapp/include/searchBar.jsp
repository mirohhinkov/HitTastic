<section id="search">
    <form action="/search.jsp">
      <label for="songsSearch">Search by song name or author:</label>
      <input type="search" id="songsSearch" name="songsSearch" value=
            <%= (state.getFilter() == null) ? "" : state.getFilter() %>>
      <input type="submit" value="Search">
    </form>
</section>