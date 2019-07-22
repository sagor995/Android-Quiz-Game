package com.sa.agd.gameofchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sagor Ahamed on 8/25/2017.
 */

public class InfoActivity extends AppCompatActivity {

    TextView about_text,info_text;
    Button go_to_m,devInfo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        about_text=(TextView)findViewById(R.id.aboutText);
        info_text=(TextView)findViewById(R.id.infoText);
        go_to_m=(Button)findViewById(R.id.goToM);
       /* devInfo=(Button)findViewById(R.id.dev_info);*/

        if(LanguageActivity.banglaSelect==false){
            about_text.setText("   About Game   ");
            info_text.setText("A Simple Quiz Game.\n\n" +

                    "Rules:\n"+
                    "        \nIn this Game You have to answer 16\n" +
                    "questions in given time. You Can select any category before playing Game.\n" +
                    "and You can also use three types of helpline: \n" +
                    "1.Half-HelpLine: Two wrong options will be gone.\n" +
                    "2.Percent-HelpLine:A Window Will show the possibilities of earch option of being correct in percentage.\n" +
                    " in percentage of each options.\n" +
                    "3.Renew-HelpLine: It will renew the upper two helpline again for once.\n"+
                    "\nNote: An internet connection required to use this helpline."+
                    "Player will earn point for each correct answer.\n" +
                    "for wrong answer game will be over directly.\n\n"+
                    "*******************************\n"+

            "\nNote: This Game has been created based on several selected sort of questions on different categories."+
            "\n\nGame Of Choice\n\n"+"Platform: Android Studio"+"\n\"AppsDevSA\"\n"+"Email:sa.agd@outlook.com" +
                    "\n\nCredits:\nsagorahamed995@gmail.com\n&\nnabilahmed18@yahoo.com ");
            go_to_m.setText("  Back  ");
           /* devInfo.setText("  Dev info.  ");*/

        }else {
            about_text.setText("   গেম সম্পর্কে   ");
            info_text.setText("একটা খুবই সাধারন কুইজ গেম।\n\n" +
                    "নিয়মঃ\n"+
                    "        \nএই গেমে নির্দিষ্ট সময়ের মধ্যে ১৬টি প্রশ্নের উত্তর দিতে হবে।\n" +
                    "গেম শুরু করার আগে যেকোন বিষয় নির্বাচন করতে পারবেন।\n" +
                    "এবং তিন ধরনের হেল্প লাইন ব্যাবহার করতে পারবেনঃ \n" +
                    "১.হালফ-হেল্পলাইন: যেখানে দুইটা ভুল অপশন চলে যাবে।\n" +
                    "২.জরিপ-হেল্পলাইন: একটা উইন্ডো প্রত্যেকটা অপশন কতটুকু সঠিক হতে পারে সেটা দেখাবে।\n"+
                    "৩.রিনিউ-হেল্পলাইন: এটা উপরের হেল্পলাইন দুটিকে আবারও\n" +
                    "\nনোটঃ এটা ব্যাবহার করতে ইন্টারনেট সংযোগ প্রয়োজন।"+
                    " সক্রিয় করে দিবে, কিন্তু ১ বারের জন্য।" +
                    "\nপ্রত্যেক সঠিক উত্তরের জন্য পয়েন্ট অর্জন করবেন।\n" +
                    "ভুল উত্তরের জন্য গেম সাথে সাথে শেষ হয়ে যাবে।\n"+"\n*******************************\n"+
                    "\nনোটঃ এই গেমটি বিভিন্ন বিভাগের কতগুলো বাছাইকৃত প্রশ্নর উপর ভিত্তি করে তৈরি করা হয়েছে।"+
                    "\n\nগেম অফ চয়েজ\n\n"+"প্লাটফর্মঃ এন্ড্রয়েড স্টুডিও"+"\n\"অ্যাপস ডেভ এস এ\"\n"+"ইমেইলঃ sa.agd@outlook.com" +
                    "\n\nক্রেডিটঃ\nsagorahamed995@gmail.com\nও\nnabilahmed18@yahoo.com ");
            go_to_m.setText("  ফিরে যান  ");
            /*devInfo.setText(" ডেভ তথ্য. ");*/

        }

        go_to_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToOptions();
            }
        });

      /*  devInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LanguageActivity.banglaSelect==false){

                    showMessage("\nGame Of Choice \n\nPlatform: Android Studio\n\n\"SA AGD\" \n\nEmail:sa.agd@outlook.com \n\n","App Credits");
                }else{
                    showMessage("\nগেম অফ চয়েজ \n\nপ্লাটফর্মঃ এন্ড্রয়েড স্টুডিও\n\n\"এস এ এ.জি.ডি\" \n\nইমেইলঃ sa.agd@outlook.com \n\n","অ্যাপ ক্রেডিটস");
                }
            }
        });*/

    }
   /* private void showMessage( String Message,String Title){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Message);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setIcon(R.drawable.a);
        builder.show();

    }*/
    @Override
    public void onBackPressed() {
        goToOptions();
    }

    private  void goToOptions(){
        Intent exitGame = new Intent(InfoActivity.this,OptionsActivity.class);
        startActivity(exitGame);
        finish();
    }
}
