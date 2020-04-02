package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
}