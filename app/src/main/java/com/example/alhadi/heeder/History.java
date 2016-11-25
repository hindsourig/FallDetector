package com.example.alhadi.heeder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

public class History extends AppCompatActivity {
    SharedPreferences sp;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.history2);
//
//        save= (Button)findViewById(R.id.button2) ;
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent10 =new Intent(history2.this  );
//                startActivity(intent10);
//
//
//            }
//        });
    }


    public void Save(String key,String value){

  sp=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor e=sp.edit();
        e.putString(key,value);
        e.commit();
    }
    public String load(String key){

        sp=PreferenceManager.getDefaultSharedPreferences(this);
        String s=sp.getString(key,"");
        return s;
    }

}
