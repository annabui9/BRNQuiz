package com.exam.brnquiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class QuestionFragment extends Fragment {

    private TextView tvQuestion;
    private ListView lvAnswers;
    private Button submitButton;
    private int choiceIndex;
    private Question question;
    private int selectedIndex = -1;
    private BRNViewModel brnModel;


    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);
        tvQuestion = getView().findViewById(R.id.tvQuestion);
        lvAnswers = getView().findViewById(R.id.lvAnswers);
        submitButton = getView().findViewById(R.id.btnSubmit);
        brnModel = new ViewModelProvider(requireActivity()).get(BRNViewModel.class);


        question = new Question("What is the capital of Colombia",
                Arrays.asList("Medellin", "Madrid", "Paris", "Bogota"),
                3);

        tvQuestion.setText(question.getQuestionText());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_single_choice,
                question.getOptions()
        );
        lvAnswers.setAdapter(adapter);



        return view;


    }

    View.OnClickListener submitButtonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if (selectedIndex == -1) {
                Toast.makeText(requireContext(), "Select an answer first!", Toast.LENGTH_SHORT).show();
                return;
            }
            if(selectedIndex == question.getCorrectIndex()){
                Toast.makeText(requireContext(), "Yay +1 Point", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(requireContext(), "Wrong! Use your BRN(AI)", Toast.LENGTH_SHORT).show();

            }
        }
    };
}