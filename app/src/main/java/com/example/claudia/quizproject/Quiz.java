package com.example.claudia.quizproject;

import java.util.UUID;

/**
 * Created by Claudia on 03/01/2017.
 */

public class Quiz {
    private UUID mId;
    private String mTitle;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Quiz() {
        // Generate unique identifier
        mId = UUID.randomUUID();
    }
}
