package com.example.exam19_gcmclient;

import java.net.URLDecoder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Ǫ�� �޽����� �޴� Receiver ����
 * 
 * @author Mike
 *
 */
public class GCMBroadcastReceiver extends WakefulBroadcastReceiver {
	private static final String TAG = "GCMBroadcastReceiver";
	
	@Override
	public void onReceive(Context context, Intent intent) {		//������ �޽��� ������  intent�� �ΰ����� ������ ���
		String action = intent.getAction();	
		Log.d(TAG, "action : " + action);
		
		if (action != null) {
			if (action.equals("com.google.android.c2dm.intent.RECEIVE")) { // Ǫ�� �޽��� ���� ��
				String from = intent.getStringExtra("from");
				String command = intent.getStringExtra("command");		// �������� ���� command ��� Ű�� value �� 
				String type = intent.getStringExtra("type");		// �������� ���� type ��� Ű�� value �� 
				String rawData = intent.getStringExtra("data");		// �������� ���� data ��� Ű�� value ��
				String data = "";
				try {
					data = URLDecoder.decode(rawData, "UTF-8");
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				
				Log.v(TAG, "from : " + from + ", command : " + command + ", type : " + type + ", data : " + data);
				
				// ��Ƽ��Ƽ�� ����
				sendToActivity(context, from, command, type, data);
				
			} else {
				Log.d(TAG, "Unknown action : " + action);
			}
		} else {
			Log.d(TAG, "action is null.");
		}
		
	}

	/**
	 * ���� ��Ƽ��Ƽ�� ���ŵ� Ǫ�� �޽����� ������ ����
	 * 
	 * @param context
	 * @param command
	 * @param type
	 * @param data
	 */
	private void sendToActivity(Context context, String from, String command, String type, String data) {
		Intent intent = new Intent(context, MainActivity.class);
		intent.putExtra("from", from);
		intent.putExtra("command", command);
		intent.putExtra("type", type);
		intent.putExtra("data", data);
		
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);

		context.startActivity(intent);
	}

}
