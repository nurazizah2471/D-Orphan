package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class userHistory implements Parcelable {

    private List<Result> result;

    protected userHistory(Parcel in) {
    }

    public static final Creator<userHistory> CREATOR = new Creator<userHistory>() {
        @Override
        public userHistory createFromParcel(Parcel in) {
            return new userHistory(in);
        }

        @Override
        public userHistory[] newArray(int size) {
            return new userHistory[size];
        }
    };

    public static userHistory objectFromData(String str) {

        return new Gson().fromJson(str, userHistory.class);
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class Result {
        private int levelId;
        private String levelName;
        private List<Questions> questions;
        private Category category;
        private UserHistory userHistory;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public int getLevelId() {
            return levelId;
        }

        public void setLevelId(int levelId) {
            this.levelId = levelId;
        }

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public List<Questions> getQuestions() {
            return questions;
        }

        public void setQuestions(List<Questions> questions) {
            this.questions = questions;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public UserHistory getUserHistory() {
            return userHistory;
        }

        public void setUserHistory(UserHistory userHistory) {
            this.userHistory = userHistory;
        }

        public static class Category {
            private int id;
            private String name;
            private String description;
            private String created_at;
            private String updated_at;

            public static Category objectFromData(String str) {

                return new Gson().fromJson(str, Category.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }

        public static class UserHistory {
            private int student_id;
            private int fis8_level_id;
            private int id;
            private int score;
            private int money_reward;
            private int ticket_reward;
            private int sum_correct_answer;
            private String created_at;

            public static UserHistory objectFromData(String str) {

                return new Gson().fromJson(str, UserHistory.class);
            }

            public int getStudent_id() {
                return student_id;
            }

            public void setStudent_id(int student_id) {
                this.student_id = student_id;
            }

            public int getFis8_level_id() {
                return fis8_level_id;
            }

            public void setFis8_level_id(int fis8_level_id) {
                this.fis8_level_id = fis8_level_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getMoney_reward() {
                return money_reward;
            }

            public void setMoney_reward(int money_reward) {
                this.money_reward = money_reward;
            }

            public int getTicket_reward() {
                return ticket_reward;
            }

            public void setTicket_reward(int ticket_reward) {
                this.ticket_reward = ticket_reward;
            }

            public int getSum_correct_answer() {
                return sum_correct_answer;
            }

            public void setSum_correct_answer(int sum_correct_answer) {
                this.sum_correct_answer = sum_correct_answer;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }
        }

        public static class Questions {
            private int id;
            private int fis8_level_id;
            private String question_text;
            private String correct_answer_option;
            private String discussion;
            private String created_at;
            private String updated_at;

            public static Questions objectFromData(String str) {

                return new Gson().fromJson(str, Questions.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getFis8_level_id() {
                return fis8_level_id;
            }

            public void setFis8_level_id(int fis8_level_id) {
                this.fis8_level_id = fis8_level_id;
            }

            public String getQuestion_text() {
                return question_text;
            }

            public void setQuestion_text(String question_text) {
                this.question_text = question_text;
            }

            public String getCorrect_answer_option() {
                return correct_answer_option;
            }

            public void setCorrect_answer_option(String correct_answer_option) {
                this.correct_answer_option = correct_answer_option;
            }

            public String getDiscussion() {
                return discussion;
            }

            public void setDiscussion(String discussion) {
                this.discussion = discussion;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
