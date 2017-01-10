package com.example.claudia.quizproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;


/**
 * Created by Claudia on 08/01/2017.
 */

public class QuestionMenuActivity extends AbsSingleFragmentActivity {





    @Override
    protected Fragment createFragment() {
        return new QuestionMenuFragment();
    }
}

