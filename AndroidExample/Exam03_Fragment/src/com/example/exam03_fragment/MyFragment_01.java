package com.example.exam03_fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class MyFragment_01 extends Fragment{
	
	/*
	public int Resource = R.layout.fragment01;
	
	public MyFragment_01(int resource)
	{
		this.Resource = resource;
	}
	*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		//System.out.println(Resource);
		return inflater.inflate(R.layout.fragment01, container, false);
	}

}
