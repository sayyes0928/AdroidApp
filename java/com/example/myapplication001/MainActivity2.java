package com.example.myapplication001;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    // MainActivity 와 연결된 첫 화면
    Button btn001;
    EditText text01;
    TextView textViewPre01;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn001 = (Button)findViewById(R.id.btn01);
        text01 = (EditText)findViewById(R.id.editText01);
        textViewPre01 = (TextView)findViewById(R.id.textView01Pre); //넘어간 화면에서 값을 받아올 영역



        btn001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity.class); //실제 클래스를 파싱값으로 쓰겠다.
                intent.putExtra("textEx01",text01.getText().toString()); // 자료를 넘길때는 [putExtra]
//                Toast.makeText(getApplicationContext(),text01.getText().toString(),Toast.LENGTH_SHORT).show();

                startActivityForResult(intent,0);
                // 다음 화면에서 원하는 결과값이 있을경우 startActivity 대신에 사용
                // requestCode : 값을 구분하기위한 코드, 의미 X [-1.0,1] 중에 한가지

//                startActivity(intent);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  // 'Intent data' 에는 넘어간 화면의 값이 담겨있다. 순서상 두번째 화면
        // startActivityForResult 로 다음화면에서 Result 로 담아왔던 값을, 받아오는 오버라이드 (다음 화면에서 버튼을 눌러 현재 화면으로 값을 보낼 때 받아줌)
        super.onActivityResult(requestCode, resultCode, data);
        String aaa = data.getStringExtra("textForResultName");
        textViewPre01.setText(aaa);
//        Toast.makeText(getApplicationContext(),aaa,Toast.LENGTH_SHORT).show();


    }
}