package com.example.phys8.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.Categories;
import com.example.phys8.Repositories.CategoryRepository;

public class CategoryViewModel extends AndroidViewModel {

    private CategoryRepository categoryRepository;
    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token){
        categoryRepository = CategoryRepository.getInstance(token);
    }

    //== Begin of view model to get all category

    @Override
    protected void onCleared() {
        super.onCleared();
        categoryRepository.resetInstance();
    }
}
