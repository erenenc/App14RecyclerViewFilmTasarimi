package com.example.app14recyclerviewfilmtasarimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        Filmler f1 = new Filmler(1, "Django", "django", 12.45);
        Filmler f2 = new Filmler(2, "Bir Zamanlar Anadoluda", "birzamanlaranadoluda", 16.75);
        Filmler f3 = new Filmler(3, "Inception", "inception", 42.45);
        Filmler f4 = new Filmler(4, "Interstellar", "interstellar", 67.45);
        Filmler f5 = new Filmler(5, "The Hateful Eight", "thehatefuleight", 72.45);
        Filmler f6 = new Filmler(6, "The Pianist", "thepianist", 62.45);

        filmlerArrayList = new ArrayList<>();
        filmlerArrayList.add(f1);
        filmlerArrayList.add(f2);
        filmlerArrayList.add(f3);
        filmlerArrayList.add(f4);
        filmlerArrayList.add(f5);
        filmlerArrayList.add(f6);

        adapter = new FilmAdapter(this, filmlerArrayList);
        rv.setAdapter(adapter);

    }
}