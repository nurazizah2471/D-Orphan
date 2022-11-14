package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class TokenResponse implements Parcelable {
    private String status;
    private String type_user;
    private String userId;
    private Result result;

    public static TokenResponse objectFromData(String str) {

        return new Gson().fromJson(str, TokenResponse.class);
    }

    protected TokenResponse(Parcel in) {
        status = in.readString();
        type_user = in.readString();
        userId = in.readString();
    }

    public static final Creator<TokenResponse> CREATOR = new Creator<TokenResponse>() {
        @Override
        public TokenResponse createFromParcel(Parcel in) {
            return new TokenResponse(in);
        }

        @Override
        public TokenResponse[] newArray(int size) {
            return new TokenResponse[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(type_user);
        dest.writeString(userId);
    }

    public static class Result {
        private String token_type;
        private int expires_in;
        private String access_token;
        private String refresh_token;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public String getAuthorization() {
            return  this.token_type + "" + this.access_token;
        }
    }

    }
