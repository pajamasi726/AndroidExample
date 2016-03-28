package com.example.exan22_phonenumberinfo;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView)findViewById(R.id.tv);
		
		TelephonyManager mgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String phoneNumber = mgr.getLine1Number();
		WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);

		String imei = mgr.getDeviceId();
		
		String total = "Æù¹øÈ£ : "+phoneNumber+"\n";
		total += "imei : "+imei+"\n";
		
		tv.setText(total);
	}
}
