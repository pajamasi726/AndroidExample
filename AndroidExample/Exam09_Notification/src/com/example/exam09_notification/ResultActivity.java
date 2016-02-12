package com.example.exam09_notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		tv = (TextView) findViewById(R.id.tv);

		CharSequence s = "���� ���� ���� ";

		int id = 0;

		Bundle extras = getIntent().getExtras();

		if (extras == null) {

			s = "error";

		}
		else {

			id = extras.getInt("notificationId");

		}
		s = s + " " + id;

		tv.setText(s);

		NotificationManager nm =

		(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// ��Ƽ�����̼� ����
		nm.cancel(id);

	}
}