package com.example.praktikum_7;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Setting extends AppCompatActivity {
    Switch sw_tema;
    TextView tv_mode;
    SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sw_tema = findViewById(R.id.sw_tema);
        tv_mode = findViewById(R.id.tv_mode);
        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
        sw_tema.setChecked(isDarkTheme);
        tv_mode.setText(isDarkTheme ? "Dark Theme" : "Light Theme");
        sw_tema.setThumbResource(isDarkTheme ? R.drawable.moon : R.drawable.sun);

        sw_tema.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Memeriksa apakah Switch diaktifkan
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            // Menyimpan status tema yang dipilih
            editor.putBoolean("is_dark_theme", isChecked);
            editor.apply();
        });
    }
}

