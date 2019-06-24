package com.idw.project.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private String[] dataDeskripsi;
    private String[] dataTanggalRilis;
    private String[] dataUserScore;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, movies.get(i).getJudul_movie(), Toast.LENGTH_SHORT).show();

                Movie movie = (Movie) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
                startActivity(intent);
            }
        });
    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.data_judul_movie);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi_movie);
        dataTanggalRilis = getResources().getStringArray(R.array.data_tanggal_rilis);
        dataUserScore = getResources().getStringArray(R.array.data_user_score);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi_movie);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setJudul_movie(dataJudul[i]);
            movie.setDeskripsi_movie(dataDeskripsi[i]);
            movie.setTanggal_rilis_movie(dataTanggalRilis[i]);
            movie.setUser_score(dataUserScore[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }

}
