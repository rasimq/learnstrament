package com.example.talha.learnstrument;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                        "Which of the following is not a wind instrument?",
                        "Which of the following is not a percussion instrument?",
                        "Which of the following is not a key instrument?",
                        "Which of the following is not a string instrument?",
                        "Which of the following is a blown instrument?",
                        "Which of the following is a percussion instrument?",
                        "Which of the following is a keystroke instrument?",
                        "Which of the following is a string instrument?",
                        "Which of the following is not characteristic of wind instruments?",
                        "Which of the following is not characteristic of percussion instruments?",
                        "Which of the following is not a feature of key instruments?",
                        "Which of the following is not characteristic of string instruments?",
                        "Which of the following are characteristic of wind instruments?",
                        "Which of the following is characteristic of percussion instruments?",
                        "Which of the following are the features of key instruments?",
                        "Which of the following are characteristics of string instruments?",
                        "Which of the following is an instrument?",
                        "Which of the following is not an instrument?",
                        "What is the instrument?",
                        "Which of the following is not an instrument type?"
                         };
    String answers[] = {"Darbuka", "Violin", "Saxophone", "Drum", "Clarinet", "Drum", "Piano", "Violin", "It is played through the nose", "Blown through", "The keys must be made of plastic" , "It is played by breathing", "Played with the keys", "It is quite difficult compared to other instruments", "It is quite difficult compared to other instruments", "It makes sound through vibrations on a bow", "Saxophone", "Drill","Musical instrument","Jumping instruments"};
    String opt[] = {
                    "Clarinet", "Saxophone", "Zurna", "Darbuka",
                    "Drum", "Bell", "Violin", "Darbuka",
                    "Organ", "Piano", "Saxophone", "Ukulele",
                    "Drum", "Electric Guitar", "Violin", "Cello",
                    "Clarinet", "Piano", "Darbuka", "Guitar",
                    "Piano.", "Drum", "Violin", "Clarinet",
                    "Piano", "Darbuka", "Cymbal", "Drum",
                    "Drum", "Violin", "Clarinet", "Drum",
                    "It can be played orally", "It has air channels", "It can be seen that it is produced from trees", "It is played through the nose",
                    "It is played with an object or hand blow", "It is played with blowing", "Blown through", "It makes other instruments stand out",
                    "It can be played with the help of a hand", "The keys must be made of plastic", "It is an instrument that is very prone to electronic music", "It is a polyphonic instrument.",
                    "It is usually played with the help of an equipment.", "It is played by breathing", "It has wires", "It all consists of one piece",
                    "It works with the help of a hand or another instrument", "Played with the mouth", "Played with a bow", "Played with the keys",
                    "It is quite difficult compared to other instruments", "It can be played with the help of a baguette", "It must be wooden", "It is in the wind instrument family",
                    "It is quite difficult compared to other instruments", "It can be played with the help of a baguette", "It must be wooden", "It is in the wind instrument family",
                    "It makes sound through vibrations on a bow", "It has air channels", "It is in the family of musical instruments", "It cannot be combined with electronic music",
                    "Typewriter", "Calculator", "Table", "Saxophone",
                    "Drum", "Piano", "Drill", "Guitar",
                    "Musical instrument", "Programming language", "Car brand", "A city name",
                    "Wind instruments", "Strings", "Keyed instruments", "Jumping instruments"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
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
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}