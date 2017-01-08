package com.example.claudia.quizproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import static com.example.claudia.quizproject.QuestionFragment.EXTRA_RECEIVED_USERNAME;


public class QuestionActivity extends AbsSingleFragmentActivity {

    /*public static Intent newIntent(Context packageContext, String receivedUsername) {
        Intent i = new Intent(packageContext, QuestionActivity.class);
        i.putExtra(EXTRA_RECEIVED_USERNAME, receivedUsername);
        return i;
    }*/
    @Override
    protected Fragment createFragment() {
        return new QuestionFragment();
    }
    }

