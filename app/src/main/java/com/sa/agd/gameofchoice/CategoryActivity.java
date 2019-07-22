package com.sa.agd.gameofchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class CategoryActivity extends AppCompatActivity {
    Button physicsBtwn,chemistryBtwn,mathBtwn,inventionBtwn,programingBtwn,categorySelect,returnBtwn;

    public static boolean physicsSelected=false,
                        chemistrySelected=false,
                        mathselected=false,
                          randomSelected=false,
                         programingSelected=false;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        physicsBtwn=(Button)findViewById(R.id.category_one);
        chemistryBtwn=(Button)findViewById(R.id.category_two);
        mathBtwn=(Button)findViewById(R.id.category_three);
        inventionBtwn=(Button)findViewById(R.id.category_four);
        programingBtwn=(Button)findViewById(R.id.category_five);
        categorySelect=(Button)findViewById(R.id.category_select);
        returnBtwn=(Button)findViewById(R.id.menu_returns);

        if (LanguageActivity.banglaSelect==false){
            categorySelect.setText("Select a Topic");
            physicsBtwn.setText("    Physics    ");
            chemistryBtwn.setText(" Chemistry ");
            mathBtwn.setText("       Math       ");
            inventionBtwn.setText("  Randomly  ");
            programingBtwn.setText("Programing");
            returnBtwn.setText("  Back  ");
        }else{
             categorySelect.setText("  একটি বিষয় নির্বাচন করুন  ");
            physicsBtwn.setText(" পদার্থ বিজ্ঞান ");
            chemistryBtwn.setText("রসায়ন বিজ্ঞান");
            mathBtwn.setText("       গনিত       ");
            inventionBtwn.setText("    এলোমেলো   ");
            programingBtwn.setText("    প্রোগ্রামিং    ");
            returnBtwn.setText("  ফিরে যান  ");
        }


        categorySelectionMethod();
    }
    private void categorySelectionMethod(){
        physicsBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                physicsSelected=true;
                chemistrySelected=false;
                mathselected=false;
                randomSelected=false;
                programingSelected=false;

                goToQuizActivity();

            }
        });

        chemistryBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chemistrySelected=true;
                physicsSelected=false;
                mathselected=false;
                randomSelected=false;
                programingSelected=false;

                goToQuizActivity();
            }
        });

        mathBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathselected=true;
                physicsSelected=false;
                chemistrySelected=false;
                randomSelected=false;
                programingSelected=false;

                goToQuizActivity();
            }
        });

        inventionBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomSelected=true;
                physicsSelected=false;
                chemistrySelected=false;
                mathselected=false;
                programingSelected=false;

                goToQuizActivity();
            }
        });

        programingBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                programingSelected=true;
                physicsSelected=false;
                chemistrySelected=false;
                mathselected=false;
                randomSelected=false;

                goToQuizActivity();
            }
        });


        returnBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void goToQuizActivity(){
        Intent intent=new Intent(CategoryActivity.this,QuizActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        //your code when back button pressed
    }
}
