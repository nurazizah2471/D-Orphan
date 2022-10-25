package com.example.phys8.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.phys8.Models.Categories;
import com.example.phys8.Models.User;
import com.example.phys8.Repositories.AuthRepository;
import com.example.phys8.Repositories.CategoryRepository;
import com.example.phys8.Repositories.UserRepository;

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
