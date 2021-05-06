package com.khanghappybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mh;
    MediaPlayer song;
    ImageView imgvMiuLe;

    public  void AnhXa() {
        mh = (RelativeLayout) findViewById(R.id.manhinh);
        imgvMiuLe = (ImageView) findViewById(R.id.imageViewMiuLe);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        //background
        mh.setBackgroundResource(R.drawable.bg1);

        //nhạc nền
        song = MediaPlayer.create(getApplicationContext(), R.raw.nangtho);
        song.start();

        //hiệu ứng hình
        Animation f = AnimationUtils.loadAnimation(this, R.anim.fade);
        f.reset();
        imgvMiuLe.clearAnimation();
        imgvMiuLe.startAnimation(f);

        imgvMiuLe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent mhMusic = new Intent(getApplicationContext(), Music.class);
                startActivity(mhMusic);

            }
        });

    }
}