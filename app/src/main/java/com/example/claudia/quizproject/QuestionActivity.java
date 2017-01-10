package com.example.claudia.quizproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;

import static com.example.claudia.quizproject.QuestionFragment.EXTRA_QUESTION_NUM;
import static com.example.claudia.quizproject.QuestionFragment.EXTRA_RECEIVED_USERNAME;


public class QuestionActivity extends AbsSingleFragmentActivity {

    boolean questionFromMenu;

    /*public static Intent newIntent(Context packageContext, String receivedUsername) {
        Intent i = new Intent(packageContext, QuestionActivity.class);
        i.putExtra(EXTRA_RECEIVED_USERNAME, receivedUsername);
        return i;
    }*/

    public static Intent newIntent(Context packageContext, int questionNumber) {
        Intent intent = new Intent(packageContext, QuestionActivity.class);
        intent.putExtra(EXTRA_QUESTION_NUM, questionNumber);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new QuestionFragment();


    }
    }

