package com.example.arraylisttransferactivity;


import java.util.ArrayList;

import DataBean.Item;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends Activity {

	ListView lv;
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		// Intent Data 받아오기 받을때 CustomSerialList가 아닌 ArrayList로 받는다
		ArrayList<Item> data = (ArrayList<Item>)getIntent().getSerializableExtra("item");

		
		
		lv = (ListView)findViewById(R.id.lv);
		
		CustomAdapter adapter = new CustomAdapter();
		adapter.setListData(data);
		lv.setAdapter(adapter);
	}

}
