package com.example.exam17_sqladapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter{


	
	public CustomCursorAdapter(Context context, Cursor c) {
		super(context, c);
	}

	// List를 나타낼 View를 리턴 
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.rawitem, parent, false);
		return v;
	}

	// cursor이 가리키고 있는 data를 view에 연결 시키는 메소드
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView tv = (TextView)view.findViewById(R.id.itemTv);
		tv.setText(cursor.getString(cursor.getColumnIndex(DB_Mark.DB_COL_NAME)));
	}

}
