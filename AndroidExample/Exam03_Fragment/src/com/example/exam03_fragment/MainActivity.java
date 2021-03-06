package com.example.exam03_fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	boolean check = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@SuppressLint("NewApi")
	public void onClick(View v)
	{
		Fragment frgment = null;
		switch(v.getId())
		{
			case R.id.btn1 :
				if(check)
				{
					check = false;
					frgment = new MyFragment_01();
				}
				else
				{
					check = true;
					frgment = new MyFragment_02();
				}
			break;
		}
		
		FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, frgment);
        fragmentTransaction.commit();
	}
}
