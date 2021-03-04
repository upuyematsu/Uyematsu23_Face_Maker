package com.example.uyematsu_alec_homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
/**
 * <!-- class MainActivity -->
 *
 * Defines the SeekBars, Button, Spinner, and RadioGroup/RadioButtons
 *
 * @author <Alec Uyematsu>
 * @version March 2020
 */
public class MainActivity extends AppCompatActivity{

    private Face myFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFace = findViewById(R.id.surfaceView);
        final FaceController faceController = new FaceController(myFace);

        //seekBar
        SeekBar redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        SeekBar blueSeekBar = (SeekBar)  findViewById(R.id.blueSeekBar);

        redSeekBar.setOnSeekBarChangeListener(faceController);
        greenSeekBar.setOnSeekBarChangeListener(faceController);
        blueSeekBar.setOnSeekBarChangeListener(faceController);

        //Random Face
        Button randomFaceButton = findViewById(R.id.randomFace);
        randomFaceButton.setOnClickListener(faceController);

        //radio group
        RadioGroup radioGroup = findViewById(R.id.hairEyesSkinGroup);
        radioGroup.setOnCheckedChangeListener(faceController);


        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(faceController);
    }

}