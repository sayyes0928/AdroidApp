package com.example.myappfirst200616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    Button btn01;
    Button btn02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

       btn01 =(Button)findViewById(R.id.btn01);
       btn02 =(Button)findViewById(R.id.btn02);

       //registerForContextMenu(매개변수) : context 에 매개변수를 추가해주는 메소드
        registerForContextMenu(btn01);
        registerForContextMenu(btn02);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);


        if (item.getTitle().equals("Item001")){
            Toast.makeText(getApplicationContext(),"안녕?! "+item.getTitle()+" 이 선택되었단다",Toast.LENGTH_SHORT).show();
        }
        if (item.getTitle().equals("Item002")){
            Toast.makeText(getApplicationContext(),"안녕?! "+item.getTitle()+" 이 선택되었단다",Toast.LENGTH_SHORT).show();
        }
        if (item.getTitle().equals("Item003")){
            Toast.makeText(getApplicationContext(),"안녕?! "+item.getItemId()+" 이 선택되었단다",Toast.LENGTH_SHORT).show();
        }

//        if(item.getItemId()==){}
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //버튼에 메뉴를 추가해주는 메소드
        // View v : 선택한 개체
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater btn = getMenuInflater();

        if(v==btn01){
            btn.inflate(R.menu.button01,menu);
        }
        else if(v==btn02){
            btn.inflate(R.menu.button02,menu);
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Code -> Override -> OncreateOption
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater(); //  Inflater .XML 외부값을 가져오는 클래스
        menuInflater.inflate(R.menu.someting,menu ); // 주입기 -> 주입 -> 매개변수(리소스,오버라이드의 매개변수 )

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ImageView imagePanel = (ImageView)findViewById(R.id.imagePanel);

        super.onOptionsItemSelected(item);

        if(item.getTitle().equals("Item01")){
            Toast.makeText(getApplicationContext(),"안녕?! "+item.getTitle()+" 이 선택되었단다",Toast.LENGTH_SHORT).show();
            imagePanel.setVisibility(View.INVISIBLE);

        }else if(item.getTitle().equals("Item02")){
            imagePanel.setImageResource(R.drawable.dog1);
            imagePanel.setVisibility(View.VISIBLE);

        }else if(item.getTitle().equals("Item03")){
//            imagePanel.setImageResource(R.drawable.cat02);
//            imagePanel.setVisibility(View.VISIBLE);

            Intent intent = new Intent(getApplicationContext(),MainActivity6.class);
            startActivity(intent);

        }
        return true;
    }



}