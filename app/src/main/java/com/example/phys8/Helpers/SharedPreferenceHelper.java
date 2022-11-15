package com.example.phys8.Helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceHelper {
    private static final String PREFS = "pref";
    private static SharedPreferenceHelper instance;
    private static SharedPreferences prefs;
    private static SharedPreferences userId;

    private static final String USERID = "userId";


    private SharedPreferenceHelper(Context context){
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        userId = PreferenceManager.getDefaultSharedPreferences(context);

    }

    public static SharedPreferenceHelper getInstance(Context context){
        if (instance == null){
            instance = new SharedPreferenceHelper(context);
        }
        return instance;
    }

    public static void saveAccessToken(String token, String userIdobj){
        prefs.edit().putString(PREFS, token).apply();
        userId.edit().putString(USERID, userIdobj).apply();
    }

    public static void saveUserId(String userIdobj){
        userId.edit().putString(USERID, userIdobj).apply();
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

    public static void clearPref() {
        prefs.edit().clear().apply();
        userId.edit().clear().apply();
    }
}
