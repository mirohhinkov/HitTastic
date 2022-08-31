package miroslav.utils;

public class UserInputUtils {
    public static String removeSpecialCharacters(String str) {
        String newString = str.trim().replaceAll("[^a-zA-Z0-9.!\\s']", "");
        return newString;
    }

    public static String capitalizeWords(String str) {
        String[] split = str.trim().split("\\s+"); // delimiter 1 or more whitespaces

        for (int i = 0; i < split.length; i++)
            split[i] = capitalizeWord(split[i]);
        return String.join(" ", split);
    }

    public static String prepareTitleForSqlQuery(String title) {
        String[] split = title.trim().split("\\s");
        for (int i = 0; i < split.length; i++)
            split[i] = "title LIKE \"%" + split[i] + "%\"";
        return String.join(" AND ", split);
    }

    private static String capitalizeWord(String str) {
        if (str == null || str.isEmpty()) return null;
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
