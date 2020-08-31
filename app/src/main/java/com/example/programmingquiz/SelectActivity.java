package com.example.programmingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        //display user name
        TextView textView=(TextView)findViewById(R.id.disname);
        Intent intent = getIntent();
        final String name= intent.getStringExtra("myname");
        textView.setText("Welcome to the Quiz "+name);

        final Button db= (Button)findViewById(R.id.db_btn);
        final Button machinel= (Button)findViewById(R.id.ml_btn);
        final Button laravel= (Button)findViewById(R.id.laravel_btn);
        final Button php= (Button)findViewById(R.id.php_btn);
        final Button java= (Button)findViewById(R.id.java_btn);
        //python button work
        final Button python= (Button)findViewById(R.id.python_btn);
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), PythonActivity.class);
               startActivity(intent);
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), JavaActivity.class);
                startActivity(intent);
            }
        });
    }
}