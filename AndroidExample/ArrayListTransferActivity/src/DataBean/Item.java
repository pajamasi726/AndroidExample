package DataBean;

import java.io.Serializable;

// ����Ʈ�� ��ü�鵵 ����ȭ�� ���ؼ� Serializable�� ��� �޴´�.
public class Item implements Serializable{
	
	public String name;
	public int age;
	

	public Item(String name, int age)
	{
		this.name 	= name;
		this.age 	= age;
	}
}
