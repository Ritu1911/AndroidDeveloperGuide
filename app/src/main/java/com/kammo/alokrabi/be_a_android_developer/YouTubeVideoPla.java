package com.kammo.alokrabi.be_a_android_developer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.kammo.alokrabi.be_a_android_developer.Common.Common;

public class YouTubeVideoPla extends YouTubeBaseActivity implements YouTubePlayer.PlayerStateChangeListener, YouTubePlayer.PlaylistEventListener, YouTubePlayer.PlaybackEventListener{
    YouTubePlayerView youTubePlayerView;
    YouTubeRecyclerViewFragment.LastItemReachedListener mListener;

    //String title = getIntent().getStringExtra("title");

    YouTubePlayer.OnInitializedListener onInitializedListener;
    YouTubePlayer.PlaybackEventListener onPlayBackEventListener;
    YouTubePlayer.PlaylistEventListener playlistEventListener ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_video_pla);

//        youTubePlayerView.initialize(ApiKey.YOUTUBE_API_KEY,onInitializedListener);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);

        if (Common.isConnectedToInternet(getBaseContext())) {
            Bundle extra = this.getIntent().getExtras();
            if (extra != null) {

                final String video = extra.getString("VIDEO");

                // final int position = Integer.parseInt(video);
                final int position = extra.getInt("POS");

                onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                        youTubePlayer.loadVideo(video);
                        youTubePlayer.setFullscreen(true);
                       // youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
                       // youTubePlayer.setPlaybackEventListener(playbackEventListener);
                    }


                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                    }
                };
                youTubePlayerView.initialize(ApiKey.YOUTUBE_API_KEY, onInitializedListener);

            } else {
                Toast.makeText(YouTubeVideoPla.this, "Please check your internet connection!!", Toast.LENGTH_SHORT).show();
                return;
            }


        }
    /*  */


    }
    @Override
    public void onConfigurationChanged (Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
    }
    @Override
    public void onResume(){
        super.onResume();
        try {
            Bundle extra = this.getIntent().getExtras();
            if (extra != null) {
                final String video = extra.getString("VIDEO");

                onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                        youTubePlayer.loadVideo(video);
                        youTubePlayer.setFullscreen(true);

                      //  youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
                        //youTubePlayer.setPlaybackEventListener(playbackEventListener);
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                    }
                };
                youTubePlayerView.initialize(ApiKey.YOUTUBE_API_KEY,onInitializedListener);
            }



        } catch (Throwable ignored) {}
    }


    @Override
    public void onPrevious() {


    }

    @Override
    public void onNext() {

    }

    @Override
    public void onPlaylistEnded() {

    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoaded(String s) {

    }

    @Override
    public void onAdStarted() {

    }

    @Override
    public void onVideoStarted() {

    }

    @Override
    public void onVideoEnded() {

    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {

    }
}
