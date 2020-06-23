package com.example.myapplication001;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DatabaseConection extends AppCompatActivity {
    Button resetBTN;
    Button insertBTN;
    Button searchBTN;
    EditText getUserNameData;
    EditText getUserGroupData;
    Mydb mydb;
    SQLiteDatabase sqlData;
    String userName;
    String userGroup;
    TextView viewDataName;
    TextView viewDataGroup;
    String textAll01 = "";
    String textAll02 = "";
    ListView getUserInfoList;
    View listView01;
    UserDTO02 userDTO02 = new UserDTO02();
    ArrayList<UserDTO02> arr = new ArrayList<>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_conection);

        resetBTN = (Button)findViewById(R.id.resetBTN);
        insertBTN = (Button)findViewById(R.id.insertBTN);
        searchBTN = (Button)findViewById(R.id.searchBTN);

        getUserNameData = (EditText)findViewById(R.id.getUserNameData);
        getUserGroupData = (EditText)findViewById(R.id.getUserGroupData);

        getUserInfoList = (ListView)findViewById(R.id.getUserInfoList);

        mydb = new Mydb(this);//DB를 사용하기위한 객체 생성


        Cadapter cadapter = new Cadapter(getApplicationContext(), R.layout.databaselistpage,arr);
        getUserInfoList.setAdapter(cadapter);


        //**** 초기화버튼 이벤트
        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sqlData = mydb.getWritableDatabase(); //만들어진 테이블, 작업권한
                mydb.onUpgrade(sqlData,1,2);
                sqlData.close();

//
//                textAll01 = "";
//                textAll02 = "";
//
//                viewDataName.setText(textAll01);
//                viewDataGroup.setText(textAll02);

            }
        });

        //**** 입력버튼 이벤트
        insertBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlData = mydb.getWritableDatabase(); // DB실행
                userName = getUserNameData.getText().toString();
                userGroup = getUserGroupData.getText().toString();

                Toast.makeText(getApplicationContext(),userName,Toast.LENGTH_SHORT).show();
                sqlData.execSQL("INSERT INTO test0622 values('"+userName+"'"+",'"+userGroup+"');");
                sqlData.close(); // 버튼 클릭시 정리
            }
        });


        //**** 조회버튼 이벤트

        searchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlData = mydb.getReadableDatabase(); //SELECT 는 데이터를 읽어만 온다
                //조회 중복 클릭시 초기화
//                textAll01 = "";
//                textAll02 = "";
//
//                viewDataName.setText(textAll01);
//                viewDataGroup.setText(textAll02);


                Cursor rs =  sqlData.rawQuery("SELECT * FROM test0622",null); //Cursor 클래스 반환 , ResultSet 역할

                while (rs.moveToNext()) {
                    userDTO02 = new UserDTO02();
                    userDTO02.setUserName(rs.getString(0));
                    userDTO02.setUserGroup(rs.getString(1));
                    arr.add(userDTO02);
//                    textAll01 += rs.getString(0) + "\n";
//                    textAll02 += rs.getString(1) + "\n";
                }// cf. if(rs.next())
//                viewDataName.setText("이름\n"+textAll01);
//                viewDataGroup.setText("인원\n"+textAll02);

                    rs.close();
                //** Java 에서 처럼 ResultSet 이 필요하다
                sqlData.close();
            }
        });


    }

    //** DB를 사용하기위해 inner class 생성
    class Mydb extends SQLiteOpenHelper //inner class 로 helper 를 만들어준다. 바로 위 클래스 안에서만 사용하기 위해서
    { // ** 상속을 받기 때문에, 생성자와 메소드를 재정의한다.
        // ** 1) DB 생성  -> Table 생성
        public Mydb(@Nullable Context context) { //DB 생성
            super(context, "testDB0622", null, 1); // name : DB명 ,
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) { // table 을 만드는 메소드라고 생각 할 수 있다.
            sqLiteDatabase.execSQL("CREATE TABLE test0622(userName varchar(20), userGroup integer);"); // Table 생성
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS test0622"); //초기화시 앱이 꺼지는 현상 해결
            onCreate(sqLiteDatabase); //같은 class 안의 메소드에서는 객체생성 필요없이 호출 가능하다.
        }
    }

    class Cadapter extends ArrayAdapter{


        public Cadapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//            super.getView(position, convertView, parent);

            LayoutInflater layoutInflater = getLayoutInflater();
            listView01 = layoutInflater.inflate(R.layout.databaselistpage,null);

            TextView text01 = (TextView)listView01.findViewById(R.id.userNamePop);
            TextView text02 = (TextView)listView01.findViewById(R.id.userNoPop);

            text01.setText(arr.get(position).getUserName());
            text02.setText(arr.get(position).getUserGroup());

            return listView01;
        }
    }




    }

