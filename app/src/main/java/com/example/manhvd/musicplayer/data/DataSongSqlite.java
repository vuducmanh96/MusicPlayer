package com.example.manhvd.musicplayer.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.example.manhvd.musicplayer.R;
import com.example.manhvd.musicplayer.model.entity.Songs;

import java.util.ArrayList;

public class DataSongSqlite extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "song_list";
    private static final String TABLE_NAME ="song";
    private static final String ID ="id_song";
    private static final String NAME ="name_song";
    private static final String ARTISTS ="artists_song";
    private Context context;
    private ArrayList<Songs> arrayListSongs;

    public DataSongSqlite(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("DBManager", "DBManager: ");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " integer primary key, " +
                NAME + " TEXT, " +
                ARTISTS + " TEXT)";
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "Drop successfylly", Toast.LENGTH_SHORT).show();
    }

    public void addSong(Songs songs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!=0";
        Cursor cursor = context.getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                    String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    //Songs s = new Songs(R.drawable.beat, name,artist);
                    Songs s = new Songs(name, artist);
                    arrayListSongs.add(s);
                    values.put(NAME, songs.getNameSongsModel());
                    values.put(ARTISTS, songs.getArtistsSongsModel());
                }while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<Songs> getAllSongs() {
        ArrayList<Songs> listSongs = new ArrayList<Songs>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Songs songs = new Songs();
                songs.setIdSongModel(cursor.getInt(0));
                songs.setNameSongsModel(cursor.getString(1));
                songs.setArtistsSongsModel(cursor.getString(2));
                listSongs.add(songs);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listSongs;
    }
}
