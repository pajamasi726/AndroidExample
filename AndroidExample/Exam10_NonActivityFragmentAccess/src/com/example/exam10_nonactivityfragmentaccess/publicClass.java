package com.example.exam10_nonactivityfragmentaccess;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;
import android.widget.Button;

public class publicClass {

	FragmentManager fragmentManager;
	
	public publicClass(FragmentManager fragmentManager) {
		this.fragmentManager = fragmentManager;
	}

	@SuppressLint("NewApi")
	public void setText(String string) {
		Fragment frag = fragmentManager.findFragmentById(R.id.fragment_place);
		
		// View �˾ƿ���
		View _v = frag.getView();
		
		
		Button btn3 = (Button)_v.findViewById(R.id.button1);
		btn3.setText(string);
		
	}

}
