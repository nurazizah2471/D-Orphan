package com.Archotech.D_Orphan.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Archotech.D_Orphan.Models.Rank;
import com.example.D_Orphan.R;

import java.util.List;

public class rvAdapter_peringkat extends RecyclerView.Adapter<rvAdapter_peringkat
        .rvAdapter_peringkatFragmentHolder> {

    private List<Rank.Result> listperingkat;
    private Context context;

    public List<Rank.Result> getListperingkat() {
        return listperingkat;
    }

    public void setListperingkatAdapter(List<Rank.Result> listperingkat) {
        this.listperingkat = listperingkat;
    }

    public rvAdapter_peringkat(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public rvAdapter_peringkat.rvAdapter_peringkatFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_leaderboard_profile, parent, false);
        return new rvAdapter_peringkat.rvAdapter_peringkatFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapter_peringkat.rvAdapter_peringkatFragmentHolder holder, int position) {
                        Rank.Result Rank = getListperingkat().get(position);
      holder.txt_rank_num.setText(String.valueOf(position + 1));
        holder.txt_username_leaderboard.setText(Rank.getStudents().getUsername());
        holder.coin_amount_leaderboard.setText(String.valueOf(Rank.getScore()));
    }

    @Override
    public int getItemCount() {
        return getListperingkat().size();
    }

    public class rvAdapter_peringkatFragmentHolder extends RecyclerView.ViewHolder {
       TextView txt_rank_num, txt_username_leaderboard, coin_amount_leaderboard;

        public rvAdapter_peringkatFragmentHolder(@NonNull View itemView) {
            super(itemView);
            txt_rank_num = itemView.findViewById(R.id.txt_rank_num);
            txt_username_leaderboard = itemView.findViewById(R.id.txt_username_leaderboard);
            coin_amount_leaderboard = itemView.findViewById(R.id.coin_amount_leaderboard);

        }
    }
}