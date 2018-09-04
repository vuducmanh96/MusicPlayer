package com.example.manhvd.musicplayer.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.view.adapter.SongsAdapter;
import com.example.manhvd.musicplayer.view.fragments.FragmentSongs;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbarMainActivity;
    private FragmentSongs fragmentSongs;
    private TextView tvMainActivityNameSong, tvMainActivityArtistsSong;
    private int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widget();
        setToolbarMainActivity();
        addControl();
        //getDataSongBottom();
    }

//    private void getDataSongBottom() {
//        tvMainActivityNameSong.setText(getIntent().getStringExtra("NAMESONG"));
//        tvMainActivityArtistsSong.setText(getIntent().getStringExtra("ARTISTSSONG"));
//    }

    private void widget() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager  =findViewById(R.id.view_pager);
        toolbarMainActivity = findViewById(R.id.tool_barActivityMain);
        tvMainActivityNameSong = findViewById(R.id.tv_activity_main_name_song);
        tvMainActivityArtistsSong = findViewById(R.id.tv_activity_main_artists_song);
    }

    private void addControl() {
        FragmentManager fragmentManager  = getSupportFragmentManager();
        PagerAdapter pagerAdapter = new com.example.manhvd.musicplayer.view.adapter.PagerAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    private void setToolbarMainActivity() {
        setSupportActionBar(toolbarMainActivity);
        getSupportActionBar().setTitle("Beauty Music");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_listView:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                fragmentSongs.recyclerViewSongs.setLayoutManager(linearLayoutManager);
                fragmentSongs.songsAdapter.setCheckTypeScreen(fragmentSongs.songsAdapter.LINEAR);
                break;
            case R.id.menu_gridView:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                fragmentSongs.recyclerViewSongs.setLayoutManager(gridLayoutManager);
                fragmentSongs.songsAdapter.setCheckTypeScreen(fragmentSongs.songsAdapter.GRID);
                break;
            case R.id.menu_action_search:
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
