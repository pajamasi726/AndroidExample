package com.example.study_fragment;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onClick(View v)
	{
		Fragment frag = null;
		
		switch(v.getId())
		{
			case R.id.btn1 : 
				frag = new FirstPage();
			break;
			
			case R.id.btn2 :
				frag = new SecondPage();
			break;
		}
		
		FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentArea, frag);
        fragmentTransaction.commit();
		
	}
}
