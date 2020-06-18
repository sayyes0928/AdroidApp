package com.example.myappfirst200616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    TextView textView01;
    TextView textView02;
    Button btn01;
    Button btn02;
    EditText name01;
    EditText name02;
    AlertDialog.Builder alertBulider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        textView01 = (TextView)findViewById(R.id.textView01);
        textView02 = (TextView)findViewById(R.id.textView02);
        btn01 = (Button)findViewById(R.id.button001);




        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View v;//setView 에 사용하기 위한 객체생성
                v = View.inflate(MainActivity9.this,R.layout.textpop,null);

                alertBulider = new AlertDialog.Builder(MainActivity9.this);
                alertBulider.setView(v);
                alertBulider.show();

                name01 = (EditText)v.findViewById(R.id.name01);
                name02 = (EditText)v.findViewById(R.id.name02);
                btn02 =(Button)v.findViewById(R.id.btnpop01);

                btn02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView01.setText(name01.getText());
                        textView02.setText(name02.getText());


                    }
                });

            }
        });

    }

}