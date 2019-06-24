package com.idw.project.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    private TextView tv_judul_movie, tv_tanggal_rilis, tv_deskripsi_movie, tv_user_score;
    private ImageView iv_poster;

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        this.setTitle("Detail Movie");

        tv_judul_movie= findViewById(R.id.tv_judul_movie);
        tv_tanggal_rilis= findViewById(R.id.tv_tanggal_rilis);
        tv_deskripsi_movie= findViewById(R.id.tv_deskripsi_movie);
        tv_user_score= findViewById(R.id.tv_user_score);
        iv_poster= findViewById(R.id.iv_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tv_judul_movie.setText(movie.getJudul_movie());
        tv_tanggal_rilis.setText(movie.getTanggal_rilis_movie());
        tv_deskripsi_movie.setText(movie.getDeskripsi_movie());
        tv_user_score.setText(movie.getUser_score());
        iv_poster.setImageResource(movie.getPoster());
    }
}
