package com.example.claudia.quizproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Claudia on 07/01/2017.
 */

public class UsernameFragment extends Fragment {
    private EditText mUsernameEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mStartButton;
    private User mUser;
    String newUser;
    String email;
    String password;
    User user;
    DBHandle db = new DBHandle(getActivity());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_username, container, false);



        mUsernameEditText = (EditText) v.findViewById(R.id.username_edit_text);


        mUsernameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            @Override
            public boolean onEditorAction (TextView textView, int i, KeyEvent keyEvent) {
                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_NEXT) {
                    newUser = textView.getText().toString();
                    InputMethodManager inputManager = (InputMethodManager)
                            getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    handled = true;
                    user.setUserOnScreen(newUser);
                }
                return handled;
            }
        });

        mEmailEditText = (EditText) v.findViewById(R.id.email_edit_text);

        mEmailEditText.setOnEditorActionListener(new TextView.OnEditorActionListener(){
        @Override
        public boolean onEditorAction (TextView textView, int i, KeyEvent keyEvent) {
            boolean handled = false;
            if (i == EditorInfo.IME_ACTION_NEXT) {
                email = textView.getText().toString();
                InputMethodManager inputManager = (InputMethodManager)
                        getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                handled = true;
            }
            return handled;
        }
    });

        mPasswordEditText = (EditText) v.findViewById(R.id.password_edit_text);

        mPasswordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction (TextView textView, int i, KeyEvent keyEvent) {
                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_DONE) {
                    password = textView.getText().toString();
                    InputMethodManager inputManager = (InputMethodManager)
                            getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    handled = true;
                }
                return handled;
            }
        });

    mStartButton = (Button)v.findViewById(R.id.start_btn);
        mStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                db.addUser(new User(newUser, email, password));
                // Start CheatActivity
                Intent i = new Intent(getActivity(), QuestionActivity.class);
                startActivity(i);
            }
        });
        return v;
}
}
