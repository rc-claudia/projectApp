package com.example.claudia.quizproject;

import java.util.UUID;

/**
 * Created by Claudia on 13/12/2016.
 */

    public class Question {

    private int mQNumber;
    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mHasCheated;

    public Question() {
    }



    public Question(int textResId, boolean answerTrue, boolean hasCheated, int number) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mHasCheated = hasCheated;
        mQNumber = number;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setHasCheated(boolean hasCheated) {
        mHasCheated = hasCheated;
    }
    public boolean isHasCheated() {
        return mHasCheated;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getQNumber() {
        return mQNumber;
    }

    public void setQNumber(int QNumber) {
        mQNumber = QNumber;
    }
}
