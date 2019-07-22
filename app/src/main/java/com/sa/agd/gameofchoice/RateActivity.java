package com.sa.agd.gameofchoice;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sagor Ahamed on 6/30/2017.
 */

public class RateActivity extends AppCompatActivity {

    TextView rateMarks,rateResult,rateText;
    RatingBar rate;
    Button rateBtwn,backBtwn;
    String rating;
    Intent rateApp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        rateText=(TextView)findViewById(R.id.rate_text);
        rateResult=(TextView)findViewById(R.id.rate_result);
        /*rateMarks = (TextView)findViewById(R.id.rate_marks);
        rate =(RatingBar)findViewById(R.id.rate_app);*/


        rateBtwn =(Button)findViewById(R.id.rate_btwn);
        backBtwn = (Button)findViewById(R.id.back_btwn);

        rateApp=new Intent(Intent.ACTION_VIEW);

        if (LanguageActivity.banglaSelect==false){
            rateText.setText("Rate This App");
            rateResult.setText("If you enjoy This Quiz Game.\n Please take a moment to rate it.\nThanks for you support.");
            rateBtwn.setText("  Rate it  ");
            backBtwn.setText("  Menu  ");
        }else{
            rateText.setText("রেট করুন এই অ্যাপ");
            rateResult.setText("আপনার এই কুইজ গেমটি ভাল লাগলে,\n একটু সময় করে গেমটিতে রেট দিন।\n আপনার সমর্থনের জন্য ধন্যবাদ। ");
            rateBtwn.setText("  রেট করুন  ");
            backBtwn.setText("  মেনু  ");
        }


        rateBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id="
                                    + getPackageName())));
                }
                finish();
                /*rating=String.valueOf(rate.getRating());
                rateApp.setData(Uri.parse("http://play.google.com/store/apps/details?id="+ getPackageName()));*/
            }
        });

        backBtwn = (Button)findViewById(R.id.back_btwn);
        backBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RateActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }

    public void toastMessage(String m){
        Toast.makeText(getApplicationContext(),m,Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onBackPressed() {
        //your code when back button pressed
    }
}
