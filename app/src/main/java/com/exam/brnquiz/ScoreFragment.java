package com.exam.brnquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {


    private BRNViewModel brnModel;


    public ScoreFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //scoreTV =
        brnModel = new ViewModelProvider(requireActivity()).get(BRNViewModel.class);
        brnModel.getAnswers().observe(getViewLifecycleOwner(), list -> {
            int score = list.size();
            //scoreTV.setText("Score: " + score);
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }
}