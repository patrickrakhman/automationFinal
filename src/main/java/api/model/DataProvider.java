package api.model;



import static api.ReadProperties.getProperty;

public class DataProvider {
    private static String username = getProperty("apilogin");
    private static String userId = getProperty("userID");




    public static String getUUID() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

}