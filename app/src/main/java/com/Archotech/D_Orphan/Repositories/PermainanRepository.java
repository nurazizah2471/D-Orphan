package com.Archotech.D_Orphan.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.Archotech.D_Orphan.Models.GetQuestionWithHistoryId;
import com.Archotech.D_Orphan.Models.GetQuestionWithLevelid;
import com.Archotech.D_Orphan.Models.Level;
import com.Archotech.D_Orphan.Retrofit.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PermainanRepository {
    private static PermainanRepository permainanRepository;
    private ApiService apiService;

    private PermainanRepository(String token){
        apiService = ApiService.getInstance(token);
    }

    public static PermainanRepository getInstance(String token){
        if (permainanRepository == null){
            permainanRepository = new PermainanRepository(token);
        }
        return permainanRepository;
    }

    public static synchronized void resetInstance(){
        if (permainanRepository != null){
            permainanRepository = null;
        }else {
            permainanRepository = null;
        }
    }

    public MutableLiveData<List<GetQuestionWithLevelid.Result>> getQuestionWithLevelId(String levelId){
        final MutableLiveData<List<GetQuestionWithLevelid.Result>> listQuestionWithLevelId = new MutableLiveData<>();

        apiService.getQuestionWithLevelId(levelId).enqueue(new Callback<GetQuestionWithLevelid>() {
            @Override
            public void onResponse(Call<GetQuestionWithLevelid> call, Response<GetQuestionWithLevelid> response) {
                if (response.isSuccessful()){
                        listQuestionWithLevelId.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<GetQuestionWithLevelid> call, Throwable t) {
            }
        });

        return listQuestionWithLevelId;
    }

    public MutableLiveData<List<Level.Result>> getAllLevel(){
        final MutableLiveData<List<Level.Result>> listAllLevel = new MutableLiveData<>();
        apiService.getAllLevel().enqueue(new Callback<Level>() {
            @Override
            public void onResponse(Call<Level> call, Response<Level> response) {
                if (response.isSuccessful()){
                    listAllLevel.postValue(response.body().getResult());
                }
            }
            @Override
            public void onFailure(Call<Level> call, Throwable t) {
            }
        });

        return listAllLevel;
    }

    public MutableLiveData<List<Level.Result>> getLevelWithID(String levelID){
        final MutableLiveData<List<Level.Result>> listLevel = new MutableLiveData<>();
        apiService.getLevelWithID(levelID).enqueue(new Callback<Level>() {
            @Override
            public void onResponse(Call<Level> call, Response<Level> response) {
                if (response.isSuccessful()){
                    listLevel.postValue(response.body().getResult());
                }
            }
            @Override
            public void onFailure(Call<Level> call, Throwable t) {
            }
        });

        return listLevel;
    }

    public MutableLiveData<List<GetQuestionWithHistoryId.Result>> getQuestionWithHistoryId(String quizHistoryId){
        final MutableLiveData<List<GetQuestionWithHistoryId.Result>> listQuestionWithHistoryId = new MutableLiveData<>();
        apiService.getQuestionWithHistoryId(quizHistoryId).enqueue(new Callback<GetQuestionWithHistoryId>() {
            @Override
            public void onResponse(Call<GetQuestionWithHistoryId> call, Response<GetQuestionWithHistoryId> response) {
                if (response.isSuccessful()){
                    listQuestionWithHistoryId.postValue(response.body().getResult());

                }
            }

            @Override
            public void onFailure(Call<GetQuestionWithHistoryId> call, Throwable t) {
            }
        });

        return listQuestionWithHistoryId;
    }

    public LiveData<String> updateRewardQuiz(String quiz_history_id, int score_level, int money_level, int ticket_level, String student_id, String active){
        final MutableLiveData<String> message = new MutableLiveData<>();
        apiService.updateRewardQuiz(quiz_history_id, score_level, money_level, ticket_level, student_id, active).enqueue(new Callback<JsonObject>() {
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
