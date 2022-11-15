package com.example.phys8.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phys8.Adapters.rvAdapter_kursusFragment;
import com.example.phys8.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KursusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KursusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KursusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KursusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KursusFragment newInstance(String param1, String param2) {
        KursusFragment fragment = new KursusFragment();
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

    TabLayout tabLayout_list_kursus_fragment_kursus;
    ViewPager2 viewpager_list_kursus_fragment_kursus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup view=(ViewGroup) inflater.inflate(R.layout.fragment_kursus, container, false);
        initialisasi(view);

        viewpager_list_kursus_fragment_kursus.setAdapter(
                new rvAdapter_kursusFragment(this)
        );
        new TabLayoutMediator(
                tabLayout_list_kursus_fragment_kursus, viewpager_list_kursus_fragment_kursus,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch(position){
                            case 0:
                                tab.setText("Pesanan");
                                break;

                            case 1:
                                tab.setText("Berlangsung");
                                break;

                            case 2:
                                tab.setText("Riwayat");
                                break;
                        }

                    }
                }
        ).attach();
        return view;
    }

    private void initialisasi(ViewGroup view) {
        tabLayout_list_kursus_fragment_kursus=view.findViewById(R.id.tabLayout_list_kursus_fragment_kursus);
        viewpager_list_kursus_fragment_kursus=view.findViewById(R.id.viewpager_list_kursus_fragment_kursus);
    }

}