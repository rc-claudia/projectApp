package com.example.claudia.quizproject;

/**
 * Created by Claudia on 24/12/2016.
 */

public class Score extends User {
    private int score;

    public Score(){
        score = 0;
    }

    public Score (String theUser, int userScore) {
        super.getUser();
        score = userScore;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int theScore) {
        this.score = theScore;
    }



}
