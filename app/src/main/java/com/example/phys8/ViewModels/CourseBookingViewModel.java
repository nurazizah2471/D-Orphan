package com.example.phys8.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.CourseBooking;
import com.example.phys8.Models.QuizHistory;
import com.example.phys8.Repositories.CourseBookingRepository;
import com.example.phys8.Repositories.QuizHistoryRepository;

import java.util.List;

public class CourseBookingViewModel extends AndroidViewModel {

    private CourseBookingRepository courseBookingRepository;

    public CourseBookingViewModel(Application application) {
        super(application);
    }

    public void init(String token){
        courseBookingRepository = CourseBookingRepository.getInstance(token);
    }

    private MutableLiveData<List<CourseBooking.Result>> resultGetCourseBooking = new MutableLiveData<>();
    public void getCourseBooking(String user_id, int type_user){
        resultGetCourseBooking = courseBookingRepository.getCourseBooking(user_id, type_user);
    }
    public LiveData<List<CourseBooking.Result>> getResultGetCourseBooking(){
        return resultGetCourseBooking;
    }
}
