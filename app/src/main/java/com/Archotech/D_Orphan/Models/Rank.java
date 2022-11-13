package com.Archotech.D_Orphan.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Rank implements Parcelable {

    private List<Result> result;

    protected Rank(Parcel in) {
    }

    public static final Creator<Rank> CREATOR = new Creator<Rank>() {
        @Override
        public Rank createFromParcel(Parcel in) {
            return new Rank(in);
        }

        @Override
        public Rank[] newArray(int size) {
            return new Rank[size];
        }
    };

    public static Rank objectFromData(String str) {

        return new Gson().fromJson(str, Rank.class);
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
        private int score;
        private Students students;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public Students getStudents() {
            return students;
        }

        public void setStudents(Students students) {
            this.students = students;
        }

        public static class Students {
            private int id;
            private String name;
            private String username;
            private String school;
            private String email;
            private String city;
            private String birthyear;
            private String created_at;
            private String updated_at;
            private String profile_photo_url;

            public static Students objectFromData(String str) {

                return new Gson().fromJson(str, Students.class);
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

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getBirthyear() {
                return birthyear;
            }

            public void setBirthyear(String birthyear) {
                this.birthyear = birthyear;
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

            public String getProfile_photo_url() {
                return profile_photo_url;
            }

            public void setProfile_photo_url(String profile_photo_url) {
                this.profile_photo_url = profile_photo_url;
            }
        }
    }
}
