package com.example.phys8.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.QuizHistory;
import com.example.phys8.Models.Rank;
import com.example.phys8.Models.userHistory;
import com.example.phys8.Retrofit.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizHistoryRepository {
    private static QuizHistoryRepository quizHistoryRepository;
    private ApiService apiService;

    private QuizHistoryRepository(String token){
        apiService = ApiService.getInstance(token);
    }

    public static QuizHistoryRepository getInstance(String token){
        if (quizHistoryRepository == null){
            quizHistoryRepository = new QuizHistoryRepository(token);
        }
        return quizHistoryRepository;
    }

    public static synchronized void resetInstance(){
        if (quizHistoryRepository != null){
            quizHistoryRepository = null;
        }else {
            quizHistoryRepository = null;
        }
    }

    public MutableLiveData<List<QuizHistory.Result>> addQuizHistory(String student_id, String level_id){
        final MutableLiveData<List<QuizHistory.Result>> listAddHistory = new MutableLiveData<>();
        apiService.addQuizHistory(student_id, level_id).enqueue(new Callback<QuizHistory>() {
            @Override
            public void onResponse(Call<QuizHistory> call, Response<QuizHistory> response) {
                if (response.isSuccessful()){
                    listAddHistory.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<QuizHistory> call, Throwable t) {
            }
        });
        return listAddHistory;
    }

    public MutableLiveData<List<QuizHistory.Result>> showQuizHistory(){
        final MutableLiveData<List<QuizHistory.Result>> listshowHistory = new MutableLiveData<>();
        apiService.showQuizHistory().enqueue(new Callback<QuizHistory>() {
            @Override
            public void onResponse(Call<QuizHistory> call, Response<QuizHistory> response) {
                if (response.isSuccessful()){
                    listshowHistory.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<QuizHistory> call, Throwable t) {
            }
        });
        return listshowHistory;
    }

    public MutableLiveData<List<userHistory.Result>> getQuizHistory(String student_id){
        final MutableLiveData<List<userHistory.Result>> listGetHistory = new MutableLiveData<>();
        apiService.getQuizHistory(student_id).enqueue(new Callback<userHistory>() {
            @Override
            public void onResponse(Call<userHistory> call, Response<userHistory> response) {
                if (response.isSuccessful()){
                    listGetHistory.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<userHistory> call, Throwable t) {
            }
        });
        return listGetHistory;
    }

    public MutableLiveData<List<Rank.Result>> getRank(){
        final MutableLiveData<List<Rank.Result>> listGetRank = new MutableLiveData<>();
        apiService.getRank().enqueue(new Callback<Rank>() {
            @Override
            public void onResponse(Call<Rank> call, Response<Rank> response) {
                if (response.isSuccessful()){
                    listGetRank.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<Rank> call, Throwable t) {
            }
        });
        return listGetRank;
    }

    public LiveData<String> addUserAnswer(String quiz_history_id, String question_id, String user_answer) {
        final MutableLiveData<String> message = new MutableLiveData<>();
        apiService.addUserAnswer(quiz_history_id, question_id, user_answer) .enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            message.postValue(msg);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
        return message;
    }
}
