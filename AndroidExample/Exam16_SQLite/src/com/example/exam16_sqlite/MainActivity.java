package com.example.exam16_sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText edt1, edt2;
	TextView tv;
	
	CustomDBManager db_Manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		db_Manager = new CustomDBManager(this, "Student.db", null, 1);
		
		resourceInit();
	}
	
	public void onClick(View v)
	{
		switch(v.getId())
		{
			case R.id.insert :
				insert();
			break;
			
			case R.id.update :
				update();
			break;
			
			case R.id.delete :
				delete();
			break;
			
			case R.id.select :
				select();
			break;
		}
	} // onclick end 
	
	private void insert()
	{
		String name = edt1.getText().toString();
		int    phonenum = Integer.parseInt(edt2.getText().toString());
		
		db_Manager.insert(name, phonenum);
	}
	
	private void update()
	{
		String name = edt1.getText().toString();
		int    phonenum = Integer.parseInt(edt2.getText().toString());
		
		db_Manager.update(phonenum, name);
	}
	
	private void delete()
	{
		String name = edt1.getText().toString();
		int    phonenum = Integer.parseInt(edt2.getText().toString());
		
		db_Manager.delete(phonenum);
	}
	
	private void select()
	{
		String str = db_Manager.select();
		
		tv.setText(str);
	}
	
	
	private void resourceInit()
	{
		edt1 = (EditText)findViewById(R.id.edt1);
		edt2 = (EditText)findViewById(R.id.edt2);
		tv   = (TextView)findViewById(R.id.result);
	}
	
	
}
