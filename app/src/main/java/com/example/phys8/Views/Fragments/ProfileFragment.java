package com.example.phys8.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.User;
import com.example.phys8.R;
import com.example.phys8.ViewModels.ProfileViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    private ProfileViewModel profileViewModel;
    private SharedPreferenceHelper helper;
    private TextView txt_alamat_fragment_profile, txt_email_fragment_profile,
            txt_bergabung_sejak_fragment_profile, txt_deskripsi_fragment_profile,
            txt_name_fragment_profile;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial();

        profileViewModel.init(helper.getAccessToken());// unsend
        profileViewModel.getUserWithId(helper.getUserId());
        profileViewModel.getResultUserWithId().observe(getActivity(), showResultUser);
    }

    private Observer<User.Result> showResultUser = new Observer<User.Result>() {
        @Override
        public void onChanged(User.Result results) {
            txt_name_fragment_profile.setText(String.valueOf(results.getName()));
            txt_alamat_fragment_profile.setText(String.valueOf(results.getAlamat()));
            txt_email_fragment_profile.setText(String.valueOf(results.getEmail()));
            txt_bergabung_sejak_fragment_profile.setText(String.valueOf(results.getCreated_at()));
            txt_deskripsi_fragment_profile.setText(String.valueOf(results.getOrphanage().getDeskripsi()));
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    loadProfile.setVisibility(View.GONE); // Hide Progress bar
//                }
//            }, 300);
        }
    };

    private void initial() {
        txt_name_fragment_profile = getActivity().findViewById(R.id.txt_name_fragment_profile);
        txt_email_fragment_profile = getActivity().findViewById(R.id.txt_email_fragment_profile);
        txt_alamat_fragment_profile = getActivity().findViewById(R.id.txt_alamat_fragment_profile);
        txt_bergabung_sejak_fragment_profile = getActivity().findViewById(R.id.txt_bergabung_sejak_fragment_profile);
        txt_deskripsi_fragment_profile = getActivity().findViewById(R.id.txt_deskripsi_fragment_profile);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        profileViewModel = new ViewModelProvider(getActivity()).get(ProfileViewModel.class);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}