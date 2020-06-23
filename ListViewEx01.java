package com.example.myapplication001;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.SelectionEvent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewEx01 extends AppCompatActivity {
    int val1;
    String val2;
    ListView listPanel;
    ImageView profileImg;
    TextView userText;
    UserDTO [] objArr;
    String [] arrTest = {"1","2","3","4"};
    View viewlist;
    int arrNo;
    AlertDialog.Builder alertBulider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ex01);

        //getter, setter 를 사용하기위해 객체 생성


        objArr = new UserDTO[10]; //한 하이템에 여러가지 내용을 담기위해 객체배열 선언

        objArr[0] = new UserDTO(R.drawable.dog1,"aaaa");
        objArr[1] = new UserDTO(R.drawable.dog2,"bbbb");
        objArr[2] = new UserDTO(R.drawable.dog3,"cccc");
        objArr[3] = new UserDTO(R.drawable.dog4,"dddd");
        objArr[4] = new UserDTO(R.drawable.dog5,"eeee");
        objArr[5] = new UserDTO(R.drawable.dog6,"ffff");
        objArr[6] = new UserDTO(R.drawable.dog7,"0000");
        objArr[7] = new UserDTO(R.drawable.dog8,"hhhh");
        objArr[8] = new UserDTO(R.drawable.dog9,"iiii");
        objArr[9] = new UserDTO(R.drawable.dog1,"jjjj");

        listPanel =(ListView)findViewById(R.id.listPanel);


        CustomApapter customApapter = new CustomApapter(getApplicationContext(),R.layout.listpage,objArr);

        //**listAdapter , ArrayAdapter 비교
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrTest);
        // 1) 세번째 매개변수에 Array 형태만 들어간다.


        listPanel.setAdapter(customApapter);
//        listPanel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), "선택하신 "+objArr[i].toString()+" 가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });



    }

    class CustomApapter extends ArrayAdapter{ // Adapter 를 사용하기 위해 상속받는다
        //Inner class 라고 부른다. 현재 클래스에서만 쓸 수 있다.
        //listAdapter or ArrayAdapter 에서는 object 타입을 매개변수로 넣을 수 없다.
        // 때문에 alt + ins 를 통해서 필요한 부분을 가져온다
        // 부모클래스의 생성자를 만들기 위해
        public CustomApapter(@NonNull Context context, final int resource, @NonNull Object[] objects) {
            super(context, resource, objects);
    }


    @NonNull
        @Override //Inflate 하기위해 오버라이드
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            super.getView(position, convertView, parent);

            LayoutInflater layoutInflater = getLayoutInflater();
            viewlist = layoutInflater.inflate(R.layout.listpage,null);

            profileImg = (ImageView)viewlist.findViewById(R.id.profileImage);
            userText = (TextView)viewlist.findViewById(R.id.textUser);

            profileImg.setImageResource(objArr[position].getProfileImg());
            userText.setText(objArr[position].getTitle());


        viewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView userTextPop = (TextView) v.findViewById(R.id.textUser);
                ImageView profileImgPop = (ImageView)viewlist.findViewById(R.id.profileImage);
                Toast.makeText(getApplicationContext(),userTextPop.getText().toString(),Toast.LENGTH_SHORT).show();

//                View pop = View.inflate(ListViewEx01.this,R.layout.activity_pop_item,null);
//                alertBulider = new AlertDialog.Builder(ListViewEx01.this);
//                alertBulider.setView(v);
//                alertBulider.show();
////
//                ImageView name01 = (ImageView)v.findViewById(R.id.img0622);
//                TextView name02 = (TextView)v.findViewById(R.id.txt0622);
//                Button btn02 =(Button)v.findViewById(R.id.btn0622);

            }
        });
            return viewlist;
        }



    }

}