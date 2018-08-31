package com.example.manhvd.musicplayer.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.model.entity.Albums;

import java.util.ArrayList;

public class AlbumsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Albums> albumsArrayList;
    private Context context;

    public AlbumsAdapter(ArrayList<Albums> albumsArrayList, Context context) {
        this.albumsArrayList = albumsArrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlbumsAdapter.AlbumsViewHolderGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AlbumsViewHolderGrid holderGrid = (AlbumsViewHolderGrid) holder;
        Albums albums = albumsArrayList.get(position);
        holderGrid.imgAlbumGrid.setImageResource(albums.getImgAlbumsModel());
        holderGrid.tvAlbumnameGrid.setText(albums.getNameAlbumsModel());
        holderGrid.tvAlbumArtistsGrid.setText(albums.getArtistsAlbumsModel());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return albumsArrayList.size();
    }

    class AlbumsViewHolderGrid extends RecyclerView.ViewHolder {
        CardView cardViewAlbumGrid;
        ImageView imgAlbumGrid;
        TextView tvAlbumnameGrid;
        TextView tvAlbumArtistsGrid;
        public AlbumsViewHolderGrid(@NonNull View itemView) {
            super(itemView);
            cardViewAlbumGrid = itemView.findViewById(R.id.card_viewAlbums);
            imgAlbumGrid = itemView.findViewById(R.id.img_albumsGrid);
            tvAlbumnameGrid = itemView.findViewById(R.id.tv_albumNamesGrid);
            tvAlbumArtistsGrid = itemView.findViewById(R.id.tv_albumArtistGrid);
        }
    }
}
