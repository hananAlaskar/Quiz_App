package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String[] MODEL_ANSWERS = {"a student","First In First Out","Lisp, Erlang, Haskell","False"};

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

        if (view.getId() == R.id.submit_btn)
            submitQuiz();
    }

    private void submitQuiz() {

        Toast.makeText(this,"Your Grade: "+calculateGrade(getAnswer()),Toast.LENGTH_LONG).show();
    }


    private String[] getAnswer() {

        String questionOneAnswer = getQuestionOneAnswer();
        String questionTwoAnswer = getQuestionTwoAnswer();
        String questionThreeAnswer = getQuestionThreeAnswer();
        String questionFourAnswer = getQuestionFourAnswer();

        String[] answers = {questionOneAnswer,questionTwoAnswer,questionThreeAnswer,questionFourAnswer};
        return answers;
    }


    private String getQuestionOneAnswer() {

        RadioGroup questionOneRadioGroup = findViewById(R.id.question_one_answer);
        int selectedRadioButtonId = questionOneRadioGroup.getCheckedRadioButtonId();

        if(selectedRadioButtonId != -1 ){
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String questionOneAnswer = selectedRadioButton.getText().toString();

            return questionOneAnswer;
        }


        return null;
    }

    private String getQuestionTwoAnswer() {

        EditText questionTwoAnswerEditText = findViewById(R.id.question_two_answer);
        Object questionTwoAnswer = questionTwoAnswerEditText.getText();

        if(questionTwoAnswer != null)
            return questionTwoAnswer.toString();
        else
            return null;
    }

    private String getQuestionThreeAnswer() {

        String questionThreeAnswer = "";

        CheckBox checkBoxOne = findViewById(R.id.question_three_check_box_one);
        CheckBox checkBoxTwo = findViewById(R.id.question_three_check_box_two);
        CheckBox checkBoxThree = findViewById(R.id.question_three_check_box_three);
        CheckBox checkBoxFour = findViewById(R.id.question_three_check_box_four);

        if(checkBoxOne.isChecked())
            questionThreeAnswer += checkBoxOne.getText().toString()+", ";

        if(checkBoxTwo.isChecked())
            questionThreeAnswer += checkBoxTwo.getText().toString()+", ";

        if(checkBoxThree.isChecked())
            questionThreeAnswer += checkBoxThree.getText().toString()+", ";

        if(checkBoxFour.isChecked())
            questionThreeAnswer += checkBoxFour.getText().toString()+", ";

        return questionThreeAnswer;

    }

    private String getQuestionFourAnswer() {

        RadioGroup questionFourRadioGroup = findViewById(R.id.question_four_answer);
        int selectedRadioButtonId = questionFourRadioGroup.getCheckedRadioButtonId();

        if(selectedRadioButtonId != -1 ){
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String questionFourAnswer = selectedRadioButton.getText().toString();
            return questionFourAnswer;
        }

        return null;

    }


    private double calculateGrade(String[] answers) {

        double grade = 0;

        for (int i = 0; i < answers.length; i++){

            if (i != 2) {
                if (answers[i] == null)
                    grade += 0;
                else if (answers[i].toLowerCase().equals(MODEL_ANSWERS[i].toLowerCase()))
                    grade += 1;
            }else {
                    grade += calculateGradeForQuestionThree(answers[i]);
                }
        }

        return grade;
    }

    private double calculateGradeForQuestionThree(String answer) {

        double grade = 0;
        int numberOFCorrectAnswers = MODEL_ANSWERS[2].split(",").length;


        if(answer.length() == 0)
            return 0;

        String[] answers = answer.split(",");


        for(int i = 0 ; i < answers.length-1; i++)
            if (MODEL_ANSWERS[2].contains(answers[i]))
                grade += 1;


        if(answers.length-1 > numberOFCorrectAnswers)
            grade -= 1;

        return grade/ numberOFCorrectAnswers;

    }

}