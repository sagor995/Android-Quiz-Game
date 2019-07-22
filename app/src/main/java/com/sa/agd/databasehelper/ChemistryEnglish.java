package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class ChemistryEnglish {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
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



    public void initChemistryEnglishQuestions(Context context) {



        cheEngDataBaseHelper = new MyDataBaseHelper(context);
        list = cheEngDataBaseHelper.getAllCheEngQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The most electronegative element among the following is ...",
                    new String[]{"Sodium","Bromine","Fluorine","Oxygen"}, "Fluorine","C",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("Which of the following is used in pencils?",
                    new String[]{"Graphite","Silicon","Charcoal","Phosphorous"}, "Graphite","A",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("Which of the following is a non metal that remains liquid at room temperature?",
                    new String[]{"Phosphorous","Bromine","Chlorine","Helium"}, "Bromine","B",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("Which of the following metals forms an amalgam with other metals?",
                    new String[]{"Tin","Mercury","Lead","Zinc"}, "Mercury","B",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The main buffer system of the human blood is.....",
                    new String[]{"H2CO3 - HCO3","H2CO3 - CO32-","CH3COOH - CH3COO-","NH2CONH2 - NH2CONH+"}, "H2CO3 - HCO3","A",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The most commonly used bleaching agent is",
                    new String[]{"Alcohol","Carbon dioxide","Chlorine","Sodium chlorine"}, "Chlorine","C",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The nucleus of a hydrogen atom consists of",
                    new String[]{"1 proton only","1 proton + 2 neutron","1 neutron only","1 electron only"}, "1 proton only","A",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The most abundant rare gas in the atmosphere is .......",
                    new String[]{"Helium","Xenon", "Neon","Argon"}, "Argon","D",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("What are the number of moles of CO2 which contains 16 g of oxygen?",
                    new String[]{"0.5 mole","0.2 mole","0.4 mole","0.25 mole"}, "0.5 mole","A",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The monomer of polythene is",
                    new String[]{"Vinyl chloride","Ethylene","Ethyl alcohol","None of the above"}, "Ethylene","B",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The most malleable metal is",
                    new String[]{"Platinum","Silver","Iron","Gold"}, "Gold","D",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The mass of one Avogadro number of helium atom is",
                    new String[]{"1.00 gram","4.00 gram","8.00 gram","4 x 6.02 x 10^23 gram"}, "4 x 6.02 x 10^23 gram","D",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The first metal used by man was",
                    new String[]{"Iron","Copper","Gold","Bronze"}, "Copper","B",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The hydronium ion is",
                    new String[]{"H+","HO -","H2+","H3O+"}, "H3O+","D",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The iron ore magnetite consists of",
                    new String[]{"Fe2O3","Fe3OH4","FeCO3","3Fe2O3 .. 3H2O"}, "Fe2O3","A",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The major constituent of air is",
                    new String[]{"Carbon dioxide","Nitrogen","Oxygen","Hydrogen"}, "Nitrogen","B",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The main chemical constituent of clay is",
                    new String[]{"Silicon oxide","Aluminium borosilicate","Zeolites","Aluminium silicate"}, "Aluminium silicate","D",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The number of g-molecule of oxygen in 6.02 x 1024CO molecules is",
                    new String[]{"1 gram of molecule","0.5 gram of molecule","5 gram of molecule","10 gram of molecule"}, "5 gram of molecule","C",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The main active constituent of tea and coffee is",
                    new String[]{"Nicotine","Chlorophyll","Caffeine","Aspirin"}, "Caffeine","C",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The hardest form of carbon is",
                    new String[]{"Coke","Graphite","Diamond","Charcoal"}, "Charcoal","D",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The most important ore of aluminium is",
                    new String[]{"Bauxite","Magnetite","Haematite","Monazite"}, "Bauxite","A",""));
            cheEngDataBaseHelper.addInitialCheEngQuestion(new Question("The element present in the highest proportion (65%) in the human body is",
                    new String[]{"Carbon","hydrogen","Oxygen","Nitrogen"}, "Oxygen","C",""));



            list = cheEngDataBaseHelper.getAllCheEngQuestionsList();//get list from database again

        }
    }
}
