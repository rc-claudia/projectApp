package com.example.claudia.quizproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Claudia on 03/01/2017.
 */

public class QuestionFragment extends Fragment{
    private Button mFalseButton;
    private Button mTrueButton;
    private Button mCheatButton;
    private Button mNextButton;
    private Button mFinishButton;
    private TextView mQuestionTextView;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final int REQUEST_CODE_CHEAT = 0;
    public int currentGameScore = 0;
    boolean answerIsTrue;
    private String username;
    protected static final String EXTRA_USERNAME = "QuizProject.username";

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (mQuestionBank[mCurrentIndex].isHasCheated()) {
            messageResId = R.string.judgment_toast;
            Toast.makeText(getActivity(), messageResId, Toast.LENGTH_SHORT)
                    .show();
        }

        else {if (userPressedTrue == answerIsTrue) {
            checkEachAnswer[mCurrentIndex] = true;
        }
        else {
           checkEachAnswer[mCurrentIndex] = false;
        }}
    }

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true, false),
            new Question(R.string.question_mideast, false, false),
            new Question(R.string.question_africa, false, false),
            new Question(R.string.question_americas, true, false),
            new Question(R.string.question_asia, true, false),
    };

    boolean[] checkEachAnswer = new boolean[mQuestionBank.length];

    private int mCurrentIndex = 0;
    private boolean mIsCheater = false;

    public int getCurrentIndex() {
        return mCurrentIndex;
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private int countScore(){
        for (int currentIndex = 0; currentIndex < mQuestionBank.length; currentIndex++){
            if (checkEachAnswer[currentIndex])
                currentGameScore++;
        }
        return currentGameScore;
    }


    public int getCurrentGameScore() {
        return currentGameScore;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        username = getActivity().getIntent().getStringExtra(EXTRA_USERNAME);

        mQuestionTextView = (TextView) v.findViewById(R.id.question_text_view);

        mTrueButton = (Button) v.findViewById(R.id.true_btn);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) v.findViewById(R.id.false_btn);

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mCheatButton = (Button) v.findViewById(R.id.cheat_btn);

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                mIsCheater = true;
                mQuestionBank[mCurrentIndex].setHasCheated(mIsCheater);
                Intent i = Cheat_Activity.newIntent(getActivity(), answerIsTrue);
                startActivity(i);
            }
        });

        mNextButton = (Button) v.findViewById(R.id.next_btn);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mIsCheater = false;
                updateQuestion();
            }
        });

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        updateQuestion();

        mFinishButton = (Button) v.findViewById(R.id.finish_btn);

        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countScore();
                Intent intent = ScoreActivity.theIntent(getActivity(), currentGameScore, username);
                startActivity(intent);
            }
        });
        return v;
    }

        @Override
        public void onActivityResult ( int requestCode, int resultCode, Intent data){
            if (resultCode != Activity.RESULT_OK) {
                return;
            }

            if (requestCode == REQUEST_CODE_CHEAT) {
                if (data == null) {
                    return;
                }

            }
        }
    }

