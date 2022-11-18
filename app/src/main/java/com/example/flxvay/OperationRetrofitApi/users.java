package com.example.flxvay.OperationRetrofitApi;

import com.google.gson.annotations.SerializedName;

public class users {

    @SerializedName("response")
    private String Response;

    @SerializedName("user_id")
    private String Userid;

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }
}
