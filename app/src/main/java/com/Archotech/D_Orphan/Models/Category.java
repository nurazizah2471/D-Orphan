package com.Archotech.D_Orphan.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Category implements Parcelable {
    private List<Result> result;

    protected Category(Parcel in) {
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public static Category objectFromData(String str) {

        return new Gson().fromJson(str, Category.class);
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
        private int id;
        private String name;
        private String description;
        private List<Level> level;
        private String created_at;
        private String updated_at;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
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

        public List<Level> getLevel() {
            return level;
        }

        public void setLevel(List<Level> level) {
            this.level = level;
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

        public static class Level {
            private int id;
            private int fis8_category_id;
            private String name;
            private String thumbnail;
            private String description;
            private int score_reward;
            private int ticket_reward;
            private int money_reward;
            private int maximum_time;
            private String created_at;
            private String updated_at;

            public static Level objectFromData(String str) {

                return new Gson().fromJson(str, Level.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getFis8_category_id() {
                return fis8_category_id;
            }

            public void setFis8_category_id(int fis8_category_id) {
                this.fis8_category_id = fis8_category_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getScore_reward() {
                return score_reward;
            }

            public void setScore_reward(int score_reward) {
                this.score_reward = score_reward;
            }

            public int getTicket_reward() {
                return ticket_reward;
            }

            public void setTicket_reward(int ticket_reward) {
                this.ticket_reward = ticket_reward;
            }

            public int getMoney_reward() {
                return money_reward;
            }

            public void setMoney_reward(int money_reward) {
                this.money_reward = money_reward;
            }

            public int getMaximum_time() {
                return maximum_time;
            }

            public void setMaximum_time(int maximum_time) {
                this.maximum_time = maximum_time;
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
