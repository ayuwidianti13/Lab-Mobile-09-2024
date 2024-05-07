package com.example.praktikum_7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button btn_login, btn_register;
    TextView tv_regis;
    EditText et_nim, et_password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nim = findViewById(R.id.ET_nim);
        et_password = findViewById(R.id.ET_password);
        btn_login = findViewById(R.id.btn_login);
        tv_regis = findViewById(R.id.tv_regis);
        checkLoginStatus(); // Memeriksa status login saat aplikasi dibuka

        tv_regis.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

        btn_login.setOnClickListener(view -> {
            // Mendapatkan nilai NIM dan password dari EditText
            String nim = et_nim.getText().toString().trim();
            String password = et_password.getText().toString().trim();

            if (nim.isEmpty()) {
                et_nim.setError("Please enter your NIM");
            } else if (password.isEmpty()) {
                et_password.setError("Please enter your password");
            } else {
                // Melakukan validasi login dan menyimpan status login
                sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
                String NIM = sharedPreferences.getString("nim", "");
                String PASS = sharedPreferences.getString("password", "");

                // Memeriksa kecocokan NIM dan password
                if (NIM.equals(nim) && PASS.equals(password)) {
                    editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true); // Jika login berhasil, simpan status login
                    editor.apply();

                    // Navigasi ke HomeActivity
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect NIM or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Pengaturan tema
        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    // memeriksa status login
    private void checkLoginStatus() {
        sharedPreferences = this.getSharedPreferences("user_pref", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            // Jika pengguna sudah login, arahkan ke Home
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
            finish();
        }
    }
}