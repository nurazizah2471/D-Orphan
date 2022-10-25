package com.example.phys8.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.Categories;
import com.example.phys8.Models.User;
import com.example.phys8.Retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static UserRepository userRepository;
    private ApiService apiService;

    private UserRepository(){
        apiService = ApiService.getInstance("");
    }

    public static UserRepository getInstance(){
        if (userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public MutableLiveData<List<User.Result>> getUsers(){
        final MutableLiveData<List<User.Result>> listUsers = new MutableLiveData<>();
        apiService.getUsers().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listUsers.postValue(response.body().getResult());
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
        return listUsers;
    }
}
