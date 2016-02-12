package DataBean;

import java.io.Serializable;
import java.util.ArrayList;

// 직렬화를 위해서 Serializable를 상속 받는다.
public class CustomSerialList extends ArrayList<Item> implements Serializable{

}
