package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 12/3/18.
 */

public class AppConfig {

    private static String BASE_URL = "http://drunkenbee.in/DROPBOXX/TEST//rest.php?applicationKey=12345&";

    public static final int STATUS_OK = 1;
    public static final int LOGIN_TYPE_UUID = 2;

    //field names
    public static final String DEVICE_UUD = "DEVICE_UUID";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String USER_ID = "USER_ID";
    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    //method names
    private static String LOGIN_METHOD_NAME = "user.login";
    private static final String TIFFIN_OPTION_METHOD_NAME = "tiffin.getOption";
    private static final String COMBO_LIST_METHOD_NAME = "combo.getList";
    private static final String CATEGORY_LIST_METHOD_NAME = "product.getList";

    public  static String getBaseUrl(){
        return BASE_URL;
    }

    public static String getLoginUrl(){return BASE_URL+"methodName="+LOGIN_METHOD_NAME;}


    public static String tiffinOptionUrl() {
        return BASE_URL+"methodName="+TIFFIN_OPTION_METHOD_NAME;
    }

    public static String comboListUrl() {
        return BASE_URL+"methodName="+COMBO_LIST_METHOD_NAME;
    }

    public static String categoryListUrl() {
        return BASE_URL+"methodName="+CATEGORY_LIST_METHOD_NAME;
    }
}

