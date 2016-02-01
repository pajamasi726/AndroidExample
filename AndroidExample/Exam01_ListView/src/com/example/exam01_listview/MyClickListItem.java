package com.example.exam01_listview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MyClickListItem implements OnItemClickListener{

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		System.out.println("item Click");
		MyAdapter imsi = (MyAdapter)parent.getAdapter();
		System.out.println(position+" : ��° Ŭ�� "+imsi.getItem(position));
		
	}

}
