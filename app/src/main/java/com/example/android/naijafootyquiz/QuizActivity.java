package com.example.android.naijafootyquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {

    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        // Font path for submit button text
        String fontPath = "fonts/kaffeesatz_schwarz.otf";

        // text view label
        TextView txtGhost = (TextView) findViewById(R.id.submit_button);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        txtGhost.setTypeface(tf);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitQuiz(View view) {
        //Get CheckBox details
        CheckBox vincentCheckBox = (CheckBox) findViewById(R.id.q7_optionA);
        boolean hasOption7A = vincentCheckBox.isChecked();
        CheckBox yoboCheckBox = (CheckBox) findViewById(R.id.q7_optionC);
        boolean hasOption7C = yoboCheckBox.isChecked();

        //Get RadioButton details
        RadioButton q1RadioButton, q2RadioButton, q3RadioButton, q4RadioButton, q5RadioButton,
                q6RadioButton, q8RadioButton, q10RadioButton;

        q1RadioButton = (RadioButton) findViewById(R.id.option1b);
        boolean hasOption1b = q1RadioButton.isChecked();

        q2RadioButton = (RadioButton) findViewById(R.id.option2c);
        boolean hasOption2c = q2RadioButton.isChecked();

        q3RadioButton = (RadioButton) findViewById(R.id.option3a);
        boolean hasOption3a = q3RadioButton.isChecked();

        q4RadioButton = (RadioButton) findViewById(R.id.option4b);
        boolean hasOption4b = q4RadioButton.isChecked();

        q5RadioButton = (RadioButton) findViewById(R.id.option5a);
        boolean hasOption5a = q5RadioButton.isChecked();

        q6RadioButton = (RadioButton) findViewById(R.id.option6a);
        boolean hasOption6a = q6RadioButton.isChecked();

        q8RadioButton = (RadioButton) findViewById(R.id.option8a);
        boolean hasOption8a = q8RadioButton.isChecked();

        q10RadioButton = (RadioButton) findViewById(R.id.option10b);
        boolean hasOption10b = q10RadioButton.isChecked();

        EditText textInputField = (EditText) findViewById(R.id.edit_Text_Field);
        Editable textEntryLine = textInputField.getText();

        EditText answerInputField = (EditText) findViewById(R.id.q9_Answer_Field);
        String answerEntryLine = answerInputField.getText().toString();

        int finalScore = calculateScore (hasOption1b, hasOption2c, hasOption3a,  hasOption4b,
        hasOption5a, hasOption6a, hasOption7A, hasOption7C, hasOption8a, hasOption10b,
        answerEntryLine );

        Toast.makeText(this, "Good Job " + textEntryLine + "!" + "\n" + "Your total score is " + finalScore + "%", Toast.LENGTH_LONG).show();
        //exit this method early because there's nothing left to show

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
    }

    /**
     * This method calculates total score based on correct checkboxes
     * radio buttons and text input
     */
    private int calculateScore(boolean hasOption1b, boolean hasOption2c, boolean hasOption3a, boolean hasOption4b,
    boolean hasOption5a, boolean hasOption6a, boolean hasOption7A, boolean hasOption7C, boolean hasOption8a,
    boolean hasOption10b, String answerEntryLine) {

// add ten marks if option 1b is chosen
        if (hasOption1b) {
            totalScore += 10;
        }
// add ten marks if option 2c is chosen
        if (hasOption2c) {
            totalScore += 10;
        }
// add ten marks if option 3a is chosen
        if (hasOption3a) {
            totalScore += 10;
        }
// add ten marks if option 4b is chosen
        if (hasOption4b) {
            totalScore += 10;
        }
// add ten marks if option 5a is chosen
        if (hasOption5a) {
            totalScore += 10;
        }
// add ten marks if option 6a is chosen
        if (hasOption6a) {
            totalScore += 10;
        }
// add five marks if option 7a is chosen
        if (hasOption7A) {
            totalScore += 5;
        }
// add five marks if option 7c is chosen
        if (hasOption7C) {
            totalScore += 5;
        }
// add ten marks if option 8a is chosen
        if (hasOption8a) {
            totalScore += 10;
        }
// add ten marks if option 10b is chosen
        if (hasOption10b) {
            totalScore += 10;
        }
// add ten marks if correct coach name is given
        if (answerEntryLine.equalsIgnoreCase("Gernot Rohr")){
            totalScore += 10;
        }
        return totalScore;
    }

}