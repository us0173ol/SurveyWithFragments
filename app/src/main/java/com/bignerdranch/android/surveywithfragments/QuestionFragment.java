package com.bignerdranch.android.surveywithfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by miked on 9/27/2016.
 */

//Suggest renaming this to 'QuestionFragment' or similar?

public class QuestionFragment extends Fragment {
    //refernece to my submit button
    private Button mSubmitButton;
//hopefully for tidying in the future to reset results when a new question is displayed
//    int yesCounter = 0;
//    int noCounter = 0;
    //interface and method for changeQuestion listener
    public interface ChangeQuestionListener{
        public void changeQuestion(String question, String answer1, String answer2);
    }//refernece to changeQuestionListener
    private ChangeQuestionListener mChangeQuestionListener;

    public static QuestionFragment newInstance(){
        return new QuestionFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ChangeQuestionListener){
            mChangeQuestionListener = (ChangeQuestionListener) activity;
        }else{
            throw new RuntimeException("Question Error message here...");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_question_activity, container, false);
        //variables for data being sent to survey activity for new qusetion and answers
        final EditText userInput = (EditText)view.findViewById(R.id.edit_text_box);
        final EditText answer1 = (EditText)view.findViewById(R.id.editText2);
        final EditText answer2 = (EditText)view.findViewById(R.id.editText3);
        //listener for submit button
        mSubmitButton = (Button) view.findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change the question and answers and clear edit text fields when submit is clicked
                mChangeQuestionListener.changeQuestion(
                        userInput.getText().toString(),
                        answer1.getText().toString(),
                        answer2.getText().toString());
                userInput.getText().clear();
                answer1.getText().clear();
                answer2.getText().clear();

            }
        });
        return view;
    }


}
