package com.example.week_planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button btn_sunday,btn_monday,btn_tuesday,btn_wednesday,btn_thursday,btn_friday,btn_saturday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_sunday=findViewById(R.id.btn_sunday);
        btn_monday=findViewById(R.id.btn_monday);
        btn_tuesday=findViewById(R.id.btn_tuesday);
        btn_wednesday=findViewById(R.id.btn_wednesday);
        btn_thursday=findViewById(R.id.btn_thursday);
        btn_friday=findViewById(R.id.btn_friday);
        btn_saturday=findViewById(R.id.btn_saturday);

        btn_sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new sunday());
            }
        });
        btn_monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new monday());
            }
        });
        btn_tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new tuesday());
            }
        });
        btn_wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new wednesday());
            }
        });
        btn_thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new thursday());
            }
        });
        btn_friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new friday());
            }
        });
        btn_saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new saturday());
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}