package com.example.myapplication001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn02;
    TextView textView01;
    EditText inputTextNext01;
    String textForResult;
    Intent intent;
    String text002;
    Intent intentForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //**id 값 호출 -> 변수 선언
        btn02 = (Button)findViewById(R.id.btn02);
        textView01 = (TextView)findViewById(R.id.textView01);
        inputTextNext01 = (EditText)findViewById(R.id.inputTextNext01); //이전 화면으로 값을 보내기 위한 변수

        // Intent 관련 변수선언, 메소드
        intent = getIntent(); // 현재 Activity 를 호출한 화면을 가져와서 담아놓는다.
        text002 = intent.getStringExtra("textEx01");
        // 현재 페이지를 호출한 Activity 에서 지정한 name 을 넣는다.
        // name 은 String 타입이기 때문에 "name" 으로 매개변수를 넣어준다.

        //
        textView01.setText(text002);




        //**버튼 이벤트 **
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intentForResult = new Intent(getApplicationContext(),MainActivity2.class);

                //** 현재 화면의 정보를 이전 화면으로 보내기
                textForResult = inputTextNext01.getText().toString(); //이전 화면으로 보낼 문자열 값
                //이전 화면을 불러오는 intent
                //**

                intentForResult.putExtra("textForResultName",textForResult);
                Toast.makeText(getApplicationContext(),textForResult,Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK,intentForResult);
                //내가원하는 화면에, 내가 원하는 결과를 넘겨줄 때 사용하는 메소드
                //setResult(상수값,이전 Activity 로 가는 경로를 담은 intent);

                finish(); //돌아가는 기능은 없다. 이전 화면으로 넘어가는 것은 아니고,
                // 넘어와진 두번째 화면을 정리하는 의미의 메소드
                // start-> finish 관계


            }
        });
    }
}