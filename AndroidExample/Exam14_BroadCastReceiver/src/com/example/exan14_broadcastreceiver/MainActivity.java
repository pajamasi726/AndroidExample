package com.example.exan14_broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent = getIntent();
		
		String msg = intent.getStringExtra("msg");
    	int age = intent.getIntExtra("age", 0);
    	if(msg != null)
    	System.out.println(msg);
	}
}
