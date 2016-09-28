package com.bignerdranch.android.surveywithfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by miked on 9/27/2016.
 */

public class SurveyActivity extends Fragment {
    public View onCreateview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_survey_activity, container, false);
    }


}
