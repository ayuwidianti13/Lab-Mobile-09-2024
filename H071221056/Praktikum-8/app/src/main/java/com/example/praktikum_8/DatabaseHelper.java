package com.example.praktikum_8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "praktikum-8";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_table";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "judul";
    private static final String COLUMN_DESCRIPTION = "deskripsi";
    private static final String COLUMN_CREATED_AT = "created_at";
    private static final String COLUMN_UPDATED_AT = "updated_at";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Mengeksekusi perintah SQL untuk membuat tabel dengan kolom yang telah ditentukan.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(          //membuat tabel baru dalam database.
                "CREATE TABLE " + TABLE_NAME + " ("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COLUMN_TITLE + " TEXT,"
                        + COLUMN_DESCRIPTION + " TEXT,"
                        + COLUMN_CREATED_AT + " INTEGER," //menyimpan angka, digunakan untuk mencatat waktu pembuatan catatan.
                        + COLUMN_UPDATED_AT + " INTEGER)"
        );
    }

    //memasukkan catatan baru ke dalam tabel database.
    public void insertRecord(String judul, @Nullable String deskripsi) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues(); //menyimpan data dalam bentuk pasangan kunci
        values.put(COLUMN_TITLE, judul);
        values.put(COLUMN_DESCRIPTION, deskripsi);
        long currentTime = System.currentTimeMillis();
        values.put(COLUMN_CREATED_AT, currentTime);
        values.put(COLUMN_UPDATED_AT, currentTime);
        db.insert(TABLE_NAME, null, values);
    }

    //mengambil semua catatan dari tabel database, dan mengembalikan dalam bentuk cursor
    public Cursor getAllRecord() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    //  Mencari catatan berdasarkan judul
    public Cursor searchByTitle(String title) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TITLE + " LIKE ?", new String[]{"%" + title + "%"});
    }  // mencari semua judul yang mengandung teks title

    public void updateRecord(int id, String judul, @Nullable String deskripsi) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, judul);
        values.put(COLUMN_DESCRIPTION, deskripsi);
        values.put(COLUMN_UPDATED_AT, System.currentTimeMillis()); // Update timestamp
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void deleteRecord(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    @Override
    // Mengelola pembaruan database ketika versi database berubah.
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Getter methods for the private variables
    public String getTableName() {
        return TABLE_NAME;
    }

    public String getColumnId() {
        return COLUMN_ID;
    }

    public String getColumnTitle() {
        return COLUMN_TITLE;
    }

    public String getColumnDescription() {
        return COLUMN_DESCRIPTION;
    }

    public String getColumnCreatedAt() {
        return COLUMN_CREATED_AT;
    }

    public String getColumnUpdatedAt() {
        return COLUMN_UPDATED_AT;
    }
}
