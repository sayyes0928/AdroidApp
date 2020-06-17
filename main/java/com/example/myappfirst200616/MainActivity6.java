package com.example.myappfirst200616;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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
    ListAdapter listAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        list01 = (ListView)findViewById(R.id.listLayout);
        btn = (Button)findViewById(R.id.btn);
        arrtxt = (EditText)findViewById(R.id.arrtxt);

        listAdap = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arrlist);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrlist.add(arrtxt.getText().toString());
//                Toast.makeText(getApplicationContext(), arrtxt.getText().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), arrlist.get(0).toString(), Toast.LENGTH_SHORT).show();
                list01.setAdapter(listAdap);
            }
        });


    }
}