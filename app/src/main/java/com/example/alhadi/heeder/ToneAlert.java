package com.example.alhadi.heeder;

import android.app.Activity;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToneAlert extends AppCompatActivity {
    Button Tones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tone_alert);

        Tones = (Button) findViewById(R.id.button2 );

        Tones.setOnClickListener(new View.OnClickListener() {
//            public String chosenRingtone;

            @Override
            public void onClick(View view) {

//                Intent intent5 = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
//                intent5.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
//                intent5.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
//                intent5.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, (Uri) null);
//                this.startActivityForResult(5, intent5);
                Intent intent4 =new Intent(ToneAlert.this ,NotSounds.class );
                startActivity(intent4);

            }

//            private void startActivityForResult(final int requestCode, final Intent intent5) {
//                int resultCode = 0;
//                if (resultCode == Activity.RESULT_OK && requestCode == 5)
//                {
//                    Uri uri = intent5.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
//
//                    if (uri != null)
//                    {
//                        this.chosenRingtone = uri.toString();
//                    }
//                    else
//                    {
//                        this.chosenRingtone = null;
//                    }
//                }
//            }
        });
    }
}
