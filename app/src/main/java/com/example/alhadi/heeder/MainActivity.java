package com.example.alhadi.heeder;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button settings;
    Button history;
    Button start;
    Button stop;

    @Override


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start= (Button)findViewById(R.id.button) ;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startClassIntent =new Intent(MainActivity.this ,Start.class );
                startActivity(startClassIntent);


            }
        });
        AlarmManager scheduler = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //Intent intent = new Intent(getApplicationContext(), FallDet.class );
        //PendingIntent scheduledIntent = PendingIntent.getService(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

      //  scheduler.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_HOUR, scheduledIntent);
        settings = (Button) findViewById(R.id.button3 );
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MainActivity.this ,Settings.class );
                startActivity(intent);

            }
        });


        history=(Button)findViewById(R.id.button4);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent2 =new Intent(MainActivity.this ,History.class );
                startActivity(intent2);
            }
        });

    }
}
