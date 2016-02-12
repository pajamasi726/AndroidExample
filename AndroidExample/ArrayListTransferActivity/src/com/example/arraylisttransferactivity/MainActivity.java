package com.example.arraylisttransferactivity;

import DataBean.CustomSerialList;
import DataBean.Item;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * ArrayList �����͸� ���� ��Ƽ��Ƽ�� �ѱ�� ����
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
		// ������ ����
		CustomSerialList item = createItem();
		
		Intent intent = new Intent(MainActivity.this , SecondActivity.class);
		intent.putExtra("item", item);
		
		startActivity(intent);
	}
	
	
	// ������ ���� �� ��ü ����
	private CustomSerialList createItem()
	{
		CustomSerialList item = new CustomSerialList();
		
		for(int i = 0 ; i < 2000; i++)
		{
			item.add(new Item("A",i));
		}
		
		return item;
	}
}