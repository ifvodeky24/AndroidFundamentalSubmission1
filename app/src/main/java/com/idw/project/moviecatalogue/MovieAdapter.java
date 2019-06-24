package com.idw.project.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }


    private class ViewHolder {
        private TextView txtJudulMovie, txtDeskripsiMovie, txtTanggalRilis, txtUserScore;
        private ImageView ivPoster;
        ViewHolder(View view) {
            txtJudulMovie = view.findViewById(R.id.tv_judul_movie);
            txtDeskripsiMovie = view.findViewById(R.id.tv_deskripsi_movie);
            ivPoster = view.findViewById(R.id.iv_poster);
            txtTanggalRilis = view.findViewById(R.id.tv_tanggal_rilis);
            txtUserScore = view.findViewById(R.id.tv_user_score);
        }
        void bind(Movie movie) {
            txtJudulMovie.setText(movie.getJudul_movie());
            txtDeskripsiMovie.setText(movie.getDeskripsi_movie());
            ivPoster.setImageResource(movie.getPoster());
            txtTanggalRilis.setText("Rilis: "+movie.getTanggal_rilis_movie());
            txtUserScore.setText("User Score: "+movie.getUser_score());
        }
    }
}
