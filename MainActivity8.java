package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
//        btn1 = (Button)findViewById(R.id.btn001);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] textarr = {"hi","Hello","안녕"};
                Boolean[] booleansarr = {true,true,false};
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity8.this); //다이얼로그의 기본 틀을 설정해준다
//                alertBuilder.setMessage("Message"+"\n"+"Message"+"Message"); //내용입력
//                alertBuilder.setItems(textarr,null);
                alertBuilder.setTitle("Title"); //큰 제목 입력
//                alertBuilder.setSingleChoiceItems(textarr,1,null);
                alertBuilder.setMultiChoiceItems(textarr,null,null);
                //setPositive , setNegative 는 버튼의 좌우면 설정해준다.
                alertBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_SHORT).show();
                    }
                });
                alertBuilder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_SHORT).show();
                    }
                }).show();

            }
        });
    }


}