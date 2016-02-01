package com.example.exam02_customlistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Ŀ���� ����Ʈ �並 ���ؼ� Ŀ���� ����͸� �����.
 * @author Administrator
 *
 */
public class CustomAdapter extends BaseAdapter{

	// �����͸� ������ ����Ʈ
	ArrayList<ItemData> data;
	
	/**
	 * ������ �޼ҵ�
	 */
	public CustomAdapter() {
		data = new ArrayList<ItemData>(1);
	}
	
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// context ������
		final Context context = parent.getContext();
		
		// �׸� ��ü
		ItemHolder item;
		
		// ����Ʈ�� ������
		ItemData   item_data;
		
		if(convertView == null) // view �� ���� �Ǿ� ���� ���� ��� 
		{
			// ���̾ƿ� �޾ƿ���
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.custom_item, parent, false);
	         
	        // ���ҽ� ���� 
	        item = new ItemHolder();
	        item.item_tv    = (TextView) convertView.findViewById(R.id.item_tv);
	        item.item_btn   = (Button) convertView.findViewById(R.id.item_btn);
	        
	        
	        // �±� ���
	        convertView.setTag(item);
		}
		else // �����Ǿ� �ִ� �� �϶� 
		{
			item = (ItemHolder)convertView.getTag();
		}
		
		item_data = data.get(position);
		
		
		item.item_tv.setText(item_data.room_Name);
		item.item_btn.setText(item_data.btn_Name);
		
		// ��ư �̺�Ʈ
		item.item_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(context, data.get(position).room_Name, Toast.LENGTH_SHORT).show();
				
			}
		});
		
	
		// �¿�� ����
		if(item_data.room_Name.equals("���긮�ٵ�"))
		{
			RelativeLayout.LayoutParams param =  new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			param.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
			item.item_tv.setLayoutParams(param);
		}
		else
		{
			
		}
		
		
		return convertView;
	}
	
	
	public void add_Data(ItemData item)
	{
		data.add(item);
	}
	

}
