package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    TextView text01; //전역변수로 선언하면 final을 안써도됨
    RadioGroup radioAll;
    ImageView imgAll;
    CheckBox checkBox01;
    RadioButton dog;
    RadioButton cat;
    RadioButton rabbit;
    Button selectOk;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        checkBox01 = (CheckBox)findViewById(R.id.startcheck);
        dog = (RadioButton)findViewById(R.id.dog);
        cat = (RadioButton)findViewById(R.id.cat);
        rabbit = (RadioButton)findViewById(R.id.rabbit);
        selectOk = (Button)findViewById(R.id.selectOk);
        radioAll = (RadioGroup)findViewById(R.id.radioAll);
        imgAll = (ImageView)findViewById(R.id.imgAll);



//       checkBox01.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               radioAll.setVisibility(View.VISIBLE);
//           }
//       });


       checkBox01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(radioAll.getVisibility() == View.INVISIBLE){
                   radioAll.setVisibility(View.VISIBLE);
               }else if(radioAll.getVisibility() == View.VISIBLE){
                   radioAll.setVisibility(View.INVISIBLE);
                   imgAll.setVisibility(View.INVISIBLE);

               }

           }
       });

        selectOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dog.isChecked() == true){
                    imgAll.setVisibility(View.VISIBLE);
                    imgAll.setImageResource(R.drawable.dog1);

                }else if(cat.isChecked()==true){
                    imgAll.setVisibility(View.VISIBLE);
                    imgAll.setImageResource(R.drawable.cat02);
                }else if(rabbit.isChecked()==true){
                    imgAll.setVisibility(View.VISIBLE);
                    imgAll.setImageResource(R.drawable.rabbit01);
                }
            }
        });


    }
}