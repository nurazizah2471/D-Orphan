package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class User implements Parcelable {


    private List<Result> result;


    ////////////////////

    protected User(Parcel in) {
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
    //////////////////

    public static User objectFromData(String str) {

        return new Gson().fromJson(str, User.class);
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public static class Result {
        private int id;
        private String name;
        private String gender;
        private String email;
        private String password;
        private String phone_number;
        private String type_user;
        private String alamat;
        private Object foto_ktp;
        private String is_login;
        private String is_active;
        private String saldo;
        private String email_verified_at;
        private String created_at;
        private String updated_at;
        private Orphanage orphanage;

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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getType_user() {
            return type_user;
        }

        public void setType_user(String type_user) {
            this.type_user = type_user;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public Object getFoto_ktp() {
            return foto_ktp;
        }

        public void setFoto_ktp(Object foto_ktp) {
            this.foto_ktp = foto_ktp;
        }

        public String getIs_login() {
            return is_login;
        }

        public void setIs_login(String is_login) {
            this.is_login = is_login;
        }

        public String getIs_active() {
            return is_active;
        }

        public void setIs_active(String is_active) {
            this.is_active = is_active;
        }

        public String getSaldo() {
            return saldo;
        }

        public void setSaldo(String saldo) {
            this.saldo = saldo;
        }

        public String getEmail_verified_at() {
            return email_verified_at;
        }

        public void setEmail_verified_at(String email_verified_at) {
            this.email_verified_at = email_verified_at;
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

        public Orphanage getOrphanage() {
            return orphanage;
        }

        public void setOrphanage(Orphanage orphanage) {
            this.orphanage = orphanage;
        }

        public static class Orphanage {
            private int id;
            private String user_id;
            private String nama_panti;
            private Object deskripsi;
            private String tanggal_berdiri;
            private Object foto_panti_1;
            private Object foto_panti_2;
            private Object foto_panti_3;
            private String created_at;
            private String updated_at;

            public static Orphanage objectFromData(String str) {

                return new Gson().fromJson(str, Orphanage.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getNama_panti() {
                return nama_panti;
            }

            public void setNama_panti(String nama_panti) {
                this.nama_panti = nama_panti;
            }

            public Object getDeskripsi() {
                return deskripsi;
            }

            public void setDeskripsi(Object deskripsi) {
                this.deskripsi = deskripsi;
            }

            public String getTanggal_berdiri() {
                return tanggal_berdiri;
            }

            public void setTanggal_berdiri(String tanggal_berdiri) {
                this.tanggal_berdiri = tanggal_berdiri;
            }

            public Object getFoto_panti_1() {
                return foto_panti_1;
            }

            public void setFoto_panti_1(Object foto_panti_1) {
                this.foto_panti_1 = foto_panti_1;
            }

            public Object getFoto_panti_2() {
                return foto_panti_2;
            }

            public void setFoto_panti_2(Object foto_panti_2) {
                this.foto_panti_2 = foto_panti_2;
            }

            public Object getFoto_panti_3() {
                return foto_panti_3;
            }

            public void setFoto_panti_3(Object foto_panti_3) {
                this.foto_panti_3 = foto_panti_3;
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
