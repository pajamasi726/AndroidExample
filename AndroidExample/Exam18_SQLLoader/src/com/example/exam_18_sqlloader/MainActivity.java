package com.example.exam_18_sqlloader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
@SuppressLint("NewApi")
public class MainActivity extends Activity implements LoaderCallbacks<Cursor>{

	EditText edt;
	ListView lv;
	CustomCursorAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edt = (EditText)findViewById(R.id.edt1);
		lv = (ListView)findViewById(R.id.lv);
		
		adapter = new CustomCursorAdapter(this, null);
		lv.setAdapter(adapter);
		
		getLoaderManager().initLoader(0, null, this);
		
		
	}
	
	public void onClick(View v)
	{
		ContentValues values = new ContentValues();
		values.put(DB_Mark.DB_COL_NAME, edt.getText().toString());
		
		getContentResolver().insert(CustomProvider.INSERT_USER_URI, values);
		
		getLoaderManager().restartLoader(0, null, this);
		
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		System.out.println("creater id : "+id);
		Uri uri = null;
		switch(id)
		{
			case CustomProvider.ALL_USER_MATCH :
				uri = CustomProvider.AllPERSON_URI;
			break;
			
			case CustomProvider.INSERT_USER_MATCH :
				uri = CustomProvider.INSERT_USER_URI;
			break;
		
		}
		return new CursorLoader(this, uri, null, null, null, null);
	}

	
	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		adapter.swapCursor(data);
		System.out.println("Finished");
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		adapter.swapCursor(null);
		System.out.println("LoaderReset");
		
		
	}
}
