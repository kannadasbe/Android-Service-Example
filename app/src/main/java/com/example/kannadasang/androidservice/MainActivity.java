package com.example.kannadasang.androidservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnStartService;
    private Button btnStopService;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), MediaPlayerService.class));
                Toast.makeText(getBaseContext(), "Service is started", Toast.LENGTH_LONG).show();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stopService(new Intent(getApplicationContext(), MediaPlayerService.class)))
                    Toast.makeText(getBaseContext(), "Service is stopped", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Service is not running", Toast.LENGTH_LONG).show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
            }
        });
    }
}
