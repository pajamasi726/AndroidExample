package com.example.exam05_viewpager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	ViewPager viewPager;
	CustomFragmentPageAdapter adapter;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 리소스 로딩
		resourceInit();
		
		// 셋팅
		
		// 현재 페이지 액션바 지정 
		final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        
        adapter = new CustomFragmentPageAdapter(getSupportFragmentManager(), this, viewPager);
        adapter.addTab(bar.newTab().setText("Fragment A"),
                CustomFragment_Page01.class, null);
        adapter.addTab(bar.newTab().setText("Fragment B"),
        		CustomFragment_Page02.class, null);
        adapter.addTab(bar.newTab().setText("Fragment C"),
        		CustomFragment_Page03.class, null);

        if (savedInstanceState != null) {
            bar.setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
        }
	}
	
	
	private void resourceInit()
	{
		viewPager = (ViewPager)findViewById(R.id.pager);
	}
}
