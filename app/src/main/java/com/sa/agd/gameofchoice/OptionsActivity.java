package com.sa.agd.gameofchoice;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Sagor Ahamed on 8/5/2017.
 */

public class OptionsActivity extends AppCompatActivity {
    Button soundOn,soundOff,soundBack,info,banBtwn,engBtwn;
    MediaPlayer sound;
    TextView game_sound,languageSelect;
    private AdView mAdView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        soundOn = (Button)findViewById(R.id.soundon);
        soundOff = (Button)findViewById(R.id.soundoff);
        soundBack=(Button)findViewById(R.id.soundback);
        game_sound=(TextView)findViewById(R.id.gameSound);
        info=(Button)findViewById(R.id.creditWindow);
        banBtwn=(Button)findViewById(R.id.banglaLanguage);
        engBtwn=(Button)findViewById(R.id.englishLanguage);
        languageSelect=(TextView)findViewById(R.id.language_select);

        if (LanguageActivity.banglaSelect==false){
           game_sound.setText("Game Sound");
            soundOn.setText(" On ");
            soundOff.setText(" Off ");
            soundBack.setText("  Menu  ");
            info.setText("   Game Info   ");
            banBtwn.setText("   Bangla   ");
            engBtwn.setText("   English   ");
            languageSelect.setText("Select Your Language");
        }else{
            game_sound.setText("গেম সাউন্ড");
            soundOn.setText(" অন ");
            soundOff.setText(" অফ ");
            soundBack.setText("  মেনু  ");
            info.setText("   গেম তথ্য   ");
            banBtwn.setText("       বাংলা       ");
            engBtwn.setText("       ইংরেজি       ");
            languageSelect.setText("ভাষা সিলেক্ট করুন");
        }


        sound=MediaPlayer.create(OptionsActivity.this,R.raw.flip);
        soundInstructions();

        soundBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenu();
            }
        });

        languageInstructions();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }



    private void languageInstructions(){
        banBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.banglaSelect=true;
                goToMenu();
            }
        });

        engBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.banglaSelect=false;
                goToMenu();
            }
        });

    }

    private void soundInstructions(){
        soundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.sOn=true;
                if (!sound.isPlaying()) {
                    sound.start();
                }
                if (sound.isPlaying()) {
                    sound.seekTo(0);
                }
                if (LanguageActivity.banglaSelect==false){
                    showMessage("  On  ","Sound");
                }else{
                    showMessage("  অন  ","সাউন্ড");
                }

            }
        });

        soundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageActivity.sOn=false;
                if (LanguageActivity.banglaSelect==false){
                    showMessage("  Off  ","Sound");
                }else{
                    showMessage("  অফ  ","সাউন্ড");
                }

            }
        });

        goToInfoActivity();
    }

    public  void goToInfoActivity(){
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this,InfoActivity.class );
                startActivity(intent);
                finish();
            }
        });
    }

    private void showMessage( String Message,String Title){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Message);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setIcon(R.drawable.a);
        builder.show();

    }
    private void goToMenu(){
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        //your code when back button pressed
    }

}
