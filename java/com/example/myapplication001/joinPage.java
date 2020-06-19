package com.example.myapplication001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class joinPage extends AppCompatActivity {
    EditText userID;
    EditText userPW;
    EditText userName;
    Button userInfo;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_page);

        userID = (EditText)findViewById(R.id.inputID);
        userPW = (EditText)findViewById(R.id.inputPW);
        userName = (EditText)findViewById(R.id.inputName);
        userInfo = (Button) findViewById(R.id.userInfoSubmitBtn);
        profile = (ImageView)findViewById(R.id.profileImage);


        // **입력받은 값을 넣은 변수 선언

        //** 입력받은 값을 이전 화면으로 돌려주기 위한 버튼 이벤트 생성
        userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentSubmit = new Intent(getApplicationContext(),indexJoin.class);
                // 입력한 정보를 index 가 아닌 loginPage 로 넘어간다
                intentSubmit.putExtra("userID",userID.getText().toString());
                intentSubmit.putExtra("userPW",userPW.getText().toString());
                intentSubmit.putExtra("userName",userName.getText().toString());
                intentSubmit.putExtra("userProfile", "dog2");

                setResult(RESULT_OK, intentSubmit);
                Toast.makeText(getApplicationContext(),"가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                finish(); //현재의 행동을 종료하고 이전 페이지로

            }
        });



    }
}