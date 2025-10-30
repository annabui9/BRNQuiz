package com.exam.brnquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class IntroActivity extends AppCompatActivity {
    Button startB;
    private String[] colors;
    private BRNViewModel brnModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //colors = getResources().getStringArray(R.color)
        startB = findViewById(R.id.beginB);
        startB.setOnClickListener(buttonListener);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    View.OnClickListener buttonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(IntroActivity.this, QuizActivity.class);
            startActivity(intent);
        }
    };

    public void changeColor(){


    }



}
