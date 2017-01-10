package com.example.claudia.quizproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Claudia on 08/01/2017.
 */

public class QuestionMenuFragment extends Fragment {
    public static final String EXTRA_QUESTION_NUM =
            "quizProject.question_num";
    public static final String EXTRA_MENU_PRESSED =
            "quizProject.question_num";
    private RecyclerView mQuestionRecyclerView;
    private QuestionAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        setMenuPressed(true);

        mQuestionRecyclerView = (RecyclerView) view
                .findViewById(R.id.question_recycler_view);
        mQuestionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        QuestionList questionList = QuestionList.get(getActivity());
        List<Question> questions = questionList.getQuestions();

        mAdapter = new QuestionAdapter(questions);
        mQuestionRecyclerView.setAdapter(mAdapter);
    }

    private class QuestionHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mQuestionTextView;
        private Question mQuestion;

        public void bindQuestion (Question question){
            mQuestion = question;
            mQuestionTextView.setText("Question " + (mQuestion.getQNumber() + 1));
        }


        public QuestionHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mQuestionTextView = (TextView) itemView;
        }

        @Override
        public void onClick(View v) {
            getAdapterPosition();
            Intent intent = QuestionActivity.newIntent(getActivity(), mQuestion.getQNumber());
            startActivity(intent);
        }
    }

        private class QuestionAdapter extends RecyclerView.Adapter<QuestionHolder> {

            private List<Question> mQuestions;

            public QuestionAdapter(List<Question> questions) {
                mQuestions = questions;
            }

            @Override
            public QuestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                View view = layoutInflater
                        .inflate(android.R.layout.simple_list_item_1, parent, false);
                return new QuestionHolder(view);
            }

            @Override
            public void onBindViewHolder(QuestionHolder holder, int position) {
                Question question = mQuestions.get(position);
                holder.bindQuestion(question);
            }

            @Override
            public int getItemCount() {
                return mQuestions.size();
            }
        }

    private void setMenuPressed(boolean isMenuPressed) {
        Intent data = new Intent();
        data.putExtra(EXTRA_MENU_PRESSED, isMenuPressed);
        getActivity().setResult(RESULT_OK, data);
    }

    public static boolean wasMenuPressed(Intent result) {
        return result.getBooleanExtra(EXTRA_MENU_PRESSED, false);
    }

}

