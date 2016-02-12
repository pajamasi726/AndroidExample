package com.example.exam11_activitytoactivityarraylist;

import java.io.Serializable;

public class Item implements Serializable{
	
	public String name;
	public int age;
	

	public Item(String name, int age)
	{
		this.name 	= name;
		this.age 	= age;
	}
}
