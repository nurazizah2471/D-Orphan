package com.Archotech.D_Orphan.Retrofit;

import com.Archotech.D_Orphan.Models.GetQuestionWithHistoryId;
import com.Archotech.D_Orphan.Models.GetQuestionWithLevelid;
import com.Archotech.D_Orphan.Models.Level;
import com.Archotech.D_Orphan.Models.QuizHistory;
import com.Archotech.D_Orphan.Models.Rank;
import com.Archotech.D_Orphan.Models.Register;
import com.Archotech.D_Orphan.Models.TokenResponse;
import com.Archotech.D_Orphan.Models.User;
import com.Archotech.D_Orphan.Models.userHistory;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndPoint {
    @POST("login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<Register> register(@Field("name") String name, @Field("email") String email,
                            @Field("password") String password,
                            @Field("password_confirmation") String password_confirmation);

    @POST("logout")
    @FormUrlEncoded
    Call<JsonObject> logout(@Field("student_id") String student_id);

    @GET("myuser")
    Call<User> getUsers();

    @GET("question/{levelId}")
    Call<GetQuestionWithLevelid> getQuestionWithLevelId(@Path("levelId") String levelId);

    @GET("level")
    Call<Level> getAllLevel();

    @GET("level/{levelId}")
    Call<Level> getLevelWithID(@Path("levelId") String level_id);

    @POST("quiz_history")
    @FormUrlEncoded
    Call<QuizHistory> addQuizHistory(@Field("student_id") String student_id,
                                     @Field("fis8_level_id") String fis8_level_id,
                                     @Field("user_id") String userId);

    @GET("quiz_history_all")
    Call<QuizHistory> showQuizHistory();

    @GET("user_history/{student_id}")

    Call<userHistory> getQuizHistory(@Path("student_id") String student_id);

    @POST("user_answer")
    @FormUrlEncoded
    Call<JsonObject> addUserAnswer(@Field("quiz_history_id") String quiz_history_id,
                                   @Field("question_id") String question_id,
                                   @Field("user_answer") String user_answer,
                                   @Field("user_id") String userId);

    @GET("rank")

    Call<Rank> getRank();

    @GET("quiz_history/{quizHistoryId}")
    Call<GetQuestionWithHistoryId> getQuestionWithHistoryId(@Path("quizHistoryId") String quizHistoryId);

    @GET("myuser/{myUserId}")
    Call<User> getUserWithId(@Path("myUserId") String myUserId);

    @POST("add_reward")
    @FormUrlEncoded
    Call<JsonObject> updateRewardQuiz(@Field("history_id") String quiz_history_id,
                                      @Field("score_level") int score_level,
                                      @Field("money_level") int money_level,
                                      @Field("ticket_level") int ticket_level,
                                      @Field("student_id") String student_id,
                                      @Field("active") String active);
}
