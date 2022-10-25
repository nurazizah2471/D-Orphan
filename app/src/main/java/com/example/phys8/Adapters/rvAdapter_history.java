package com.example.phys8.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phys8.Models.userHistory;
import com.example.phys8.R;

import java.util.List;

public class rvAdapter_history extends RecyclerView.Adapter<rvAdapter_history
        .rvAdapter_historyFragmentHolder> {

    private List<userHistory.Result> listhistory;
    private Context context;

    public List<userHistory.Result> getListhistory() {
        return listhistory;
    }

    public void setListhistoryAdapter(List<userHistory.Result> listhistory) {
        this.listhistory = listhistory;
    }

    public rvAdapter_history(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public rvAdapter_history.rvAdapter_historyFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_history_profile, parent, false);
        return new rvAdapter_history.rvAdapter_historyFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapter_history.rvAdapter_historyFragmentHolder holder, int position) {
                        userHistory.Result history = getListhistory().get(position);
                        
        holder.txt_history_level.setText(history.getLevelName());
        holder.txt_history_correct_answers.setText(String.valueOf(history.getUserHistory().getSum_correct_answer())+"/"+history.getQuestions().size());
        holder.txt_history_score.setText(String.valueOf(history.getUserHistory().getScore()));
    }

    @Override
    public int getItemCount() {
        return getListhistory().size();
    }

    public class rvAdapter_historyFragmentHolder extends RecyclerView.ViewHolder {
       TextView txt_history_level, txt_history_correct_answers, txt_history_score;

        public rvAdapter_historyFragmentHolder(@NonNull View itemView) {
            super(itemView);
            txt_history_level = itemView.findViewById(R.id.txt_history_level);
            txt_history_correct_answers = itemView.findViewById(R.id.txt_history_correct_answers);
            txt_history_score = itemView.findViewById(R.id.txt_history_score);

        }
    }
}