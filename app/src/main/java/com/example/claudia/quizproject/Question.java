package com.example.claudia.quizproject;

import java.util.UUID;

/**
 * Created by Claudia on 13/12/2016.
 */

    public class Question {

    private UUID mId;
    private String mTitle;
    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mHasCheated;

    public Question() {
        // Generate unique identifier
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Question(int textResId, boolean answerTrue, boolean hasCheated) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mHasCheated = hasCheated;
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
}
