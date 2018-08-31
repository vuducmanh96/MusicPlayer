package com.example.manhvd.musicplayer.model.entity;

import java.io.Serializable;

public class Albums implements Serializable {
    private int imgAlbumsModel;
    private String nameAlbumsModel;
    private String ArtistsAlbumsModel;

    public Albums(int imgAlbumsModel, String nameAlbumsModel, String artistsAlbumsModel) {
        this.imgAlbumsModel = imgAlbumsModel;
        this.nameAlbumsModel = nameAlbumsModel;
        ArtistsAlbumsModel = artistsAlbumsModel;
    }

    public Albums(String nameAlbumsModel, String artistsAlbumsModel) {
        this.nameAlbumsModel = nameAlbumsModel;
        ArtistsAlbumsModel = artistsAlbumsModel;
    }

    public int getImgAlbumsModel() {
        return imgAlbumsModel;
    }

    public void setImgAlbumsModel(int imgAlbumsModel) {
        this.imgAlbumsModel = imgAlbumsModel;
    }

    public String getNameAlbumsModel() {
        return nameAlbumsModel;
    }

    public void setNameAlbumsModel(String nameAlbumsModel) {
        this.nameAlbumsModel = nameAlbumsModel;
    }

    public String getArtistsAlbumsModel() {
        return ArtistsAlbumsModel;
    }

    public void setArtistsAlbumsModel(String artistsAlbumsModel) {
        ArtistsAlbumsModel = artistsAlbumsModel;
    }
}
