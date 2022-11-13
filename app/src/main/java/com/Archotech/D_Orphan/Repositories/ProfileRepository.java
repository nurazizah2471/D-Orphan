package com.Archotech.D_Orphan.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.Archotech.D_Orphan.Models.User;
import com.Archotech.D_Orphan.Retrofit.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    private static ProfileRepository profileRepository;
    private ApiService apiService;

    private ProfileRepository(String token){

        apiService = ApiService.getInstance(token);
    }

    public static ProfileRepository getInstance(String token){
        if (profileRepository == null){
            profileRepository = new ProfileRepository(token);
        }
        return profileRepository;
    }

    public static synchronized void resetInstance(){
        if (profileRepository != null){
            profileRepository = null;
        }
    }

    //<String> karna di postman jika berhasil logout akan tampil message atau pesan logout berhasil
    //Cara mengambil response gson berupa String object
    public LiveData<String> logout(){
        final MutableLiveData<String> message = new MutableLiveData<>();
        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    System.out.println(response.body()+"haaa");
                    if (response.body() != null){
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            message.postValue(msg);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }else{
                    System.out.println(response+"haaa");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
        return message;
    }

    public MutableLiveData<User.Result> getUserWithId(String userId){
        final MutableLiveData<User.Result> UserWithId = new MutableLiveData<>();
        apiService.getUserWithId(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    UserWithId.postValue(response.body().getResult().get(0));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
        return UserWithId;
    }
}
