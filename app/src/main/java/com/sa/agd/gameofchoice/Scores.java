package com.sa.agd.gameofchoice;

/**
 * Created by Sagor Ahamed on 8/5/2017.
 */

public class Scores {
    public String name;
    public int score;
    public String category;

    public Scores(String name, int score, String category) {
        this.name = name;
        this.score = score;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
