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
import com.example.manhvd.musicplayer.model.entity.Songs;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {
    private ArrayList<Songs> songsArrayList;
    private Context context;

    public SongsAdapter(ArrayList<Songs> songsArrayList, Context context) {
        this.songsArrayList = songsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item_linear,  parent, false);
        return new SongsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        Songs songs = songsArrayList.get(position);
        holder.imgSongs.setImageResource(songs.getImgSongsModel());
        holder.tvSongsName.setText(songs.getNameSongsModel());
        holder.tvSongsArtists.setText(songs.getArtistsSongsModel());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return songsArrayList.size();
    }

    class SongsViewHolder extends RecyclerView.ViewHolder{
        CardView cardViewSongs;
        ImageView imgSongs;
        TextView tvSongsName;
        TextView tvSongsArtists;
        public  SongsViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewSongs = itemView.findViewById(R.id.card_viewSongs);
            imgSongs = itemView.findViewById(R.id.img_songs);
            tvSongsName = itemView.findViewById(R.id.tv_songName);
            tvSongsArtists = itemView.findViewById(R.id.tv_songArtists);
        }
    }
}

