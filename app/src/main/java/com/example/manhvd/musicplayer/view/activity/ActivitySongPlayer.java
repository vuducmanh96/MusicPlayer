package com.example.manhvd.musicplayer.view.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.manhvd.musicplayer.CircularSeekBar;
import com.example.manhvd.musicplayer.R;

public class ActivitySongPlayer extends AppCompatActivity {
    private Toolbar toolbarSongPlayer;
    private TextView tvSongPlayerArtists;
    private CircularSeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_song_player);
        super.onCreate(savedInstanceState);
        widgets();
        setToolbarSongPlayer();
        tvSongPlayerArtists.setText(getIntent().getStringExtra("ARTISTSSONG"));
        seekbar.getProgress();
        seekbar.setProgress(50);
    }

    private void widgets() {
        seekbar = findViewById(R.id.circularSeekBar1);
        toolbarSongPlayer = findViewById(R.id.tool_barActivitySongPlayer);
        tvSongPlayerArtists = findViewById(R.id.tv_SongPlayer_Artists);
    }

    private void setToolbarSongPlayer() {
        String nameSong = getIntent().getStringExtra("NAMESONG");
        setSupportActionBar(toolbarSongPlayer);
        getSupportActionBar().setTitle(nameSong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_songs, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.all_songs:
                //...
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

