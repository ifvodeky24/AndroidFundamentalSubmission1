package com.idw.project.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int poster;
    private String judul_movie;
    private String deskripsi_movie;
    private String tanggal_rilis_movie;
    private String user_score;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getJudul_movie() {
        return judul_movie;
    }

    public void setJudul_movie(String judul_movie) {
        this.judul_movie = judul_movie;
    }

    public String getDeskripsi_movie() {
        return deskripsi_movie;
    }

    public void setDeskripsi_movie(String deskripsi_movie) {
        this.deskripsi_movie = deskripsi_movie;
    }

    public String getTanggal_rilis_movie() {
        return tanggal_rilis_movie;
    }

    public void setTanggal_rilis_movie(String tanggal_rilis_movie) {
        this.tanggal_rilis_movie = tanggal_rilis_movie;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.judul_movie);
        dest.writeString(this.deskripsi_movie);
        dest.writeString(this.tanggal_rilis_movie);
        dest.writeString(this.user_score);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.poster = in.readInt();
        this.judul_movie = in.readString();
        this.deskripsi_movie = in.readString();
        this.tanggal_rilis_movie = in.readString();
        this.user_score = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
