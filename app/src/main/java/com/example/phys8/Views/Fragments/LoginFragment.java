package com.example.phys8.Views.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

    private TextInputLayout til_email_LoginFragment, til_password_LoginFragment;
    private FrameLayout btn_submit_LoginFragment;
    private TextView txt_btn_fragmentLogin;
    private LoginViewModel loginViewModel;
    private UserViewModel userViewModel;
    private SharedPreferenceHelper helper;
    private ProgressBar progressBar;
    private String objEmailLogin, objPassLogin;
    private MediaPlayer mediaPlayer;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.clicksound);

        if(helper.getUserId()!=""){
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_berandaFragment2);
        }else{
            initial(view);
            loginProccess();
        }
    }

    private void loginProccess(){
        btn_submit_LoginFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              loadingButtonSubmitLogin(true);

              objEmailLogin = til_email_LoginFragment.getEditText().getText().toString().trim();
              objPassLogin = til_password_LoginFragment.getEditText().getText().toString().trim();

              loginViewModel.login(objEmailLogin, objPassLogin).observe(LoginFragment.this.requireActivity(), tokenResponse -> {
                  if (tokenResponse != null) {
                      if(tokenResponse.getResult()!=null) {
                          btn_submit_LoginFragment.setEnabled(true);
                          helper.saveAccessToken(tokenResponse.getResult().getAuthorization(), tokenResponse.getUserId());

                          mediaPlayer.start();
                          Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_berandaFragment);
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
        btn_submit_LoginFragment.setEnabled(check);
        if(check){
            btn_submit_LoginFragment.setBackgroundResource(R.drawable.bg_btn_red_active);
        }else{
            btn_submit_LoginFragment.setBackgroundResource(R.drawable.bg_btn_nonactive);
        }
    }

    private void loadingButtonSubmitLogin(Boolean check){
        if(check){
            btn_submit_LoginFragment.setEnabled(!check);
            progressBar.setVisibility(View.VISIBLE);
            txt_btn_fragmentLogin.setText("Silakan tunggu");
            btn_submit_LoginFragment.setBackground(getResources().getDrawable(R.drawable.bg_btn_red_inloading));
        }else{
            progressBar.setVisibility(View.GONE);
            txt_btn_fragmentLogin.setText("Masuk");
            btn_submit_LoginFragment.setBackground(getResources().getDrawable(R.drawable.bg_btn_red_active));
            btn_submit_LoginFragment.setEnabled(!check);
        }
    }

    private void tilCheckToDatabase(List<User.Result> user){
        objEmailLogin = til_email_LoginFragment.getEditText().getText().toString().trim();
        objPassLogin = til_password_LoginFragment.getEditText().getText().toString().trim();

        if (objEmailLogin.length() == 0) {
            til_email_LoginFragment.setError("Email tidak boleh kosong");
            setActivationButton(false);
        } if (objPassLogin.length() == 0) {
            til_password_LoginFragment.setError("Password tidak boleh kosong");
            setActivationButton(false);
        }else{
            til_password_LoginFragment.setError("");
        }

        if (objEmailLogin.length() > 0) {
            for (int i = 0; i < user.size(); i++) {
                if (user.get(i).getEmail().equals(objEmailLogin)) {
                    til_email_LoginFragment.setError("");
                    setActivationButton(true);
                    break;
                } else if (user.get(i).getEmail() != objEmailLogin && i == user.size() - 1) {
                    til_email_LoginFragment.setError("Akun belum terdaftar");
                    setActivationButton(false);
                }else {
                    setActivationButton(false);
                }
            }
        }
    }

    private void initial(View view) {
        til_email_LoginFragment = getActivity().findViewById(R.id.til_email_LoginFragment);
        til_password_LoginFragment = getActivity().findViewById(R.id.til_password_LoginFragment);
        btn_submit_LoginFragment = getActivity().findViewById(R.id.btn_submit_LoginFragment);
        progressBar = view.findViewById(R.id.progressBar_FragmentLogin); // Get ProgressBar reference
        txt_btn_fragmentLogin = view.findViewById(R.id.txt_btn_fragmentLogin);

        loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}