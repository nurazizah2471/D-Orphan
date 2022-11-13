package com.Archotech.D_Orphan.Repositories;

import com.Archotech.D_Orphan.Retrofit.ApiService;

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
