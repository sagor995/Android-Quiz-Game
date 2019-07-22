package com.sa.agd.databasehelper;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class PhysicsEnglish {

    // declare list of Question objects
    List <Question> list = new ArrayList<>();
    MyDataBaseHelper cheEngDataBaseHelper;


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



    public void initPhysicsEnglishQuestions(Context context) {



        cheEngDataBaseHelper = new MyDataBaseHelper(context);
        list = cheEngDataBaseHelper.getAllPhyEngQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Nuclear sizes are expressed in a unit named",
                    new String[]{"Fermi","angstrom","newton","tesla"}, "Fermi","A","এটা হয়ত OptionA"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Light year is a unit of ",
                    new String[]{ "time","distance","light","intensity of light"}, "distance","B","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Light from the Sun reaches us in nearly",
                    new String[]{"2 minutes","4 minutes","8 minutes","16 minutes"}, "8 minutes","C","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Pa(Pascal) is the unit for",
                    new String[]{"thrust","pressure","frequency","conductivity"}, "pressure","B","এটা হয়ত OptionA"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Metals are good conductors of electricity because of",
                    new String[]{"free electrons","atoms are lightly packed","high melting point","All of the above"}, "free electrons","A","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Rectifiers are used to convert",
                    new String[]{"DC to AC","AC to DC","high volt to low volt","low volt to high volt"}, "AC to DC","B","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Sound waves in air are",
                    new String[]{"transverse","longitudinal","electromagnetic","polarised"}, "longitudinal","B","এটা হয়ত OptionA"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Magnetism at the centre of a bar magnet is",
                    new String[]{"minimum","maximum","zero","minimum or maximum"}, "zero","C","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Of the following properties of a wave, the one that is independent of the other is its",
                    new String[]{"amplitude","velocity","wavelength","frequency"}, "amplitude","A","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Sound of frequency below 20 Hz is called",
                    new String[]{"audio sounds","infrasonic","ultrasonic","supersonics"}, "infrasonic","B","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Moment of inertia is",
                    new String[]{"vector","scalar","phasor","tensor"}, "tensor","D","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("One thousand microns is equal to",
                    new String[]{"10^-3m","10^-6m","10^-9m","10^-12m"}, "10^-3m","A","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Sound travels at the fastest speed in",
                    new String[]{"steel","water","air","vacuum"}, "steel","A","এটা হয়ত OptionA"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Light travels at the fastest speed in",
                    new String[]{"glass","water","hydrogen","vacuum"}, "vacuum","D","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Light Emitting Diodes (LED) is used in fancy electronic devices such as toys emit",
                    new String[]{"X-rays","ultraviolet light","visible light","radio waves"}, "visible light","C","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Optical fibre works on the",
                    new String[]{"principle of refraction","total internal reflection","scattering","interference"}, "total internal reflection","B","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Supersonic plane fly with the speed",
                    new String[]{"< speed of sound","of sound","> the speed of sound","of light"}, "> the speed of sound","C","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("One watt-hour is equivalent to",
                    new String[]{"6.3 x 10^3 J","6.3 x 10^-7 J","3.6 x 10^3 J","3.6 x 10^-3 J"}, "3.6 x 10^3 J","C","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Radiocarbon dating technique is used to estimate the age of",
                    new String[]{"rocks","monuments","soil","fossils"}, "fossils","D","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Identify the vector quantity from the following",
                    new String[]{"Heat","Angular momentum","Time","Work"}, "Angular momentum","B","এটা হয়ত OptionC"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("One nanometer is equal to",
                    new String[]{"10^-6m","10^-8m","10^-9m","10^-5m"}, "10^-9m","C","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Minimum number of unequal vectors which can give zero resultant are",
                    new String[]{"two","three","four","more than four"}, "three","B","এটা হয়ত OptionB"));
            cheEngDataBaseHelper.addInitialPhyEngQuestion(new Question("Intensity of sound has",
                    new String[]{"an object existence","subject existence","no existence","both a and b"}, "an object existence","A","এটা হয়ত OptionC"));

            list = cheEngDataBaseHelper.getAllPhyEngQuestionsList();//get list from database again

        }
    }




}