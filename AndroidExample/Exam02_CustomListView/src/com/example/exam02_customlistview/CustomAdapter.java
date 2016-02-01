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
 * 커스텀 리스트 뷰를 위해서 커스텀 어댑터를 만든다.
 * @author Administrator
 *
 */
public class CustomAdapter extends BaseAdapter{

	// 데이터를 저장할 리스트
	ArrayList<ItemData> data;
	
	/**
	 * 생성자 메소드
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
		// context 얻어오기
		final Context context = parent.getContext();
		
		// 항목 객체
		ItemHolder item;
		
		// 리스트뷰 데이터
		ItemData   item_data;
		
		if(convertView == null) // view 가 생성 되어 있지 않은 경우 
		{
			// 레이아웃 받아오기
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.custom_item, parent, false);
	         
	        // 리소스 연결 
	        item = new ItemHolder();
	        item.item_tv    = (TextView) convertView.findViewById(R.id.item_tv);
	        item.item_btn   = (Button) convertView.findViewById(R.id.item_btn);
	        
	        
	        // 태그 등록
	        convertView.setTag(item);
		}
		else // 생성되어 있는 뷰 일때 
		{
			item = (ItemHolder)convertView.getTag();
		}
		
		item_data = data.get(position);
		
		
		item.item_tv.setText(item_data.room_Name);
		item.item_btn.setText(item_data.btn_Name);
		
		// 버튼 이벤트
		item.item_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(context, data.get(position).room_Name, Toast.LENGTH_SHORT).show();
				
			}
		});
		
	
		// 좌우로 설정
		if(item_data.room_Name.equals("에브리바디"))
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
