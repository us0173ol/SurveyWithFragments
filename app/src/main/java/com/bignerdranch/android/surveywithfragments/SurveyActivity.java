package com.bignerdranch.android.surveywithfragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by miked on 9/27/2016.
 */

public class SurveyActivity extends Fragment {

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

    public interface onFragmentSendResults{
        public void resultsSent(int counters);
    }

    private static final String TAG = "Add Survey Fragment";
    private static final String YES = "YesCounter";
    private static final String NO = "NoCounter";

    public static SurveyActivity newInstance(){
        return new SurveyActivity();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

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
            }
        });
        mNoButton = (Button) view.findViewById(R.id.no_button);
        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                noCounter++;
            }
        });
        mResultsButton = (Button) view.findViewById(R.id.results_button);
        mResultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int yesCount = yesCounter;
                int noCount = noCounter;

            }
        });


        return view;
    }
    public void sendResults(int yesCounter,int noCounter){
        Bundle args = new Bundle();
        args.putInt(YES,yesCounter);
        args.putInt(NO, noCounter);
        resultsFrag.setArguments(args);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.commit();

    }


}
