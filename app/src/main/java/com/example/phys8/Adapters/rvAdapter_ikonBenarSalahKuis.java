package com.example.phys8.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.phys8.Models.GetQuestionWithHistoryId;
import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.R;

import java.util.ArrayList;
import java.util.List;

public class rvAdapter_ikonBenarSalahKuis extends RecyclerView.Adapter<rvAdapter_ikonBenarSalahKuis.ikonBenarSalahKuisHolder>{
    private Context context;
    private String idUser;
    boolean isStarted;
    private GetQuestionWithHistoryId.Result objResult; //sudah disesuaikan dengan level yang diinginkan
    private List<GetQuestionWithHistoryId.Result.Question> listQuestion; //sudah disesuaikan dengan level yang diinginkan

    public void setListQuestionUserAdapter(List<GetQuestionWithHistoryId.Result.Question> listQuestion, String idUser) {
        this.listQuestion = listQuestion;
        this.idUser = idUser;
    }

    public rvAdapter_ikonBenarSalahKuis(Context context, GetQuestionWithHistoryId.Result objResult) {
        this.context = context;
        this.objResult=objResult;
    }

    public List<GetQuestionWithHistoryId.Result.Question> getListQuestion(){
        return listQuestion;
    }

    public String getIdUser(){
        return idUser;
    }

    @Override
    public ikonBenarSalahKuisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_ikon_benar_salah_kuis, parent, false);
        return new ikonBenarSalahKuisHolder(view);
    }

    @Override
    public void onBindViewHolder(rvAdapter_ikonBenarSalahKuis.ikonBenarSalahKuisHolder holder, int position) {

                if (getListQuestion().get(position).getCorrect_answer_option().equalsIgnoreCase(getListQuestion().get(position).getPivot().getUser_answer())){
                    //jika jawaban user benar
                    holder.ikon_benar_salah_kuis.setImageResource(R.drawable.correct_gameplay);
                }
                else {
                    //jika user salah jawab kuis
                    holder.ikon_benar_salah_kuis.setImageResource(R.drawable.wrong_gameplay);
                }
    }

    @Override
    public int getItemCount() {
        return getListQuestion().size();
    }

    public class ikonBenarSalahKuisHolder extends RecyclerView.ViewHolder {
        ImageView ikon_benar_salah_kuis;
        public ikonBenarSalahKuisHolder(View itemView) {
            super(itemView);

            ikon_benar_salah_kuis = itemView.findViewById(R.id.ikon_benar_salah_kuis);
        }
    }
}
