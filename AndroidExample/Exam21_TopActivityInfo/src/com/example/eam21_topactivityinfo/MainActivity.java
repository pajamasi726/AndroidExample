package com.example.eam21_topactivityinfo;

import java.util.List;

import com.example.eam21_topactivityinfo.Activity.ThirdActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView)findViewById(R.id.MainTV);
		
		ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> Info = am.getRunningTasks(1);
		ComponentName topActivity = Info.get(0).topActivity;
		
		
		String m = topActivity.getClass().getName();
		String msg = topActivity.getClassName();
		String msg2 = topActivity.getShortClassName();
		String topactivityname = topActivity.getPackageName();
		
		String total = m+"\n"+msg+"\n"+msg2+"\n"+topactivityname;
		
		tv.setText(total);
		
	}
	
	public void onClick(View v)
	{
		Intent intent = null;
		
		switch(v.getId())
		{
			case R.id.button1 :
				intent = new Intent(this, SecondActivity.class);
			break;
			
			case R.id.button2 : 
				intent = new Intent(this, ThirdActivity.class);
			break;
		}
		
		startActivity(intent);
	}
}
