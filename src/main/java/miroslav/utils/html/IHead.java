/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.utils.html;

public interface IHead {
    String TOP_HTML =
            "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                    "<%@include file=\"include/head.jsp\" %>" +
                    "<title>songs</title>" +
                "</head>" +
                "<body>" +
                "<%@include file=\"include/nav.jsp\" %>";
}
