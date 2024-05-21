package com.example.praktikum_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {

    private EditText etJudul;
    private EditText etDeskripsi;
    private Button btnSubmit;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        databaseHelper= new DatabaseHelper(this);

        etJudul = findViewById(R.id.et_judul);
        etDeskripsi = findViewById(R.id.et_deskripsi);
        btnSubmit = findViewById(R.id.btn_submit);

        // Set the toolbar back button
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity
            }
        });

        // Set the submit button listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etJudul.getText().toString().trim();
                String description = etDeskripsi.getText().toString().trim();

                if (title.isEmpty()) {
                    Toast.makeText(Add.this, "Judul tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    databaseHelper.insertRecord(title, description);
                    finish();
                }
            }
        });
    }
}
