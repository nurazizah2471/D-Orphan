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

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.R;
import com.example.phys8.ViewModels.LoginViewModel;
import com.example.phys8.ViewModels.UserViewModel;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    private TextInputLayout til_email_fragment_register, til_password_fragment_register, til_password_confirmation_fragment_register;
    private Button btn_daftar_fragment_register;
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
            Navigation.findNavController(view).navigate(R.id.kursusFragment);
        }else{
            initial(view);
            loginProccess();
            goToRegisterFragment();
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