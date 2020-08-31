package com.example.programmingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class JavaActivity extends AppCompatActivity {
    TextView txtquestion;
    Button confirm, quit;
    RadioGroup rg;
    RadioButton r1, r2, r3, r4;


    String questions[]={"Which of the following option leads to the portability and security of Java?",
            "Which of the following is not a Java features?",
            "_____ is used to find and fix bugs in the Java programs.",
            "Which of the following is a valid declaration of a char?",
            "What is the return type of the hashCode() method in the Object class?",
            "Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?",
            "Which of the following for loop declaration is not valid?",
            "Which method of the Class.class is used to determine the name of a class represented by the class object as a String?",
            "Which package contains the Random class?",
            "An interface with no fields or methods is known as a ______."
    };

    String ans[]={
            "Bytecode is executed by JVM",
            "Use of pointers",
            "JDB",
            "char ch = '\\utea';",
            "int",
            "Javadoc tool",
            "for ( int i = 99; i >= 0; i / 9 )",
            "getName()",
            "java.util package",
            "Marker Interface"
    };
    String opt[]={"Bytecode is executed by JVM", "The applet makes the Java code secure and portable", "Use of exception handling", "Dynamic binding between objects",
            "Dynamic", "Architecture Neutral","Use of pointers", "Object-oriented",
            "JVM", "JRE", "JDK", "JDB",
            "char ch = '\\utea';", "char ca = 'tea';", "char cr = \\u0223;", "char cc = '\\itea';",
            "Object","int","long","void",
            "javap tool","Javadoc tool","javah command","javaw ",
            "for ( int i = 7; i <= 77; i += 7 )","for ( int i = 99; i >= 0; i / 9 )","for ( int i = 20; i >= 2; - -i )","for ( int i = 2; i <= 20; i = 2* i )",
            "getClass()","getName()","intern()","toString()",
            "java.util package","java.lang package","java.awt package","java.io package",
            "Runnable Interface", "Marker Interface","Abstract Interface","CharSequence Interface"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        final TextView score = (TextView)findViewById(R.id.numtxt);

        confirm=(Button)findViewById(R.id.confirm_btn);
        quit=(Button)findViewById(R.id.quit_btn);
        txtquestion=(TextView) findViewById(R.id.questions);

        rg=(RadioGroup)findViewById(R.id.radiogroup);
        r1=(RadioButton)findViewById(R.id.option1);
        r2=(RadioButton)findViewById(R.id.option2);
        r3=(RadioButton)findViewById(R.id.option3);
        r4=(RadioButton)findViewById(R.id.option4);

        txtquestion.setText(questions[flag]);
        r1.setText(opt[0]);
        r2.setText(opt[1]);
        r3.setText(opt[2]);
        r4.setText(opt[3]);

        // answer confirmation
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton userans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String ansText = userans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(ans[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    txtquestion.setText(questions[flag]);
                    r1.setText(opt[flag*4]);
                    r2.setText(opt[flag*4 +1]);
                    r3.setText(opt[flag*4 +2]);
                    r4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(), javaResultActivity.class);
                    startActivity(in);
                }
                rg.clearCheck();

            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), javaResultActivity.class);
                startActivity(intent);
            }
        });

    }
}