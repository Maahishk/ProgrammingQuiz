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

public class PythonActivity extends AppCompatActivity {
    TextView txtquestion;
    Button confirm, quit;
    RadioGroup rg;
    RadioButton r1, r2, r3, r4;


    String questions[]={"Which of the following is an invalid statement?",
            "What is the maximum possible length of an identifier?",
            "Write a sorting algorithm for a numerical dataset in Python.",
            "Which statement is correct....??",
            "print(chr(ord('b')+1))",
            " The format function, when applied on a string returns :",
            "class test:\n" +
                    "   def __init__(self):\n" +
                    "      print \"Hello World\"\n" +
                    "   def __init__(self):\n" +
                    "      print \"Bye World\"\n" +
                    "obj=test(",
            "What is correct syntax to copy one list into another?",
            "If a='cpp', b='buzz' then what is the output of:\n" +
                    "c = a-b\n" +
                    "print(c)",
            "Which of the following print statements will print all the names in the list on a seperate line\n" +
                    "names = ['Ramesh', 'Rajesh', 'Roger', 'Ivan', 'Nico']"
    };

    String ans[]={
            "a b c = 1000 2000 3000",
            "None of the above",
            "list = [\"1\", \"4\", \"0\", \"6\", \"9\"]",
            "List is mutable && Tuple is immutable",
            "c",
            "str",
            "Bye World",
            "listA = listB[:]",
            "TypeError: unsupported operand",
            "print(\" \".join(names))"
    };
    String opt[]={"abc = 1,000,000", "a b c = 1000 2000 3000", "a,b,c = 1000, 2000, 3000", " a_b_c = 1,000,000",
            "32 characters", "63 characters","79 characters", "None of the above",
            "list = [\"1\", \"4\", \"0\", \"6\", \"9\"]", "list = [int(i) for i in list]", "list.sort()", "print (list)",
            "List is mutable && Tuple is immutable", " List is immutable && Tuple is mutable", "Both are Immutable", "Both are Mutable",
            "b","syntax error","c","b+1",
            "bool","list","str","int",
            "Compilation error","Hello World","Bye World","Ambiguity",
            "listA = listB[]","listA = listB[:]","listA = listB[]()","listA = listB",
            "cpp-buzz","cppbuzz","TypeError: unsupported operand","None of the above",
            "print(names.append(\" \"))", "print(names.join(\"%s \", names))","print(\" \".join(names))","print(names.concatenate(\" \"))"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);

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
                    Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(in);
                }
                rg.clearCheck();

            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);
            }
        });

    }
}