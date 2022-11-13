package com.Archotech.D_Orphan.Views.Activities;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.D_Orphan.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavHostFragment nav_fragment_main_menu;
    private NavController navController;
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        nav_fragment_main_menu = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.berandaFragment, R.id.permainanFragment, R.id.profileFragment).build();
        navController = nav_fragment_main_menu.getNavController();
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.profileFragment || destination.getId() == R.id.loginFragment
                    || destination.getId() == R.id.permainanFragment || destination.getId() == R.id.peringkatFragment || destination.getId() == R.id.historyFragment) {
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.bgsound);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1, 1);
        mediaPlayer.start();

        Objects.requireNonNull(getSupportActionBar()).hide();
        bottomNavigationView.setVisibility(View.GONE);
        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, configuration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    protected void onPause() {
        if (this.isFinishing()) { //basically BACK was pressed from this activity
            mediaPlayer.stop();
        }
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                mediaPlayer.stop();
            }
        }
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navController = nav_fragment_main_menu.getNavController();
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return nav_fragment_main_menu.getNavController().navigateUp() || super.onSupportNavigateUp();
    }
}