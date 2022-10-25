package com.example.phys8.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phys8.Models.Level;
import com.example.phys8.R;

import java.util.List;

public class rvAdapter_level extends RecyclerView.Adapter<rvAdapter_level
        .rvAdapter_levelFragmentHolder> {

    private List<Level.Result> listLevel;
    private Context context;

    public List<Level.Result> getListLevel(){
        return listLevel;
    }

    public void setListLevelAdapter(List<Level.Result> listLevel){
        this.listLevel=listLevel;
    }

    public rvAdapter_level(Context context){
        this.context=context;
    }
    @NonNull
    @Override
    public rvAdapter_levelFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_level_game, parent, false);
        return new rvAdapter_levelFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapter_level.rvAdapter_levelFragmentHolder holder, int position) {
        holder.textLevel_levelFragment.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return getListLevel().size();
    }

    public class rvAdapter_levelFragmentHolder extends RecyclerView.ViewHolder {
        TextView textLevel_levelFragment;
        public rvAdapter_levelFragmentHolder(@NonNull View itemView) {
            super(itemView);
            textLevel_levelFragment=itemView.findViewById(R.id.textLevel_levelFragment);
        }
    }
}

