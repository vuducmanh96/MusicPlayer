package com.example.manhvd.musicplayer.model.entity;

import java.io.Serializable;

public class Songs implements Serializable {
    private int idSongModel;
    private int imgSongsModel;
    private String nameSongsModel;
    private String artistsSongsModel;

    public Songs(int idSongModel, int imgSongsModel, String nameSongsModel, String artistsSongsModel) {
        this.idSongModel = idSongModel;
        this.imgSongsModel = imgSongsModel;
        this.nameSongsModel = nameSongsModel;
        this.artistsSongsModel = artistsSongsModel;
    }

    public Songs(int imgSongsModel, String nameSongsModel, String artistsSongsModel) {
        this.imgSongsModel = imgSongsModel;
        this.nameSongsModel = nameSongsModel;
        this.artistsSongsModel = artistsSongsModel;
    }

    public Songs(String nameSongsModel, String artistsSongsModel) {
        this.nameSongsModel = nameSongsModel;
        this.artistsSongsModel = artistsSongsModel;
    }

    public int getIdSongModel() {
        return idSongModel;
    }

    public void setIdSongModel(int idSongModel) {
        this.idSongModel = idSongModel;
    }

    public int getImgSongsModel() {
        return imgSongsModel;
    }

    public void setImgSongsModel(int imgSongsModel) {
        this.imgSongsModel = imgSongsModel;
    }

    public String getNameSongsModel() {
        return nameSongsModel;
    }

    public void setNameSongsModel(String nameSongsModel) {
        this.nameSongsModel = nameSongsModel;
    }

    public String getArtistsSongsModel() {
        return artistsSongsModel;
    }

    public void setArtistsSongsModel(String artistsSongsModel) {
        this.artistsSongsModel = artistsSongsModel;
    }
}