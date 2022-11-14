package com.Archotech.D_Orphan.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.Archotech.D_Orphan.Helpers.SharedPreferenceHelper;
import com.Archotech.D_Orphan.ViewModels.LoginViewModel;
import com.google.android.material.textfield.TextInputLayout;
import com.example.D_Orphan.R;


public class LogInTutorFragment extends Fragment {

    TextView reg_btn;

    TextInputLayout surel_login, kata_sandi_login;
    Button btn_masuk;
    TextView btn_daftar;

    private LoginViewModel loginViewModel;
    private SharedPreferenceHelper helper;

    public LogInTutorFragment() {
    }

    public static LogInTutorFragment newInstance(String param1, String param2) {
        LogInTutorFragment fragment = new LogInTutorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log_in_tutor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        surel_login = view.findViewById(R.id.til_surel_fragment_log_in_tutor);
        kata_sandi_login = view.findViewById(R.id.til_kata_sandi_fragment_log_in_tutor);
        btn_masuk = view.findViewById(R.id.btn_masuk_fragment_log_in_tutor);

        btn_daftar = view.findViewById(R.id.btn_daftar_fragment_log_in_tutor);
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavDirections action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
//                Navigation.findNavController(view).navigate(action);
            }
        });

        loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        btn_masuk.setOnClickListener(view1 -> {
            if (!surel_login.getEditText().getText().toString().isEmpty()
                    && !kata_sandi_login.getEditText().getText().toString().isEmpty()) {
                String surel = surel_login.getEditText().getText().toString().trim();
                String kata_sandi = kata_sandi_login.getEditText().getText().toString().trim();
                loginViewModel.login(surel, kata_sandi).observe(requireActivity(), tokenResponse -> {
                    if (tokenResponse != null) {
//                        helper.saveAccessToken(tokenResponse.getAuthorization());
//                        helper.saveId(tokenResponse.getId());
//                        NavDirections actions = LoginFragmentDirections.actionLoginFragmentToGameFragment();
//                        Navigation.findNavController(view1).navigate(actions);
//                        Toast.makeText(requireActivity(), "Login Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(requireActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(requireActivity(), "Please fill all field", Toast.LENGTH_SHORT).show();
            }
        });
    }
}