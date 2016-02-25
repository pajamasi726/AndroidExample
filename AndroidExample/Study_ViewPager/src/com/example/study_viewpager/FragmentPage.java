package com.example.study_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPage extends Fragment{
	
	String page = "";
	TextView tv;
	ViewGroup root;
	
	public FragmentPage(String page)
	{
		this.page = page;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		root = (ViewGroup)inflater.inflate(R.layout.fragmentpage, container, false);
		tv = (TextView)root.findViewById(R.id.tv);
		tv.setText(page);
		
		return root;
	}
}