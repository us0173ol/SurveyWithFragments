package com.bignerdranch.android.surveywithfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by miked on 9/27/2016.
 */

//Let's rename this to SurveyFragment, now it's a Fragment?
    //Recommend renaming your other Fragments too

public class SurveyFragment extends Fragment {

    private Button mYesButton;
    private Button mNoButton;
    private Button mResultsButton;
    private static final int REQUEST_RESULTS = 0;
    private static final int CONFIG_RESULTS = 1;

    private ResultsActivity resultsFrag = new ResultsActivity();
    private QuestionActivity questionFrag = new QuestionActivity();

    String yesButtonText;
    String noButtonText;

    int yesCounter = 0;
    int noCounter = 0;
    private int getYesCounter;
    private int getNoCounter;

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_survey_activity, container, false);

        yesButtonText = getString(R.string.yes_button);
        noButtonText = getString(R.string.no_button);

        mYesButton = (Button) view.findViewById(R.id.yes_button);
        mYesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                yesCounter++;
                //Notify the listener that the results have changed
                mResultsUpdatedListener.resultsUpdated(yesCounter, noCounter);

            }
        });
        mNoButton = (Button) view.findViewById(R.id.no_button);
        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                noCounter++;
                //Same for the no button
                mResultsUpdatedListener.resultsUpdated(yesCounter, noCounter);

            }
        });

        //Do you need this, if you have all three fragments on screen at once?
        //If you were to redesign your app to have survey and results on different screens,
        //you would need a Results button, or some other way to move from the Survey to the Results.
//        mResultsButton = (Button) view.findViewById(R.id.results_button);
//        mResultsButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                int yesCount = yesCounter;
//                int noCount = noCounter;
//
//            }
//        });


        return view;
    }
//    Don't need this - Bundles used to send data TO fragments at creation
    // Regular method calls to send data FROM fragments.

//    public void sendResults(int yesCounter,int noCounter){
//        Bundle args = new Bundle();
//        args.putInt(YES,yesCounter);
//        args.putInt(NO, noCounter);
//        resultsFrag.setArguments(args);
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        ft.commit();
//
//    }


}
