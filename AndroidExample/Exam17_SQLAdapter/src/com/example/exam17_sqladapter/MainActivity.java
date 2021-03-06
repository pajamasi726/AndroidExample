package com.example.exam17_sqladapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	CustomCursorAdapter adapter;
	CustomDBManager dbmanager;
	Cursor cursor;
	ListView lv;
	EditText edt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView)findViewById(R.id.lv);
		edt = (EditText)findViewById(R.id.edt1);
		
		dbmanager = new CustomDBManager(this, DB_Mark.DB_TABLE, null, 1);
		adapter = new CustomCursorAdapter(this, null);
		lv.setAdapter(adapter);
		
		init();
	}
	
	private void init()
	{
		dbmanager.dbOpen();
		cursor = dbmanager.allData();
		adapter.swapCursor(cursor);
		
	}
	
	
	public void onClick(View v)
	{
		String item = edt.getText().toString();
		
		dbmanager.insert(item);
		cursor = dbmanager.allData();
		adapter.swapCursor(cursor);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		init();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		cursor.close();
		dbmanager.dbClose();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		cursor.close();
		dbmanager.dbClose();
	}
	
}
