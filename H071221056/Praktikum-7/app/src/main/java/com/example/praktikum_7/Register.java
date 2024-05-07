package com.example.praktikum_7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Register extends AppCompatActivity {

    EditText et_nim, et_password;
    Button btn_register;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_nim = findViewById(R.id.ET_nimRegis);
        et_password = findViewById(R.id.ET_passwordRegis);
        btn_register = findViewById(R.id.btn_register2);

        btn_register.setOnClickListener(view -> {
            // Mendapatkan nilai NIM dan password dari EditText
            String nim = et_nim.getText().toString().trim();
            String password = et_password.getText().toString().trim();

            if (nim.isEmpty()) {
                et_nim.setError("Please enter your NIM");
                et_nim.requestFocus();
            }
            else if (password.isEmpty()) {
                et_password.setError("Please enter your password");
                et_password.requestFocus();
            }
            else {
                // Mengambil SharedPreferences untuk menyimpan data registrasi
                SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.clear();

                // Menyimpan data registrasi baru
                editor.putString("nim", nim);
                editor.putString("password", password);
                editor.apply();
                Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}