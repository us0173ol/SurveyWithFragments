package com.bignerdranch.android.surveywithfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by miked on 9/27/2016.
 */

public class ResultsActivity extends Fragment {

    private int returnYes;
    private int returnNo;
    private Button mResetResultsButton;
    private Button mContinueSurveyButton;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_results_activity, container, false);

        //returnYes = getArguments()
        TextView showResults = (TextView) view.findViewById(R.id.results_textview);
        showResults.setText("Yes:" + returnYes + "No: " + returnNo);

        return view;
    }
}
