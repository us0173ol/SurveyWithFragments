package com.bignerdranch.android.surveywithfragments;

import android.app.Activity;
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

public class ResultsFragment extends Fragment {
    //variables set to zero for resetiing counters
    private int returnYes = 0;
    private int returnNo = 0;
    //Button variable references the Reset Button
    private Button mResetResultsButton;

    //Tried to set variables for text changes in results but android didnt like the way I did it
    //String yesAnswerText = getString(R.string.yes_button);
    //String noAnswerText = getString(R.string.no_button);
    //TODO add an interface called ResetSurveyListener with one method called resetSurvey()
    //interface with method to reset results
    public interface ResetSurveyListener {
        public void resetSurvey(int yes, int no);
    }
    //TODO add a variable to store a reference to a ResetSurveyListener
    //Variable to reference ResetSurvey listener
    private ResetSurveyListener mResetSurveyListener;

    public static ResultsFragment newInstance(){
        return new ResultsFragment();
    }
    //TODO add onAttach(Activity activity) method to save the activity as the ResetSurveyListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ResetSurveyListener){
            mResetSurveyListener = (ResetSurveyListener) activity;
        }else{
            throw new RuntimeException("Error message here...");
        }
    }

    //Change TextView to global variable
    TextView showResults;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_results_activity, container, false);
        //Variable for results textview reference
        showResults = (TextView) view.findViewById(R.id.results_textview);
        //You are showing a default value until data received

        //listener for the reset button, will send a message to the ResetSurveyListener
        mResetResultsButton = (Button)view.findViewById(R.id.reset_button);
        mResetResultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                mResetSurveyListener.resetSurvey(returnYes, returnNo);
            }
        });
        //Have MainActivity implement ResetSurveyListener, and provide a resetSurvey() method
        //When this method is called, MainActivity will notify SurveyActivity.
        //Provide a reset method in SurveyActivty that sets yesCounter and noCounter to 0.

        return view;
    }


    ///SurveyFragment notifies MainActivity when the results are updated,
    //and MainActivity calls this method.
    public void resultsUpdated(int yes, int no) {
        showResults.setText(yes + "                     " + no);
    //this was my workaround for my textVariables not working
    }
}
