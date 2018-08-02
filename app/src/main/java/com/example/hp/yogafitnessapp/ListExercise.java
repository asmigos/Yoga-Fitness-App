package com.example.hp.yogafitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.yogafitnessapp.Adapter.RecyclerViewAdapter;
import com.example.hp.yogafitnessapp.Model.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ListExercise extends AppCompatActivity {

    List<Exercise> exerciseList =  new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercise);

        initData();

        recyclerView = findViewById(R.id.list_ex);
        adapter = new RecyclerViewAdapter(exerciseList, getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        exerciseList.add(new Exercise(R.drawable.yoga1, "Yoga1"));
        exerciseList.add(new Exercise(R.drawable.yoga2, "Yoga2"));
        exerciseList.add(new Exercise(R.drawable.yoga3, "Yoga3"));
        exerciseList.add(new Exercise(R.drawable.yoga4, "Yoga4"));
        exerciseList.add(new Exercise(R.drawable.yoga5, "Yoga5"));
        exerciseList.add(new Exercise(R.drawable.yoga6, "Yoga6"));
    }
}
