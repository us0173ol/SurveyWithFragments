package com.bignerdranch.android.surveywithfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
    //Have MainActivity be something that can listen for updates from SurveyFragment

        SurveyFragment.SurveyResultsUpdatedListener,
        ResultsFragment.ResetSurveyListener,
        QuestionFragment.ChangeQuestionListener{

    private SurveyFragment surveyFragment = SurveyFragment.newInstance();
    private ResultsFragment resultsFragment = ResultsFragment.newInstance();  //These should be newInstance too, but here it's not that important
    private QuestionFragment questionFragment = QuestionFragment.newInstance();

    private static final String SURVEY_KEY = "SURVEY_FRAGMENT";
    private static final String RESULTS_KEY= "RESULTS_FRAGMENT";
    private static final String QUESTION_KEY= "QUESTION_FRAGMENT";

    private static final String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.surevey_view_container, surveyFragment, SURVEY_KEY);
        ft.add(R.id.results_view_container, resultsFragment, RESULTS_KEY);
        ft.add(R.id.change_question_view_container, questionFragment, QUESTION_KEY);
        ft.commit();

        }

    @Override
    public void resultsUpdated(int yes, int no) {

        //Send message to resultsFragment
        resultsFragment.resultsUpdated(yes, no);

    }

    @Override
    public void resetSurvey(int yes, int no) {

        surveyFragment.resultsReset(yes, no);
    }

    @Override
    public void changeQuestion(String question, String answer1, String answer2){

        surveyFragment.changeQuestion(question, answer1, answer2);
    }
}


