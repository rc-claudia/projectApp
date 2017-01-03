package com.example.claudia.quizproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.attr.id;

public class QuizActivity extends AppCompatActivity {

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


    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();



        int messageResId = 0;

        if (mIsCheater) {
            messageResId = R.string.judgment_toast;
        }

        if (userPressedTrue == answerIsTrue) {
            checkEachAnswer[mCurrentIndex] = true;
        }
        else {
            checkEachAnswer[mCurrentIndex] = false;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    boolean[] checkEachAnswer = new boolean[mQuestionBank.length];
    private int mCurrentIndex = 0;
    private boolean mIsCheater;


    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void aScore(Score thisScore){
        for (int currentIndex = 0; currentIndex <= mQuestionBank.length; currentIndex++){
            if (checkEachAnswer[currentIndex] == true)
                currentGameScore++;
        }
        thisScore.setScore(currentGameScore);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton = (Button) findViewById(R.id.true_btn);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_btn);

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mCheatButton = (Button) findViewById(R.id.cheat_btn);

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                Intent i = Cheat_Activity.newIntent(QuizActivity.this, answerIsTrue);
                startActivityForResult(i, REQUEST_CODE_CHEAT);

            }
        });

        mNextButton = (Button) findViewById(R.id.next_btn);

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

        mFinishButton = (Button) findViewById(R.id.finish_btn);

        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countScore();
                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null) {
                return;
            }
            mIsCheater = Cheat_Activity.wasAnswerShown(data);
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);


        public void onStart(){
            super.onStart();
            Log.d(TAG, "onStart() called");
        }

        @Override
        public void onPause () {
            super.onPause();
            Log.d(TAG, "onPause() called");
        }

        @Override
        public void onResume () {
            super.onResume();
            Log.d(TAG, "onResume() called");
        }

        @Override
        public void onStop () {
            super.onStop();
            Log.d(TAG, "onStop() called");
        }

        @Override
        public void onDestroy () {
            super.onDestroy();
            Log.d(TAG, "onDestroy() called");
        }

    }
}

