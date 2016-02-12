package com.example.exam11_activitytoactivityarraylist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * ArrayList 데이터를 다음 액티비티로 넘기는 예제
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	public void onClick(View v)
	{
		ItemBean item = new ItemBean();
		
		
		
		item.add(new Item("A",1));
		item.add(new Item("B",2));
		item.add(new Item("C",3));
		item.add(new Item("D",4));
		item.add(new Item("E",5));
		
		
		Intent intent = new Intent(MainActivity.this , SecondActivity.class);
		intent.putExtra("item", item);
		
		startActivity(intent);
		
	}
}
