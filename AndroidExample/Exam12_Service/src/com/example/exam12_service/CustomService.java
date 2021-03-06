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

	// 서비스가 생성될때 호출 되는 메소드 =
	@Override
	public void onCreate() {
		System.out.println("Custom onCreate : ");
		super.onCreate();
	}

	// 다른 컴포넌트가 startService()를 호출 하면 실행 된다.
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("Custom onStartCommand : ");
		
		String call = intent.getStringExtra("call");
		System.out.println("Intent 값 : " + call);

		th = new CustomThread();
		th.start();

		return super.onStartCommand(intent, flags, startId);
	}

	// 서비스가 종료될때 호출 된다. 자원 회수 할때 사용
	@Override
	public void onDestroy() {
		th.interrupt();
		th = null;
		super.onDestroy();
	}

}
