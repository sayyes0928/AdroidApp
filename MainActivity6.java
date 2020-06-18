package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {
    ListView list01;
    ArrayList<String> arrlist = new ArrayList<String>();
    String[] listArr = new String[arrlist.size()];
    Button btn;
    EditText arrtxt;
    ArrayAdapter listAdap; // cf : ListAdapter, 갱신을 위해서는 ArrayAdapter 를 사용한다


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        list01 = (ListView)findViewById(R.id.listLayout);
        btn = (Button)findViewById(R.id.btn);
        arrtxt = (EditText)findViewById(R.id.arrtxt);


        listAdap = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrlist);
        list01.setAdapter(listAdap);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrlist.add(arrtxt.getText().toString());
                listAdap.notifyDataSetChanged();

            }
        });

        list01.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), "선택하신 "+arrlist.get(i).toString()+" 가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                arrlist.remove(i);
                listAdap.notifyDataSetChanged();
                return true;
            }
        });



    }
}