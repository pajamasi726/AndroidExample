package com.example.exam02_customlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	
	ListView lv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = (ListView)findViewById(R.id.listView1);
        
        CustomAdapter adapter = new CustomAdapter();
        
        lv.setAdapter(adapter);
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
        
        adapter.add_Data(new ItemData("���긮�ٵ�","����"));
        adapter.add_Data(new ItemData("ȫ�浿","����"));
      
    }
}
