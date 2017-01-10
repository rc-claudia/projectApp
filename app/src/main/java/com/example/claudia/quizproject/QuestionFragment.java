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

import java.util.List;
import java.util.UUID;

/**
 * Created by Claudia on 03/01/2017.
 */

public class QuestionFragment extends Fragment{
    private Button mFalseButton;
    private Button mTrueButton;
    private Button mCheatButton;
    private Button mNextButton;
    private Button mFinishButton;
    private Button mMenuButton;
    private TextView mQuestionTextView;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    public int currentGameScore = 0;
    boolean answerIsTrue;
    //private String username;
    protected static final String EXTRA_RECEIVED_USERNAME = "QuizProject.username";
    private static final String ARG_QUESTION_NUM = "question_num";
    Question mQuestion;
    public static final String EXTRA_QUESTION_NUM =
            "quizProject.question_num";
    private static final int REQUEST_CODE_MENU = 0;
    private List<Question> mQuestions;

    //DBHandle db = new DBHandle(getActivity());
    User user = new User();
    String username = user.getUserOnScreen();

    public static QuestionFragment newInstance(int qNum) {
        Bundle args = new Bundle();
        args.putInt(ARG_QUESTION_NUM, qNum);
        QuestionFragment fragment = new QuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestion.isAnswerTrue();

        int messageResId = 0;

        if (mQuestion.isHasCheated()) {
            messageResId = R.string.judgment_toast;
            Toast.makeText(getActivity(), messageResId, Toast.LENGTH_SHORT)
                    .show();
        }

        else {if (userPressedTrue == answerIsTrue) {
            checkEachAnswer[mQuestionNumber] = true;
        }
        else {
           checkEachAnswer[mQuestionNumber] = false;
        }}
    }

    boolean[] checkEachAnswer = new boolean[5];

    int mQuestionNumber = 0;
    private boolean mIsCheater = false;
    private boolean mMenuPressed;


    private void updateQuestion() {
        mQuestion = QuestionList.get(getActivity()).getQuestion(mQuestionNumber);
        int question = mQuestion.getTextResId();
        mQuestionTextView.setText(question);
    }

    private void setQuestionFromMenu(){
        mQuestionNumber = getActivity().getIntent().getIntExtra(EXTRA_QUESTION_NUM, 4);
        mQuestion = QuestionList.get(getActivity()).getQuestion(mQuestionNumber);
        int question = mQuestion.getTextResId();
        mQuestionTextView.setText(question);
        mMenuPressed = false;
    }

    private int countScore(){
        for (int currentIndex = 0; currentIndex < 5; currentIndex++){
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
        QuestionList questionList = QuestionList.get(getActivity());
        mQuestions = questionList.getQuestions();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        //username = getActivity().getIntent().getStringExtra(EXTRA_RECEIVED_USERNAME);

        if (mMenuPressed){
            int messageResId = R.string.judgment_toast;
            Toast.makeText(getActivity(), messageResId, Toast.LENGTH_SHORT)
                    .show();
            setQuestionFromMenu();
        }
        else {
            int messageResId = R.string.correct_toast;
            Toast.makeText(getActivity(), messageResId, Toast.LENGTH_SHORT)
                    .show();
            mQuestionTextView = (TextView) v.findViewById(R.id.question_text_view);
        }

        mMenuButton = (Button) v.findViewById(R.id.menu_btn);

        mMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menuPressed = true;
                Intent i = new Intent(getActivity(), QuestionMenuActivity.class);
                startActivityForResult(i, REQUEST_CODE_MENU);
            }
        });

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
                answerIsTrue = mQuestion.isAnswerTrue();
                mIsCheater = true;
                mQuestion.setHasCheated(mIsCheater);
                Intent i = Cheat_Activity.newIntent(getActivity(), answerIsTrue);
                startActivity(i);
            }
        });

        mNextButton = (Button) v.findViewById(R.id.next_btn);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestionNumber = (mQuestionNumber + 1) % 5;
                mIsCheater = false;
                updateQuestion();
            }
        });

        if (savedInstanceState != null) {
            mQuestionNumber = savedInstanceState.getInt(KEY_INDEX, 1);
        }
        updateQuestion();

        mFinishButton = (Button) v.findViewById(R.id.finish_btn);

        //final User retrievedUser = db.getUser(username);

        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countScore();
                //db.addAttempt(new Score(retrievedUser.getUserOnScreen(), currentGameScore));
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

            if (requestCode == REQUEST_CODE_MENU) {
                if (data == null) {
                    return;
                }
                mMenuPressed = QuestionMenuFragment.wasMenuPressed(data);
            }
        }
    }

