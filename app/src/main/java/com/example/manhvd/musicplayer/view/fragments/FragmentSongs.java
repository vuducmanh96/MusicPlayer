package com.example.manhvd.musicplayer.view.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.model.entity.Songs;
import com.example.manhvd.musicplayer.view.adapter.SongsAdapter;

import java.util.ArrayList;

public class FragmentSongs extends Fragment {

    private RecyclerView recyclerViewSongs;
    private CardView cardView;
    private ArrayList<Songs> songsList;
    private SongsAdapter songsAdapter;

    public FragmentSongs() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_song, container, false);
        recyclerViewSongs = view.findViewById(R.id.recycler_Songs);
        cardView = view.findViewById(R.id.card_viewSongs);
        songsList = new ArrayList<>();
        checkUserPermission();
        loadSongs();
        songsAdapter = new SongsAdapter(songsList, getContext());
        //songsAdapterGrid = new SongsAdapterGrid(songsList, getContext());
        recyclerViewSongs.setAdapter(songsAdapter);
        LinearLayoutSetup();
        //GridLayoutSetup();
        return view;
    }

    private void LinearLayoutSetup() {
        recyclerViewSongs.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewSongs.setLayoutManager(linearLayoutManager);
    }

    private void GridLayoutSetup() {
        recyclerViewSongs.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViewSongs.setLayoutManager(gridLayoutManager);
    }

    private void checkUserPermission(){
        if(Build.VERSION.SDK_INT>=23){
            if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
                return;
            }
        }
        loadSongs();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 123:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    loadSongs();
                }else{
                    Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                    checkUserPermission(); }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void loadSongs(){
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC+"!=0";
        Cursor cursor = getContext().getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                    String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    Songs s = new Songs(R.drawable.beat, name,artist);
                    //Songs s = new Songs(name, artist);
                    songsList.add(s);
                }while (cursor.moveToNext());
            }
            cursor.close();
            songsAdapter = new SongsAdapter(songsList, getContext());
           // songsAdapterGrid = new SongsAdapterGrid(songsList, getContext());
        }
    }
}


