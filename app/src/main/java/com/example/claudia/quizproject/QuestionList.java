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
                  mQuestions.add(new Question(R.string.question_oceans, true, false, 0));
                 mQuestions.add(new Question(R.string.question_mideast, false, false, 1));
                   mQuestions.add(new Question(R.string.question_africa, false, false, 2));
                  mQuestions.add(new Question(R.string.question_americas, true, false, 3));
                  mQuestions.add(new Question(R.string.question_asia, true, false, 4));
        }

            public List<Question> getQuestions() {
                return mQuestions;
            }

            public Question getQuestion(int number) {
                for (Question question : mQuestions) {
                    if (question.getQNumber() == number) {
                        return question;
                    }
                }
                return null;
        }
    public int getItemCount (List<Question> questionList){
        mQuestions = questionList;
        return mQuestions.size();
    }

}
