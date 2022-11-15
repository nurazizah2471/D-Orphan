package com.example.phys8.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phys8.Models.CourseBooking;
import com.example.phys8.Models.Level;
import com.example.phys8.Models.Rank;
import com.example.phys8.R;

import java.util.List;

public class rvAdapter_tabBerlangsungKursus extends RecyclerView.Adapter<com.example.phys8.Adapters.rvAdapter_tabBerlangsungKursus
            .rvAdapter_tabBerlangsungKursusFragmentHolder> {

        private List<CourseBooking.Result> listCourseBooking;
        private Context context;

        public List<CourseBooking.Result> getListCourseBooking(){
            return listCourseBooking;
        }

        public void setListCourseBookingAdapter(List<CourseBooking.Result> listCourseBooking){
            this.listCourseBooking=listCourseBooking;
        }

        public rvAdapter_tabBerlangsungKursus(Context context){
            this.context=context;
        }
        @NonNull
        @Override
        public com.example.phys8.Adapters.rvAdapter_tabBerlangsungKursus.rvAdapter_tabBerlangsungKursusFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pesanan_kursus_fragment_kursus, parent, false);
            return new com.example.phys8.Adapters.rvAdapter_tabBerlangsungKursus.rvAdapter_tabBerlangsungKursusFragmentHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.phys8.Adapters.rvAdapter_tabBerlangsungKursus.rvAdapter_tabBerlangsungKursusFragmentHolder holder, int position) {
            CourseBooking.Result course_booking = getListCourseBooking().get(position);
            holder.cardview_hargaperjam_pesanan_fragment_kursus.setText(course_booking.getTotal_biaya_kursus_perjam());
            holder.cardview_jumlahjam_pesanan_fragment_kursus.setText(course_booking.getJumlah_jam());
            holder.cardview_tanggal_pesanan_fragment_kursus.setText(course_booking.getTanggal_kursus());
        }

        @Override
        public int getItemCount() {
            return getListCourseBooking().size();
        }

        public class rvAdapter_tabBerlangsungKursusFragmentHolder extends RecyclerView.ViewHolder {
            TextView cardview_hargaperjam_pesanan_fragment_kursus,
                    cardview_jumlahjam_pesanan_fragment_kursus, cardview_tanggal_pesanan_fragment_kursus;
            Button btn_batalkan_pesanan_fragment_kursus;

            public rvAdapter_tabBerlangsungKursusFragmentHolder(@NonNull View itemView) {
                super(itemView);
                cardview_hargaperjam_pesanan_fragment_kursus=itemView.findViewById(R.id.cardview_hargaperjam_pesanan_fragment_kursus);
                cardview_jumlahjam_pesanan_fragment_kursus=itemView.findViewById(R.id.cardview_jumlahjam_pesanan_fragment_kursus);
                cardview_tanggal_pesanan_fragment_kursus=itemView.findViewById(R.id.cardview_tanggal_pesanan_fragment_kursus);
                btn_batalkan_pesanan_fragment_kursus=itemView.findViewById(R.id.btn_batalkan_pesanan_fragment_kursus);
            }
        }
    }
