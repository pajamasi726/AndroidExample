package com.example.study_broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText edt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edt = (EditText)findViewById(R.id.editText1);
	}
	
	public void onClick(View v)
	{
		int num = Integer.parseInt(edt.getText().toString());
		
		// ��� �ϱ� 
		Intent intent = new Intent();
		intent.putExtra("num", num);
		intent.setAction("com.example.study_broadcastreceiver.myreceiver");
		sendBroadcast(intent);
		
	}
}
