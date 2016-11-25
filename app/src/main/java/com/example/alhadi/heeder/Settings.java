package com.example.alhadi.heeder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Settings extends AppCompatActivity {

    Button contacts;
    Button tone;
    Button  alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        contacts = (Button) findViewById(R.id.button6);

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Settings.this, Contacts.class);
                startActivity(intent2);

            }
        });


//        tone=(Button)findViewById(R.id.button);
//        tone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view1) {
//                Intent intent3 =new Intent(Settings.this ,ToneAlert.class );
//                startActivity(intent3);
//            }
//        });
        alert = (Button) findViewById(R.id.button8);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent3 = new Intent(Settings.this, ToneAlert.class);
                startActivity(intent3);
            }
        });
    }


}
