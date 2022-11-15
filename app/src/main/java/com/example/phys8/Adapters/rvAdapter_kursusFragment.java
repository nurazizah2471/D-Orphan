package com.example.phys8.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.phys8.Views.Fragments.TabBerlangsungKursus;
import com.example.phys8.Views.Fragments.TabPesananKursus;
import com.example.phys8.Views.Fragments.TabRiwayatKursus;

public class rvAdapter_kursusFragment extends FragmentStateAdapter {
    private Fragment a;
    public rvAdapter_kursusFragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    public rvAdapter_kursusFragment(@NonNull Fragment fragment){
        super(fragment);
    }
    public rvAdapter_kursusFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle){
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                a= new TabPesananKursus();
                break;
            case 1:
                a= new TabBerlangsungKursus();
                break;
            case 2:
                a= new TabRiwayatKursus();
                break;

        }
        return a;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
