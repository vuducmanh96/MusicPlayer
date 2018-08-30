package com.example.manhvd.musicplayer.model.entity;

import java.io.Serializable;

public class Artists implements Serializable {
    private int imgArtistsModel;
    private String nameArtistsModel;
    private int numberSongsArtistsModel;
    private int numberAlbumsArtistsModel;

    public Artists(int imgArtistsModel, String nameArtistsModel, int numberSongsArtistsModel, int numberAlbumsArtistsModel) {
        this.imgArtistsModel = imgArtistsModel;
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

    public int getNumberSongsArtistsModel() {
        return numberSongsArtistsModel;
    }

    public void setNumberSongsArtistsModel(int numberSongsArtistsModel) {
        this.numberSongsArtistsModel = numberSongsArtistsModel;
    }

    public int getNumberAlbumsArtistsModel() {
        return numberAlbumsArtistsModel;
    }

    public void setNumberAlbumsArtistsModel(int numberAlbumsArtistsModel) {
        this.numberAlbumsArtistsModel = numberAlbumsArtistsModel;
    }
}

