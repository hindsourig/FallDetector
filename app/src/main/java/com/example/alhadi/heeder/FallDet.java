//package com.example.alhadi.heeder;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorManager;
//import android.location.Criteria;
//import android.location.Location;
//import android.location.LocationManager;
//import android.os.AsyncTask;
//import android.os.IBinder;
//import android.hardware.SensorEventListener;
//import android.telephony.SmsManager;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//public class FallDet extends Service  implements SensorEventListener {
//
//    private static final String DEBUG_TAG = "FallDetectService";
//
//    private float lastX, lastY, lastZ;
//
//
//    private SensorManager senMgr = null;
//    private Sensor senAcc = null;
//
//
//    @Override
//    public int onStartCommand(Intent intent7, int flags, int startId) {
//        senMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        senAcc = senMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        senMgr.registerListener(this, senAcc, SensorManager.SENSOR_DELAY_NORMAL);
//        return START_STICKY;
//    }
//
//
//    public void onSensorChanged(SensorEvent senEvent) {
//        senMgr.unregisterListener(this);
//        new SensorEventLoggerTask().execute(senEvent);
//        stopSelf();
//    }
//
//    private class SensorEventLoggerTask extends
//            AsyncTask<SensorEvent, Void, Void> {
//        @Override
//        protected Void doInBackground(SensorEvent... events) {
//            SensorEvent senEvent = events[0];
//            // log the value
//            return null;
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor senAcc, int accuracy) {
//
//    }
//
//    public FallDet(SensorManager senMgr, Sensor senAcc) {
//
//        this.senMgr = senMgr;
//        this.senAcc = senAcc;
//
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        //throw new UnsupportedOperationException("Not yet implemented");
//        return null;
//
//
//    }
//
//    //sending messeges
//// as a reaction
////    public void send_message() {
////        SmsManager sms = SmsManager.getDefault();
////    //how to call it??
////        String number = "0024999442917";//the number you want to send to and must b called from picked contact
////        sms.sendTextMessage(number, null, "the message to be sent", null, null);
////        Toast.makeText(this, "I need help I just fell" + number, Toast.LENGTH_LONG).show();
////
////    }
//
//}