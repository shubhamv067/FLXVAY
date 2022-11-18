package com.example.flxvay.OperationRetrofitApi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    ////////email_Signup/////////
    @GET("email_registration.php")
    Call<users> performEmailRegistration(
            @Query("user_name") String user_name,
            @Query("user_email") String user_email,
            @Query("user_password") String user_password
    );

    ////////email_login/////////
    @GET("email_login.php")
    Call<users> performEmailLogin(
            @Query("user_email") String user_email,
            @Query("user_password") String user_password
    );
}
