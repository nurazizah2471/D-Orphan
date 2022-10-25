package com.example.phys8.ViewModels;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.User;
import com.example.phys8.Repositories.ProfileRepository;

import java.util.List;


public class ProfileViewModel extends AndroidViewModel {
    private ProfileRepository profileRepository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token){
        profileRepository = ProfileRepository.getInstance(token);
    }

    public LiveData<String> logout(){
        profileRepository.resetInstance();
        return profileRepository.logout();
    }

    private MutableLiveData<User.Result> resultUsers = new MutableLiveData<>();
    public void getUserWithId(String userId){
        resultUsers = profileRepository.getUserWithId(userId);
    }
    public LiveData<User.Result> getResultUserWithId(){
        return resultUsers;
    }

    private MutableLiveData<User.Result> resultUsers2 = new MutableLiveData<>();
    public void getUserWithId2(String userId){
        resultUsers2 = profileRepository.getUserWithId(userId);
    }
    public LiveData<User.Result> getResultUserWithId2(){
        return resultUsers2;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        profileRepository.resetInstance();
    }
}
