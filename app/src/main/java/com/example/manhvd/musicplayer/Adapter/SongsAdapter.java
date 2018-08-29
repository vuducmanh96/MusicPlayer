package com.example.manhvd.musicplayer.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.model.Songs;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {
    private ArrayList<Songs> songsArrayList;

    public SongsAdapter(ArrayList<Songs> songsArrayList) {
        this.songsArrayList = songsArrayList;
    }

    @NonNull
    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_songs, parent, false);
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
    public int getItemCount() {
        return songsArrayList.size();
    }

    public class SongsViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgSongs;
        private TextView tvSongsName;
        private TextView tvSongsArtists;
        public  SongsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSongs = itemView.findViewById(R.id.img_songs);
            tvSongsName = itemView.findViewById(R.id.tv_songName);
            tvSongsArtists = itemView.findViewById(R.id.tv_songArtists);
        }
    }
}
