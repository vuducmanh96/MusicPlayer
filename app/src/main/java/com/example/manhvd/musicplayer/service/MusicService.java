//package com.example.manhvd.musicplayer.service;
//
//import android.app.Service;
//import android.content.ComponentName;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.os.Binder;
//import android.os.IBinder;
//import android.os.PowerManager;
//import android.support.annotation.Nullable;
//
//import com.example.manhvd.musicplayer.model.entity.Songs;
//
//import java.util.ArrayList;
//
//public class MusicService extends Service implements
//        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
//        MediaPlayer.OnCompletionListener{
//    private MediaPlayer player;
//    private ArrayList<Songs> songsArrayList;
//    private int songPosn;
//    private MusicService musicSrv;
//    private Intent playIntent;
//    private boolean musicBound=false;
//
//    public void setSongsArrayList(ArrayList<Songs> songsArrayList) {
//        this.songsArrayList = songsArrayList;
//    }
//
//    public class MusicBinder extends Binder {
//        MusicService getService() {
//            return MusicService.this;
//        }
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCompletion(MediaPlayer mp) {
//
//    }
//
//    @Override
//    public boolean onError(MediaPlayer mp, int what, int extra) {
//        return false;
//    }
//
//    @Override
//    public void onPrepared(MediaPlayer mp) {
//
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        songPosn = 0;
//        player = new MediaPlayer();
//        initMusicPlayer();
//    }
//
//    private ServiceConnection musicConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            MusicBinder binder = (MusicBinder) service;
//            musicSrv = binder.getService();
//            musicSrv.setSongsArrayList(songsArrayList);
//            musicBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            musicBound = false;
//        }
//    };
//
//    public void initMusicPlayer() {
//        player.setWakeMode(getApplicationContext(),
//                PowerManager.PARTIAL_WAKE_LOCK);
//        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        player.setOnPreparedListener(this);
//        player.setOnCompletionListener(this);
//        player.setOnErrorListener(this);
//    }
//}
