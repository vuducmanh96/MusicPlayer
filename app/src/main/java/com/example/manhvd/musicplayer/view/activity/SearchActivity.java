package com.example.manhvd.musicplayer.view.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.manhvd.musicplayer.R;

public class SearchActivity extends AppCompatActivity {
    private ListView listViewSearch;
    private ImageView imgBackSearch;
    private ImageView imgClearTextSearch;
    private EditText edtSearchText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        widgets();
        listenerSearchActivity();
    }

    private void listenerSearchActivity() {
        imgBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imgClearTextSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSearchText.setText("");
            }
        });
    }

    private void widgets() {
        listViewSearch = findViewById(R.id.lv_listSearch);
        imgBackSearch = findViewById(R.id.img_back_search);
        imgClearTextSearch = findViewById(R.id.img_search_clear_text);
        edtSearchText = findViewById(R.id.edt_search_text);
    }

}
