package com.example.claudia.quizproject;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Claudia on 03/01/2017.
 */

public class QuestionList {
        private static QuestionList sQuestionList;
    private List<Question> mQuestions;

    public static QuestionList get(Context context) {
            if (sQuestionList == null) {
                sQuestionList = new QuestionList(context);
            }
            return sQuestionList;
        }

        private QuestionList(Context context) {
                mQuestions = new ArrayList<>();
             Question[] mQuestionBank = new Question[]{
                    new Question(R.string.question_oceans, true, false),
                    new Question(R.string.question_mideast, false, false),
                    new Question(R.string.question_africa, false, false),
                    new Question(R.string.question_americas, true, false),
                    new Question(R.string.question_asia, true, false),
            };
            }

            public List<Question> getQuestions() {
                return mQuestions;
            }

            public Question getQuestion(UUID id) {
                for (Question question : mQuestions) {
                    if (question.getId().equals(id)) {
                        return question;
                    }
                }
                return null;
        }

}
