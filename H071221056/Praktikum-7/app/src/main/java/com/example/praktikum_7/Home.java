package com.example.praktikum_7;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Home extends AppCompatActivity {
    TextView tv_welcome;
    Button btn_logout, btn_setting;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv_welcome = findViewById(R.id.TV_welcome);
        btn_logout = findViewById(R.id.btn_logout);
        btn_setting = findViewById(R.id.btn_setting);

        sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        String nim = sharedPreferences.getString("nim", "");
        tv_welcome.setText("Hallo..., " + nim + "!");

        btn_logout.setOnClickListener(view -> {
            sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();

            Intent intent = new Intent(Home.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Setting.class);
                startActivity(intent);
            }
        });

        // Pengaturan tema
//        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
//        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
//        if (isDarkTheme) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }
    }
}