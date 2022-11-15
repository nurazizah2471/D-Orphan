package com.example.phys8.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.User;
import com.example.phys8.R;
import com.example.phys8.ViewModels.LoginViewModel;
import com.example.phys8.ViewModels.UserViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    private TextInputLayout til_email_fragment_fragment_ubah_peserta_kursus, til_kata_sandi_fragment_log_in;
    private Button btn_masuk_fragment_log_in;
    private TextView txt_btn_masuk_fragment_log_in, btn_daftar_fragment_log_in;
    private LoginViewModel loginViewModel;
    private UserViewModel userViewModel;
    private SharedPreferenceHelper helper;
    private ProgressBar progressBar_fragment_login;
    private String objEmailLogin, objPassLogin;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        helper = SharedPreferenceHelper.getInstance(requireActivity());

        if(helper.getUserId()!=""){
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_kursusFragment);
        }else{
            initial(view);
            loginProccess();
            goToRegisterFragment();
        }
    }
    private void goToRegisterFragment(){
        btn_daftar_fragment_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment2);
            }
        });
    }
    private void loginProccess(){
        btn_masuk_fragment_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              loadingButtonSubmitLogin(true);

              objEmailLogin = til_email_fragment_fragment_ubah_peserta_kursus.getEditText().getText().toString().trim();
              objPassLogin = til_kata_sandi_fragment_log_in.getEditText().getText().toString().trim();

              loginViewModel.login(objEmailLogin, objPassLogin).observe(LoginFragment.this.requireActivity(), tokenResponse -> {
                  if (tokenResponse != null) {
                      if(tokenResponse.getResult()!=null) {
                          btn_masuk_fragment_log_in.setEnabled(true);
                          helper.saveAccessToken(tokenResponse.getResult().getAuthorization(), tokenResponse.getUserId());

                          Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_kursusFragment);
                          Toast.makeText(LoginFragment.this.requireActivity(), tokenResponse.getStatus(), Toast.LENGTH_SHORT).show();
                      }else{
                          loadingButtonSubmitLogin(false);
                          Toast.makeText(LoginFragment.this.requireActivity(), tokenResponse.getStatus(), Toast.LENGTH_SHORT).show();
                      }
                  } else {
                      loadingButtonSubmitLogin(false);
                      Toast.makeText(LoginFragment.this.requireActivity(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                  }
              });
            }
        });
    }

    private void setActivationButton(Boolean check){
        btn_masuk_fragment_log_in.setEnabled(check);
        if(check){
            btn_masuk_fragment_log_in.setBackgroundResource(R.drawable.bg_btn_red_active);
        }else{
            btn_masuk_fragment_log_in.setBackgroundResource(R.drawable.bg_btn_nonactive);
        }
    }

    private void loadingButtonSubmitLogin(Boolean check){
        if(check){
            btn_masuk_fragment_log_in.setEnabled(!check);
            progressBar_fragment_login.setVisibility(View.VISIBLE);
            txt_btn_masuk_fragment_log_in.setText("Silakan tunggu");
            btn_masuk_fragment_log_in.setBackground(getResources().getDrawable(R.drawable.bg_btn_red_inloading));
        }else{
            progressBar_fragment_login.setVisibility(View.GONE);
            txt_btn_masuk_fragment_log_in.setText("Masuk");
            btn_masuk_fragment_log_in.setBackground(getResources().getDrawable(R.drawable.bg_btn_red_active));
            btn_masuk_fragment_log_in.setEnabled(!check);
        }
    }

    private void initial(View view) {
        til_email_fragment_fragment_ubah_peserta_kursus = getActivity().findViewById(R.id.til_email_fragment_fragment_ubah_peserta_kursus);
        til_kata_sandi_fragment_log_in = getActivity().findViewById(R.id.til_kata_sandi_fragment_log_in);
        btn_masuk_fragment_log_in = getActivity().findViewById(R.id.btn_masuk_fragment_log_in);
        progressBar_fragment_login = view.findViewById(R.id.progressBar_fragment_login); // Get ProgressBar reference
        txt_btn_masuk_fragment_log_in = view.findViewById(R.id.txt_btn_masuk_fragment_log_in);
        btn_daftar_fragment_log_in = view.findViewById(R.id.btn_daftar_fragment_log_in);

        loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}