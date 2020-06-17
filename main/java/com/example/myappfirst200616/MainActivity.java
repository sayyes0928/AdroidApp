package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {//onCreate : 자바의 'main'
        super.onCreate(savedInstanceState); //
        setContentView(R.layout.activity_main); //R : '리소스의 약자', 이 메소드가 화면에 보여진다
   //drawable : 'PNG' 이미지 파일만 사용가능
        // AndroidManifest.xml : 이 '프로젝트의 환경'을 수정

    }
}