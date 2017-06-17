package serifenuruysal.com.mediaexample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    ImageView btnVideoPlay,btnStopVideo;
    MediaPlayer mp;
    VideoView videoView;
    Button btnSoundPlay,btnSoundStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVideoPlay = (ImageView) findViewById(R.id.btnPlayVideo);
        btnStopVideo=(ImageView)findViewById(R.id.btnStopVideo);
        btnSoundPlay=(Button)findViewById(R.id.btnSoundPlay);
        btnSoundStop=(Button)findViewById(R.id.btnSoundStop);
        videoView = (VideoView) findViewById(R.id.videoView);
        mp = MediaPlayer.create(MainActivity.this, R.raw.samplesound);

        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videoView.setKeepScreenOn(true);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.samplevideo);
        videoView.requestFocus();


        btnVideoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();


            }
        });
        btnStopVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
        btnSoundPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

            }
        });
        btnSoundStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();

    }
}
