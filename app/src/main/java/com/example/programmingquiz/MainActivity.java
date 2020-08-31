package com.example.programmingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startbtn= (Button)findViewById(R.id.start_btn);
        Button about=(Button)findViewById(R.id.about_btn);
        final EditText nametxt= (EditText)findViewById(R.id.edit_name);
            startbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = nametxt.getText().toString();
                    if (name.trim().isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                        intent.putExtra("myname", name);
                        startActivity(intent);
                    }
                }
            });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), DeveloperActivity.class);
                startActivity(intent);
            }
        });

    }
}