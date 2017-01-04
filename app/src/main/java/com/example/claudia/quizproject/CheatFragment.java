package com.example.claudia.quizproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Claudia on 03/01/2017.
 */

public class CheatFragment extends Fragment {
    protected static final String EXTRA_ANSWER_IS_TRUE =
            "QuizProject.answer_is_true";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cheat, container, false);

        mAnswerIsTrue = getActivity().getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) v.findViewById(R.id.answer_text_view);

        if (mAnswerIsTrue) {
            mAnswerTextView.setText(R.string.true_button);
        } else {
            mAnswerTextView.setText(R.string.false_button);
        }
        return v;
    }
}



