package com.example.phys8.Repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.Categories;
import com.example.phys8.Retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private static CategoryRepository categoryRepository;
    private ApiService apiService;

    private CategoryRepository(String token){
        apiService = ApiService.getInstance(token);
    }

    public static CategoryRepository getInstance(String token){
        if (categoryRepository == null){
            categoryRepository = new CategoryRepository(token);
        }
        return categoryRepository;
    }

    public static synchronized void resetInstance(){
        if (categoryRepository != null){
            categoryRepository = null;
        }else {
            categoryRepository = null;
        }
    }


}
