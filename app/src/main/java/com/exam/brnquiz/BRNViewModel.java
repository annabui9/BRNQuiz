package com.exam.brnquiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class BRNViewModel extends ViewModel {
    private MutableLiveData<LinkedList<Integer>> correctAnswers = new MutableLiveData<>(new LinkedList<>());

    public BRNViewModel() {
        // No need to pass LiveData into constructor
    }

    public MutableLiveData<LinkedList<Integer>> getAnswers() {
        return correctAnswers;
    }

    public void addCorrect(Integer c) {
        LinkedList<Integer> l = correctAnswers.getValue();
        if (l != null) {
            l.add(c);
            correctAnswers.setValue(l);
        }
    }
}
