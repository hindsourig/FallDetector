package com.example.alhadi.heeder;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Math.acos;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Start extends AppCompatActivity implements SensorEventListener {

    private static final float M_PI = (float) 3.14;
    private float lastX, lastY, lastZ;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private TextView textView8, textView9, textView10,textView6 ;

    private float[] SV = new float [100];//={0};// (100);// = {0};
    private int count=0;
    float sv;
    static float Csv=12;
    public float max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initializeViews();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        //SV={0};
    }

    public void initializeViews() {

        textView8 = (TextView) findViewById(R.id.textView8);

        textView9 = (TextView) findViewById(R.id.textView9);

        textView10 = (TextView) findViewById(R.id.textView10);

        textView6 = (TextView) findViewById(R.id.textView6);
    }

    //onResume() register the accelerometer for listening the events

    protected void onResume() {

        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);

    }

    //onPause() unregister the accelerometer for stop listening the events

    protected void onPause() {

        super.onPause();
        sensorManager.unregisterListener(this);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
// clean current values
        displayCleanValues();
        // display the current x,y,z accelerometer values
        displayCurrentValues();

        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];
        sv= (float) sqrt(Math.abs(lastX)*Math.abs(lastX) +
                Math.abs(lastY)*Math.abs(lastY) + Math.abs(lastZ)*Math.abs(lastZ));
        SV[count++]=sv;
        count=count%100;


    }
    public void displayCleanValues() {

        textView8.setText("0.0");

        textView9.setText("0.0");

        textView10.setText("0.0");

    }
    // display the current x,y,z accelerometer values

    public void displayCurrentValues() {

        textView8.setText(Float.toString(lastX));

        textView9.setText(Float.toString(lastY));

        textView10.setText(Float.toString(lastZ));
        textView6.setText(Float.toString(fallSV()));



    }
    //reading every 2 seconds
    //keep calculating immediately
    public float fallSV (){
        float max=  SV[0];
        for (int i=1;i<100;i++){
            if (SV[i] > max){
                max=  SV[i];
            }
        }
        if ( max > Csv){
            new SMS().execute(null, null, null);
            return max;
        }
        else {
            return 0;
        }
    }

    public void send_message() {
        SmsManager sms = SmsManager.getDefault();
        //how to call it??
        String number = getPhoneNumber();//the number you want to send to and must b called from picked contact
        sms.sendTextMessage(number, null, "the message to be sent", null, null);

    }
    public String getPhoneNumber(){
        SharedPreferences sharedPref = getSharedPreferences("app", Context.MODE_PRIVATE);
        String phoneNum =  sharedPref.getString("phone", "0991008201");
        Log.i("hind", "phone is " + phoneNum);
        return phoneNum;
    }
    public class SMS extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.i("hind", "sending the number to" + getPhoneNumber());
            send_message();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(Start.this, "Message has been sent", Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);
        }
    }

}