package com.example.study_broadcastreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		String name = intent.getAction();
		
		
		if(name.equals("com.example.study_broadcastreceiver.myreceiver"))
		{
			int num = intent.getIntExtra("num", 0);
			
			Intent i = new Intent();
        	i.setAction(Intent.ACTION_MAIN);
        	i.addCategory(Intent.CATEGORY_LAUNCHER);
        	i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	i.putExtra("num", num);
        	i.setClass(context, MainActivity.class);
        	context.startActivity(i);
		}
	}

}
