package com.example.uyematsu_alec_homework2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * <!-- Face -->
 *
 * This class is used to draw the face onto the SurfaceView.
 * This class uses methods to set paints, draw features and the OnDraw to draw to the SurfaceView
 *
 * @author <Alec Uyematsu>
 * @version March 2020
 */

public class Face extends SurfaceView {

    private FaceModel faceModel;

    //creates new paints
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();

    //constructor for Face
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.faceModel = new FaceModel();
        setWillNotDraw(false); //so OnDraw method doesn't get called
        setBackgroundColor(Color.WHITE);
    }

    //getter for FaceModel
    public FaceModel getFaceModel(){return this.faceModel;}


    /*
    *
    * 3 methods do get different color for the skin, eye, and hair.
    *
     */
    public void skinPaint(float r, float g, float b){
        Paint myPaint = new Paint();
        if(this.faceModel.hairSkinEyes == 2) { //int value for skin
            //gets int value from rgb
            int rgb = android.graphics.Color.rgb(r, g, b); //https://stackoverflow.com/questions/18022364/how-to-convert-rgb-color-to-int-in-java
            myPaint.setColor(rgb);
            this.skinPaint = myPaint; //sets skinPaint to paint just created
            skinPaint.setStyle(Paint.Style.FILL);
        }
    }
    public void eyePaint(float r, float g, float b){
        Paint myPaint = new Paint();
        if(this.faceModel.hairSkinEyes == 3) { //int value for eye
            //gets int value from rgb
            int rgb = android.graphics.Color.rgb(r, g, b); //https://stackoverflow.com/questions/18022364/how-to-convert-rgb-color-to-int-in-java
            myPaint.setColor(rgb);
            this.eyePaint = myPaint;
            eyePaint.setStyle(Paint.Style.FILL);
        }
    }
    public void hairPaint(float r, float g, float b){
        Paint myPaint = new Paint();
        if(this.faceModel.hairSkinEyes == 1) { //int value for hair
            //gets int value from rgb
            int rgb = android.graphics.Color.rgb( r, g, b); //https://stackoverflow.com/questions/18022364/how-to-convert-rgb-color-to-int-in-java
            myPaint.setColor(rgb);
            this.hairPaint = myPaint;
            hairPaint.setStyle(Paint.Style.FILL);
        }
    }

    //Method to draw eye
    public void drawEye(Canvas canvas, float x, float y, Paint myPaint){
        Paint white = new Paint();
        white.setColor(Color.WHITE);
        canvas.drawCircle(x,y ,30, white); //draws eye white
        canvas.drawCircle(x, y, 15, myPaint); //draws pupil
    }
    //Method to draw skin
    public void drawSkin(Canvas canvas, int left, int top, int right, int bottom, Paint myPaint){
        canvas.drawOval(left, top, right, bottom, myPaint);
    }
    //Method to draw Hiar
    public void drawHair(Canvas canvas, int hair, Paint myPaint){
        //bald
        if(hair == 1){
            return;
        }
        //Afro
        else if(hair == 2){
            canvas.drawCircle(550, 150, 500, myPaint);
        }
        //hat
        else if(hair == 3){
            canvas.drawRect(300, 100,800,200, myPaint);
            canvas.drawRect(400,50,700,200, myPaint);
        }
    }

    //Method that draws a random face
    public void randomFace(Canvas canvas){
        Random rand = new Random();

        //generating random hair color
        int hairInt = android.graphics.Color.rgb((float) rand.nextInt(255), (float) rand.nextInt(255), (float) rand.nextInt(255));
        Paint hairPaint = new Paint();
        hairPaint.setColor(hairInt);
        this.hairPaint = hairPaint;
        //generating random eye color
        int eyeInt = android.graphics.Color.rgb((float) rand.nextInt(255), (float) rand.nextInt(255), (float) rand.nextInt(255));
        Paint eyePaint = new Paint();
        eyePaint.setColor(eyeInt);
        this.eyePaint = eyePaint;
        //generating random skin color
        int faceInt = android.graphics.Color.rgb((float) rand.nextInt(255), (float) rand.nextInt(255), (float) rand.nextInt(255));
        Paint facePaint = new Paint();
        facePaint.setColor(faceInt);
        this.skinPaint = facePaint;

        //draw random face
        drawSkin(canvas, 300, 100, 800, 700, this.skinPaint);


        int random = rand.nextInt(3) + 1; //gives us random number from 1-3
        //drawing hair
        drawHair(canvas, random, this.hairPaint);
        //draws both eyes
        drawEye(canvas, 450, 250, this.eyePaint);
        drawEye(canvas, 650, 250, this.eyePaint);


    }
    //onDraw method to print face to SurfaceView
    protected void onDraw(Canvas canvas){
        //set paints
        eyePaint(this.faceModel.red, this.faceModel.green, this.faceModel.blue);
        skinPaint(this.faceModel.red, this.faceModel.green, this.faceModel.blue);
        hairPaint(this.faceModel.red, this.faceModel.green, this.faceModel.blue);

            //draws random face when hit
            if(this.faceModel.hit == true) {
                randomFace(canvas);
                this.faceModel.hit = false;
            }

            //drawing face
            drawHair(canvas, this.faceModel.hairType, this.hairPaint);
            drawSkin(canvas, 300, 100, 800, 700, this.skinPaint);
            drawEye(canvas, 450, 250, this.eyePaint);
            drawEye(canvas, 650, 250, this.eyePaint);

    }
}
