package com.example.movierecommendations;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
public class movieDao {
    public ArrayList<Movies> tumFilmlerByKategoriId(VeriTabani vt, int categori_id) {
        ArrayList<Movies> moviesArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cu = db.rawQuery("SELECT * FROM movies " +
                "JOIN categories ON movies.categori_id = categories.categori_id " +
                "JOIN directors ON movies.director_id = directors.director_id " +
                "WHERE movies.categori_id=" + categori_id, null);
        while (cu.moveToNext()) {
            Categories c = new Categories(cu.getInt(cu.getColumnIndexOrThrow("categori_id")),
                    cu.getString(cu.getColumnIndexOrThrow("categori_name")));
            Directors d = new Directors(cu.getInt(cu.getColumnIndexOrThrow("director_id")),
                    cu.getString(cu.getColumnIndexOrThrow("director_name")));
            Movies m = new Movies(cu.getInt(cu.getColumnIndexOrThrow("movie_id")),
                    cu.getString(cu.getColumnIndexOrThrow("movie_name")),
                    cu.getInt(cu.getColumnIndexOrThrow("movie_year")),
                    cu.getString(cu.getColumnIndexOrThrow("movie_picture")), c, d);

            moviesArrayList.add(m);
        }

        return moviesArrayList;
    }
}
