package com.example.manhvd.musicplayer.view.fragments;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.model.entity.Albums;
import com.example.manhvd.musicplayer.model.entity.Artists;
import com.example.manhvd.musicplayer.view.adapter.AlbumsAdapter;
import com.example.manhvd.musicplayer.view.adapter.ArtistsAdapter;

import java.util.ArrayList;

public class FragmentArtists extends Fragment {

    private RecyclerView recyclerViewArtists;
    private ArtistsAdapter artistsAdapter;
    private ArrayList<Artists> artistsArrayList;
    private CardView cardView;

    public FragmentArtists(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_artists, container, false);
        recyclerViewArtists = view.findViewById(R.id.recycler_Artists);
        cardView = view.findViewById(R.id.card_viewArtists);
        artistsArrayList = new ArrayList<>();
        loadArtists();
        artistsAdapter = new ArtistsAdapter(artistsArrayList, getContext());
        recyclerViewArtists.setAdapter(artistsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewArtists.setLayoutManager(gridLayoutManager);
        return view;
    }

    private void loadArtists(){
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!=0";
        Cursor cursor = getContext().getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST));
                    //String numberAlbum = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ENTRY_CONTENT_TYPE));
                    //String numberSong = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.));
                    Artists s = new Artists(artist, "123", "123");
                    artistsArrayList.add(s);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }
    }
}

