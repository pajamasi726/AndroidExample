package com.example.study_viewpager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {
	
	FragmentManager fm;
	ViewPager pager;
	CustomPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pager = (ViewPager)findViewById(R.id.pager);
		
		fm = getSupportFragmentManager();
		adapter = new CustomPagerAdapter(fm);
		
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(adapter);
		
	}
}
