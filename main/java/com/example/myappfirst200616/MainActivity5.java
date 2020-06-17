package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    Spinner spi;
    ImageView imgPanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        spi = (Spinner)findViewById(R.id.spi);
        imgPanel = (ImageView)findViewById(R.id.imgPabel);


        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    imgPanel.setImageResource(R.drawable.dog1);
                }
                if(i == 1){
                    imgPanel.setImageResource(R.drawable.rabbit01);
                }
                if(spi.getSelectedItem().toString().equals("3")){
                    imgPanel.setImageResource(R.drawable.cat02);
                }
            }
            //getApplicationContext() : Context 주체를 가져온다.
            //Toast.LENGTH_SHORT : 내용이 보여지는 속도를 조절한다
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}