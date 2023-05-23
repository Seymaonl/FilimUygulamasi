package com.example.movierecommendations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VeriTabani extends SQLiteOpenHelper {

    public VeriTabani(@Nullable Context context) {
        super(context, "bilgiler.db" , null, 1);
    }

    @Override


    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS categories (\n" +
                "\tcategori_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tcategori_name TEXT\n" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS directors (\n" +
                "\tdirector_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tdirector_name TEXT\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS movies (\n" +
                "\tmovie_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tmovie_name TEXT,\n" +
                "\tmovie_year INTEGER,\n" +
                "\tmovie_picture TEXT,\n" +
                "\tcategori_id INTEGER,\n" +
                "\tdirector_id INTEGER\n" +
                ")");
    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS categories");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS directors");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS movies");
        onCreate(sqLiteDatabase);

    }
}

