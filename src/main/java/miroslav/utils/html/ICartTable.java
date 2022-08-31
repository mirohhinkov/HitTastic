package miroslav.utils.html;

public interface ICartTable {
    String HEAD =
            "<table>" +
                    "<tr>" +
                      "<th class=\"col1\">Author</th>" +
                      "<th class=\"col2\">Title</th>" +
                      "<th class=\"col3\">Quantity</th>" +
                      "<th class=\"col4\">Actions</th>" +
                    "</tr>";
    String ROW =
            "<tr>" +
                    "<td class=\"col1\">%1%</td>" +
                    "<td class=\"col2\">%2%</td>" +
                    "<td class=\"col3\">%3%</td>" +
                    "<td class=\"col4\">" +
                      "<ul>" +
                        "<li>" +
                          "<a href=\"#1\"><button class=\"lightgreen\">+</button></a>" +
                        "</li>" +
                        "<li>" +
                          "<a href=\"#2\"><button class=\"lightgreen\">-</button></a>" +
                        "</li>" +
                        "<li>" +
                          "<a href=\"#3\"><button class=\"lightred\">x</button></a>" +
                        "</li>" +
                      "</ul>" +
                    "</td>" +
                  "</tr>";
    String END_TABLE = "</table>";
}
