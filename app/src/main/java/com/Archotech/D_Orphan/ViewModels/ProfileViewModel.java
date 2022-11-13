package com.Archotech.D_Orphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.Archotech.D_Orphan.Models.User;
import com.Archotech.D_Orphan.Repositories.ProfileRepository;


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
