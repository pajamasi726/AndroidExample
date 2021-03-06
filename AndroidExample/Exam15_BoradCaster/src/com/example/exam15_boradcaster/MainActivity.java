package com.example.exam15_boradcaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText et1;
	EditText et2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et1 = (EditText)findViewById(R.id.editText1);
		et2 = (EditText)findViewById(R.id.editText2);
	}
	
	public void onClick(View v)
	{
		String msg = et1.getText().toString();
		int    age = Integer.parseInt(et2.getText().toString());
		
		Intent intent = new Intent();
		intent.putExtra("msg", msg);
		intent.putExtra("age", age);
		intent.setAction("com.example.exam14_broadcastreceiver.pajamasi");
		sendBroadcast(intent);
		System.out.println("보내기 완료");
		
	}
}
