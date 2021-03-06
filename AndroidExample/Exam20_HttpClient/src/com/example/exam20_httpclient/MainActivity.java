package com.example.exam20_httpclient;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// UI Thread 에서 네트워크 사용
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		tv = (TextView)findViewById(R.id.tv);
		
	}
	
	public void onClick(View v)
	{
		String url = "http://www.naver.com";
		HttpClient http = new DefaultHttpClient();
		try { 

			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			// 파라미터 설정
			nameValuePairs.add(new BasicNameValuePair("name", "유재석"));

			HttpParams params = http.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 5000);
			HttpConnectionParams.setSoTimeout(params, 5000);

			// post 인코딩 설정
			HttpPost httpPost = new HttpPost(url);
			//UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(nameValuePairs, "EUC-KR");
			//httpPost.setEntity(entityRequest);
			
			HttpResponse responsePost = http.execute(httpPost);
			HttpEntity resEntity = responsePost.getEntity();
			
			tv.setText( EntityUtils.toString(resEntity));
		}catch(Exception e){e.printStackTrace();}
	}
}
