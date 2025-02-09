package com.example.diary_oil_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.diary_oil_v3.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private FloatingActionButton floatingActionButton;
    public static final String SHARED_PREFS = "sharedPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CameraVieActivity.class)));
        replaceFragment(new HomeFragment());
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.SHARED_PREFS, MODE_PRIVATE);
        String o2 = sharedPreferences.getString(CameraVieActivity.LAST_RECORD_DATE,"Do");
        if (o2.equals("Do"))
        {
            Intent intent = new Intent(this, On_Boa.class);
            startActivity(intent);
        }

        binding.bottomNaviView.setOnItemSelectedListener(item -> {

        switch (item.getItemId()){

            case R.id.home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.person:
                replaceFragment(new ProfileFragment());
                break;
            case R.id.settings:
                replaceFragment(new SettingFragment());
                break;
            case R.id.timeline:
                replaceFragment(new TimelineFragment());
                break;
        }
        return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}