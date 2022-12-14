package com.example.phys8.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.Register;
import com.example.phys8.Models.TokenResponse;
import com.example.phys8.Retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private static AuthRepository authRepository;
    private ApiService apiService;
    private static final String TAG = "AuthRepository";


    private AuthRepository(){
        apiService = ApiService.getInstance(""); //getinstance("") krna ktika login tdk mmbthkn token (barier, header di postman)
    }

    public static AuthRepository getInstance(){
        if(authRepository == null){
            authRepository = new AuthRepository();
        }
        return authRepository;
    }

    public MutableLiveData<TokenResponse> login(String email, String password){
        MutableLiveData<TokenResponse> tokenResponseMutableLiveData = new MutableLiveData<>();

        apiService.login(email, password).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
               //nilai 200 itu artinya jika berhasil
                        if(response.body() != null) {
                            tokenResponseMutableLiveData.postValue(response.body());
                        }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });
        return tokenResponseMutableLiveData;
    }

    public MutableLiveData<Register> register(String email, String password, String password_confirmation, int type_user, String name){
        MutableLiveData<Register> RegisterResponseMutableLiveData = new MutableLiveData<>();

        apiService.register(email, password, password_confirmation, type_user, name).enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.isSuccessful()){
                    if(response.code() == 200){ //nilai 200 itu artinya jika berhasil
                        if(response.body() != null){
                            RegisterResponseMutableLiveData.postValue(response.body());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {

            }
        });
        return RegisterResponseMutableLiveData;
    }
}
