package DataBean;

import java.io.Serializable;

// 리스트의 객체들도 직렬화를 위해서 Serializable를 상속 받는다.
public class Item implements Serializable{
	
	public String name;
	public int age;
	

	public Item(String name, int age)
	{
		this.name 	= name;
		this.age 	= age;
	}
}
