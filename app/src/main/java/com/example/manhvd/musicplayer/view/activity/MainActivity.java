package com.example.manhvd.musicplayer.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.view.fragments.FragmentSongs;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private android.support.v7.widget.Toolbar toolbarMainActivity;
    private FragmentSongs fragmentSongs;
    private int check;
    public static final int LINEAR = 1;
    public static final int GRID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        addControl();
    }

    private void addControl() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager  =findViewById(R.id.view_pager);
        FragmentManager fragmentManager  = getSupportFragmentManager();
        PagerAdapter pagerAdapter = new com.example.manhvd.musicplayer.view.adapter.PagerAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    private void setToolbar() {
        toolbarMainActivity = findViewById(R.id.tool_barActivityMain);
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
                fragmentSongs = new FragmentSongs();
                fragmentSongs.LayoutSetup(LINEAR);
                break;
            case R.id.menu_gridView:
                fragmentSongs = new FragmentSongs();
                fragmentSongs.LayoutSetup(GRID);
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
