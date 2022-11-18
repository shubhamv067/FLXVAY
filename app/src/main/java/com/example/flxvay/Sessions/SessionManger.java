package com.example.flxvay.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManger {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE =0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    private static final String USER_ID = "USER_ID";

    public SessionManger(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }
    public void createSession(String user_id){
        editor.putBoolean(LOGIN,true);
        editor.putString(USER_ID,user_id);
        editor.apply();
    }
    public boolean isLogin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }
    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USER_ID,sharedPreferences.getString(USER_ID,null));
        return user;
    }

}
