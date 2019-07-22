package com.sa.agd.gameofchoice;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.sa.agd.RecycleBin.SoundActivity;

/**
 * Created by Sagor Ahamed on 8/12/2017.
 */

public class SplashActivity extends AppCompatActivity {
    int count=0;
    ImageView splashImage;
    CountDownTimer splashTimer;
    int sCounter;
    MediaPlayer play;
    GlideDrawableImageViewTarget imageViewTarget;
   int arr[]={R.drawable.a,
           R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
    };
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_splash);
        play = MediaPlayer.create(SplashActivity.this,R.raw.shine);
        splashImage=(ImageView)findViewById(R.id.splashImage);
        imageViewTarget = new GlideDrawableImageViewTarget(splashImage);
        splashImage.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Glide.with(SplashActivity.this).load(R.raw.splash2).into(imageViewTarget);

        /*if (SoundActivity.sOn==true) {
            if (!play.isPlaying()) {
                play.start();
            }
            if (play.isPlaying()) {
                play.seekTo(0);
            }
        }*/

        splashTimer=new CountDownTimer(1250,30) {
            @Override
            public void onTick(long millisUntilFinished) {
                count++;
            }

            @Override
            public void onFinish() {
                count=0;
                splashTimer.cancel();

                goToSignIn();

                /*if (isNetworkAvailable()==true){

                }else {
                    Toast.makeText(SplashActivity.this, "Please check your wifi internet connection", Toast.LENGTH_SHORT).show();
//
                }*/

            }
        }.start();




    }

    private void goToSignIn(){
        splashTimer.cancel();
        Intent goToNext=new Intent(SplashActivity.this,LoadingActivity.class);
        startActivity(goToNext);
        finish();
    }


}
