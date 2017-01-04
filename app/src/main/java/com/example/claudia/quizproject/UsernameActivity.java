package com.example.claudia.quizproject;

import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UsernameActivity extends AppCompatActivity {

    private EditText mUsernameEditText;
    private Button mStartButton;
    String username;

    public String getUsername() {
        return username;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        mUsernameEditText = (EditText) findViewById(R.id.username_edit_text);


        mUsernameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            @Override
            public boolean onEditorAction (TextView textView, int i, KeyEvent keyEvent) {
                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_DONE) {
                    username = textView.getText().toString();
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    handled = true;

                }
                return handled;
            }
        });

        mStartButton = (Button)findViewById(R.id.start_btn);
        mStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start CheatActivity
                Intent i = QuestionActivity.newIntent(UsernameActivity.this, username);
                startActivity(i);
            }
        });
    }



}
