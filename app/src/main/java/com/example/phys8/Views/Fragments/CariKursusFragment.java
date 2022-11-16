package com.example.phys8.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.R;
import com.example.phys8.ViewModels.LoginViewModel;
import com.example.phys8.ViewModels.UserViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CariKursusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CariKursusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CariKursusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CariKursusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CariKursusFragment newInstance(String param1, String param2) {
        CariKursusFragment fragment = new CariKursusFragment();
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
        return inflater.inflate(R.layout.fragment_cari_kursus, container, false);

    }

    private CardView cv1_cari_kursus_fragment, cv2_cari_kursus_fragment, cv3_cari_kursus_fragment, cv4_cari_kursus_fragment;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial();
        cv1_cari_kursus_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_cariKursusFragment_to_cariTutorFragment);

            }
        });
        cv2_cari_kursus_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_cariKursusFragment_to_cariTutorFragment);

            }
        });
        cv3_cari_kursus_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_cariKursusFragment_to_cariTutorFragment);

            }
        });
        cv4_cari_kursus_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_cariKursusFragment_to_cariTutorFragment);

            }
        });
    }

    private void initial() {
        cv1_cari_kursus_fragment= getActivity().findViewById(R.id.cv1_cari_kursus_fragment);
        cv2_cari_kursus_fragment= getActivity().findViewById(R.id.cv2_cari_kursus_fragment);
        cv3_cari_kursus_fragment= getActivity().findViewById(R.id.cv3_cari_kursus_fragment);
        cv4_cari_kursus_fragment= getActivity().findViewById(R.id.cv4_cari_kursus_fragment);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }





}