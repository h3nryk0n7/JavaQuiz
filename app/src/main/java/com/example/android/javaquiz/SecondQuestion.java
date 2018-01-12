package com.example.android.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SecondQuestion extends AppCompatActivity {
    // Initializing Variables
    int score = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_second);

        // Receiving data from previous Activity with a bundle
        Intent i = getIntent();
        final Bundle bundle = i.getExtras();
        final String name = bundle.getString("name");
        final String email = bundle.getString("email");
        score = bundle.getInt("score");

        // Initializing nextButton object
        Button btnNextScreen = (Button) findViewById(R.id.nextButton2);

        // Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), ThirdQuestion.class);

                // Checking if correct answers are checked and if yes adding one point to the score
                CheckBox question2CB1 = (CheckBox) findViewById(R.id.question2Answer1);
                CheckBox question2CB2 = (CheckBox) findViewById(R.id.question2Answer2);
                CheckBox question2CB3 = (CheckBox) findViewById(R.id.question2Answer3);
                CheckBox question2CB4 = (CheckBox) findViewById(R.id.question2Answer4);

                if (question2CB2.isChecked()) {

                    if (question2CB3.isChecked()) {

                        if (question2CB1.isChecked()) {



                        } else if (question2CB4.isChecked()) {



                        } else {

                            score += 1;

                        }

                    }

                }

                // Sending data to next Activity with a bundle
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("email", email);
                bundle.putInt("score", score);
                nextScreen.putExtras(bundle);

                // Continuing to next Activity
                startActivity(nextScreen);

            }
        });

    }

}
