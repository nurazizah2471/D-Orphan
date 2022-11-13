package com.Archotech.D_Orphan.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Archotech.D_Orphan.Adapters.rvAdapter_peringkat;
import com.Archotech.D_Orphan.Helpers.SharedPreferenceHelper;
import com.Archotech.D_Orphan.Models.Rank;
import com.example.D_Orphan.R;
import com.Archotech.D_Orphan.ViewModels.QuizHistoryViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeaderboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeaderboardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LeaderboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeaderboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeaderboardFragment newInstance(String param1, String param2) {
        LeaderboardFragment fragment = new LeaderboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView rv_leaderBoard;
    private QuizHistoryViewModel quizHistoryViewModel;
    private SharedPreferenceHelper helper;
    private List<Rank.Result> arrayRank;
    private rvAdapter_peringkat adapter_peringkat;
    private ConstraintLayout loadLeaderboard;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inisialisasi(view);

        quizHistoryViewModel.init(helper.getAccessToken());// unsend
        quizHistoryViewModel.getRank();
        quizHistoryViewModel.getResultGetRank().observe(getActivity(), showResultRank);
    }

    private void inisialisasi(View view) {
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        rv_leaderBoard = view.findViewById(R.id.rv_leaderBoard);
        loadLeaderboard = getActivity().findViewById(R.id.loadLeaderboard);
        quizHistoryViewModel=new ViewModelProvider(getActivity()).get(QuizHistoryViewModel.class);
    }

    private Observer<List<Rank.Result>> showResultRank = new Observer<List<Rank.Result>>() {
        @Override
        public void onChanged(List<Rank.Result> results) {
            if(results!=null) {
                set_RVRank(results);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadLeaderboard.setVisibility(View.GONE); // Hide Progress bar
                    }
                }, 300);
            }
        }
    };

    private void set_RVRank(List<Rank.Result> results) {
        rv_leaderBoard.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter_peringkat = new rvAdapter_peringkat(getActivity());
        adapter_peringkat.setListperingkatAdapter(results);
        rv_leaderBoard.setAdapter(adapter_peringkat);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaderboard, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}