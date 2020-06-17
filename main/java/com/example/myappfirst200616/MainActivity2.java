package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      Button btn = (Button)findViewById(R.id.button12); //id값을 찾아오고 (T 반환형) ->버튼으로 형변환
      btn.setOnClickListener(new View.OnClickListener() { //객체를 이용해 버튼 클릭이벤트
          @Override
          public void onClick(View view) {

          }
      });

    }
}
