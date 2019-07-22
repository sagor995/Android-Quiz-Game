package com.sa.agd.gameofchoice;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sa.agd.RecycleBin.SoundActivity;
import com.sa.agd.databasehelper.ChemistryBangla;
import com.sa.agd.databasehelper.ChemistryEnglish;
import com.sa.agd.databasehelper.MathBangla;
import com.sa.agd.databasehelper.MathEnglish;
import com.sa.agd.databasehelper.MyDataBaseHelper;
import com.sa.agd.databasehelper.PhysicsBangla;
import com.sa.agd.databasehelper.PhysicsEnglish;
import com.sa.agd.databasehelper.ProgrammingBangla;
import com.sa.agd.databasehelper.ProgrammingEnglish;
import com.sa.agd.databasehelper.RandomBangla;
import com.sa.agd.databasehelper.RandomEnglish;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Random;

/**
 * Created by Sagor Ahamed on 6/29/2017.
 */

public class QuizActivity extends AppCompatActivity implements RewardedVideoAdListener {
    Button exitGame, newGame;
    Button username;
    TextView levelTextView, helpLineText;
    Boolean videoAdsPlayed = false;
    private TextView quesShow, quesCounter, timeCounter, pointCounter;
    Button optionA, optionB, optionC, optionD, lockButton;
    ImageView levelCounter, helpLineOne, helpLineTwo, helpLineThree;

    private int timeCount, animateCount;
    private String correctAnswer;

    private int point = 0;

    private int questionNumber = 0, number = 0;

    private PhysicsEnglish mQuestionLibrary = new PhysicsEnglish();
    private PhysicsBangla physicsBangla = new PhysicsBangla();

    private ChemistryBangla chemistryBangla = new ChemistryBangla();
    private ChemistryEnglish chemistryEnglish = new ChemistryEnglish();

    private ProgrammingBangla programmingBangla = new ProgrammingBangla();
    private ProgrammingEnglish programmingEnglish = new ProgrammingEnglish();

    private MathBangla mathBangla = new MathBangla();
    private MathEnglish mathEnglish = new MathEnglish();

    private RandomBangla randomBangla = new RandomBangla();
    private RandomEnglish randomEnglish = new RandomEnglish();

    ProgressBar simpleProgressBar;

    CountDownTimer gameTimer, animateTimer;

    MediaPlayer answerLock, correct, wrong, hint_help, half_help, percent_help, levelUP, netNotAvailable;

    boolean buttonA = false, buttonB = false, buttonC = false, buttonD = false;
    boolean half_helpLine = false, hint_helpLine = false, percent_helpLine = false;

    //HelpLines
    String secondHelpLine, firstHelpLine;
    Random rand;
    int l1, l2, l3, l4;

    MyDataBaseHelper myDatabaseHelper2;


    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        myDatabaseHelper2 = new MyDataBaseHelper(this);

        Intent intent = getIntent();

        levelTextView = (TextView) findViewById(R.id.level_text_view);
        helpLineText = (TextView) findViewById(R.id.help_line_text);


        username = (Button) findViewById(R.id.usernameB);
        username.setText(UserNameActivity.name);


        /*
        ** Help Lines
        **/
        helpLineOne = (ImageView) findViewById(R.id.helpLine_one);
        helpLineTwo = (ImageView) findViewById(R.id.helpLine_two);
        helpLineThree = (ImageView) findViewById(R.id.helpLine_three);


        /*
        ** Question, level, time & point Counter Part
        **/
        levelCounter = (ImageView) findViewById(R.id.level_counter);
        quesCounter = (TextView) findViewById(R.id.question_coutner);

        //timeCounter = (TextView) findViewById(R.id.time_counter);

        simpleProgressBar = (ProgressBar) findViewById(R.id.time_counter);

        pointCounter = (TextView) findViewById(R.id.point_counter);


        quesShow = (TextView) findViewById(R.id.question_show);

        optionA = (Button) findViewById(R.id.option_a);
        optionB = (Button) findViewById(R.id.option_b);
        optionC = (Button) findViewById(R.id.option_c);
        optionD = (Button) findViewById(R.id.option_d);
        lockButton = (Button) findViewById(R.id.lock_it_button);

        newGame = (Button) findViewById(R.id.new_game_button);

        exitGame = (Button) findViewById(R.id.exit_game_button);


        /*
        ** Sound for option Choose
        **/
        answerLock = MediaPlayer.create(QuizActivity.this, R.raw.answer_lock_new);
        correct = MediaPlayer.create(QuizActivity.this, R.raw.correct);
        wrong = MediaPlayer.create(QuizActivity.this, R.raw.wrong);
        hint_help = MediaPlayer.create(QuizActivity.this, R.raw.quick_hint);

        half_help = MediaPlayer.create(QuizActivity.this, R.raw.half);

        percent_help = MediaPlayer.create(QuizActivity.this, R.raw.flip);

        levelUP = MediaPlayer.create(QuizActivity.this, R.raw.level_up);

        netNotAvailable = MediaPlayer.create(QuizActivity.this, R.raw.connection);

        /*
        ** Timer of the Game
        **/
        gameTimer = new CountDownTimer(33000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                //timeCounter.setText(String.valueOf(timeCount));
                simpleProgressBar.setProgress(timeCount);
                timeCount++;
                // if (timeCount==32){
                // timeCounter.setText("সময় শেষ");
                // }
            }

            @Override
            public void onFinish() {
                Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                //scoreIntent.putExtra("gameScore",point);
                if (point == 0) {
                    startActivity(scoreIntent);
                    finish();
                } else {
                    goToScoreActivity();
                }
            }
        };


        //Timer for animation
        animateTimer = new CountDownTimer(14000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                animateCount++;
                //Animation for button
                buttonAnimation();
            }

            @Override
            public void onFinish() {
                animateTimer.cancel();
                animateCount = 0;


            }
        };

        //************Ads

        //App ID: ca-app-pub-5358264522471884~9573801335
        // Sample AdMob app ID
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();


         /*
        ** in this method category selection and language condtion will be checked
        **/
        categorySelectionCondition();

        /*
        ** in this method bangla or english language property will work
        **/
        banglaOrEnglish();

        updateQuestion();
        // show current total score for the user
        updateScore();


         /*
        ** Here All The Condition will be checked for all 4 (A, B, C, D) buttons
        **/
        buttonConditionCheck();


        /*
        ** After Select a Button Final Result will be checked here.
        **/
        displayCorrectAnswer();


        /*
        ** Help line using method
        **/
        helplineUse();

           /*
        ** Restart Game
        **/
        relodeGame();

                 /*
        ** Go to Main Menu From Game
        **/
        goToMainMenu();


         /*
        ** Game Score Condition
        **/



       /* if (LanguageActivity.banglaSelect==false){

        }else{

        }*/


    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(getString(R.string.reward_admob_app_id),
                new AdRequest.Builder().build());
    }
    private void categorySelectionCondition() {
        if (CategoryActivity.physicsSelected == true) {
            if (LanguageActivity.banglaSelect == false) {
                mQuestionLibrary.initPhysicsEnglishQuestions(getApplicationContext());
            } else {
                physicsBangla.initPhysicsBanglaQuestions(getApplicationContext());
            }
        } else if (CategoryActivity.chemistrySelected == true) {
            if (LanguageActivity.banglaSelect == false) {
                chemistryEnglish.initChemistryEnglishQuestions(getApplicationContext());
            } else {
                chemistryBangla.initChemistryBanglaQuestions(getApplicationContext());
            }
        } else if (CategoryActivity.mathselected == true) {
            if (LanguageActivity.banglaSelect == false) {
                mathEnglish.initMathEnglishQuestions(getApplicationContext());
            } else {
                mathBangla.initMathBanglaQuestions(getApplicationContext());
            }
        } else if (CategoryActivity.programingSelected == true) {
            if (LanguageActivity.banglaSelect == false) {
                programmingEnglish.initProgrammingEnglishQuestions(getApplicationContext());
            } else {
                programmingBangla.initProgrammingBanglaQuestions(getApplicationContext());
            }
        } else if (CategoryActivity.randomSelected == true) {
            if (LanguageActivity.banglaSelect == false) {
                randomEnglish.initRandomEnglishQuestions(getApplicationContext());
            } else {
                randomBangla.initRandomBanlishQuestions(getApplicationContext());
            }
        }
    }


    private void banglaOrEnglish() {
        if (LanguageActivity.banglaSelect == false) {
            levelTextView.setText("Level: ");
            newGame.setText("New");
            exitGame.setText("Exit");

            helpLineText.setText("HelpLine");
            quesCounter.setText("Q-No.1");
            pointCounter.setText("0 point");
            lockButton.setText("Lock it");

            levelCounter.setImageResource(R.drawable.levele1);
            helpLineOne.setImageResource(R.drawable.halfe1);

        } else {
            levelTextView.setText("লেভেলঃ ");
            newGame.setText("নতুন");
            exitGame.setText("বাহির");

            helpLineText.setText("হেল্পলাইন");
            quesCounter.setText("প্রশ্নঃ ১");
            pointCounter.setText("০ পয়েন্ট");
            lockButton.setText("লক করুন");
            levelCounter.setImageResource(R.drawable.levelb1);
            helpLineOne.setImageResource(R.drawable.halfb1);
        }

    }


    private void helplineUse() {


        helpLineOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (half_helpLine == false) {

                    if (firstHelpLine.toString().equals("A")) {
                        optionC.setText("");
                        optionB.setText("");

                    } else if (firstHelpLine.toString().equals("B")) {
                        optionA.setText("");
                        optionD.setText("");

                    } else if (firstHelpLine.toString().equals("C")) {
                        optionB.setText("");
                        optionD.setText("");

                    } else if (firstHelpLine.toString().equals("D")) {
                        optionC.setText("");
                        optionA.setText("");

                    }

                    if (LanguageActivity.sOn == true) {
                        if (!half_help.isPlaying()) {
                            half_help.start();
                        }
                        if (half_help.isPlaying()) {
                            half_help.seekTo(0);
                        }
                    }
                    half_helpLine = true;
                }

                helpLineOne.setImageDrawable(null);

                if (LanguageActivity.banglaSelect == false) {
                    helpLineOne.setImageResource(R.drawable.halfe2);
                } else {
                    helpLineOne.setImageResource(R.drawable.halfb2);
                }


            }
        });


        helpLineTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()) {
                    if (half_helpLine == true && percent_helpLine == true) {
                        if (hint_helpLine == false) {
                            if (mRewardedVideoAd.isLoaded()) {
                                mRewardedVideoAd.show();

                            } else if (!mRewardedVideoAd.isLoaded()) {

                                if (!LanguageActivity.banglaSelect) {
                                    Toast.makeText(getApplicationContext(), "No, ads is availabe at this moment", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "এই মুহূর্তে কোন অ্যাডস নেই", Toast.LENGTH_SHORT).show();
                                }

                            }

                            //secondhelpLineMethod(secondHelpLine);
                            if (LanguageActivity.sOn == true) {
                                if (!hint_help.isPlaying()) {
                                    hint_help.start();
                                }
                                if (hint_help.isPlaying()) {
                                    hint_help.seekTo(0);
                                }
                            }


                        }

                    } else {
                        if (LanguageActivity.banglaSelect == false) {
                            secondhelpLineMethod("Use the above two helpline first.");
                        } else {
                            secondhelpLineMethod("উপরের দুইটা হেল্পলাইন আগে ব্যাবহার করুন।");
                        }

                    }
                   /* helpLineTwo.setImageDrawable(null);

                    helpLineTwo.setImageResource(R.drawable.renew1);*/
                } else {

                    if (LanguageActivity.sOn == true) {
                        if (!netNotAvailable.isPlaying()) {
                            netNotAvailable.start();
                        }
                        if (netNotAvailable.isPlaying()) {
                            netNotAvailable.seekTo(0);
                        }
                    }


                    if (LanguageActivity.banglaSelect == false) {
                        Toast.makeText(getApplicationContext(), "ইন্টারনেট সংযোগ প্রয়োজন !!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Internet Connection Required !!!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


        helpLineThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percent_helpLine == false) {

                    rand = new Random();
                    l1 = rand.nextInt(90 - 85) + 85;
                    l2 = rand.nextInt(70 - 60) + 60;
                    l3 = rand.nextInt(45 - 30) + 30;
                    l4 = rand.nextInt(35 - 25) + 25;


                    if (firstHelpLine.toString().equals("A")) {
                        thirdHelpLineMethod(l1, l2, l4, l3);

                    } else if (firstHelpLine.toString().equals("B")) {
                        thirdHelpLineMethod(l2, l1, l3, l4);
                    } else if (firstHelpLine.toString().equals("C")) {
                        thirdHelpLineMethod(l4, l3, l1, l2);

                    } else if (firstHelpLine.toString().equals("D")) {
                        thirdHelpLineMethod(l3, l4, l2, l1);
                    }

                    if (LanguageActivity.sOn == true) {
                        if (!percent_help.isPlaying()) {
                            percent_help.start();
                        }
                        if (percent_help.isPlaying()) {
                            percent_help.seekTo(0);
                        }
                    }
                    percent_helpLine = true;
                }
                helpLineThree.setImageDrawable(null);
                helpLineThree.setImageResource(R.drawable.percent2);
            }
        });

    }

    private void secondhelpLineMethod(String Message) {
        AlertDialog.Builder secondHelpLine = new AlertDialog.Builder(this);
        secondHelpLine.setMessage(Message);
        secondHelpLine.setCancelable(true);
        secondHelpLine.setTitle("Hint");

        secondHelpLine.setIcon(R.drawable.secondhelpline);
        secondHelpLine.show();


    }

    private void thirdHelpLineMethod(int a, int b, int c, int d) {
        LayoutInflater inflater = getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.probability_rate, null);

        Button A = (Button) dialoglayout.findViewById(R.id.percent_a);
        Button B = (Button) dialoglayout.findViewById(R.id.percent_b);
        Button C = (Button) dialoglayout.findViewById(R.id.percent_c);
        Button D = (Button) dialoglayout.findViewById(R.id.percent_d);

        A.setText("" + a + "%");
        B.setText("" + b + "%");
        C.setText("" + c + "%");
        D.setText("" + d + "%");


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialoglayout);
        if (LanguageActivity.banglaSelect == false) {
            builder.setTitle("Probability rate: %");
        } else {
            builder.setTitle("সম্ভাব্যতার হারঃ %");
        }


        builder.setIcon(R.drawable.helplinethree);
        builder.show();

    }


    private void updateQuestion() {
        System.out.println("The numbers are: " + mQuestionLibrary.getLength());
        //Level count updater
        levelUpdater();

        callQuestionFromPhysics();
        callQuestionFromChemistry();
        callQuestionFromMath();
        callQuestionFromProgramming();
        callQuestionFromRandom();
        // check if we are not outside array bounds for questions

    }

    private void callQuestionFromPhysics() {
        if (CategoryActivity.physicsSelected == true) {
            if (LanguageActivity.banglaSelect == false) {

                if (questionNumber < mQuestionLibrary.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(mQuestionLibrary.getQuestion(questionNumber));
                    optionA.setText(mQuestionLibrary.getChoice(questionNumber, 0));
                    optionB.setText(mQuestionLibrary.getChoice(questionNumber, 1));
                    optionC.setText(mQuestionLibrary.getChoice(questionNumber, 2));
                    optionD.setText(mQuestionLibrary.getChoice(questionNumber, 3));
                    correctAnswer = mQuestionLibrary.getCorrectAnswer(questionNumber);

                    secondHelpLine = (mQuestionLibrary.getHintHelpLine(questionNumber));
                    firstHelpLine = (mQuestionLibrary.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Physics"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            } else {

                if (questionNumber < physicsBangla.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(physicsBangla.getQuestion(questionNumber));
                    optionA.setText(physicsBangla.getChoice(questionNumber, 0));
                    optionB.setText(physicsBangla.getChoice(questionNumber, 1));
                    optionC.setText(physicsBangla.getChoice(questionNumber, 2));
                    optionD.setText(physicsBangla.getChoice(questionNumber, 3));
                    correctAnswer = physicsBangla.getCorrectAnswer(questionNumber);

                    secondHelpLine = (physicsBangla.getHintHelpLine(questionNumber));
                    firstHelpLine = (physicsBangla.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "পদার্থ বিজ্ঞান"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            }
        }

    }

    private void callQuestionFromChemistry() {
        if (CategoryActivity.chemistrySelected == true) {
            if (LanguageActivity.banglaSelect == false) {

                if (questionNumber < chemistryEnglish.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(chemistryEnglish.getQuestion(questionNumber));
                    optionA.setText(chemistryEnglish.getChoice(questionNumber, 0));
                    optionB.setText(chemistryEnglish.getChoice(questionNumber, 1));
                    optionC.setText(chemistryEnglish.getChoice(questionNumber, 2));
                    optionD.setText(chemistryEnglish.getChoice(questionNumber, 3));
                    correctAnswer = chemistryEnglish.getCorrectAnswer(questionNumber);

                    secondHelpLine = (chemistryEnglish.getHintHelpLine(questionNumber));
                    firstHelpLine = (chemistryEnglish.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Chemistry"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            } else {

                if (questionNumber < chemistryBangla.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(chemistryBangla.getQuestion(questionNumber));
                    optionA.setText(chemistryBangla.getChoice(questionNumber, 0));
                    optionB.setText(chemistryBangla.getChoice(questionNumber, 1));
                    optionC.setText(chemistryBangla.getChoice(questionNumber, 2));
                    optionD.setText(chemistryBangla.getChoice(questionNumber, 3));
                    correctAnswer = chemistryBangla.getCorrectAnswer(questionNumber);

                    secondHelpLine = (chemistryBangla.getHintHelpLine(questionNumber));
                    firstHelpLine = (chemistryBangla.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "রসায়ন বিজ্ঞান"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            }
        }

    }

    private void callQuestionFromMath() {
        if (CategoryActivity.mathselected == true) {
            if (LanguageActivity.banglaSelect == false) {

                if (questionNumber < mathEnglish.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(mathEnglish.getQuestion(questionNumber));
                    optionA.setText(mathEnglish.getChoice(questionNumber, 0));
                    optionB.setText(mathEnglish.getChoice(questionNumber, 1));
                    optionC.setText(mathEnglish.getChoice(questionNumber, 2));
                    optionD.setText(mathEnglish.getChoice(questionNumber, 3));
                    correctAnswer = mathEnglish.getCorrectAnswer(questionNumber);

                    secondHelpLine = (mathEnglish.getHintHelpLine(questionNumber));
                    firstHelpLine = (mathEnglish.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }

                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Math"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            } else {

                if (questionNumber < mathBangla.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(mathBangla.getQuestion(questionNumber));
                    optionA.setText(mathBangla.getChoice(questionNumber, 0));
                    optionB.setText(mathBangla.getChoice(questionNumber, 1));
                    optionC.setText(mathBangla.getChoice(questionNumber, 2));
                    optionD.setText(mathBangla.getChoice(questionNumber, 3));
                    correctAnswer = mathBangla.getCorrectAnswer(questionNumber);

                    secondHelpLine = (mathBangla.getHintHelpLine(questionNumber));
                    firstHelpLine = (mathBangla.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "গনিত"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            }
        }

    }

    private void callQuestionFromProgramming() {
        if (CategoryActivity.programingSelected == true) {
            if (LanguageActivity.banglaSelect == false) {

                if (questionNumber < programmingEnglish.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(programmingEnglish.getQuestion(questionNumber));
                    optionA.setText(programmingEnglish.getChoice(questionNumber, 0));
                    optionB.setText(programmingEnglish.getChoice(questionNumber, 1));
                    optionC.setText(programmingEnglish.getChoice(questionNumber, 2));
                    optionD.setText(programmingEnglish.getChoice(questionNumber, 3));
                    correctAnswer = programmingEnglish.getCorrectAnswer(questionNumber);

                    secondHelpLine = (programmingEnglish.getHintHelpLine(questionNumber));
                    firstHelpLine = (programmingEnglish.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Programming"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            } else {

                if (questionNumber < programmingBangla.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(programmingBangla.getQuestion(questionNumber));
                    optionA.setText(programmingBangla.getChoice(questionNumber, 0));
                    optionB.setText(programmingBangla.getChoice(questionNumber, 1));
                    optionC.setText(programmingBangla.getChoice(questionNumber, 2));
                    optionD.setText(programmingBangla.getChoice(questionNumber, 3));
                    correctAnswer = programmingBangla.getCorrectAnswer(questionNumber);

                    secondHelpLine = (programmingBangla.getHintHelpLine(questionNumber));
                    firstHelpLine = (programmingBangla.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "প্রোগ্রামিং"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            }
        }

    }

    private void callQuestionFromRandom() {
        if (CategoryActivity.randomSelected == true) {
            if (LanguageActivity.banglaSelect == false) {

                if (questionNumber < randomEnglish.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(randomEnglish.getQuestion(questionNumber));
                    optionA.setText(randomEnglish.getChoice(questionNumber, 0));
                    optionB.setText(randomEnglish.getChoice(questionNumber, 1));
                    optionC.setText(randomEnglish.getChoice(questionNumber, 2));
                    optionD.setText(randomEnglish.getChoice(questionNumber, 3));
                    correctAnswer = randomEnglish.getCorrectAnswer(questionNumber);

                    secondHelpLine = (randomEnglish.getHintHelpLine(questionNumber));
                    firstHelpLine = (randomEnglish.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Random"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            } else {

                if (questionNumber < randomBangla.getLength()) {
                    // set the text for new question,
                    // and new 4 alternative to answer on four buttons
                    quesShow.setText(randomBangla.getQuestion(questionNumber));
                    optionA.setText(randomBangla.getChoice(questionNumber, 0));
                    optionB.setText(randomBangla.getChoice(questionNumber, 1));
                    optionC.setText(randomBangla.getChoice(questionNumber, 2));
                    optionD.setText(randomBangla.getChoice(questionNumber, 3));
                    correctAnswer = randomBangla.getCorrectAnswer(questionNumber);

                    secondHelpLine = (randomBangla.getHintHelpLine(questionNumber));
                    firstHelpLine = (randomBangla.getHalfHelpLine(questionNumber));


                    questionNumber++;

                    gameTimer.cancel();
                    timeCount = 0;

                    gameTimer.start();

                }
                if (questionNumber == 16) {
                    Toast.makeText(QuizActivity.this, "!!!", Toast.LENGTH_SHORT).show();
                    Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);
                    Intent gameWinIntent = new Intent(QuizActivity.this, GameWinActivity.class);
                    //scoreIntent.putExtra("gameScore",point);
                    if (point == 0) {
                        startActivity(scoreIntent);
                        finish();
                    } else {
                        myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "এলোমেলো"));
                        startActivity(gameWinIntent);
                        finish();
                    }
                }
            }
        }

    }


    private void levelUpdater() {

        if (LanguageActivity.banglaSelect == false) {
            quesCounter.setText("Q-No: " + (number + 1));
        } else {
            quesCounter.setText("প্রশ্নঃ " + (number + 1));
        }

        number++;

        if (questionNumber == 6) {

            if (LanguageActivity.sOn == true) {
                if (!levelUP.isPlaying()) {
                    levelUP.start();
                }
                if (levelUP.isPlaying()) {
                    levelUP.seekTo(0);
                }
            }

            levelCounter.setImageDrawable(null);
            if (LanguageActivity.banglaSelect == false) {
                levelCounter.setImageResource(R.drawable.levele2);
            } else {
                levelCounter.setImageResource(R.drawable.levelb2);
            }


        } else if (questionNumber == 11) {

            if (!levelUP.isPlaying()) {
                levelUP.start();
            }
            if (levelUP.isPlaying()) {
                levelUP.seekTo(0);
            }

            levelCounter.setImageDrawable(null);
            if (LanguageActivity.banglaSelect == false) {
                levelCounter.setImageResource(R.drawable.levele3);
            } else {
                levelCounter.setImageResource(R.drawable.levelb3);
            }


        }

    }

    // show current total score for the user
    private void updateScore() {

        if (LanguageActivity.banglaSelect == false) {
            pointCounter.setText("" + point + " point");
        } else {
            pointCounter.setText("" + point + " পয়েন্ট ");
        }


        animateTimer.cancel();
        animateCount = 0;
        lockButton.setBackgroundResource(R.drawable.buttons_style_confirm);

        buttonA = false;
        buttonB = false;
        buttonC = false;
        buttonD = false;


        optionA.setClickable(true);
        optionB.setClickable(true);
        optionD.setClickable(true);
        optionD.setClickable(true);
    }


    private void buttonConditionCheck() {

        //Condition Checked For Button A
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sound for option A
                if (LanguageActivity.sOn == true) {
                    if (!answerLock.isPlaying()) {
                        answerLock.start();
                    }
                    if (answerLock.isPlaying()) {
                        answerLock.seekTo(0);
                    }
                }


                buttonA = true;
                buttonB = false;
                buttonC = false;
                buttonD = false;

                 /*
        ** Option A Button color will be set here to Orange
        **/
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners);
            }
        });

        //Condition Checked For Button B
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound for option B
                if (LanguageActivity.sOn == true) {
                    if (!answerLock.isPlaying()) {
                        answerLock.start();
                    }
                    if (answerLock.isPlaying()) {
                        answerLock.seekTo(0);
                    }
                }

                buttonA = false;
                buttonB = true;
                buttonC = false;
                buttonD = false;

                 /*
        ** Option B Button color will be set here to Orange
        **/
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners);
            }
        });

        //Condition Checked For Button C
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound for option A
                if (LanguageActivity.sOn == true) {
                    if (!answerLock.isPlaying()) {
                        answerLock.start();
                    }
                    if (answerLock.isPlaying()) {
                        answerLock.seekTo(0);
                    }
                }

                buttonA = false;
                buttonB = false;
                buttonC = true;
                buttonD = false;

                 /*
        ** Option C Button color will be set here to Orange
        **/
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners);
            }
        });

        //Condition Checked For Button D
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound for option A
                if (LanguageActivity.sOn == true) {
                    if (!answerLock.isPlaying()) {
                        answerLock.start();
                    }
                    if (answerLock.isPlaying()) {
                        answerLock.seekTo(0);
                    }
                }

                buttonA = false;
                buttonB = false;
                buttonC = false;
                buttonD = true;

                /*
        ** Option D Button color will be set here to Orange
        **/
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners);
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners);
            }
        });

    }

    private void displayCorrectAnswer() {

        lockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonA != true && buttonB != true && buttonC != true && buttonD != true) {
                    if (LanguageActivity.banglaSelect == false) {
                        infoMessage("Message", "Select an Answer First!!! ");
                    } else {
                        infoMessage("মেসেজ", "যেকোনো একটা উত্তরে ক্লিক করুন ");
                    }


                } else {

                    lockButton.setBackgroundResource(R.drawable.button_bg_round_corners_correct);

                    optionA.setClickable(false);
                    optionB.setClickable(false);
                    optionD.setClickable(false);
                    optionD.setClickable(false);

                    animateTimer.start();
                }
            }
        });
    }


    private void infoMessage(String Title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Message);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setIcon(R.drawable.info);
        builder.show();
    }

    private void buttonAnimation() {
        Intent scoreIntent = new Intent(QuizActivity.this, ScoreActivity.class);


        if (buttonA == true && optionA.getText().toString().equals(correctAnswer)) {
            if (animateCount == 2) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
                point += 10;
                if (LanguageActivity.sOn == true) {
                    if (!correct.isPlaying()) {
                        correct.start();
                    }
                    if (correct.isPlaying()) {
                        correct.seekTo(0);
                    }
                }

            } else if (animateCount == 3) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 5) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 7) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 9) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_correct);

                updateScore();
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners);
                updateQuestion();
            }
        } else if (buttonA == true && !optionA.getText().toString().equals(correctAnswer)) {
                       /*
        ** Otherwise Option A Button Color will be set to Red
        **/

            if (animateCount == 2) {
                if (LanguageActivity.sOn == true) {
                    if (!wrong.isPlaying()) {
                        wrong.start();
                    }
                    if (wrong.isPlaying()) {
                        wrong.seekTo(0);
                    }
                }

                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 3) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 5) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 7) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 9) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionA.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);


                if (LanguageActivity.banglaSelect == false) {
                    helpMessage("Correct Answer: "+correctAnswer,scoreIntent);
                } else {
                    helpMessage("সঠিক উত্তরঃ "+correctAnswer,scoreIntent);
                }
                updateScore();
                // scoreIntent.putExtra("userName",name);
                //scoreIntent.putExtra("gameScore",point);
            }
        }
        if (buttonB == true && optionB.getText().toString().equals(correctAnswer)) {
                       /*
        ** If Option B is correct then its Button color will be set to Green
        **/
            if (animateCount == 2) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
                point += 10;
                if (LanguageActivity.sOn == true) {
                    if (!correct.isPlaying()) {
                        correct.start();
                    }
                    if (correct.isPlaying()) {
                        correct.seekTo(0);
                    }
                }
            } else if (animateCount == 3) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 5) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 7) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 9) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_correct);

                updateScore();
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners);
                updateQuestion();
            }
        } else if (buttonB == true && !optionB.getText().toString().equals(correctAnswer)) {

                    /*
        ** Otherwise Option B Button Color will be set to Red
        **/

            if (animateCount == 2) {

                if (LanguageActivity.sOn == true) {
                    if (!wrong.isPlaying()) {
                        wrong.start();
                    }
                    if (wrong.isPlaying()) {
                        wrong.seekTo(0);
                    }
                }
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 3) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 5) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 7) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 9) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionB.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
                if (LanguageActivity.banglaSelect == false) {
                    helpMessage("Correct Answer: "+correctAnswer,scoreIntent);
                } else {
                    helpMessage("সঠিক উত্তরঃ "+correctAnswer,scoreIntent);
                }
                updateScore();
                //scoreIntent.putExtra("gameScore",point);

            }
        }

        if (buttonC == true && optionC.getText().toString().equals(correctAnswer)) {

                      /*
        ** If Option C is correct then its Button color will be set to Green
        **/
            if (animateCount == 2) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
                point += 10;
                if (LanguageActivity.sOn == true) {
                    if (!correct.isPlaying()) {
                        correct.start();
                    }
                    if (correct.isPlaying()) {
                        correct.seekTo(0);
                    }
                }
            } else if (animateCount == 3) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 5) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 7) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 9) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_correct);

                updateScore();
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners);
                updateQuestion();
            }
        } else if (buttonC == true && !optionC.getText().toString().equals(correctAnswer)) {

                    /*
        ** Otherwise Option C Button Color will be set to Red
        **/

            if (animateCount == 2) {
                if (LanguageActivity.sOn == true) {
                    if (!wrong.isPlaying()) {
                        wrong.start();
                    }
                    if (wrong.isPlaying()) {
                        wrong.seekTo(0);
                    }
                }
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 3) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 5) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 7) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 9) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionC.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
                if (LanguageActivity.banglaSelect == false) {
                    helpMessage("Correct Answer: "+correctAnswer,scoreIntent);
                } else {
                    helpMessage("সঠিক উত্তরঃ "+correctAnswer,scoreIntent);
                }
                updateScore();
                // scoreIntent.putExtra("userName",name);
            }
        }


        //D start
        if (buttonD == true && optionD.getText().toString().equals(correctAnswer)) {
            if (animateCount == 2) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
                point += 10;
                if (LanguageActivity.sOn == true) {
                    if (!correct.isPlaying()) {
                        correct.start();
                    }
                    if (correct.isPlaying()) {
                        correct.seekTo(0);
                    }
                }

            } else if (animateCount == 3) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 5) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 7) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_correct);
            } else if (animateCount == 9) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_correct);

                updateScore();
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners);
                updateQuestion();
            }
        } else if (buttonD == true && !optionD.getText().toString().equals(correctAnswer)) {
                       /*
        ** Otherwise Option A Button Color will be set to Red
        **/

            if (animateCount == 2) {
                if (LanguageActivity.sOn == true) {
                    if (!wrong.isPlaying()) {
                        wrong.start();
                    }
                    if (wrong.isPlaying()) {
                        wrong.seekTo(0);
                    }
                }
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 3) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 4) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 5) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 6) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 7) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount == 8) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
            } else if (animateCount == 9) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_select);
            } else if (animateCount >= 10 && animateCount < 12) {
                optionD.setBackgroundResource(R.drawable.button_bg_round_corners_wrong);
                if (LanguageActivity.banglaSelect == false) {
                    helpMessage("Correct Answer: "+correctAnswer,scoreIntent);
                } else {
                    helpMessage("সঠিক উত্তরঃ "+correctAnswer,scoreIntent);
                }
                updateScore();
                // scoreIntent.putExtra("userName",name);
                //scoreIntent.putExtra("gameScore",point);
            }
        }
    }

    private void goToScoreActivity() {
        Intent scoreIntent = new Intent(this, ScoreActivity.class);

        if (CategoryActivity.physicsSelected == true) {
            if (LanguageActivity.banglaSelect == false) {

                myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Physics"));
                startActivity(scoreIntent);
                finish();
            } else {
                myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "পদার্থ বিজ্ঞান"));
                startActivity(scoreIntent);
                finish();
            }

        } else if (CategoryActivity.chemistrySelected == true) {
            if (LanguageActivity.banglaSelect == false) {
                myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Chemistry"));
                startActivity(scoreIntent);
                finish();
            } else {
                myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "রসায়ন বিজ্ঞান"));
                startActivity(scoreIntent);
                finish();
            }

        } else if (CategoryActivity.mathselected == true) {
            if (LanguageActivity.banglaSelect == false) {
                myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Math"));
                startActivity(scoreIntent);
                finish();
            } else {
                myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "গনিত"));
                startActivity(scoreIntent);
                finish();
            }

        } else if (CategoryActivity.programingSelected == true) {
            if (LanguageActivity.banglaSelect == false) {
                myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Programming"));
                startActivity(scoreIntent);
                finish();
            } else {
                myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "প্রোগ্রামিং"));
                startActivity(scoreIntent);
                finish();
            }

        } else if (CategoryActivity.randomSelected == true) {
            if (LanguageActivity.banglaSelect == false) {
                myDatabaseHelper2.insertEngData(new Scores(UserNameActivity.name, point, "Random"));
                startActivity(scoreIntent);
                finish();
            } else {
                myDatabaseHelper2.insertBanData(new Scores(UserNameActivity.name, point, "এলোমেলো"));
                startActivity(scoreIntent);
                finish();
            }

        }

    }


    private void relodeGame() {
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

    }


    private void goToMainMenu() {
        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LanguageActivity.banglaSelect == false) {
                    QuitGame("Exit", "Do you want to exit ?", "Yes", "No");
                } else {
                    QuitGame("বাহির", "আপনি কি বের হতে চান ?", "হ্যাঁ", "না");
                }


            }
        });
    }

    private void QuitGame(String Title, String Message, String yes, String no) {

        new AlertDialog.Builder(this, R.style.AlertDialogCustom)
                .setIcon(R.drawable.a)
                .setTitle(Title)
                .setMessage(Message)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent exitGame = new Intent(QuizActivity.this, MenuActivity.class);
                        startActivity(exitGame);
                        dialog.dismiss();
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

    }

    protected void onStart() {
        super.onStart();
        Log.d("QuizActivity", "onStart invoked");
    }

    @Override
    protected void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
        Log.d("QuizActivity", "onResume invoked");
    }

    @Override
    protected void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
        Log.d("QuizActivity", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();

        /*
        **timer will be stoped
        */
        gameTimer.cancel();
        timeCount = 0;
        /*
        **sound will be stoped
        */
        if (answerLock.isPlaying()) {
            answerLock.seekTo(0);
        }

        Log.d("QuizActivity", "onStop invoked");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("QuizActivity", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
        Log.d("QuizActivity", "onDestroy invoked");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onBackPressed() {
        //your code when back button pressed
    }


    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {
        gameTimer.cancel();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        gameTimer.start();
        hint_helpLine = true;
        helpLineTwo.setImageDrawable(null);
        helpLineTwo.setImageResource(R.drawable.renew1);
        loadRewardedVideoAd();

    }

    //needed
    @Override
    public void onRewarded(RewardItem rewardItem) {
        half_helpLine = false;
        percent_helpLine = false;

        helpLineOne.setImageDrawable(null);
        helpLineThree.setImageDrawable(null);
        helpLineThree.setImageResource(R.drawable.percent1);

        if (LanguageActivity.banglaSelect == false) {
            helpLineOne.setImageResource(R.drawable.halfe1);

        } else {
            helpLineOne.setImageResource(R.drawable.halfb1);
        }
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        hint_helpLine = true;
    }

    //

  /*  if (LanguageActivity.banglaSelect == false) {
        customToat("", android.R.drawable.ic_dialog_info);
    } else {
        customToat("", android.R.drawable.ic_dialog_info);
    }*/
    /*private void customToat(String msg){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));

        TextView toastTextView = (TextView) layout.findViewById(R.id.custom_toast_message);
        ImageView toastImageView = (ImageView) layout.findViewById(R.id.custom_toast_image);

            toastTextView.setText(msg);
        toastImageView.setImageResource(android.R.drawable.ic_dialog_info);
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }*/
  public void helpMessage(String text1, final Intent scoreIntent){
      gameTimer.cancel();
      timeCount = 0;
      LayoutInflater inflater = getLayoutInflater();
      View view1 = inflater.inflate(R.layout.help_layout,null);
      Button closeBtwn=(Button)view1.findViewById(R.id.closeEnter);
      TextView hText=(TextView)view1.findViewById(R.id.helpText);

      final AlertDialog.Builder builder=new AlertDialog.Builder(this);
      builder.setIcon(android.R.drawable.ic_dialog_info);
      builder.setView(view1);
      builder.setCancelable(false);

      final AlertDialog alert = builder.create();
      alert.show();
      alert.getWindow().setGravity(Gravity.CENTER);
      alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

      hText.setMovementMethod(new ScrollingMovementMethod());
      hText.setText(""+text1);
      if (LanguageActivity.banglaSelect == false) {
          closeBtwn.setText("Ok");
      } else {
          closeBtwn.setText("ঠিক আছে");
      }

      closeBtwn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              alert.dismiss();
              if (point == 0) {
                  startActivity(scoreIntent);
                  finish();
              } else {
                  goToScoreActivity();
              }
          }
      });

  }

}
