package com.example.alhadi.heeder;

import android.app.Activity;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotSounds extends AppCompatActivity {
    private String chosenRingtone;

    //List of the notification sounds available
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_sounds);
        Intent intent5 = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent5.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
        intent5.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent5.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, (Uri) null);
        this.startActivityForResult(5, intent5);

    }

    private void startActivityForResult(final int requestCode, final Intent intent5) {
        int resultCode = 0;
        if (resultCode == Activity.RESULT_OK && requestCode == 5)
        {
            Uri uri = intent5.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

            if (uri != null)
            {
                this.chosenRingtone = uri.toString();
            }
            else
            {
                this.chosenRingtone = null;
            }
        }
    }
}

