package com.example.eam21_topactivityinfo.Activity;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eam21_topactivityinfo.R;

public class ThirdActivity extends Activity {

	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirdactivity);
		
		tv = (TextView)findViewById(R.id.thirdTV);
		
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
}