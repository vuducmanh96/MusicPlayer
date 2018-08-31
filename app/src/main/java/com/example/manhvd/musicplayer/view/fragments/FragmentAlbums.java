package com.example.manhvd.musicplayer.view.fragments;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
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
import com.example.manhvd.musicplayer.view.adapter.AlbumsAdapter;

import java.util.ArrayList;

public class FragmentAlbums extends Fragment {

    private RecyclerView recyclerViewAlbums;
    private CardView cardView;
    private ArrayList<Albums> albumsArrayList;
    private AlbumsAdapter albumsAdapter;
    public FragmentAlbums() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        recyclerViewAlbums = view.findViewById(R.id.recycler_Albums);
        cardView = view.findViewById(R.id.card_viewAlbums);
        albumsArrayList = new ArrayList<>();
        loadAlbum();
        albumsAdapter = new AlbumsAdapter(albumsArrayList, getContext());
        recyclerViewAlbums.setAdapter(albumsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewAlbums.setLayoutManager(gridLayoutManager);
        return view;
    }

    public void loadAlbum(){
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC+"!=0";
        Cursor cursor = getContext().getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                    String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST));
                    //String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    Albums s = new Albums(name,artist);
                    //Songs s = new Songs(name, artist);
                    albumsArrayList.add(s);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }
    }
}

