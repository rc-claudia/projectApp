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
    private String mUsername;
    protected static final String EXTRA_SCORE = "QuizProject.score";
    protected static final String EXTRA_USERNAME = "QuizProject.username";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScore = new Score();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);

        mUsername = getActivity().getIntent().getStringExtra(EXTRA_USERNAME);
        mUserScore = getActivity().getIntent().getIntExtra(EXTRA_SCORE, 0);

        mUsernameDisplay = (TextView) v.findViewById(R.id.user_text_view);
        mUsernameDisplay.setText(mUsername);

        mScoreDisplay = (TextView) v.findViewById(R.id.score_text_view);
        mScoreDisplay.setText(mUserScore + "");
        return v;
    }
}
