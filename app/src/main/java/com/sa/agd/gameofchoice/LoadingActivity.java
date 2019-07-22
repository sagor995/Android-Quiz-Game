package com.sa.agd.gameofchoice;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Sagor Ahamed on 8/13/2017.
 */

public class LoadingActivity extends AppCompatActivity {
    ProgressBar loadingBar;
    CountDownTimer loadingTimer;
    int loading;
    RelativeLayout loading_header;
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        loadingBar = (ProgressBar) findViewById(R.id.gameLoader);


        loading_header=(RelativeLayout)findViewById(R.id.loginHeader);


        if (LanguageActivity.banglaSelect==false){
            loading_header.setBackgroundResource(R.drawable.screen);

        }else{
            loading_header.setBackgroundResource(R.drawable.screen2);
        }


        loadingTimer = new CountDownTimer(7000,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                loading++;
                loadingBar.setProgress(loading);
            }

            @Override
            public void onFinish() {
                //Toast.makeText(getApplicationContext(),"Loading Complete",Toast.LENGTH_SHORT).show();
                loadingTimer.cancel();
                Intent goToNext=new Intent(LoadingActivity.this,UserNameActivity.class);
                startActivity(goToNext);
                finish();
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        //your code when back button pressed
    }

}
