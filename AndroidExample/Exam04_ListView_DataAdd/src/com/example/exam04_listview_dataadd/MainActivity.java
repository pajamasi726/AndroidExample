package com.example.exam04_listview_dataadd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView 	lv;
	Button 		btn;
	EditText	edit;
	
	CustomAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 리소스 로딩 
		resourceInit();
		
		// 어댑터 설정
		setAdapter();
	}
	
	public void onClick(View v)
	{
		switch(v.getId())
		{
			case R.id.btn :
				addData();
			break;
		}
	}
	
	private void addData()
	{
		String msg = edit.getText().toString();
		
		ItemDTO imsi = new ItemDTO(msg);
		adapter.addData(imsi);
		
		// 데이터 갱신 알리기
		adapter.notifyDataSetChanged();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	private void setAdapter()
	{
		adapter = new CustomAdapter();
		
		lv.setAdapter(adapter);
	}
	private void resourceInit()
	{
		lv   = 	(ListView)findViewById(R.id.lv);
		btn	 =	(Button)findViewById(R.id.btn);
		edit = 	(EditText)findViewById(R.id.editText);
	}
}
