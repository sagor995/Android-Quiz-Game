package com.sa.agd.gameofchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sagor Ahamed on 8/12/2017.
 */

public class LanguageActivity extends AppCompatActivity {
    public static boolean sOn=true;
   Button banglaBtwn,englishBtwn;
    public static boolean banglaSelect=false;
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_language);
        banglaBtwn=(Button)findViewById(R.id.bangla_select);
        englishBtwn=(Button)findViewById(R.id.english_select);

        selectLanguage();
    }
    private void selectLanguage(){

        banglaBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banglaSelect=true;

//                if (banglaSelect==true){
//                   // toastMessage("বাংলা ভাষা সিলেক্ট করা হয়েছে।");
//                }
                goToNext();
            }
        });

        englishBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banglaSelect=false;
//                if (banglaSelect==false){
//                  //  toastMessage("English Language Selected.");
//                }
                goToNext();
            }
        });
    }

    private void goToNext(){
        Intent goToNext=new Intent(LanguageActivity.this,SplashActivity.class);
        startActivity(goToNext);
        finish();

    }
   /* private void toastMessage(String m){
        Toast.makeText(getApplicationContext(),m,Toast.LENGTH_SHORT).show();
    }*/

}
