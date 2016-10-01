package com.bignerdranch.android.surveywithfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by miked on 9/27/2016.
 */

//Suggest renaming this to 'QuestionFragment' or similar?

public class QuestionActivity extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){
        return inflater.inflate(R.layout.fragment_new_question_activity, container, false);
    }
}
