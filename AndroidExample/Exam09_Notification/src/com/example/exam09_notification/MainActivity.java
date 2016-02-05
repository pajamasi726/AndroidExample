package com.example.exam09_notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn:
			create_Notifi();
			break;
		}
	}

	private void create_Notifi() {

		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		Resources res = getResources();

		Intent notificationIntent = new Intent(this, ResultActivity.class);

		notificationIntent.putExtra("notificationId", 9999); // 전달할 값

		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder builder = new NotificationCompat.Builder(this)

				.setContentTitle("상태바 드래그시 보이는 타이틀")

				.setContentText("상태바 드래그시 보이는 서브타이틀")

				.setTicker("상태바 한줄 메시지")

				.setSmallIcon(R.drawable.ic_launcher)

				.setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher))

				.setContentIntent(contentIntent)

				.setAutoCancel(true)

				.setWhen(System.currentTimeMillis())

				.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)

				.setNumber(13);

		Notification n = builder.build();

		nm.notify(1234, n);
	}
}
