package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class MathEnglish {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper mathEngDataBaseHelper;


    public int getLength(){
        return list.size();
    }




    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }


    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num);
    }


    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }

    public String getHalfHelpLine(int a){return list.get(a).getHalfHelpLine();}
    public String getHintHelpLine(int a){return list.get(a).getHintHelpLine();}



    public void initMathEnglishQuestions(Context context) {



        mathEngDataBaseHelper = new MyDataBaseHelper(context);
        list = mathEngDataBaseHelper.getAllMathEngQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("The set of positive integers is _________",
                    new String[]{"Infinite","Finite","Subset","Empty"}, "Infinite","A",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("The value of x + x(x+x+x) when x = 2 is-",
                    new String[]{"10","18","14","64"}, "14","C",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("By solving equation 6a = 5 - 9a, value of a will be",
                    new String[]{"1/5","1/3","2/5","1/2"}, "1/3","B",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("By solving equation c^3-343 = 0, value of 'c' will be",
                    new String[]{"5","10","7","20"}, "7","C",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("If diameter of cylinder is 6cm and its height is 12cm then volume of cylinder is",
                    new String[]{"804.352cm^3","452.6cm^3","339.29cm^3","252.2cm^3"}, "339.29cm^3","A",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("If volume of cylinder is 700cm^2 with height of 15cm then diameter of cylinder is",
                    new String[]{"24cm^2","7.71cm^2","9.57cm^2","12.23cm^2"}, "7.71cm^2","B",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("If diameter of a cylinder is 5cm and volume of cylinder is 400cm3 then height of cylinder is",
                    new String[]{"40cm","25cm","33cm","20cm"}, "20cm","অ",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("If a handbag is priced at $150 and is sold at $90 then percentage discount is",
                    new String[]{"40%","30%","35%","25%"}, "40%","A",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("On subtracting following rational numbers 6⁄9, 8⁄12 and 7⁄15, answer will be",
                    new String[]{"24/45","21/45","22/45","23/45"}, "21/45","B",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("In decimals, cubic root of 6 is",
                    new String[]{"1.81","2.08","3.08","4.5"}, "1.81","A",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("Considering formula 1⁄w = 1⁄x + 1⁄y + 1⁄z, then if x = 10, y = 20, and z = 15, value of 1⁄w is",
                    new String[]{"13/50","13/60","50/13","60/13"}, "13/60","B",""));
            /*mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("Considering formula a = bc + cd + f + g/bcd, then if value of b = 2, c = 3, d = -3, f = 1, g =-2, value of 'a' will be",
                    new String[]{"4/9","2/9","2/7","1/4"}, "2/9","B",""));*/
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("What is the symbol of Omega?",
                    new String[]{"€","π","Ω","∞"}, "Ω","C",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("Simplify :180 ÷ (5 + 5 x 8) - 4",
                    new String[]{"2","5","0","6" }, "0","C",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("What is the largest two digits prime number?",
                    new String[]{ "96","97","98","99"}, "97","B",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("What is the average value of 18, 17, 19, 16 and 21?",
                    new String[]{ "20","21.5","18.2","19.4" }, "18.2","C",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("How many hours in 105 minutes?",
                    new String[]{ "1.5 hours","1.30 hours","1.75 hours","None of these"}, "1.75 hours","C",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("10-2 means ?",
                    new String[]{"milli","centi","micro","deci"}, "milli","A",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("The cube root of 2197 is",
                    new String[]{ "11","13","19","17"}, "13","B",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("The average of first 50 natural numbers is ",
                    new String[]{ "25.30","25.5","25.00","12.25"}, "25.5","B",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("The simplest form of 1.5 : 2.5 is ",
                    new String[]{ "6: 10","15: 25","0.75: 1.25","3:5"}, "3:5","D",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("$3540 is spend in the floor repair of 45 × 15 ft hall. What is repair cost per square feet?",
                    new String[]{"$5.24","$67.00","$32.48","$42.10"}, "$5.24","A",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("If 18 is 40% of a number, what is the number?",
                    new String[]{"41","48","45","43"}, "12","C",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("If ∆ means multiply the first number by second, then (3 ∆ 5) ∆ 3 = ?",
                    new String[]{"25","45","30","31"}, "45","B",""));
            mathEngDataBaseHelper.addInitialMathEngQuestion(new Question("The number which is neither prime nor composite is ",
                    new String[]{"0","1","3","2"}, "1","B",""));





            list = mathEngDataBaseHelper.getAllMathEngQuestionsList();//get list from database again

        }
    }
}
