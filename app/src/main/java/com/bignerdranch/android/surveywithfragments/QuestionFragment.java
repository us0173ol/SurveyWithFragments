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

    private Button mSubmitButton;

    int yesCounter = 0;
    int noCounter = 0;

    public interface ChangeQuestionListener{
        public void changeQuestion(String question, String answer1, String answer2);
    }
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

        final EditText userInput = (EditText)view.findViewById(R.id.edit_text_box);
        final EditText answer1 = (EditText)view.findViewById(R.id.editText2);
        final EditText answer2 = (EditText)view.findViewById(R.id.editText3);

        mSubmitButton = (Button) view.findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
