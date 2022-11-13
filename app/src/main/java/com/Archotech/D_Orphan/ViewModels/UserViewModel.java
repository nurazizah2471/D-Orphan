package com.Archotech.D_Orphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.Archotech.D_Orphan.Models.User;
import com.Archotech.D_Orphan.Repositories.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance();
    }

    //== Begin of view model to get all category
    private MutableLiveData<List<User.Result>> resultUsers = new MutableLiveData<>();
    public void getUsers(){
        resultUsers = userRepository.getUsers();
    }
    public LiveData<List<User.Result>> getResultUsers(){
        return resultUsers;
    }
}
