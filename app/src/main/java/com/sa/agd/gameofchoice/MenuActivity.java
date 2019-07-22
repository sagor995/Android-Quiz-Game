package com.sa.agd.gameofchoice;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.sa.agd.gameofchoice.R.id.StartButton;

public class MenuActivity extends AppCompatActivity {
    TextView welcomeText,rate_this_game,infor;
    Button strartBtwn, optionsBtwn, hScoreBtwn, exitBtwn;
    ImageView socialShare;
     Typeface custom_font;
    RelativeLayout menu_header;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       // custom_font = Typeface.createFromAsset(getAssets(), "fonts/bat.ttf");

//        welcomeText = (TextView) findViewById(R.id.WelcomeText);
//        welcomeText.setTypeface(custom_font);

        menu_header=(RelativeLayout)findViewById(R.id.menuHeader);

        strartBtwn = (Button) findViewById(StartButton);
        optionsBtwn = (Button) findViewById(R.id.OptionsButton);
        hScoreBtwn = (Button) findViewById(R.id.HighScoreButton);
        rate_this_game = (TextView) findViewById(R.id.rate_me);
        exitBtwn = (Button) findViewById(R.id.ExitButton);
        socialShare = (ImageView) findViewById(R.id.social_share);

        if (LanguageActivity.banglaSelect==false){
            menu_header.setBackgroundResource(R.drawable.goce);
            strartBtwn.setText(" Start ");
            optionsBtwn.setText(" Option ");
            hScoreBtwn.setText(" Score ");
            exitBtwn.setText(" Exit ");
        }else{
            menu_header.setBackgroundResource(R.drawable.gocb);
            strartBtwn.setText(" শুরু ");
            optionsBtwn.setText(" বিকল্প ");
            hScoreBtwn.setText(" স্কোর ");
            exitBtwn.setText(" বাহির ");
        }

        exitBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LanguageActivity.banglaSelect==false){
                    exitDialog("Exit!!!","Are you really you want to Exit ?","Yes","No");

                }else{
                    exitDialog("বাহির!!!","আপনি কি বের হতে চান?","হ্যাঁ","না");
                }
            }
        });

        goToOptionActivity();

        goToRateActivity();

        goToCategoryActivity();

        goToScoreActivity();

       /* goToInfoActivity();*/
        socialShare();

    }


    /*private void openSocialButtonsView(){
        LayoutInflater inflater = getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.social_pack, null);

        ImageView fb = (ImageView)dialoglayout.findViewById(R.id.fb_button);
        ImageView goo = (ImageView)dialoglayout.findViewById(R.id.google_button);
        ImageView tweet = (ImageView)dialoglayout.findViewById(R.id.twitter_button);
        ImageView pin = (ImageView)dialoglayout.findViewById(R.id.pinterest_button);
        //ImageView link = (ImageView)dialoglayout.findViewById(R.id.linkdin_button);
        ImageView email = (ImageView)dialoglayout.findViewById(R.id.email_button);

       fb.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Intent.ACTION_SEND);
               i.setType("text/plain");
               String uri="Game Of Choice: Quiz Game";//any Url
               i.putExtra(Intent.EXTRA_TEXT,uri);
               i.setPackage("com.facebook.katana");
               startActivity(i);
           }
       });

        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String uri="Game Of Choice: Quiz Game";//any Url
                i.putExtra(Intent.EXTRA_TEXT,uri);
                i.setPackage("com.google.android.apps.plus");
                startActivity(i);
            }
        });

        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i=new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_TEXT,"Game Of Choice: Quiz Game "+"market://details?id=" + getPackageName());
                    i.setPackage("advanced.twitter.android");
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please Install the Twitter App.",Toast.LENGTH_SHORT).show();
                }


            }
        });

        pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String uri="Game Of Choice: Quiz Game";//any Url
                i.putExtra(Intent.EXTRA_TEXT,uri);
                i.setPackage("com.pinterest");
                startActivity(i);
            }
        });

     *//*   link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*//*

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("Email"));
                //String[] strings={"sa_agd@gmail.com",""};
                String[] strings={"sa_agd@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL,strings);
                i.putExtra(Intent.EXTRA_SUBJECT,"");
                i.putExtra(Intent.EXTRA_TEXT,"");
                i.setType("message/rfc822");
                Intent chooser=Intent.createChooser(i,"Launch Email");
                startActivity(chooser);
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialoglayout);
        if (LanguageActivity.banglaSelect==false){
            builder.setTitle("Please Share: ");

        }else{
            builder.setTitle("শেয়ার করুনঃ ");
        }


        builder.setIcon(R.drawable.shareicon);
        builder.show();
    }*/



    private  void socialShare(){
        socialShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String uri="http://play.google.com/store/apps/details?id="+ getPackageName();//any Url
            i.putExtra(Intent.EXTRA_SUBJECT,"Game Of Choice: Quiz Game");
                i.putExtra(Intent.EXTRA_TEXT,uri);

                startActivity(Intent.createChooser(i,"Share via "));
                /*Toast.makeText(getApplicationContext(),"Social Share Icons",Toast.LENGTH_SHORT).show();*/
            }
        });

    }

    public void goToCategoryActivity() {
        strartBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public  void goToOptionActivity(){
        optionsBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,OptionsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void goToRateActivity(){
        rate_this_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rateIntent = new Intent(MenuActivity.this,RateActivity.class);
                startActivity(rateIntent);
                finish();
            }});
    }


    public  void goToScoreActivity(){
        hScoreBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    /**/
    @Override
    public void onBackPressed() {

            if (LanguageActivity.banglaSelect == false) {
                exitDialog("Exit","Do you want to exit ?","Yes","No");
            } else {
                exitDialog("বাহির","আপনি কি বের হতে চান ?","হ্যাঁ","না");
            }


    }

    /*private void Exit(String Title, String Message,String yes, String no){

        new AlertDialog.Builder(this)
                .setIcon(R.drawable.a)
                .setTitle(Title)
                .setMessage(Message)
                .setPositiveButton(yes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       *//*
                        dialog.dismiss();
                        finish();*//*
                        finish();
                    }

                })
                .setNegativeButton(no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

    }*/
    private void exitDialog(String Title, String Message, String Yes, String No){

        new AlertDialog.Builder(this,R.style.AlertDialogCustom)
                .setIcon(R.drawable.exitgame)
                .setTitle(Title)
                .setMessage(Message)
                .setPositiveButton(Yes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton(No, null)
                .show();
    }

}
