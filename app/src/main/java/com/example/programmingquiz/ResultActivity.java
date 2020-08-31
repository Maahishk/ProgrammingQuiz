package com.example.programmingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView result, correctans, wrongans, finalscore;
    Button exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        correctans=(TextView)findViewById(R.id.correct_txt);
        wrongans=(TextView)findViewById(R.id.wrong_txt);
        finalscore=(TextView)findViewById(R.id.final_score);
        exit_btn=(Button)findViewById(R.id.exit_result);


        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + PythonActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + PythonActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + PythonActivity.correct + "\n");
        correctans.setText(sb);
        wrongans.setText(sb2);
        finalscore.setText(sb3);

        PythonActivity.correct=0;
        PythonActivity.wrong=0;

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}