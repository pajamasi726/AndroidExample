package com.example.exam07_viewpager_01;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new CustomAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);

	}
}
