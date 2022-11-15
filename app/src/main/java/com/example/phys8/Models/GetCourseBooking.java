package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class GetCourseBooking implements Parcelable {
    private List<Result> result;


    ////////////////////

    protected GetCourseBooking(Parcel in) {
    }

    public static final Creator<GetCourseBooking> CREATOR = new Creator<GetCourseBooking>() {
        @Override
        public GetCourseBooking createFromParcel(Parcel in) {
            return new GetCourseBooking(in);
        }

        @Override
        public GetCourseBooking[] newArray(int size) {
            return new GetCourseBooking[size];
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

    public static GetCourseBooking objectFromData(String str) {

        return new Gson().fromJson(str, GetCourseBooking.class);
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public static class Result {
        private int id;
        private Orphanage orphanage;
        private Course course;
        private String status;
        private String jumlah_anak;
        private String status_lokasi;
        private String is_payment;
        private String alamat_kunjungan;
        private String total_biaya_pendukung;
        private String total_biaya_kursus_perjam;
        private String start_time;
        private String jumlah_jam;
        private String tanggal_kursus;
        private Object foto_bukti_pelaksanaan;
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

        public Orphanage getOrphanage() {
            return orphanage;
        }

        public void setOrphanage(Orphanage orphanage) {
            this.orphanage = orphanage;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getJumlah_anak() {
            return jumlah_anak;
        }

        public void setJumlah_anak(String jumlah_anak) {
            this.jumlah_anak = jumlah_anak;
        }

        public String getStatus_lokasi() {
            return status_lokasi;
        }

        public void setStatus_lokasi(String status_lokasi) {
            this.status_lokasi = status_lokasi;
        }

        public String getIs_payment() {
            return is_payment;
        }

        public void setIs_payment(String is_payment) {
            this.is_payment = is_payment;
        }

        public String getAlamat_kunjungan() {
            return alamat_kunjungan;
        }

        public void setAlamat_kunjungan(String alamat_kunjungan) {
            this.alamat_kunjungan = alamat_kunjungan;
        }

        public String getTotal_biaya_pendukung() {
            return total_biaya_pendukung;
        }

        public void setTotal_biaya_pendukung(String total_biaya_pendukung) {
            this.total_biaya_pendukung = total_biaya_pendukung;
        }

        public String getTotal_biaya_kursus_perjam() {
            return total_biaya_kursus_perjam;
        }

        public void setTotal_biaya_kursus_perjam(String total_biaya_kursus_perjam) {
            this.total_biaya_kursus_perjam = total_biaya_kursus_perjam;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getJumlah_jam() {
            return jumlah_jam;
        }

        public void setJumlah_jam(String jumlah_jam) {
            this.jumlah_jam = jumlah_jam;
        }

        public String getTanggal_kursus() {
            return tanggal_kursus;
        }

        public void setTanggal_kursus(String tanggal_kursus) {
            this.tanggal_kursus = tanggal_kursus;
        }

        public Object getFoto_bukti_pelaksanaan() {
            return foto_bukti_pelaksanaan;
        }

        public void setFoto_bukti_pelaksanaan(Object foto_bukti_pelaksanaan) {
            this.foto_bukti_pelaksanaan = foto_bukti_pelaksanaan;
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

        public static class Course {
            private int id;
            private String tutor_id;
            private String skill_id;
            private String deskripsi;
            private String start_day;
            private String end_day;
            private String start_time;
            private String end_time;
            private String alamat_pertemuan;
            private String is_ready_berkunjung;
            private String batasan_jumlah_anak;
            private String total_biaya_pendukung;
            private String deskripsi_biaya_pendukung;
            private String total_biaya_kursus_perjam;
            private String created_at;
            private String updated_at;

            public static Course objectFromData(String str) {

                return new Gson().fromJson(str, Course.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTutor_id() {
                return tutor_id;
            }

            public void setTutor_id(String tutor_id) {
                this.tutor_id = tutor_id;
            }

            public String getSkill_id() {
                return skill_id;
            }

            public void setSkill_id(String skill_id) {
                this.skill_id = skill_id;
            }

            public String getDeskripsi() {
                return deskripsi;
            }

            public void setDeskripsi(String deskripsi) {
                this.deskripsi = deskripsi;
            }

            public String getStart_day() {
                return start_day;
            }

            public void setStart_day(String start_day) {
                this.start_day = start_day;
            }

            public String getEnd_day() {
                return end_day;
            }

            public void setEnd_day(String end_day) {
                this.end_day = end_day;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getAlamat_pertemuan() {
                return alamat_pertemuan;
            }

            public void setAlamat_pertemuan(String alamat_pertemuan) {
                this.alamat_pertemuan = alamat_pertemuan;
            }

            public String getIs_ready_berkunjung() {
                return is_ready_berkunjung;
            }

            public void setIs_ready_berkunjung(String is_ready_berkunjung) {
                this.is_ready_berkunjung = is_ready_berkunjung;
            }

            public String getBatasan_jumlah_anak() {
                return batasan_jumlah_anak;
            }

            public void setBatasan_jumlah_anak(String batasan_jumlah_anak) {
                this.batasan_jumlah_anak = batasan_jumlah_anak;
            }

            public String getTotal_biaya_pendukung() {
                return total_biaya_pendukung;
            }

            public void setTotal_biaya_pendukung(String total_biaya_pendukung) {
                this.total_biaya_pendukung = total_biaya_pendukung;
            }

            public String getDeskripsi_biaya_pendukung() {
                return deskripsi_biaya_pendukung;
            }

            public void setDeskripsi_biaya_pendukung(String deskripsi_biaya_pendukung) {
                this.deskripsi_biaya_pendukung = deskripsi_biaya_pendukung;
            }

            public String getTotal_biaya_kursus_perjam() {
                return total_biaya_kursus_perjam;
            }

            public void setTotal_biaya_kursus_perjam(String total_biaya_kursus_perjam) {
                this.total_biaya_kursus_perjam = total_biaya_kursus_perjam;
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
