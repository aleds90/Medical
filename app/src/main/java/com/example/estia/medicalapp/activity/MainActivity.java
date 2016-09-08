package com.example.estia.medicalapp.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.estia.medicalapp.R;
import com.example.estia.medicalapp.fragment.AllStatsFragment;
import com.example.estia.medicalapp.fragment.HomeFragment;
import com.example.estia.medicalapp.fragment.ProfileFragment;
import com.example.estia.medicalapp.fragment.SettingFragment;
import com.example.estia.medicalapp.fragment.StatFragment;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    ImageButton ib_home, ib_stat, ib_profile, ib_setting;
    FrameLayout main_frame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
    }

    private void findViewById() {
        main_frame = (FrameLayout)findViewById(R.id.main_frame);

        android.app.Fragment newFragment = new HomeFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();


        ib_home     = (ImageButton)findViewById(R.id.ib_home);
        ib_home.setBackground(getResources().getDrawable(R.drawable.ic_home_black_24dp));
        ib_stat     = (ImageButton)findViewById(R.id.ib_stat);
        ib_profile  = (ImageButton)findViewById(R.id.ib_profile);
        ib_setting  = (ImageButton)findViewById(R.id.ib_setting);

        ib_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ib_home.setBackground(getResources().getDrawable(R.drawable.ic_home_black_24dp));
                ib_stat.setBackground(getResources().getDrawable(R.drawable.ic_trending_up_white_24dp));
                ib_profile.setBackground(getResources().getDrawable(R.drawable.ic_person_white_24dp));
                ib_setting.setBackground(getResources().getDrawable(R.drawable.ic_settings_white_24dp));
                android.app.Fragment newFragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        ib_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ib_home.setBackground(getResources().getDrawable(R.drawable.ic_home_white_24dp));
                ib_stat.setBackground(getResources().getDrawable(R.drawable.ic_trending_up_black_24dp));
                ib_profile.setBackground(getResources().getDrawable(R.drawable.ic_person_white_24dp));
                ib_setting.setBackground(getResources().getDrawable(R.drawable.ic_settings_white_24dp));
                android.app.Fragment newFragment = new StatFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        ib_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ib_home.setBackground(getResources().getDrawable(R.drawable.ic_home_white_24dp));
                ib_stat.setBackground(getResources().getDrawable(R.drawable.ic_trending_up_white_24dp));
                ib_profile.setBackground(getResources().getDrawable(R.drawable.ic_person_black_24dp));
                ib_setting.setBackground(getResources().getDrawable(R.drawable.ic_settings_white_24dp));
                android.app.Fragment newFragment = new ProfileFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ib_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ib_home.setBackground(getResources().getDrawable(R.drawable.ic_home_white_24dp));
                ib_stat.setBackground(getResources().getDrawable(R.drawable.ic_trending_up_white_24dp));
                ib_profile.setBackground(getResources().getDrawable(R.drawable.ic_person_white_24dp));
                ib_setting.setBackground(getResources().getDrawable(R.drawable.ic_settings_black_24dp));
                android.app.Fragment newFragment = new SettingFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
