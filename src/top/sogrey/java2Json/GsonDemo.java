package top.sogrey.java2Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import top.sogrey.java2Json.bean.User;

public class GsonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("Sogrey");
		Gson g = new GsonBuilder().create();
		String str = g.toJson(user);
		System.out.println(str);
		// {"userName":"Sogrey","age":0}
		// 若是想序列化null值对应的key，只需要将以上创建代码改成以下代码就行：

		g = new GsonBuilder().serializeNulls().create();
		str = g.toJson(user);
		System.out.println(str);
		// {"userName":"Sogrey","age":0,"job":null}
	}
}
