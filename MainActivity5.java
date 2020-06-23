package com.example.myapplication001;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    public String clickdeDate;
    AlertDialog.Builder alertBulider;
    Mydb mydb = new Mydb(this);;
    SQLiteDatabase sqlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button insertBTN = (Button)findViewById(R.id.insertInfo);
        Button showBTN = (Button)findViewById(R.id.showInfo);

        CalendarView calendarView = (CalendarView)findViewById(R.id.calendar01);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                 clickdeDate = Integer.toString(i2);
            }
        });

        sqlData = mydb.getWritableDatabase(); // 달력 테이블 만들기
        mydb.onUpgrade(sqlData,1,2);
        sqlData.close();


//*** 등록
        insertBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View v;
                v = View.inflate(MainActivity5.this,R.layout.activity_poplist,null);

                alertBulider = new AlertDialog.Builder(MainActivity5.this);
                alertBulider.setView(v);
                alertBulider.show();

                final EditText inputTitle = (EditText)v.findViewById(R.id.userInputTitle);
                final EditText inputContents = (EditText)v.findViewById(R.id.userInputContents);
                Button getContentBTN = (Button)v.findViewById(R.id.userContentsSubmit);

                getContentBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sqlData = mydb.getWritableDatabase(); // DB실행
                        String title = inputTitle.getText().toString();
                        String contents = inputContents.getText().toString();

                        sqlData.execSQL("INSERT INTO test0623 values('"+clickdeDate+"','"+title+"'"+",'"+contents+"');");
                        sqlData.close(); // 버튼 클릭시 정리

                        Toast.makeText(getApplicationContext(),"일정이 등록되었습니다." ,Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });


        // *** 보기

        showBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View vContents;
                vContents = View.inflate(MainActivity5.this,R.layout.showcontents,null);

                alertBulider = new AlertDialog.Builder(MainActivity5.this);
                alertBulider.setView(vContents);
                alertBulider.show();

                final TextView showDate = (TextView)vContents.findViewById(R.id.showDate);
                final TextView showTitle = (TextView)vContents.findViewById(R.id.showTitle);
                final TextView showContents = (TextView)vContents.findViewById(R.id.showContents);

                sqlData = mydb.getReadableDatabase();
                Cursor rs =  sqlData.rawQuery("SELECT * FROM test0623 WHERE date='"+clickdeDate+"'",null);

                if(rs.moveToNext()){

                    showDate.setText(rs.getString(0));
                    showTitle.setText(rs.getString(1));
                    showContents.setText(rs.getString(2));
                    Toast.makeText(getApplicationContext(),rs.getString(0) + "   "+rs.getString(1),Toast.LENGTH_SHORT).show();
                }
                rs.close();
                sqlData.close();


            }
        });
    }

    //** DB를 사용하기위해 inner class 생성
    class Mydb extends SQLiteOpenHelper //inner class 로 helper 를 만들어준다. 바로 위 클래스 안에서만 사용하기 위해서
    { // ** 상속을 받기 때문에, 생성자와 메소드를 재정의한다.
        // ** 1) DB 생성  -> Table 생성
        public Mydb(@Nullable Context context) { //DB 생성
            super(context, "testDB0623", null, 1); // name : DB명 ,
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) { // table 을 만드는 메소드라고 생각 할 수 있다.
            sqLiteDatabase.execSQL("CREATE TABLE test0623(date varchar(20), title varchar(50),content varchar(100));"); // Table 생성
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS test0623"); //초기화시 앱이 꺼지는 현상 해결
            onCreate(sqLiteDatabase); //같은 class 안의 메소드에서는 객체생성 필요없이 호출 가능하다.
        }
    }
}