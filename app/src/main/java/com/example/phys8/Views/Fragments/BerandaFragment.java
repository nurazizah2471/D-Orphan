package com.example.phys8.Views.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.User;
import com.example.phys8.R;
import com.example.phys8.ViewModels.ProfileViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BerandaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BerandaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BerandaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaFragment newInstance(String param1, String param2) {
        BerandaFragment fragment = new BerandaFragment();
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
        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

    private ImageView btnPlayGame_berandaFragment, btn_exit;
    private CardView card_profile;
    private TextView textView12;
    private ProfileViewModel profileViewModel;
    private MediaPlayer mediaPlayer;
    private ConstraintLayout loadBeranda;

    private SharedPreferenceHelper helper;
    TextView ticket_amount, cash_amount, coin_amount, name_user;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inisialisasi();

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.clicksound);

        profileViewModel.init(helper.getAccessToken());
        profileViewModel.getUserWithId(helper.getUserId());
       // profileViewModel.getResultUserWithId().observe(getActivity(), showResultUserInfo);

        card_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                //Navigation.findNavController(v).navigate(R.id.action_berandaFragment_to_profileFragment);
            }
        });

        btnPlayGame_berandaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                //Navigation.findNavController(view).navigate(R.id.action_berandaFragment_to_pilihLevelFragment);
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileViewModel.init(helper.getAccessToken()); //unsend
                profileViewModel.logout().observe(requireActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        helper.clearPref();

                        Toast.makeText(requireActivity(), s, Toast.LENGTH_SHORT).show();
                       // Navigation.findNavController(v).navigate(R.id.action_berandaFragment_to_loginFragment);
                    }
                });
            }
        });
    }

//    private Observer<User.Result> showResultUserInfo = new Observer<User.Result>() {
//        @Override
//        public void onChanged(User.Result results) {
//            if(results.getUsername().length()>15) {
//                name_user.setText(String.valueOf(results.getUsername().subSequence(0, 16)+"..."));
//            }else {
//                name_user.setText(String.valueOf(results.getUsername()));
//            }
//            cash_amount.setText(String.valueOf(results.getMyuser().getMoney()));
//            ticket_amount.setText(String.valueOf(results.getMyuser().getTicket()));
//            coin_amount.setText(String.valueOf(results.getMyuser().getScore()));
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    loadBeranda.setVisibility(View.GONE); // Hide Progress bar
//                }
//            }, 300);
//        }
//    };

    private void inisialisasi() {
        ticket_amount = getActivity().findViewById(R.id.ticket_amount);
        cash_amount = getActivity().findViewById(R.id.cash_amount);
        coin_amount = getActivity().findViewById(R.id.coin_amount);
        name_user = getActivity().findViewById(R.id.name_user);
        btn_exit = getActivity().findViewById(R.id.btn_exit);
        card_profile = getActivity().findViewById(R.id.card_profile);
        loadBeranda = getActivity().findViewById(R.id.loadBeranda);
        btnPlayGame_berandaFragment = getActivity().findViewById(R.id.btnPlayGame_berandaFragment);
        profileViewModel=new ViewModelProvider(getActivity()).get(ProfileViewModel.class);
        helper = SharedPreferenceHelper.getInstance(requireActivity());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}