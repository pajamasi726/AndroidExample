package com.example.exam17_sqladapter;

public final class DB_Mark {
	public static final String DB_NAME = "pserson.db";
	public static final String DB_COL_NAME = "name";
	public static final String DB_TABLE = "Person";
	public static final String SQL_CREATE = "create table "+DB_TABLE+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+DB_COL_NAME+" TEXT);";
	
}
