package com.Archotech.D_Orphan.Views.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.Archotech.D_Orphan.Helpers.SharedPreferenceHelper;
import com.example.D_Orphan.R;

public class SplashScreenFragment extends Fragment {
    LinearLayout linearLayout_splash_screen_fragment;
    TextView txt_app_version_splash_screen_fragment;

    private static final int splashtime = 3000;
    private static final String TAG = "SplashScreenFragment";

    Animation bottomAnimation;

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

//        SharedPreferenceHelper helper = SharedPreferenceHelper.getInstance(requireActivity());

        bottomAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.bottom_animation);

        linearLayout_splash_screen_fragment = view.findViewById(R.id.linearlayout_fragment_splash_screen);
        txt_app_version_splash_screen_fragment = view.findViewById(R.id.txt_slogan_fragment_splash_screen);

        linearLayout_splash_screen_fragment.setAnimation(bottomAnimation);
        txt_app_version_splash_screen_fragment.setAnimation(bottomAnimation);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            NavDirections action;
            if (SharedPreferenceHelper.getAccessToken().isEmpty()) {
                action = SplashScreenFragmentDirections.actionSplashFragmentToLoginFragment();
            } else {
                action = SplashScreenFragmentDirections.actionSplashFragmentToLoginFragment();
            }
            Navigation.findNavController(view).navigate(action);
        }, splashtime);
    }
}