package com.example.alhadi.heeder;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

/**
 * Created by Alhadi on 11/23/2016.
 */
public interface Start1 {
    void onAccuracyChanged(Sensor sensor, int accuracy);

    float onSensorChanged(SensorEvent event);
}
