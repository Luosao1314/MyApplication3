package com.example.luke.tv;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.net.URL;

public class Play extends AppCompatActivity {

    private String[] list = {
            "CCTV-1 综合", "CCTV-2 财经", "CCTV-3 综艺", "CCTV-4 中文国际", "CCTV-5 体育",
            "CCTV-6 电影", "CCTV-7 军事农业", "济南影视", "峨眉电影",
            "四川文化", "四川经济", "四川影视", "四川公共"
    };
    private String[] urllist = {
            "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8",
            "http://223.110.245.170/ott.js.chinamobile.com/PLTV/3/224/3221227207/index.m3u8",
            "http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8",
            "http://ivi.bupt.edu.cn/hls/cctv4hd.m3u8",
            "http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8",
            "http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8",
            "http://ivi.bupt.edu.cn/hls/cctv7hd.m3u8",
            "http://ts1.ijntv.cn/yshd/hd/live.m3u8",
            "http://scgctvshow.sctv.com/hdlive/emei/3.m3u8",
            "http://scgctvshow.sctv.com/hdlive/sctv2/3.m3u8",
            "http://scgctvshow.sctv.com/hdlive/sctv3/3.m3u8",
            "http://scgctvshow.sctv.com/hdlive/sctv5/3.m3u8",
            "http://scgctvshow.sctv.com/sdlive/sctv9/3.m3u8",
    };
    private int[] icon = {
            R.drawable.c1,
            R.drawable.c2,
            R.drawable.c3,
            R.drawable.c4,
            R.drawable.c5,
            R.drawable.c6,
            R.drawable.c7,
            R.drawable.j1,
            R.drawable.e1,
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
    };
    private ImageView img;
    private PlayerView mPlayerView;
    private SimpleExoPlayer mPlayer;
    private VideoView videoView;
    public String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();//返回按钮
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }//返回按钮
        Intent intent = getIntent();
        int tvId = intent.getIntExtra("name", 0);
        setTitle(list[tvId]);
        img = (ImageView) findViewById(R.id.img);
        img.setImageResource(icon[tvId]);
        //initView();
        //initExo(tvId);
        test(tvId);
    }

    public boolean onOptionsItemSelected(MenuItem item) {//返回按钮
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }//返回按钮

    //    private void initView() {
//        mPlayerView = (PlayerView) findViewById(R.id.ep1);
//    }
    public void test(int tvId) {
        String videoUrl2 = urllist[tvId];
        Uri uri = Uri.parse(videoUrl2);
        videoView = (VideoView) this.findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this));
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
        videoView.setVideoURI(uri);
        videoView.start();

    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(Play.this, "播放错误", Toast.LENGTH_SHORT).show();
        }
    }
    //public void test(int tvId) {
//        Handler mainHandler = newHandler();
//        BandwidthMeter bandwidthMeter = newDefaultBandwidthMeter();
//        TrackSelection.Factory videoTrackSelectionFactory = newAdaptiveTrackSelection.Factory(bandwidthMeter);
//        TrackSelector trackSelector = newDefaultTrackSelector(videoTrackSelectionFactory);

    //}
//    private void initExo(int tvId) {
//        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
//
//        TrackSelection.Factory videoTrackSelectionFactory =
//                new AdaptiveTrackSelection.Factory(bandwidthMeter);
//        TrackSelector trackSelector =
//                new DefaultTrackSelector(videoTrackSelectionFactory);
//
//        mPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
//        //组件绑定播放器
//        mPlayerView.setPlayer(mPlayer);
//
//        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
//        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
//                Util.getUserAgent(this, "yzplayer"), defaultBandwidthMeter);
//        Uri url = Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8");
//        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(url);
//        //开始播放
//        mPlayer.prepare(videoSource);
//        mPlayer.setPlayWhenReady(true);
//
//        Toast.makeText(getApplicationContext(), url.getPath(),
//                Toast.LENGTH_SHORT).show();
//    }


}
