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

//Let's rename this to SurveyFragment, now it's a Fragment?
    //Recommend renaming your other Fragments too

public class SurveyFragment extends Fragment {

    private Button mYesButton;
    private Button mNoButton;
    private static final int REQUEST_RESULTS = 0;
    private static final int CONFIG_RESULTS = 1;

    //private ResultsFragment resultsFrag = new ResultsFragment();
    //private QuestionFragment questionFrag = new QuestionFragment();

    String yesButtonText;
    String noButtonText;

    int yesCounter = 0;
    int noCounter = 0;

    public void changeQuestion(String question, String answer1, String answer2){

        showQuestion.setText(question);
        mYesButton.setText(answer1);
        mNoButton.setText(answer2);
    }


    public void resultsReset(int yes, int no) {
        yesCounter=0;
        noCounter=0;
        mResultsUpdatedListener.resultsUpdated(yes,no);

    }

//    public interface onFragmentSendResults{
//        public void resultsSent(int counters);
//    }

    //I'm renaming your interface

    public interface SurveyResultsUpdatedListener {
        public void resultsUpdated(int yes, int no);
    }

    //And a reference to your listener

    private SurveyResultsUpdatedListener mResultsUpdatedListener;

    private static final String TAG = "Add Survey Fragment";
    private static final String YES = "YesCounter";
    private static final String NO = "NoCounter";

    public static SurveyFragment newInstance(){
        return new SurveyFragment();
    }

    //Use the old version for now, the new one with Context argument won't work on Android 4
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        //Register the listener. The Activty that hosts this Fragment is going to
        //be listening for changes to survey results

        if (activity instanceof  SurveyResultsUpdatedListener) {
            mResultsUpdatedListener = (SurveyResultsUpdatedListener) activity;
        }
        else {
            //crash program, the Activity is not able to listen to results
            throw new RuntimeException("Activity must implement the SurveyResultsUpdatedListener");
        }
     }

    TextView showQuestion;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_survey_activity, container, false);
        //Set default values for yes and no buttons
        yesButtonText = getString(R.string.yes_button);
        noButtonText = getString(R.string.no_button);

        showQuestion = (TextView) view.findViewById(R.id.question_textview);
        //Listener for clicked yes button, update results after adding to counter
        mYesButton = (Button) view.findViewById(R.id.yes_button);
        mYesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                yesCounter++;
                //Notify the listener that the results have changed
                mResultsUpdatedListener.resultsUpdated(yesCounter,noCounter);

            }
        });//listener for no button, does the same as yes button
        mNoButton = (Button) view.findViewById(R.id.no_button);
        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                noCounter++;
                //Same for the no button
                mResultsUpdatedListener.resultsUpdated(yesCounter,noCounter);

            }
        });

        return view;
    }

}
