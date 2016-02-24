package com.example.study_broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = getIntent();
		
		int num = intent.getIntExtra("num", 0);
		
		tv = (TextView)findViewById(R.id.tv);
		
		if(num !=0)
		{
			tv.setText(""+num);
		}
	}
}
