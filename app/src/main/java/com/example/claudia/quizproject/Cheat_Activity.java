package com.example.claudia.quizproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import static com.example.claudia.quizproject.CheatFragment.EXTRA_ANSWER_IS_TRUE;

public class Cheat_Activity extends AbsSingleFragmentActivity {

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, Cheat_Activity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    @Override
    protected Fragment createFragment() {
        return new CheatFragment();
    }
    }

