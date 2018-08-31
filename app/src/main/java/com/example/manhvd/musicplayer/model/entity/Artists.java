package com.example.manhvd.musicplayer.model.entity;

import java.io.Serializable;

public class Artists implements Serializable {
    private int imgArtistsModel;
    private String nameArtistsModel;
    private String numberSongsArtistsModel;
    private String numberAlbumsArtistsModel;

    public Artists(int imgArtistsModel, String nameArtistsModel, String numberSongsArtistsModel, String numberAlbumsArtistsModel) {
        this.imgArtistsModel = imgArtistsModel;
        this.nameArtistsModel = nameArtistsModel;
        this.numberSongsArtistsModel = numberSongsArtistsModel;
        this.numberAlbumsArtistsModel = numberAlbumsArtistsModel;
    }

    public Artists(String nameArtistsModel, String numberSongsArtistsModel, String numberAlbumsArtistsModel) {
        this.nameArtistsModel = nameArtistsModel;
        this.numberSongsArtistsModel = numberSongsArtistsModel;
        this.numberAlbumsArtistsModel = numberAlbumsArtistsModel;
    }

    public int getImgArtistsModel() {
        return imgArtistsModel;
    }

    public void setImgArtistsModel(int imgArtistsModel) {
        this.imgArtistsModel = imgArtistsModel;
    }

    public String getNameArtistsModel() {
        return nameArtistsModel;
    }

    public void setNameArtistsModel(String nameArtistsModel) {
        this.nameArtistsModel = nameArtistsModel;
    }

    public String getNumberSongsArtistsModel() {
        return numberSongsArtistsModel;
    }

    public void setNumberSongsArtistsModel(String numberSongsArtistsModel) {
        this.numberSongsArtistsModel = numberSongsArtistsModel;
    }

    public String getNumberAlbumsArtistsModel() {
        return numberAlbumsArtistsModel;
    }

    public void setNumberAlbumsArtistsModel(String numberAlbumsArtistsModel) {
        this.numberAlbumsArtistsModel = numberAlbumsArtistsModel;
    }
}

