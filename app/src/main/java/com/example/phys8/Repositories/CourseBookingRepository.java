package com.example.phys8.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.CourseBooking;
import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.Retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseBookingRepository {
    private static CourseBookingRepository courseBookingRepository;
    private ApiService apiService;

    private CourseBookingRepository(String token){
        apiService = ApiService.getInstance(token);
    }

    public static CourseBookingRepository getInstance(String token){
        if (courseBookingRepository == null){
            courseBookingRepository = new CourseBookingRepository(token);
        }
        return courseBookingRepository;
    }

    public static synchronized void resetInstance(){
        if (courseBookingRepository != null){
            courseBookingRepository = null;
        }else {
            courseBookingRepository = null;
        }
    }

    public MutableLiveData<List<CourseBooking.Result>> getCourseBooking(String user_id){
        final MutableLiveData<List<CourseBooking.Result>> listCourseBooking = new MutableLiveData<>();

        apiService.getCourseBooking(user_id).enqueue(new Callback<CourseBooking>() {
            @Override
            public void onResponse(Call<CourseBooking> call, Response<CourseBooking> response) {
                if (response.isSuccessful()){
                    listCourseBooking.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<CourseBooking> call, Throwable t) {
            }
        });

        return listCourseBooking;
    }
}
