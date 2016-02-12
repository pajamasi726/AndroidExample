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
		// �׼ǹ� ����
		mActionBar = activity.getActionBar();
		
		// ������ ����
		mViewPager = pager;
		
		// ����� ���� 
		mViewPager.setAdapter(this);
		
		// ü���� ������ ����
		mViewPager.setOnPageChangeListener(this);
	}
	
	public void addTab(ActionBar.Tab tab, Class<?> cls, Bundle bun)
	{
		TabInfo info = new TabInfo(cls, bun);
		// �±� �ɱ� 
		tab.setTag(info);
		// �̺�Ʈ ������
		tab.setTabListener(this);
		
		// ����Ʈ�� �߰� 
		tab_list.add(info);
		
		// �׼ǹٿ� �߰�
		mActionBar.addTab(tab);
		// ����
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

	
	
	// ActionBar ���� ������ ������ �Ͼ�� �̺�Ʈ
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

	
	
	// ViewPager ��ũ�� �ɶ� �Ͼ�� �̺�Ʈ
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