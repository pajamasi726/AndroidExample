package com.example.exam17_sqlitelistview;

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

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.rawitem, parent, false);
		return v;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView tv = (TextView)view.findViewById(R.id.itemTv);
		tv.setText("!");
		tv.setText(cursor.getString(cursor.getColumnIndex(CustomDBManager.DB_COL_NAME)));
	}

}
