package com.Archotech.D_Orphan.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.Archotech.D_Orphan.Models.GetQuestionWithHistoryId;
import com.Archotech.D_Orphan.Models.GetQuestionWithLevelid;
import com.Archotech.D_Orphan.Models.Level;
import com.Archotech.D_Orphan.Repositories.PermainanRepository;

import java.util.List;

public class PermainanViewModel extends AndroidViewModel {
    private PermainanRepository permainanRepository;

    public PermainanViewModel(Application application) {
        super(application);
    }

    public void init(String token){

        permainanRepository = PermainanRepository.getInstance(token);
    }

    //== Begin of view model to get question with level id
    private MutableLiveData<List<GetQuestionWithLevelid.Result>> resultQuestionWithLevelId = new MutableLiveData<>();
    public void getQuestionWithLevelId(String levelId){
        resultQuestionWithLevelId = permainanRepository.getQuestionWithLevelId(levelId);
    }
    public LiveData<List<GetQuestionWithLevelid.Result>> getResultQuestionWithLevelId(){return resultQuestionWithLevelId;}

    //== Begin of view model to get all level
    private MutableLiveData<List<Level.Result>> resultAllLevel = new MutableLiveData<>();
    public void getAllLevel(){
        resultAllLevel = permainanRepository.getAllLevel();
    }
    public LiveData<List<Level.Result>> getResultAllLevel(){return resultAllLevel;}

    //== Begin of view model to get level
    private MutableLiveData<List<Level.Result>> resultLevel = new MutableLiveData<>();
    public void getLevelWithID(String levelID){
        resultLevel = permainanRepository.getLevelWithID(levelID);
    }
    public LiveData<List<Level.Result>> getResultLevel(){return resultLevel;}

    private MutableLiveData<List<GetQuestionWithHistoryId.Result>> resultQuestionWithHistoryId = new MutableLiveData<>();
    public void getQuestionWithHistoryId(String quizHistoryId){
        resultQuestionWithHistoryId = permainanRepository.getQuestionWithHistoryId(quizHistoryId);
    }
    public LiveData<List<GetQuestionWithHistoryId.Result>> getResultQuestionWithHistoryId(){return resultQuestionWithHistoryId;}

    public LiveData<String> updateRewardQuiz(String quiz_history_id, int score_level, int money_level, int ticket_level, String student_id, String active){
        return permainanRepository.updateRewardQuiz(quiz_history_id, score_level, money_level, ticket_level, student_id, active);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        permainanRepository.resetInstance();
    }
}
