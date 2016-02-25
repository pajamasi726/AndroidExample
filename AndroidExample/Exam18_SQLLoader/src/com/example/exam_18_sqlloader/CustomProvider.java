package com.example.exam_18_sqlloader;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class CustomProvider extends ContentProvider{
	
	public static final String PROVIDER_NAME = "com.example.exam_18_sqlloader.CustomProvider";
	
	// ��ü ����� �˻� ��û 
	public static final String ALL_USER = "AllPerson";
	
	public static final Uri AllPERSON_URI = Uri.parse("content://"+PROVIDER_NAME+"/"+ALL_USER); // ������ �κ��� �˻� ��û �κ� 
	
	
	private static final int ALL_USER_MATCH = 1;
	
	private static final UriMatcher uriMatcher ;
	
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, ALL_USER, ALL_USER_MATCH); // ���� ,�н� ,�ڵ�
    }
    
    CustomDBManager dbmanager;
    

	// ����Ʈ ���ι��̴� ������ ȣ�� 
	@Override
	public boolean onCreate() {
		dbmanager = new CustomDBManager(getContext(), DB_Mark.DB_TABLE, null, 1);
		return true;
	}

	// ����Ʈ ���ι��̴� ������ ����
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		if(uriMatcher.match(uri)==ALL_USER_MATCH){
            return dbmanager.allData();
        }else{
            return null;
        }
	}

	// ������ MIME Ÿ���� ���� 
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	// ������ ���� 
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	// ������ ���� 
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	// ������ ������Ʈ 
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}