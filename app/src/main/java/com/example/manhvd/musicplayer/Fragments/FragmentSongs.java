package com.example.manhvd.musicplayer.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manhvd.musicplayer.R;


public class FragmentSongs extends Fragment {

    private RecyclerView recyclerViewSongs;
    private CardView cardView;
    public FragmentSongs() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        recyclerViewSongs = view.findViewById(R.id.recycler_Songs);
        cardView = view.findViewById(R.id.card_viewSongs);

        return view;
    }

}
