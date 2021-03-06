package com.example.study_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class CustomPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{

	final int MAX_PAGE = 3;
	FragmentManager fm;
	
	
	public CustomPagerAdapter(FragmentManager fm) {
		super(fm);
		this.fm = fm;
		
	}

	@Override
	public Fragment getItem(int position) {
		FragmentPage frag = null;
		
		if(position == 0)
		{
			frag = new FragmentPage("첫번째 페이지");
		}
		else if(position == 1)
		{
			frag = new FragmentPage("두번째 페이지");	
		}
		else if(position == 2)
		{
			frag = new FragmentPage("세번째 페이지");
		}
		
		return frag;
	}

	@Override
	public int getCount() {
		return MAX_PAGE;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		System.out.println(position);
	}
	

}
