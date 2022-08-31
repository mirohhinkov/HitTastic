package miroslav.utils.html;

public interface ITable {
    static String songRow =
            "<tr>" +
               "<td>Artist</td>" +
               "<td>Name</td>" +
               "<td>Price</td>" +
               "<td>  </td>" +
            "</tr>";

    static String tableHead = "" +
            "<table border=" + "1" + ">" +
               "<thead>" +
               "%TABLE%" +
               "</thead>";

    static String href = "<a href=\"addToCart.jsp?id=%I%\">Buy</a>";

    static String tableEnd = "</table>";
}
