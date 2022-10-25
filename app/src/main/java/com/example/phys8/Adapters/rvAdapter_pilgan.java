package com.example.phys8.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phys8.Models.GetQuestionWithHistoryId;
import com.example.phys8.Models.GetQuestionWithLevelid;
import com.example.phys8.Models.Level;
import com.example.phys8.R;

import java.util.List;

public class rvAdapter_pilgan extends RecyclerView.Adapter<rvAdapter_pilgan
        .rvAdapter_pilganFragmentHolder>{

    private List<GetQuestionWithLevelid.Result.AnswerOption> listPilgan;
    private Context context;

    public List<GetQuestionWithLevelid.Result.AnswerOption> getListPilgan(){
        return listPilgan;
    }

    public void setListPilganAdapter(List<GetQuestionWithLevelid.Result.AnswerOption> listPilgan){
        this.listPilgan=listPilgan;
    }

    public rvAdapter_pilgan(Context context){
        this.context=context;
    }

    @Override
    public rvAdapter_pilganFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pilgan_permainan_fragment, parent, false);
        return new rvAdapter_pilganFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(rvAdapter_pilgan.rvAdapter_pilganFragmentHolder holder, int position) {
        holder.textPilgan_permainanFragment.setText(getListPilgan().get(position).getOption_text());
    }

    @Override
    public int getItemCount() {
        return getListPilgan().size();
    }

    public class rvAdapter_pilganFragmentHolder extends RecyclerView.ViewHolder {

        TextView textPilgan_permainanFragment;
        public rvAdapter_pilganFragmentHolder(View itemView) {
            super(itemView);
            textPilgan_permainanFragment = itemView.findViewById(R.id.textPilgan_permainanFragment);
        }
    }
}
