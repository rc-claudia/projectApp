package com.example.claudia.quizproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Claudia on 04/01/2017.
 */

public class ScoreFragment extends Fragment {
    private Score mScore;
    private TextView mScoreDisplay;
    private TextView mUsernameDisplay;
    private int mUserScore;
    protected static final String EXTRA_SCORE = "QuizProject.score";
    protected static final String EXTRA_USERNAME = "QuizProject.username";
    User user;
    private String mUsername = user.getUserOnScreen();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScore = new Score();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);
        DBHandle db = new DBHandle(getActivity());

        final User retrievedUser = db.getUser(mUsername);

        mUserScore = db.getScore(mUsername);

        mUsernameDisplay = (TextView) v.findViewById(R.id.user_text_view);
        mUsernameDisplay.setText(mUsername);

        mScoreDisplay = (TextView) v.findViewById(R.id.score_text_view);
        mScoreDisplay.setText(mUserScore + "");
        return v;
    }
}
