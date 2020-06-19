package com.example.myapplication001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginPage extends AppCompatActivity {

    EditText userID;
    EditText userPW;
    Button loginSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        userID = (EditText)findViewById(R.id.loginUserID);
        userPW = (EditText)findViewById(R.id.loginUserPW);
        loginSubmitBtn = (Button)findViewById(R.id.loginSubmitBtn);


        //** 로그인 버튼 이벤트
        loginSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoginSubmit = new Intent(getApplicationContext(),indexJoin.class);
                intentLoginSubmit.putExtra("logID",userID.getText().toString());
                intentLoginSubmit.putExtra("logPW",userPW.getText().toString());

                setResult(RESULT_OK,intentLoginSubmit);
                finish();

            }
        });


    }
}