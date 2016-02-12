package com.example.exam10_nonactivityfragmentaccess;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/*
 * ��Ƽ��Ƽ�� �ƴѰ� �Ǵ� �ٸ������� �����׸�Ʈ�� �����ؼ� �ٲٴ� ����
 */
public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ������ ��Ʈ�� �並 �޾ƿ��� (��Ƽ��Ƽ�� �ƴѰ������� ���� �ϴ�)
		View v = MyFragment_01.fragment.getView();
		Button btn = (Button)v.findViewById(R.id.button1);
		// ��ư ����
		btn.setText("text");
		
		
		
		/* ��� 2 getFragmentManager() �޼ҵ带 ���ؼ� ��Ƽ��Ƽ ���� �����׸�Ʈ�� ������ �����ϴ�.
	
		Fragment frag = (Fragment)getFragmentManager().findFragmentById(R.id.fragment_place);
		
		View _v = frag.getView();
		
		Button btn3 = (Button)_v.findViewById(R.id.button1);
		
		btn3.setText("!!!");
	   */
		
		// ���3 �Ű������� �����׸�Ʈ �Ŵ��� �Ѱ��ֱ�
		publicClass p = new publicClass(getFragmentManager());
		p.setText("@@@");
		
	}
}