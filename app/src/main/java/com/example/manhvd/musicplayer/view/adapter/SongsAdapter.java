package com.example.manhvd.musicplayer.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.model.entity.Songs;
import com.example.manhvd.musicplayer.view.activity.ActivitySongPlayer;
import com.example.manhvd.musicplayer.view.fragments.FragmentSongs;

import java.util.ArrayList;


public class SongsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Songs> songsArrayList;
    private Context context;
    private int checkTypeScreen;
    public static final int LINEAR = 1;
    public static final int GRID = 0;

    public SongsAdapter(ArrayList<Songs> songsArrayList, Context context) {
        this.songsArrayList = songsArrayList;
        this.context = context;
    }

    public SongsAdapter(ArrayList<Songs> songsArrayList, Context context, int checkTypeScreen) {
        this.songsArrayList = songsArrayList;
        this.context = context;
        this.checkTypeScreen = checkTypeScreen;
    }

    public int getCheckTypeScreen() {
        return checkTypeScreen;
    }

    public void setCheckTypeScreen(int checkTypeScreen) {
        this.checkTypeScreen = checkTypeScreen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case LINEAR: {
                return new SongsViewHolderLinear(LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item_linear, parent, false));
            }
            case GRID: {
                return new SongViewHolderGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item_grid, parent, false));
            }
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return checkTypeScreen;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Songs songs = songsArrayList.get(position);
        switch (holder.getItemViewType()) {
            case LINEAR:
                SongsViewHolderLinear holderLinear = (SongsViewHolderLinear) holder;
                //Songs songsLinear = songsArrayList.get(position);
                holderLinear.imgSongs.setImageResource(songs.getImgSongsModel());
                holderLinear.tvSongsName.setText(songs.getNameSongsModel());
                holderLinear.tvSongsArtists.setText(songs.getArtistsSongsModel());
                break;
            case GRID:
                SongViewHolderGrid holderGrid = (SongViewHolderGrid) holder;
                //Songs songsGrid = songsArrayList.get(position);
                holderGrid.tvSongsnameGrid.setText(songs.getNameSongsModel());
                holderGrid.tvSongsArtistsGrid.setText(songs.getArtistsSongsModel());
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Songs songsLinear = songsArrayList.get(position);
                Intent intent = new Intent(context.getApplicationContext(), ActivitySongPlayer.class);
                intent.putExtra("NAMESONG", songs.getNameSongsModel());
                intent.putExtra("ARTISTSSONG", songs.getArtistsSongsModel());
                context.startActivity(intent);
            }
        });
    }



    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return songsArrayList.size();
    }

    class SongsViewHolderLinear extends RecyclerView.ViewHolder{
        CardView cardViewSongs;
        ImageView imgSongs;
        TextView tvSongsName;
        TextView tvSongsArtists;
        public  SongsViewHolderLinear(@NonNull View itemView) {
           super(itemView);
            cardViewSongs = itemView.findViewById(R.id.card_viewSongs);
            imgSongs = itemView.findViewById(R.id.img_songs);
            tvSongsName = itemView.findViewById(R.id.tv_songName);
            tvSongsArtists = itemView.findViewById(R.id.tv_songArtists);
        }
    }

    class SongViewHolderGrid extends RecyclerView.ViewHolder {
        AdapterView.OnItemClickListener clickListener;
        CardView cardViewSongGrid;
        TextView tvSongsnameGrid;
        TextView tvSongsArtistsGrid;
        public SongViewHolderGrid(@NonNull View itemView) {
            super(itemView);
            cardViewSongGrid = itemView.findViewById(R.id.card_viewSongsGrid);
            tvSongsnameGrid = itemView.findViewById(R.id.tv_songNameGrid);
            tvSongsArtistsGrid = itemView.findViewById(R.id.tv_songArtistsGrid);
        }
    }
}

