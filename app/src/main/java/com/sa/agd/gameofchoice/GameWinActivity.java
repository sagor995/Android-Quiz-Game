package com.sa.agd.gameofchoice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sa.agd.RecycleBin.SoundActivity;

/**
 * Created by Sagor Ahamed on 8/25/2017.
 */

public class GameWinActivity extends AppCompatActivity {
    TextView p_name,congrats_text;
    ImageView win_image;
    Button next_menu;
    RelativeLayout game_win_image;
    MediaPlayer winn;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_game_win);
        p_name=(TextView)findViewById(R.id.pName);
        congrats_text=(TextView)findViewById(R.id.congratsText);

        win_image=(ImageView)findViewById(R.id.winImage);

        winn=MediaPlayer.create(GameWinActivity.this,R.raw.winner);

        next_menu=(Button)findViewById(R.id.nextMenu);

        p_name.setText(UserNameActivity.name);

        if(LanguageActivity.banglaSelect==false){
            congrats_text.setText("You Win");
            next_menu.setText("Next");
            win_image.setBackgroundResource(R.drawable.congrats);
        }else{
            congrats_text.setText("আপনি জয়ী হয়েছেন");
            next_menu.setText("পরবর্তী");
            win_image.setBackgroundResource(R.drawable.congrats);
        }
        
        next_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitGame = new Intent(GameWinActivity.this,ScoreActivity.class);
                startActivity(exitGame);
                finish();
            }
        });


        if (SoundActivity.sOn==true) {
            if (!winn.isPlaying()) {
                winn.start();
            }
            if (winn.isPlaying()) {
                winn.seekTo(0);
            }
        }
    }
}
