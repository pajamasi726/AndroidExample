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
        
        // ������ �غ� 
        data.add("�̼���");
        data.add("������");
        data.add("������");
        data.add("��ȿ���");
        
        
        // ������ ���ÿ� ����
        Adapter = new MyAdapter(this, android.R.layout.simple_expandable_list_item_1, data);
        
        lv.setAdapter(Adapter);
        
        lv.setOnItemClickListener(listener);
        
        
    }
    
    
}
