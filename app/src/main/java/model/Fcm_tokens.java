package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fcm_tokens {

    @SerializedName("token_string")
    @Expose
    private String token_string;

    public void setToken_string(String token_string) {
        this.token_string = token_string;
    }

    public String getToken_string() {
        return token_string;
    }
}
