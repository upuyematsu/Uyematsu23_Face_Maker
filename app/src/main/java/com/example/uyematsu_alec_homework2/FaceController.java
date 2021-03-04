package com.example.uyematsu_alec_homework2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
/**
 * <!-- class FaceController -->
 *
 * This class is used to handel all of the methods from the SeekBar, Button, RadioGroup, and Spinner
 * This Class also creates a new FaceModel and sets variables from each method to the FaceModel object
 *
 * @author <Alec Uyematsu>
 * @version March 2020
 */

public class FaceController implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private Face face;
    private FaceModel faceModel;

    //Constructor
    public FaceController(Face face){
        this.face = face;
        this.faceModel = this.face.getFaceModel();
    }

    /*
    *
    * ALL METHODS CALL INVALIDATE IN ORDER TO REDRAW THE FACE
    *
     */

    //seekBar
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //switch to set each progess to a color
        switch (seekBar.getId()) {
            case R.id.blueSeekBar:
                this.faceModel.blue = progress;
                face.invalidate();
            case R.id.redSeekBar:
                this.faceModel.red = progress;
                face.invalidate();
            case R.id.greenSeekBar:
                this.faceModel.green = progress;
                face.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    //Random face button
    @Override
    public void onClick(View v) {
        this.faceModel.hit = true; //if hit sets to true
        face.invalidate();
    }

    //Radio Group
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //if statement to set an int to which radioButton is selected
        if(checkedId == R.id.hair) { //hair id
            this.faceModel.hairSkinEyes = 1;
            face.invalidate();
        }
        else if(checkedId == R.id.skin) {//skin
            this.faceModel.hairSkinEyes = 2;
            face.invalidate();
        }

        else if(checkedId == R.id.eyes){//eyes
            this.faceModel.hairSkinEyes = 3;
            face.invalidate();
        }
    }


    //Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String hair = parent.getItemAtPosition(position).toString();
        //if statement to get int based on which spinner item is selected
        if(hair.equals("Bald") == true){
            this.faceModel.hairType = 1;
            face.invalidate();
        }
        else if(hair.equals("Afro") == true){
            this.faceModel.hairType = 2;
            face.invalidate();
        }
        else if(hair.equals("Hat") == true){
            this.faceModel.hairType = 3;
            face.invalidate();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
