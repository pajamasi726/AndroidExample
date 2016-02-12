package com.example.exam08_actionbarbutton;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements  ActionBar.TabListener{

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        
        Tab t1 = bar.newTab();
        t1.setText("1");
        t1.setTabListener(this);
        
        
        Tab t2 = bar.newTab();
        t2.setText("2");
        t2.setTabListener(this);
        
        Tab t3 = bar.newTab();
        t3.setText("3");
        t3.setTabListener(this);
        
        bar.addTab(t1);
        bar.addTab(t2);
        bar.addTab(t3);
	}

	
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}