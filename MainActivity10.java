package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity10 extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Intent intent;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        btn1 = (Button)findViewById(R.id.intentbtn01);
        btn2 = (Button)findViewById(R.id.intentbtn02);

        Uri uri = Uri.parse("https://www.naver.com");



        intent1 = new Intent(Intent.ACTION_VIEW,uri);
        intent = new Intent(getApplicationContext(),MainActivity9.class);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(intent);
            }
        });

    }
}