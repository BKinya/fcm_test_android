package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message_model {

    @SerializedName("message")
    @Expose
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
