package com.exam.brnquiz;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class QuizActivity extends AppCompatActivity {

    private FragmentManager fg;
    private QuestionFragment qFrag;
    private ScoreFragment sFrag;
    private BRNViewModel brnModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if(savedInstanceState == null){
            fg = getSupportFragmentManager();
            FragmentTransaction trans = fg.beginTransaction();
            qFrag = new QuestionFragment();
            trans.add(R.id.quizFrag, qFrag, "questionFragment");
            sFrag = new ScoreFragment();
            trans.add(R.id.scoreFrag, sFrag, "scoreFragment");
            trans.commit();

        }



    }
}