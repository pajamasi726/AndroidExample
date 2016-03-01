package com.example.exam19_gcmclient;


import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class GCMIntentService extends IntentService {

	private static final String TAG = "GCMIntentService";
	
	/**
	 * ������
	 */
    public GCMIntentService() {
        super(TAG);

        Log.d(TAG, "GCMIntentService() called.");
    }

    /*
     * ���޹��� ����Ʈ ó��
     */
	@Override
	protected void onHandleIntent(Intent intent) {
		String action = intent.getAction();
		
		Log.d(TAG, "action : " + action);
		
	}

}