package miroslav.utils.html;


public interface INav {

    String NAV =
                "<header id=\"main-navigation\">" +
                    "<nav>" +
                            "<a href=\"songs.jsp\">Songs</a>" +
                            "<a href=\"cart.jsp\">Cart</a>" +
                            "<a href=\"login.jsp\">%LOG%</a>" +
                            "<a href=\"adminLogin.jsp\">Admin Login</a>" +
                    "</nav>" +
                "</header>";


    String MAIN = "<main class=\"main\">";
    String END_MAIN = "</main>";
    String WELCOME = 
                "<section id=\"welcome\">" +
                      "  " +
                "</section>";
}

