package com.example.exam12_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CustomService extends Service {

	Thread th;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	// ���񽺰� �����ɶ� ȣ�� �Ǵ� �޼ҵ� =
	@Override
	public void onCreate() {
		System.out.println("Custom onCreate : ");
		super.onCreate();
	}

	// �ٸ� ������Ʈ�� startService()�� ȣ�� �ϸ� ���� �ȴ�.
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("Custom onStartCommand : ");
		
		String call = intent.getStringExtra("call");
		System.out.println("Intent �� : " + call);

		th = new CustomThread();
		th.start();

		return super.onStartCommand(intent, flags, startId);
	}

	// ���񽺰� ����ɶ� ȣ�� �ȴ�. �ڿ� ȸ�� �Ҷ� ���
	@Override
	public void onDestroy() {
		th.interrupt();
		th = null;
		super.onDestroy();
	}

}