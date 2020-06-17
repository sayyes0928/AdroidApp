package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity4 extends AppCompatActivity {
    Spinner arr01;
    String itemText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        arr01 =(Spinner)findViewById(R.id.spi);
        itemText = arr01.getSelectedItem().toString();


        arr01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), arr01.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
                   //getApplicationContext() : Context 주체를 가져온다.
                   //Toast.LENGTH_SHORT : 내용이 보여지는 속도를 조절한다
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}