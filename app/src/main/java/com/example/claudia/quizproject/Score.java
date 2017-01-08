package com.example.claudia.quizproject;

/**
 * Created by Claudia on 24/12/2016.
 */

public class Score extends User {
    private int score;
    private String username;

    public Score(){
        score = 0;
    }

    public Score (String theUser, int userScore) {
        this.username = theUser;
        this.score = userScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int theScore) {
        this.score = theScore;
    }

    @Override
    public String getUserOnScreen() {
        return username;
    }

    @Override
    public void setUserOnScreen(String username) {
        this.username = username;
    }
}
