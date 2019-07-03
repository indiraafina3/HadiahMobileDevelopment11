package com.example.hadiahsound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /**
     *
     */
    Button btn01;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int musicId = R.raw.Everybody;
        player = MediaPlayer.create(this,musicId);
        player.setLooping(true);

        btn01 = findViewById(R.id.btn_tampil);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PesanActivity.class);
                startActivity(i);
            }
        });
    }   // end onCreate method

    @Override
    protected void onResume() {
        if(player != null){
            player.start();
        }
        super.onResume();
    }   // end onResume

    @Override
    protected void onPause() {
        if(player.isPlaying()){
            player.pause();
        }
        super.onPause();
    }   // end onPause

    @Override
    protected void onDestroy() {
        if(player != null){
            player.stop();
            player.release();
        }
        super.onDestroy();
    }   // end onDestroy

}   // end Class