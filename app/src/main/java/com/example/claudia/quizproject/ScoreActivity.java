package com.example.claudia.quizproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.claudia.quizproject.R.string.score;

public class ScoreActivity extends AppCompatActivity {
    private TextView mScoreDisplay;
    private int userScore;

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mScoreDisplay = (TextView) findViewById(R.id.score_text_view);
        mScoreDisplay.setText(userScore);
    }
}
