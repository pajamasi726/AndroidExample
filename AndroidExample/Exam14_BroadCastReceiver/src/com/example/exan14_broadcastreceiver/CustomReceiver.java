package com.example.exan14_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String name = intent.getAction();
        System.out.println(name);
        if(name.equals("com.example.exam14_broadcastreceiver.pajamasi")){
        	Intent i = new Intent();
        	i.setAction(Intent.ACTION_MAIN);
        	i.addCategory(Intent.CATEGORY_LAUNCHER);
        	i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	i.setClass(context, MainActivity.class);
        	context.startActivity(i);
        }
      }
	}
