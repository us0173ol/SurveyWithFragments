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


    //TODO add an interface called ResetSurveyListener with one method called resetSurvey()

    //TODO add a variable to store a reference to a ResetSurveyListener

    //TODO add onAttach(Activity activity) method to save the activity as the ResetSurveyListener

    //Change TextView to global variable
    TextView showResults;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_results_activity, container, false);

        //returnYes = getArguments()
        showResults = (TextView) view.findViewById(R.id.results_textview);
       // showResults.setText("Yes:" + returnYes + "No: " + returnNo);
        //You are showing a default value until data received

        //TODO - listener for the reset button, will send a message to the ResetSurveyListener
        //TODO Have MainActivity implemente ResetSurveyListener, and provide a resetSurvey() method
        //When this method is called, MainActivity will notify SurveyActivity.
        //Provide a reset method in SurveyActivty that sets yesCounter and noCounter to 0.

        return view;
    }


    ///SurveyFragment notifies MainActivity when the results are updated,
    //and MainActivity calls this method.
    public void resultsUpdated(int yes, int no) {
        showResults.setText("Yes:" + yes + "No: " + no);

    }
}
