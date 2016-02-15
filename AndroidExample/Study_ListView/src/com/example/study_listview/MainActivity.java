package com.example.study_listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView lv;
	ArrayList<String> list;
	
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView)findViewById(R.id.lv);
		
		list = new ArrayList<String>(1);
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
		
		lv.setAdapter(adapter);
		
	}
}
