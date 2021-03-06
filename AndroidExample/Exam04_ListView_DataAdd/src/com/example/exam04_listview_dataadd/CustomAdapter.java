package com.example.exam04_listview_dataadd;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

	private ArrayList<ItemDTO> list;
	private CustomAdapter adapter;

	public CustomAdapter() {
		this.adapter 	= this;
		list	 		= new ArrayList<ItemDTO>(1);
	}

	public ArrayList<ItemDTO> getData() {
		return this.list;
	}

	public void addData(ItemDTO item) {
		list.add(item);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// context 얻어오기
		final Context context = parent.getContext();
		
		// 항목 객체
		ItemHolder itemHolder;

		// 리스트뷰 데이터
		ItemDTO itemDTO;

		if (convertView == null) // view 가 생성 되어 있지 않은 경우
		{
			// 레이아웃 받아오기
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listitem, parent, false);

			// 리소스 연결
			itemHolder = new ItemHolder();
			itemHolder.tv = (TextView) 	convertView.findViewById(R.id.itemtv);
			itemHolder.btn = (Button) 	convertView.findViewById(R.id.itembtn);

			// 태그 등록
			convertView.setTag(itemHolder);
		} 
		else // 생성되어 있는 뷰 일때
		{
			itemHolder = (ItemHolder) convertView.getTag();
		}

		itemDTO = list.get(position);

		itemHolder.tv.setText(itemDTO.name);
		itemHolder.btn.setText("삭제");

		// 버튼 이벤트
		itemHolder.btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(context, list.get(position).name,
						Toast.LENGTH_SHORT).show();
				list.remove(position);
				
				// 데이터 갱신
				adapter.notifyDataSetChanged();
			}
		});

		return convertView;
	}

}
