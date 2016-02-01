package com.example.exam01_listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity{

	ListView lv;
	MyAdapter Adapter;
	ArrayList<String> data = new ArrayList<String>(1);
	MyClickListItem listener = new MyClickListItem();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = (ListView)findViewById(R.id.listView);
        
        // 데이터 준비 
        data.add("이순신");
        data.add("유관순");
        data.add("강감찬");
        data.add("원효대사");
        
        
        // 생성과 동시에 연결
        Adapter = new MyAdapter(this, android.R.layout.simple_expandable_list_item_1, data);
        
        lv.setAdapter(Adapter);
        
        lv.setOnItemClickListener(listener);
        
        
    }
    
    
}
