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
import com.example.manhvd.musicplayer.model.entity.Artists;

import java.util.ArrayList;

public class ArtistsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Artists> artistsArrayList;
    private Context context;

    public ArtistsAdapter(ArrayList<Artists> artistsArrayList, Context context) {
        this.artistsArrayList = artistsArrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArtistsAdapter.ArtistsViewHolderGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artists_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArtistsAdapter.ArtistsViewHolderGrid holderGrid = (ArtistsViewHolderGrid) holder;
        Artists artists = artistsArrayList.get(position);
        holderGrid.imgArtistsGrid.setImageResource(artists.getImgArtistsModel());
        holderGrid.tvArtistsnameGrid.setText(artists.getNameArtistsModel());
        holderGrid.tvNumberSongArtistsGrid.setText(artists.getNumberSongsArtistsModel());
        holderGrid.tvNumberAlbumArtistsGrid.setText(artists.getNumberAlbumsArtistsModel());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return artistsArrayList.size();
    }

    class ArtistsViewHolderGrid extends RecyclerView.ViewHolder {
        CardView cardViewArtistsGrid;
        ImageView imgArtistsGrid;
        TextView tvArtistsnameGrid;
        TextView tvNumberAlbumArtistsGrid;
        TextView tvNumberSongArtistsGrid;
        public ArtistsViewHolderGrid(@NonNull View itemView) {
            super(itemView);
            cardViewArtistsGrid = itemView.findViewById(R.id.card_viewArtists);
            imgArtistsGrid = itemView.findViewById(R.id.img_artistsGrid);
            tvArtistsnameGrid = itemView.findViewById(R.id.tv_artistsNamesGrid);
            tvNumberSongArtistsGrid = itemView.findViewById(R.id.tv_numberSongsArtistGrid);
            tvNumberAlbumArtistsGrid = itemView.findViewById(R.id.tv_numberAlbumArtistGrid);
        }
    }
}
