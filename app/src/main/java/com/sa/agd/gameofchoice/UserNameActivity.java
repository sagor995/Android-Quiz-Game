package com.sa.agd.gameofchoice;

/**
 * Created by Sagor Ahamed on 6/19/2017.
 */

import android.widget.Button;
import android.widget.TextView;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
import android.widget.Toast;

public class UserNameActivity extends AppCompatActivity {
    TextView enterNameTxt;
    Button confirmNameBtwn;
    public static String name;
    //Typeface custom_font;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

     //  custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SutonnyMJ-Bold.ttf");

        enterNameTxt = (TextView)findViewById(R.id.EnterNameText);
       // enterNameTxt.setTypeface(custom_font);

        confirmNameBtwn = (Button) findViewById(R.id.ConfirmNameButton);
       // confirmNameBtwn.setTypeface(custom_font);
        username = (EditText)findViewById(R.id.EnterName);



        if (LanguageActivity.banglaSelect==false){
            enterNameTxt.setText("Enter Your Name Here: ");
            confirmNameBtwn.setText("    Submit    ");

        }else{
            enterNameTxt.setText("এখানে আপনার নাম লিখুনঃ ");
            confirmNameBtwn.setText("    সাবমিট    ");

        }

        confirmNameBtwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                name=username.getText().toString().trim();
                if (name.length()>=6){
                    if(LanguageActivity.banglaSelect==false){
                        toastMessage("UserName must be Less Than 6 Characters.");
                    }else {
                        toastMessage("ইউজার নাম ৫ অক্ষরের বেশি হবে না");
                    }


                }else if (name.isEmpty() ){
                    if(LanguageActivity.banglaSelect==false){
                        toastMessage("Please, Enter UserName");
                    }else {
                        toastMessage("ইউজার নাম দিন");
                    }

                }else {

                    GoToMenuActivity();
                }
            }
        });

        
    }

    public void GoToMenuActivity(){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        //your code when back button pressed
    }
}
