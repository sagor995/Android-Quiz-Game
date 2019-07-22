package com.sa.agd.gameofchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sa.agd.databasehelper.MyDataBaseHelper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Sagor Ahamed on 5/26/2017.
 */

public class ScoreActivity extends AppCompatActivity {
    private Button menuBackButton,resetScoreButton;
    ListView listView;
    MyDataBaseHelper myDatabaseHelper2;
    ArrayList<Scores> listData;

    AdView adView;
    private InterstitialAd interstitialAd;

    TextView score_text,player_name,player_score,player_category;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        myDatabaseHelper2 =new MyDataBaseHelper(this);
        listView=(ListView)findViewById(R.id.mlistView);
        Intent receiveIntent = getIntent();

        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.intertial_ads)); //ca-app-pub-5358264522471884/5630864500
        interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                startActivity(new Intent(ScoreActivity.this,MenuActivity.class));
                finish();
                interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
            }
        });
//        //usual Score
//        normalScore = (TextView)findViewById(R.id.normal_Score);
//
//        //Highest Score
//        highScore = (TextView)findViewById(R.id.high_Score);

        //display Name
        //  String name = receiveIntent.getStringExtra("userName");
        //display current Score
        //score=receiveIntent.getIntExtra("gameScore",0);
        listData=new ArrayList<>();
        if(LanguageActivity.banglaSelect==false){
            listData=myDatabaseHelper2.getAllEngScoreDatas();
        }else{
            listData=myDatabaseHelper2.getAllBanScoreDatas();
        }

        //Sorting score number Ascending Order

        Collections.sort(listData, new Comparator<Scores>(){
            public int compare(Scores obj1, Scores obj2)
            {
                // TODO Auto-generated method stub
                return (obj1.score > obj2.score) ? -1: (obj1.score > obj2.score) ? 1:0 ;
            }
        });


        ScoreListAdapter adapter = new ScoreListAdapter(this,R.layout.custome_scoreview,listData);
        listView.setAdapter(adapter);



//        normalScore.setText(" আপনার বর্তমান স্কোর: "+score);

//        sharedPreferences = getPreferences(MODE_PRIVATE);
//        int highestScore = sharedPreferences.getInt("hscore",0);
//
//        if (highestScore>=score){
//            highScore.setText(" সর্বোচ্চ স্কোর : "+highestScore);
//
//        }else{
//            highScore.setText(" অভিনঁদন! নতুন সর্বোচ্চ স্কোর: "+score);
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.putInt("hscore",score);
//            editor.commit();
//        }
        menuBackButton = (Button)findViewById(R.id.menu_back_button);
        resetScoreButton = (Button)findViewById(R.id.reset_high_score);
        score_text=(TextView)findViewById(R.id.scoreText);
        player_name=(TextView)findViewById(R.id.playerName);
        player_score=(TextView)findViewById(R.id.playerScore);
        player_category=(TextView)findViewById(R.id.playerCategory);

        if (LanguageActivity.banglaSelect==false){
            menuBackButton.setText("  Menu  ");
            resetScoreButton.setText("  Reset  ");
            score_text.setText("Score Board  ");
            player_score.setText("Score: ");
            player_name.setText("Name: ");
            player_category.setText("Topic");
        }else{
            menuBackButton.setText("  মেনু  ");
            resetScoreButton.setText("  রিসেট  ");
            score_text.setText("স্কোর বোর্ড");
            player_score.setText("স্কোরঃ ");
            player_name.setText("নামঃ ");
            player_category.setText("বিষয়ঃ");
        }



        goToMenu();
      //  playAgain();
        resetScore();


    }


    private void goToMenu(){

        menuBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()){
                    interstitialAd.show();
                }else {
                    startActivity(new Intent(ScoreActivity.this,MenuActivity.class));
                    finish();

                }


            }
        });

    }
    private void resetScore(){

        resetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                editor.clear();
//                editor.commit();
//                highScore.setText(" সর্বোচ্চ স্কোর :");
                if (LanguageActivity.banglaSelect==false){
                    myDatabaseHelper2.clearEngScores();
                }else{
                    myDatabaseHelper2.clearBanScores();
                }

                Intent intent = new Intent(ScoreActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
//    private void playAgain(){
//        scoreBackButton = (Button)findViewById(R.id.score_back_button);
//        scoreBackButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(ScoreActivity.this, QuizActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

   // }
   @Override
   public void onBackPressed() {
       //your code when back button pressed
   }


}
