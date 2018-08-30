package com.example.manhvd.musicplayer.view.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.manhvd.musicplayer.view.fragments.FragmentAlbums;
import com.example.manhvd.musicplayer.view.fragments.FragmentArtists;
import com.example.manhvd.musicplayer.view.fragments.FragmentSongs;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentSongs();
                break;
            case 1:
                fragment = new FragmentAlbums();
                break;
            case 2:
                fragment = new FragmentArtists();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "SONGS";
                break;
            case 1:
                title = "ALBUMS";
                break;
            case 2:
                title = "ARTISTS";
                break;
            default:
                break;
        }
        return title;
    }
}