package com.example.phys8.Views.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phys8.Adapters.rvAdapter_level;
import com.example.phys8.Adapters.rvAdapter_tabBerlangsungKursus;
import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.Level;
import com.example.phys8.R;
import com.example.phys8.ViewModels.CourseBookingViewModel;
import com.example.phys8.ViewModels.PermainanViewModel;
import com.example.phys8.ViewModels.QuizHistoryViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabPesananKursus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabPesananKursus extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabPesananKursus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabPesananKursus.
     */
    // TODO: Rename and change types and number of parameters
    public static TabPesananKursus newInstance(String param1, String param2) {
        TabPesananKursus fragment = new TabPesananKursus();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_tab_pesanan_kursus, container, false);
    }

//    private RecyclerView rv_tab_pesanan_item_rycyclerView;
//    private rvAdapter_tabBerlangsungKursus adapter_tabBerlangsungKursus;
//    private CourseBookingViewModel;
//    private QuizHistoryViewModel quizHistoryViewModel;
//    private SharedPreferenceHelper helper;
//    private int numberOfColumns, bundleLevelId, score_level, money_level, ticket_level, positions;
//    private View myv;
//    String checkAvailable;
//    private Bundle bundle;
//    private List<Level.Result> arrayListLevel;
//    private MediaPlayer mediaPlayer;
//    private ConstraintLayout loadLevel;
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initial(view);
//        rg_type_user_change();
//        registerProccess();
//    }
}