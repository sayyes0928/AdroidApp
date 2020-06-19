package com.example.myapplication001;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class indexJoin extends AppCompatActivity {
    Button joinBtn;
    Button loginBtn;
    Button logout;
    TextView userIDlogin;
    TextView userPWlogin;
    TextView userNamelogin;
    ImageView imageMain;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_join);

        joinBtn = (Button)findViewById(R.id.joinBtn);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        userIDlogin = (TextView)findViewById(R.id.userIDlogin);
        userPWlogin = (TextView)findViewById(R.id.userPWlogin);
        userNamelogin = (TextView)findViewById(R.id.userNamelogin);
        imageMain = (ImageView)findViewById(R.id.imageMain);
        logout = (Button)findViewById(R.id.logout);

        // **변수 그룹

        //** 회원가입 버튼 이벤트
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJoin = new Intent(getApplicationContext(),joinPage.class); //joinPage 로 가기위한 intent 객체 생성

                startActivityForResult(intentJoin,0); //결과값을 가져 올 수 있는 메소드

            }
        });

        //** 로그입 버튼 이벤트

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(getApplicationContext(),loginPage.class); //joinPage 로 가기위한 intent 객체 생성

                startActivityForResult(intentLogin,1); //결과값을 가져 올 수 있는 메소드
            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String userID;
        String userPW;
        String userName;
        String userProfile;
        String loginUserID;
        String loginUserPW;

        if(requestCode == 0){
            userID = data.getStringExtra("userID");
            userPW = data.getStringExtra("userPW");
            userName = data.getStringExtra("userName");
            userProfile = data.getStringExtra("userProfile");

            userIDlogin.setText(userID);
            userPWlogin.setText(userPW);
            userNamelogin.setText(userName);
            imageMain.setImageResource(R.drawable.dog2);


        }
        else if(requestCode == 1){
            loginUserID = data.getStringExtra("logID");
            loginUserPW = data.getStringExtra("logPW");

            if(userIDlogin.getText().toString().equals(loginUserID) && userPWlogin.getText().toString().equals(loginUserPW)){
                userIDlogin.setVisibility(View.VISIBLE);
                userPWlogin.setVisibility(View.VISIBLE);
                userNamelogin.setVisibility(View.VISIBLE);
                imageMain.setVisibility(View.VISIBLE);

                joinBtn.setVisibility(View.INVISIBLE);
                loginBtn.setVisibility(View.INVISIBLE);
                logout.setVisibility(View.VISIBLE);
            }
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinBtn.setVisibility(View.VISIBLE);
                loginBtn.setVisibility(View.VISIBLE);
                logout.setVisibility(View.INVISIBLE);

                userIDlogin.setVisibility(View.INVISIBLE);
                userPWlogin.setVisibility(View.INVISIBLE);
                userNamelogin.setVisibility(View.INVISIBLE);
                imageMain.setVisibility(View.INVISIBLE);

            }
        });

    }
}