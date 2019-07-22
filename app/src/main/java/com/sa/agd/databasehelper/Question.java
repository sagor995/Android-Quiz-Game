package com.sa.agd.databasehelper;

/**
 * Created by Sagor Ahamed on 6/22/2017.
 */

public class Question {
    private String question;
    private String[] choice = new String[4];
    private String answer;
    private String halfHelpLine;
    private String hintHelpLine;

    public Question() {

    }
    public Question(String question, String[] choices, String answer, String halfHelpLine, String hintHelpLine) {
        this.question = question;
        this.choice[0] = choices[0];
        this.choice[1] = choices[1];
        this.choice[2] = choices[2];
        this.choice[3] = choices[3];
        this.answer = answer;
        this.halfHelpLine = halfHelpLine;
        this.hintHelpLine = hintHelpLine;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice(int i) {
        return choice[i];
    }

    public String getAnswer() {
        return answer;
    }

    public String getHalfHelpLine(){return halfHelpLine;}

    public String getHintHelpLine(){return hintHelpLine;}



    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setChoice(int i, String choice) {
        this.choice[i] = choice;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setHalfHelpLine(String halfHelpLine){this.halfHelpLine=halfHelpLine;}
    public void setHintHelpLine(String hintHelpLine){this.hintHelpLine=hintHelpLine;}


}
