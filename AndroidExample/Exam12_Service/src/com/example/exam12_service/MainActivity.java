package com.example.exam12_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	public void onClick(View v)
	{
		Intent intent = null;
		switch(v.getId())
		{
			case R.id.button1 :
				intent = new Intent("com.example.exam12_service");
				intent.putExtra("call", "call");
				startService(intent);
			break;
			
			case R.id.button2 :
				intent = new Intent("com.example.exam12_service");
				stopService(intent);
			break;
		}
	}
}

