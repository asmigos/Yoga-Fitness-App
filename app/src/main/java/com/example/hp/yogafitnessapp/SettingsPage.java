package com.example.hp.yogafitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.hp.yogafitnessapp.Database.YogaDB;

public class SettingsPage extends AppCompatActivity {

    Button btnSave;
    RadioButton rdiEasy, rdiMedium, rdiHard;
    RadioGroup rdiGroup;
    YogaDB yogaDB;
    ToggleButton switchAlarm;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        //init view
        btnSave = findViewById(R.id.btnSave);
        rdiGroup = findViewById(R.id.rdiGroup);
        rdiEasy = findViewById(R.id.rdiEasy);
        rdiMedium = findViewById(R.id.rdiMedium);
        rdiHard = findViewById(R.id.rdiHard);
        switchAlarm = findViewById(R.id.switchAlarm);
        timePicker = findViewById(R.id.timePicker);

        yogaDB = new YogaDB(this);

        int mode = yogaDB.getSettingMode();
        setRadioButton(mode);

        //Event
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWorkoutMode();
            }
        });
    }

    private void saveWorkoutMode() {
    }

    private void setRadioButton(int mode) {
        if(mode == 0)
            rdiGroup.check(R.id.rdiEasy);
        else if (mode == 1)
            rdiGroup.check(R.id.rdiMedium);
        else if(mode == 2)
            rdiGroup.check(R.id.rdiHard);
    }
}
