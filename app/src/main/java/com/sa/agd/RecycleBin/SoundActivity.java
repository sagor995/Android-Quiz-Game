package com.sa.agd.RecycleBin;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sa.agd.gameofchoice.LanguageActivity;
import com.sa.agd.gameofchoice.R;
import com.sa.agd.gameofchoice.SplashActivity;

/**
 * Created by Sagor Ahamed on 8/12/2017.
 */

public class SoundActivity extends AppCompatActivity {
    Button sound_On, sound_Off;
    TextView gameSound;
    public static boolean sOn=true;
    MediaPlayer sound;
  //  Typeface custom_font;
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sound);
        sound=MediaPlayer.create(SoundActivity.this,R.raw.flip);
       // custom_font = Typeface.createFromAsset(getAssets(), "fonts/bat.ttf");
        gameSound =(TextView)findViewById(R.id.GameSounds);
      //  gameSound.setTypeface(custom_font);
        sound_On=(Button)findViewById(R.id.sound_yes);
      //  sound_On.setTypeface(custom_font);
        sound_Off=(Button)findViewById(R.id.sound_no);
      //  sound_Off.setTypeface(custom_font);

        if (LanguageActivity.banglaSelect==false){
            gameSound.setText("Game Sound");
            sound_On.setText("Yes");
            sound_Off.setText("No");
        }else{
            gameSound.setText("গেম সাউন্ড");
            sound_On.setText("হ্যাঁ");
            sound_Off.setText("না");
        }
        clickProperty();
    }

    private void clickProperty(){


        sound_On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sOn=true;
                if (!sound.isPlaying()) {
                    sound.start();
                }
                if (sound.isPlaying()) {
                    sound.seekTo(0);
                }
                /*if (LanguageActivity.banglaSelect==false){
                    showMessage("Volume On","Sound");
                }else{
                    showMessage("ভলিউম অন হয়েছে","সাউন্ড");
                }*/
                goToNext();
            }
        });


        sound_Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sOn=false;

                /*if (LanguageActivity.banglaSelect==false){
                    showMessage("Volume Off","Sound");
                }else{
                    showMessage("ভলিউম অফ হয়েছে","সাউন্ড");
                }*/
                goToNext();
            }
        });
    }
    private void goToNext(){
        Intent goToNext=new Intent(SoundActivity.this,SplashActivity.class);
        startActivity(goToNext);
        finish();

    }
   /* public void showMessage( String Message,String Title){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Message);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setIcon(R.drawable.volume);
        builder.show();

    }*/

    @Override
    public void onBackPressed() {
        //your code when back button pressed
    }
}
