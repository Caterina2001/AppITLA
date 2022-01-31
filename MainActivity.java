package com.example.apptema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.Layout;
import android.text.style.BackgroundColorSpan;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<myTextClick> extends AppCompatActivity {

    WindowManager wm;
    Point screen;
    Display display;
    TextView t100;
    TextView t50;
    TextView t20;
    TextView t10;
    TextView t5;
    BackgroundColorSpan color;
    View layout;

    EditText eText;

    private Object myTextClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    layout=findViewById(R.id.lf);
    wm=getWindowManager();
    display=wm.getDefaultDisplay();
    screen=new Point();
    display.getSize(screen);
    }

    public void clickTextView(View view) {

        switch(view.getId()){
            case R.id.tv1: uno();break;
            case R.id.tv2: dos(); break;
            case R.id.tv3: tres(); break;
            case R.id.tv4: cuatro(); break;
            case R.id.tv5: cinco(); break;
        }
    }

    public void uno(){
        layout.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
    }
    public void dos(){
        layout.setBackgroundColor(Color.parseColor("#605E5E"));
    }
    public void tres(){
        layout.setBackgroundColor(Color.parseColor("#454141"));
    }
    public void cuatro(){
        layout.setBackgroundColor(Color.parseColor("#2E2C2C"));
    }
    public void cinco(){
        layout.setBackgroundColor(Color.parseColor("#0B0A0A"));
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        t100=findViewById(R.id.txt100);
        t50=findViewById(R.id.text50);
        t20=findViewById(R.id.text20);
        t10=findViewById(R.id.text10);
        t5=findViewById(R.id.text5);
        eText=findViewById(R.id.txtInput);

        String str = eText.getText().toString();
        int num1= 0;
        int num2= 0;
        int num3= 0;
        double num4= 0;
        double num5= 0;

        int action = event.getAction();
        int keyCode = event.getKeyCode();
        int cont = 0;
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    cont++;
                    num1= Integer.parseInt(str)/100;
                    t100.setText("Billetes de 100: "+ num1);
                    num2= Integer.parseInt(str)/50;
                    t50.setText("Billetes de 50: "+num2);
                    num3= Integer.parseInt(str)/20;
                    t20.setText("Monedas de 20: "+num3);
                    num4= Integer.parseInt(str)/0.01; //10 centavos
                    t10.setText("Monedas de 10¢: "+num4);
                    num5= Integer.parseInt(str)/0.005; //5 centavos
                    t5.setText("Monedas de 5¢: "+num5);
                }
            default:
                return super.dispatchKeyEvent(event);
        }
    }
float x1,x2,y1,y2;
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1= touchEvent.getX();
                y1=touchEvent.getY();
                break;

            case MotionEvent.ACTION_UP:
                x2=touchEvent.getX();
                y2=touchEvent.getY();
                if(x1<x2){
                    Toast.makeText(MainActivity.this, "Aplicacion cerrada", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Datos Borrados", Toast.LENGTH_SHORT).show();
                    eText.setText("");
                    t100.setText("");
                    t50.setText("");
                    t20.setText("");
                    t10.setText("");
                    t5.setText("");
                }
                break;
        }
        return false;
    }
}

