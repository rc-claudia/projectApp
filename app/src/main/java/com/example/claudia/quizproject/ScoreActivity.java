package com.example.claudia.quizproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//import static com.example.claudia.quizproject.QuestionFragment.EXTRA_USERNAME;
import static com.example.claudia.quizproject.ScoreFragment.EXTRA_SCORE;


public class ScoreActivity extends FragmentActivity {

    public static Intent theIntent(Context packageContext, int score, String username) {
        Intent intent = new Intent(packageContext, ScoreActivity.class);
        intent.putExtra(EXTRA_SCORE, score);
        //intent.putExtra(EXTRA_USERNAME, username);
        return intent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.score_container);

        if (fragment == null) {
            fragment = new ScoreFragment();
            fm.beginTransaction()
                    .add(R.id.score_container, fragment)
                    .commit();
        }
    }
}
