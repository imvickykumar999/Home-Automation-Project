
//https://stackoverflow.com/a/62919369/11493297

//https://console.firebase.google.com/u/0/project/home-automation-336c0/settings/general/android:com.example.iotapp

package com.example.iotapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iotapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button onbutton, offbutton;
    boolean isSwitchOn = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        onbutton = findViewById(R.id.onbtn);
        offbutton = findViewById(R.id.offbtn);

        onbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    FirebaseDatabase.getInstance().getReference("A/B/C/Switch").setValue(1);
                    Toast.makeText(MainActivity.this, "Turned On Led",Toast.LENGTH_LONG).show();
            }
        });

        offbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("A/B/C/Switch").setValue(0);
                Toast.makeText(MainActivity.this, "Turned Off Led",Toast.LENGTH_LONG).show();
            }
        });

    }
}