package com.example.phys8.ViewModels;

import android.app.Application;
import android.graphics.Movie;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.Models.Level;
import com.example.phys8.Models.QuizHistory;
import com.example.phys8.Models.Rank;
import com.example.phys8.Models.userHistory;
import com.example.phys8.Repositories.PermainanRepository;
import com.example.phys8.Repositories.QuizHistoryRepository;

import java.util.List;

public class QuizHistoryViewModel extends AndroidViewModel {
    private QuizHistoryRepository quizHistoryRepository;

    public QuizHistoryViewModel(Application application) {
        super(application);
    }

    public void init(String token){
        quizHistoryRepository = QuizHistoryRepository.getInstance(token);
    }

    private MutableLiveData<List<QuizHistory.Result>> resultAddQuizHistory = new MutableLiveData<>();
    public void addQuizHistory(String student_id, String level_id){
        resultAddQuizHistory = quizHistoryRepository.addQuizHistory(student_id, level_id);
    }
    public LiveData<List<QuizHistory.Result>> getResultAddQuizHistory(){
        return resultAddQuizHistory;
    }

    private MutableLiveData<List<QuizHistory.Result>> resultshowQuizHistory = new MutableLiveData<>();
    public void showQuizHistory(String student_id, String level_id){
        resultshowQuizHistory = quizHistoryRepository.showQuizHistory();
    }
    public LiveData<List<QuizHistory.Result>> getResultQuizHistory(){
        return resultshowQuizHistory;
    }

    private MutableLiveData<List<userHistory.Result>> resultGetQuizHistory = new MutableLiveData<>();
    public void getQuizHistory(String student_id){
        resultGetQuizHistory = quizHistoryRepository.getQuizHistory(student_id);
    }
    public LiveData<List<userHistory.Result>> getResultGetQuizHistory(){
        return resultGetQuizHistory;
    }

    private MutableLiveData<List<Rank.Result>> resultGetRank = new MutableLiveData<>();
    public void getRank(){
        resultGetRank = quizHistoryRepository.getRank();
    }
    public LiveData<List<Rank.Result>> getResultGetRank(){
        return resultGetRank;
    }

    public LiveData<String> addUserAnswer(String quiz_history_id, String question_id, String user_answer){
        return quizHistoryRepository.addUserAnswer(quiz_history_id, question_id, user_answer);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        quizHistoryRepository.resetInstance();
    }
}
