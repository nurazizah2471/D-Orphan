package com.example.phys8.Views.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.phys8.R;
import com.example.phys8.ViewModels.RegisterViewModel;
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

    private TextInputLayout til_email_fragment_register, til_password_fragment_register, til_password_confirmation_fragment_register,
            til_name_fragment_register;
    private Button btn_daftar_fragment_register;
    private RegisterViewModel registerViewModel;
    private RadioGroup rg_type_user_fragment_register;
    private String objEmailRegister, objPassRegister, objPassConfirmationRegister, objTypeUser, objName;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            initial(view);
            rg_type_user_change();
            registerProccess();
    }

    private void rg_type_user_change(){
        rg_type_user_fragment_register.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rg_value_panti_asuhan_fragment_register:
                        objTypeUser = "0";

                        break;
                    case R.id.rg_value_tutor_fragment_register:
                        objTypeUser = "1";
                        break;
                }
            }
        });
    }
    private void registerProccess(){
        btn_daftar_fragment_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert= new AlertDialog.Builder(getActivity());
                alert.setTitle("Konfirmasi");
                alert.setMessage("Data akan disimpan. Apakah kamu yakin?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        objEmailRegister = til_email_fragment_register.getEditText().getText().toString().trim();
                        objPassRegister = til_password_fragment_register.getEditText().getText().toString().trim();
                        objPassConfirmationRegister = til_password_confirmation_fragment_register.getEditText().getText().toString().trim();
                        objName = til_name_fragment_register.getEditText().getText().toString().trim();

                        if (objEmailRegister != null && objPassRegister != null && objPassConfirmationRegister != null && objTypeUser != null && objName != null){
                            registerViewModel.register(objEmailRegister, objPassRegister, objPassConfirmationRegister, objTypeUser, objName).observe(RegisterFragment.this.requireActivity(), register -> {
                                if (register != null) {
                                        Toast.makeText(RegisterFragment.this.requireActivity(), register.getStatus(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterFragment.this.requireActivity(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                }
                            });
                    }
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.create().show();
            }
        });
    }

    private void initial(View view) {
        til_email_fragment_register = getActivity().findViewById(R.id.til_email_fragment_register);
        til_password_fragment_register = getActivity().findViewById(R.id.til_password_fragment_register);
        til_password_confirmation_fragment_register = getActivity().findViewById(R.id.til_password_confirmation_fragment_register);
        til_name_fragment_register = getActivity().findViewById(R.id.til_name_fragment_register);

        btn_daftar_fragment_register = view.findViewById(R.id.btn_daftar_fragment_register);
        rg_type_user_fragment_register = view.findViewById(R.id.rg_type_user_fragment_register);

        registerViewModel = new ViewModelProvider(getActivity()).get(RegisterViewModel.class);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}