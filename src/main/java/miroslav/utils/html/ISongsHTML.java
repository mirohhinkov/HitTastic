/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.utils.html;

public interface ISongsHTML {

    public static String SONG_PAGE_TITLE = "<h2>Songs List</h2>";

    public static String MESSAGE ="<p id=\"message\">%1</p>";

    public static String FLEX_CONTAINER="<div class=\"flex-container\">";

    public static String DIV_END = "</div>";

    public static String CARD =
            "<div class=\"card\">" +
            "<img " +
              "class=\"song-img\"" +
              " src=\"%1\"" +
              " alt=\"%2\"" +
            "/>" +
            "<div class=\"card_right\">" +
              "<h3>%3</h3>" +
              "<h5>%4</h5>" +
              "<a href=\"%5\" >" +
                "<button class=\"btn_card\">" +
                  "<span class=\"%6\">%7</span>" +
                "</button></a>" +
            "</div>" +
          "</div>";

}


