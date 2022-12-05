package com.example.audio_video;

import androidx.appcompat.app.AppCompatActivity; import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController; import android.widget.Toast;
import android.widget.VideoView; import java.io.IOException;
import java.net.URI;


public class MainActivity extends AppCompatActivity {

    Button play, pause, stop;
    MediaPlayer mp; VideoView myVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play= findViewById(R.id.button1);
        pause=(Button)findViewById(R.id.button2);
        stop=(Button)findViewById(R.id.button3);
        MediaPlayer mPlayer = new MediaPlayer();
        try {
            Uri myUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song);
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); mPlayer.setDataSource(getApplicationContext(), myUri);

            mPlayer.prepare();

        } catch (IOException e) { e.printStackTrace();
        }
        play.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { mPlayer.start();

        }
        });



        pause.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { mPlayer.pause();

        }
        });
//video view
//Set MediaController to enable play, pause, forward, etc options.
MediaController mediaController= new MediaController(this);
myVideoView= findViewById(R.id.videoView);
//Location of Media File
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.namo);
//Starting VideView By Setting MediaController and
 myVideoView.setMediaController(mediaController);
 myVideoView.setVideoURI(uri);
 myVideoView.requestFocus();
 myVideoView.start();

    }
}