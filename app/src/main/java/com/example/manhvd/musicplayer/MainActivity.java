package com.example.manhvd.musicplayer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvTitleMainActivity;
    private android.support.v7.widget.Toolbar toolbarMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        addControl();
    }

    private void setToolbar() {
        toolbarMainActivity = findViewById(R.id.tool_barActivityMain);
        //tvTitleMainActivity = findViewById(R.id.tv_titleToolBarMainActivity);
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
                Toast.makeText(this, "Select menu1!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_gridView:
                Toast.makeText(this, "Select menu2!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_action_search:
                Toast.makeText(this, "Select search!", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addControl() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager  =findViewById(R.id.view_pager);
        FragmentManager fragmentManager  = getSupportFragmentManager();
        PagerAdapter pagerAdapter = new com.example.manhvd.musicplayer.Adapter.PagerAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }
}
