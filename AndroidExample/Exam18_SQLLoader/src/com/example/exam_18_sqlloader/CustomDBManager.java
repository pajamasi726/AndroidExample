package com.example.exam_18_sqlloader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CustomDBManager extends SQLiteOpenHelper{
	
	public static final int 	DataBaseVersion = 1;
	SQLiteDatabase db;
	
	public CustomDBManager(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		this.dbOpen();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DB_Mark.SQL_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + DB_Mark.DB_TABLE);
        onCreate(db);
	}
	
	public void insert(ContentValues values)
	{
		db.insert(DB_Mark.DB_TABLE, null, values);
		
		System.out.println("DB Insert Success");
	}
	
	public Cursor allData()
	{
		String str = "";
		Cursor c = db.query(DB_Mark.DB_TABLE, null, null, null, null, null, null);
		return c; 
	}
	
	public void dbOpen()
	{
		db = this.getWritableDatabase();
	}
	
	public void dbClose()
	{
		db.close();
	}
}
