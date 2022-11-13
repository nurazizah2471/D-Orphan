package com.Archotech.D_Orphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.Archotech.D_Orphan.Repositories.CategoryRepository;

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
