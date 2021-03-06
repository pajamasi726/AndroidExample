package com.example.exam_18_sqlloader;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class CustomProvider extends ContentProvider{
	
	public static final String PROVIDER_NAME = "com.example.exam_18_sqlloader.CustomProvider";
	
	// 전체 사용자 검색 요청 
	public static final String ALL_USER = "AllPerson";
	public static final String INSERT_USER = "InsertUser";
	
	public static final Uri AllPERSON_URI = Uri.parse("content://"+PROVIDER_NAME+"/"+ALL_USER); // 마지막 부분은 검색 요청 부분 
	public static final Uri INSERT_USER_URI = Uri.parse("content://"+PROVIDER_NAME); // 마지막 부분은 검색 요청 부분 
	
	public static final int ALL_USER_MATCH 		= 0;
	public static final int INSERT_USER_MATCH 	= 1;
	
	private static final UriMatcher uriMatcher_AllUser ;
	
    static {
        uriMatcher_AllUser = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher_AllUser.addURI(PROVIDER_NAME, ALL_USER, ALL_USER_MATCH); // 구별 ,패스 ,코드
    }
    
    private static final UriMatcher uriMatcher_InsertUser ;
	
    static {
    	uriMatcher_InsertUser = new UriMatcher(UriMatcher.NO_MATCH);
    	uriMatcher_InsertUser.addURI(PROVIDER_NAME, INSERT_USER, ALL_USER_MATCH); // 구별 ,패스 ,코드
    }
    
    CustomDBManager dbmanager;
    

	// 컨텐트 프로바이더 생성시 호출 
	@Override
	public boolean onCreate() {
		dbmanager = new CustomDBManager(getContext(), DB_Mark.DB_TABLE, null, 1);
		return true;
	}

	// 컨텐트 프로바이더 쿼리문 실행
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		if(uriMatcher_AllUser.match(uri)==ALL_USER_MATCH){
            return dbmanager.allData();
        }else{
            return null;
        }
	}

	// 데이터 MIME 타입을 리턴 
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	// 데이터 삽입 
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		System.out.println("ContentProvider Insert");
		
		dbmanager.insert(values);
		return null;
	}

	// 데이터 삭제 
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	// 데이터 업데이트 
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
