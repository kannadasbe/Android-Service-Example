package com.example.kannadasang.androidservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button btnStopService;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnStopService = (Button) findViewById(R.id.btnStop);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stopService(new Intent(getApplicationContext(), MediaPlayerService.class)))
                    Toast.makeText(getBaseContext(), "Service is stopped", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Service is not running", Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });


    }
}

