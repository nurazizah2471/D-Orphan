package com.example.phys8.Views.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.R;

public class SplashScreenFragment extends Fragment {

    LinearLayout linearlayout_fragment_splash_screen;
    TextView txt_slogan_fragment_splash_screent;

    private static final int splashtime = 3000;
    private static final String TAG = "SplashScreenFragment";

    public SplashScreenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linearlayout_fragment_splash_screen = view.findViewById(R.id.linearlayout_fragment_splash_screen);
        txt_slogan_fragment_splash_screent = view.findViewById(R.id.txt_slogan_fragment_splash_screen);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            NavDirections action;
            if (SharedPreferenceHelper.getAccessToken().isEmpty()) {
                action = SplashScreenFragmentDirections.actionSplashScreenFragmentToLoginFragment();
            } else {
                action = SplashScreenFragmentDirections.actionSplashScreenFragmentToLoginFragment();
            }
            Navigation.findNavController(view).navigate(action);
        }, splashtime);
        Navigation.findNavController(view).navigate(R.id.action_splashScreenFragment_to_loginFragment);
    }
}