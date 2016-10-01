package com.bignerdranch.android.surveywithfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
    //Have MainActivity be something that can listen for updates from SurveyFragment
        implements SurveyFragment.SurveyResultsUpdatedListener{

    private SurveyFragment surveyFragment = SurveyFragment.newInstance();
    private ResultsActivity resultsFragment = new ResultsActivity();  //These should be newInstance too, but here it's not that important
    private QuestionActivity questionFragment = new QuestionActivity();

    private static final String SURVEY_KEY = "SURVEY FRAGMENT";
    private static final String RESULTS_KEY= "RESULTS_FRAGMENT";
    private static final String QUESTION_KEY= "QUESTION_FRAGMENT";

    private static final String TAG = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SurveyFragment addSurveyActivity = SurveyFragment.newInstance();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.surevey_view_container, surveyFragment, SURVEY_KEY);
        ft.add(R.id.results_view_container, resultsFragment, RESULTS_KEY);
        ft.add(R.id.change_question_view_container, questionFragment, QUESTION_KEY);
        ft.commit();
        //Fragment fragment = fm.findFragmentById(R.id.surevey_view_container);


//        if (fragment == null){
//            fragment = new SurveyActivity();
//            fm.beginTransaction().add(R.id.surevey_view_container, fragment).commit();
        //}



//        if (savedInstanceState == null){
//            Log.d(TAG, "on create has no instance state.  Set it up.");

            //SurveyActivity surveyActivity = SurveyActivity.newInstance();
        }

    @Override
    public void resultsUpdated(int yes, int no) {

        //Send message to resultsFragment
        resultsFragment.resultsUpdated(yes, no);

    }
}

