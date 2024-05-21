package com.example.praktikum_8;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {
    private EditText etUpJudul;
    private EditText etUpDesc;
    private Button btnUpdate;
    private DatabaseHelper databaseHelper;
    private int recordId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        databaseHelper = new DatabaseHelper(this);

        etUpJudul = findViewById(R.id.et_upjudul);
        etUpDesc = findViewById(R.id.et_updes);
        btnUpdate = findViewById(R.id.btn_update);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("record_id")) {
            recordId = intent.getIntExtra("record_id", -1);
            loadRecordData(recordId);
        }

        findViewById(R.id.btn_backk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCancelConfirmationDialog();
            }
        });

        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteConfirmationDialog();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = etUpJudul.getText().toString();
                String deskripsi = etUpDesc.getText().toString();

                if (!judul.isEmpty()) {
                    databaseHelper.updateRecord(recordId, judul, deskripsi);
                    finish(); // Close the activity
                } else {
                    etUpJudul.setError("Judul tidak boleh kosong");
                }
            }
        });
    }

    private void loadRecordData(int id) {
        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery("SELECT * FROM " + databaseHelper.getTableName() + " WHERE " + databaseHelper.getColumnId() + " = ?", new String[]{String.valueOf(id)});
        if (cursor != null && cursor.moveToFirst()) {
            etUpJudul.setText(cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getColumnTitle())));
            etUpDesc.setText(cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getColumnDescription())));
            cursor.close();
        }
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hapus Note");
        builder.setMessage("Apakah anda yakin ingin menghapus note ini?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                databaseHelper.deleteRecord(recordId);
                finish(); // Close the activity
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Dismiss the dialog
            }
        });
        builder.create().show();
    }

    private void showCancelConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Batal");
        builder.setMessage("Apakah anda ingin membatalkan perubahan pada form?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Update.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Dismiss the dialog
            }
        });
        builder.create().show();
    }
}
