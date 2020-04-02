package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addClickListener();
    }

    private void addClickListener() {

        findViewById(R.id.submit_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.submit_btn:
                submitQuiz();
                break;

        }

    }

    private void submitQuiz() {

        getAnswer();

    }

    private void getAnswer() {

        String questionOneAnswer = getQuestionOneAnswer();
        String questionTwoAnswer = getQuestionTwoAnswer();
        ArrayList<String> questionThreeAnswer = getQuestionThreeAnswer();
        String questionFourAnswer = getQuestionFourAnswer();

    }


    private String getQuestionOneAnswer() {

        RadioGroup questionOneRadioGroup = findViewById(R.id.question_one_answer);
        int selectedRadioButtonid = questionOneRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonid);
        String questionOneAnswer = selectedRadioButton.getText().toString();

        return questionOneAnswer;
    }

    private String getQuestionTwoAnswer() {

        EditText questionTwoAnswerEditText = findViewById(R.id.question_two_answer);
        String questionTwoAnswer = questionTwoAnswerEditText.getText().toString();

        return questionTwoAnswer;
    }

    private ArrayList<String> getQuestionThreeAnswer() {

        ArrayList<String> questionThreeAnswer = new ArrayList<>();

        CheckBox checkBoxOne = findViewById(R.id.question_three_check_box_one);
        CheckBox checkBoxTwo = findViewById(R.id.question_three_check_box_two);
        CheckBox checkBoxThree = findViewById(R.id.question_three_check_box_three);
        CheckBox checkBoxFour = findViewById(R.id.question_three_check_box_four);

        if(checkBoxOne.isChecked())
            questionThreeAnswer.add(checkBoxOne.getText().toString());

        if(checkBoxTwo.isChecked())
            questionThreeAnswer.add(checkBoxTwo.getText().toString());

        if(checkBoxThree.isChecked())
            questionThreeAnswer.add(checkBoxThree.getText().toString());

        if(checkBoxFour.isChecked())
            questionThreeAnswer.add(checkBoxFour.getText().toString());

        return questionThreeAnswer;

    }

    private String getQuestionFourAnswer() {

        RadioGroup questionFourRadioGroup = findViewById(R.id.question_four_answer);
        int selectedRadioButtonid = questionFourRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonid);
        String questionFourAnswer = selectedRadioButton.getText().toString();

        return questionFourAnswer;

    }

}