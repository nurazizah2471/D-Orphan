package com.example.phys8.Helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceHelper {
    private static final String PREFS = "pref";
    private static SharedPreferenceHelper instance;
    private static SharedPreferences prefs;
    private static SharedPreferences userId;
    private static SharedPreferences typeUser;
    private static final String USERID = "userId";
    private static final String TYPEUSER = "typeUser";

    private SharedPreferenceHelper(Context context){
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        userId = PreferenceManager.getDefaultSharedPreferences(context);
        typeUser = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferenceHelper getInstance(Context context){
        if (instance == null){
            instance = new SharedPreferenceHelper(context);
        }
        return instance;
    }

    public static void saveAccessToken(String token, String userIdobj, String userTypeobj){
        prefs.edit().putString(PREFS, token).apply();
        userId.edit().putString(USERID, userIdobj).apply();
        typeUser.edit().putString(TYPEUSER, userTypeobj).apply();
    }

    public static void saveUserId(String userIdobj){
        userId.edit().putString(USERID, userIdobj).apply();
    }
    public static void saveTypeUser(String userTypeobj){
        typeUser.edit().putString(TYPEUSER, userTypeobj).apply();
    }
    public void saveRefreshToken(String token){
        prefs.edit().putString(PREFS, token).apply();
    }

    public static String getAccessToken(){
        return prefs.getString(PREFS, "");
    }

    public static String getUserId(){
        return userId.getString(USERID, "");
    }
    public static String getTypeUser(){
        return typeUser.getString(TYPEUSER, "");
    }

    public static void clearPref() {
        prefs.edit().clear().apply();
        userId.edit().clear().apply();
        typeUser.edit().clear().apply();
    }
}
