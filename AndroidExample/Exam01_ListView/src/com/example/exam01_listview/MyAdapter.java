package com.example.exam01_listview;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyAdapter extends ArrayAdapter<String>{

	// ����ڷ� ���� ��� ���� ������ �޼ҵ�
	public MyAdapter(Context context, int resource,
			List<String> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

}
