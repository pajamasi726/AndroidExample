package com.example.exam16_sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

@SuppressLint("NewApi")
public class CustomDBManager extends SQLiteOpenHelper{

	// ������  DB�̸��� ������ �޴´�
	public CustomDBManager(Context context, String DBname, CursorFactory factory, int DBversion) {
		super(context, DBname, factory, DBversion);
	}

	// �����ڿ��� �Ѱܹ��� �̸��� ������ �����ͺ��̽��� ���� ���� ������ ȣ��
	// �ʱ� �����ÿ� 1�� ȣ���� �ȴ�.
	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer sb = new StringBuffer();
		
		// ������ ���� 
		sb.append("CREATE TABLE STUDENT( ");
		sb.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sb.append("name TEXT, ");
		sb.append("phonenum INTEGER);");
		
		// ���� ����
		db.execSQL(sb.toString());
	}

	
	// DB������ �ٸ��� ȣ��ȴ�. ������ �÷��ְ� ������ ���ο� �۾�
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	public void insert(String name, int phonenum)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Insert into STUDENT (name,phonenum) VALUES (?,?)");
		
		SQLiteDatabase db = getWritableDatabase();
		SQLiteStatement statement = db.compileStatement(sb.toString());
		
		statement.bindString(1, name);
		statement.bindLong(2, phonenum);
		
		long result = statement.executeInsert();
		System.out.println("DB �Է� ��� : "+result);
		
		statement.close();
		db.close();
	}
	
	public void update(int id, String name)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Update STUDENT set name = ? where _id = ?");
		
		SQLiteDatabase db = getWritableDatabase();
		SQLiteStatement statement = db.compileStatement(sb.toString());
		
		statement.bindString(1, name);
		statement.bindLong(2, id);
		statement.executeUpdateDelete();
		
		statement.close();
		db.close();
	}
	
	public void delete(int id)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Delete from STUDENT where _id = ?");
		
		SQLiteDatabase db = getWritableDatabase();
		SQLiteStatement statement = db.compileStatement(sb.toString());
		
		statement.bindLong(1, id);
		statement.executeUpdateDelete();
		
		statement.close();
		db.close();
	}
	
	public String select()
	{
		String str = "";
		
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from STUDENT");
		
		
		SQLiteDatabase db = getWritableDatabase();
		
		Cursor cursor = db.rawQuery(sb.toString(), null);
		
		while(cursor.moveToNext())
		{
			str += "Id : "+cursor.getInt(0);
			str += "\t name : "+cursor.getString(1);
			str += "\t phonenum : "+cursor.getInt(2);
			str += "\n";
		}
		
		cursor.close();
		db.close();
		return str;
	}
	

}