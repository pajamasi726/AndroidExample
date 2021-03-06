package com.example.exam05_viewpager;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi")
public class CustomFragmentPageAdapter extends FragmentPagerAdapter implements ActionBar.TabListener , ViewPager.OnPageChangeListener{

	private final int PAGE = 3;
	
	
	private ActionBar mActionBar;
	private ViewPager mViewPager;
	private Context   mContext;
	
	private ArrayList<TabInfo> tab_list = new ArrayList<TabInfo>(1);
	
	public CustomFragmentPageAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public CustomFragmentPageAdapter(FragmentManager fm , FragmentActivity activity, ViewPager pager)
	{
		super(fm);
		
		mContext   = activity.getApplicationContext();
		// 액션바 지정
		mActionBar = activity.getActionBar();
		
		// 페이저 지정
		mViewPager = pager;
		
		// 어댑터 지정 
		mViewPager.setAdapter(this);
		
		// 체인지 리스너 지정
		mViewPager.setOnPageChangeListener(this);
	}
	
	public void addTab(ActionBar.Tab tab, Class<?> cls, Bundle bun)
	{
		TabInfo info = new TabInfo(cls, bun);
		// 태그 걸기 
		tab.setTag(info);
		// 이벤트 리스너
		tab.setTabListener(this);
		
		// 리스트에 추가 
		tab_list.add(info);
		
		// 액션바에 추가
		mActionBar.addTab(tab);
		// 갱신
		notifyDataSetChanged();
	}

	@Override
	public Fragment getItem(int position) {
		TabInfo info = tab_list.get(position);
        return Fragment.instantiate(mContext, info.cls.getName(), info.bun);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE;
	}

	
	
	// ActionBar 에서 선택을 했을때 일어나는 이벤트
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Object tag = tab.getTag();
        for (int i=0; i<tab_list.size(); i++) {
            if (tab_list.get(i) == tag) {
                mViewPager.setCurrentItem(i);
            }
        }
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	
	
	// ViewPager 스크롤 될때 일어나는 이벤트
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
		mActionBar.setSelectedNavigationItem(position);
	}
	
	

}
