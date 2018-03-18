package in.drunkenbee.app.dropboxx;

/**
 * Created by ankit on 15/3/18.
 */

public class LoginAdapter {
    private int userId;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
