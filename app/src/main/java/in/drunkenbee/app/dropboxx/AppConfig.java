package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 12/3/18.
 */

public class AppConfig {

    private static String BASE_URL = "http://drunkenbee.in/DROPBOXX/TEST/rest.php?applicationKey=12345&";

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
    private static final String CART_URL = "order.save";
    private static final String ADDRESS_LIST_METHOD = "user.getAddressList";
    private static final String ADDRESS_SAVE_METHOD = "user.addAddress";
    private static final String ADDRESS_MODIFY_METHOD = "user.modifyAddress";
    private static final String ORDER_HISTORY_METHOD = "order.getHistory";

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

    public static String cartUrl() {
        return BASE_URL+"methodName="+CART_URL;
    }

    public static String getAddressListUrl() {
        return BASE_URL+"methodName="+ADDRESS_LIST_METHOD;
    }

    public static String getAddressSaveUrl() {
        return BASE_URL+"methodName="+ADDRESS_SAVE_METHOD;
    }

    public static String getAddressModifyUrl(){
        return BASE_URL+"methodName="+ADDRESS_MODIFY_METHOD;
    }

    public static String getOrderHistoryUrl(){
        return BASE_URL+"methodName="+ORDER_HISTORY_METHOD;
    }
}

