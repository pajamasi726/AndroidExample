package com.example.exam10_nonactivityfragmentaccess;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class MyFragment_01 extends Fragment{
	
	public static Fragment fragment;
	public View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		// 현재 프래그먼트 지정
		fragment = this;
		
		view = inflater.inflate(R.layout.fragment01, container, false);
		
		return view;
	}

}
