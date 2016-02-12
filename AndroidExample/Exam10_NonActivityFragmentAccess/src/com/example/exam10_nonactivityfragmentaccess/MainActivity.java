package com.example.exam10_nonactivityfragmentaccess;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 프래그 먼트의 뷰를 받아오기 (액티비티가 아닌곳에서도 가능 하다)
		View v = MyFragment_01.fragment.getView();
		Button btn = (Button)v.findViewById(R.id.button1);
		// 버튼 설정
		btn.setText("text");
		
		
		
		/* 방법 2 getFragmentManager() 메소드를 통해서 엑티비티 내에 프래그먼트에 접근이 가능하다.
	
		Fragment frag = (Fragment)getFragmentManager().findFragmentById(R.id.fragment_place);
		
		View _v = frag.getView();
		
		Button btn3 = (Button)_v.findViewById(R.id.button1);
		
		btn3.setText("!!!");
	   */
		
		// 방법3 매개변수로 프래그먼트 매니저 넘겨주기
		publicClass p = new publicClass(getFragmentManager());
		p.setText("@@@");
		
	}
}
