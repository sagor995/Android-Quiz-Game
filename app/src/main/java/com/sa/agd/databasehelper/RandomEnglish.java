package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/17/2017.
 */

public class RandomEnglish {


    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper randEngDataBaseHelper;


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



    public void initRandomEnglishQuestions(Context context) {



        randEngDataBaseHelper = new MyDataBaseHelper(context);
        list = randEngDataBaseHelper.getAllRandEngQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("The format identifier ‘%i’ is also used for _____ data type?",
                    new String[]{"char","int","float","double"}, "int","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("What is the size of an int data type?",
                    new String[]{"4 Bytes","8 Bytes","Depends on the system/compiler","Cannot be determined"}, "Depends on the system/compiler","C",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Which is valid C expression?",
                    new String[]{"int my_num = 100,000;","int my_num = 100000;","int my num = 1000;","int $my_num = 10000;"}, "int my_num = 100000;","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Which is more effective while calling the functions?",
                    new String[]{"call by value","call by reference","call by pointer","none of the mentioned"}, "call by reference","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("",
                    new String[]{"interface","Interface","intf","Intf"}, "interface","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("What is the range of data type byte in Java?",
                    new String[]{"-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned"}, "-128 to 127","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Light year is a unit of ",
                    new String[]{ "time","distance","light","intensity of light"}, "distance","B","এটা হয়ত OptionC"));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question(" Metals are good conductors of electricity because of",
                    new String[]{"free electrons","atoms are lightly packed","high melting point","All of the above"}, "free electrons","A","এটা হয়ত OptionB"));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Sound travels at the fastest speed in",
                    new String[]{"steel","water","air","vacuum"}, "steel","A","এটা হয়ত OptionA"));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("One watt-hour is equivalent to",
                    new String[]{"6.3 x 10^3 J","6.3 x 10^-7 J","3.6 x 10^3 J","3.6 x 10^-3 J"}, "3.6 x 10^3 J","C","এটা হয়ত OptionB"));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("One nanometer is equal to",
                    new String[]{"10^-6m","10^-8m","10^-9m","10^-5m"}, "10^-9m","C","এটা হয়ত OptionB"));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("The set of positive integers is _________",
                    new String[]{"Infinite","Finite","Subset","Empty"}, "Infinite","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("$4570 is spend in the floor repair of 45 × 15 ft hall. What is repair cost per square feet?",
                    new String[]{"$5.27","$6.77","$8.48","$7.10"}, "$6.77","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("The cube root of 2744 is",
                    new String[]{ "11","13","14","17"}, "14","C",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("What is the symbol of Omega?",
                    new String[]{"€","π","Ω","∞"}, "Ω","C",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("If volume of cylinder is 700cm^2 with height of 15cm then diameter of cylinder is",
                    new String[]{"24cm^2","7.71cm^2","9.57cm^2","12.23cm^2"}, "7.71cm^2","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("The most abundant rare gas in the atmosphere is .......",
                    new String[]{"Helium","Xenon", "Neon","Argon"}, "Argon","D",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("The first metal used by man was",
                    new String[]{"Iron","Copper","Gold","Bronze"}, "Copper","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question(" \"OS\" computer abbreviation usually means ?",
                    new String[]{"Order of Significance","Open Software","Operating System","Optical Sensor"}, "Operating System","C",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\".MOV\" extension refers usually to what kind of file?",
                    new String[]{"Image file","Animation/movie file","Audio file","MS Office document"}, "","",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question(" \".TMP\" extension refers usually to what kind of file?",
                    new String[]{"Compressed Archive file","Image file","Temporary file","Audio file"}, "Temporary file","C",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question(" Which of the following is used in pencils?",
                    new String[]{"Graphite","Silicon","Charcoal","Phosphorous"}, "Graphite","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("The main buffer system of the human blood is.....",
                    new String[]{"H2CO3 - HCO3","H2CO3 - CO32-","CH3COOH - CH3COO-","NH2CONH2 - NH2CONH+"}, "H2CO3 - HCO3","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("The most important ore of aluminium is",
                    new String[]{"Bauxite","Magnetite","Haematite","Monazite"}, "Bauxite","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\".JPG\" extension refers usually to what kind of file?",
                    new String[]{"System file","Animation/movie file","MS Encarta document","Image file"}, "Image file","D",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\".TXT\" extension refers usually to what kind of file?",
                    new String[]{"Text File","Image file","Audio file","Adobe Acrobat file"}, "Text File","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\"FET\" is a type of transistor, Its full name is ________ Effect Transistor...?",
                    new String[]{"Field","Factor","Flash","Force"}, "Field","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Compact discs, according to the original CD specifications hold how many minutes of music?",
                    new String[]{"74 minutes","56 minutes","60 minutes","90 minutes"}, "","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\"CD\" computer abbreviation usually means ?",
                    new String[]{"Command Description","Change Data","Copy Density","Compact Disc"}, "Compact Disc","D",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\".BAK\" extension refers usually to what kind of file?",
                    new String[]{"Backup file","Audio file","Animation/movie file","MS Encarta document"}, "Backup file","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\".BAT\" extension refers usually to what kind of file?",
                    new String[]{"Compressed Archive file","System file","Audio file","Backup file"}, "System file","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("\"DB\" computer abbreviation usually means ?",
                    new String[]{"Database","Double Byte","Data Block","Driver Boot"}, "Database","A",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("What Galileo invented?",
                    new String[]{"Barometer","Pendulum clock","Microscope","Thermometer"}, "Thermometer","D",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("What invention caused many deaths while testing it?",
                    new String[]{"Dynamite","Ladders","Race cars","Parachute"}, "Parachute","D",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Who invented Gramophone?",
                    new String[]{"Michael Faraday","Fahrenheit","Sir Alexander Graham Bell","Thomas Alva Edison"}, "Thomas Alva Edison","D",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Where was the yo-yo invented?",
                    new String[]{"France","United States","Philippines","England"}, "Philippines","C",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Who invented Electric Generator?",
                    new String[]{"Sir Alexander Graham Bell","Michael Faraday","Alfred B. Nobel","Thomas Alva Edison"}, "Michael Faraday","B",""));
            randEngDataBaseHelper.addInitialRandEngQuestion(new Question("Who invented Dynamite?",
                    new String[]{"Sir Alexander Graham Bell","Benjamin Franklin","Thomas Alva Edison","Alfred B. Nobel"}, "Alfred B. Nobel","D",""));




            list = randEngDataBaseHelper.getAllRandEngQuestionsList();//get list from database again

        }
    }
}
