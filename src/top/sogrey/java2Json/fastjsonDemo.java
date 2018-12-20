package top.sogrey.java2Json;

import top.sogrey.java2Json.bean.User;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * fastjson 版本是 1.2.54
 * 
 * @author Administrator
 * 
 */
public class fastjsonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("Sogrey");
		String str = JSONObject.toJSONString(user);// fastjson默认转换是不序列化null值对应的key的
		System.out.println(str);
		// 输出结果是：{"age":0,"userName":"Sogrey"}

		// 如果需要序列化null对应的key
		str = JSONObject
				.toJSONString(
						user,
						new SerializerFeature[] { SerializerFeature.WriteMapNullValue });
		System.out.println(str);
		// 输出结果是： {"age":0,"job":null,"userName":"Sogrey"}

		/**
		 * 除了WriteMapNullValue还有： QuoteFieldNames———-输出key时是否使用双引号,默认为true
		 * WriteMapNullValue——–是否输出值为null的字段,默认为false
		 * WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
		 * WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
		 * WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
		 * WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
		 */

		// 想字符类型字段如果为null,转换输出为"",而非null ，需要多加一个参数：WriteNullStringAsEmpty
		str = JSONObject.toJSONString(user, new SerializerFeature[] {
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullStringAsEmpty });
		System.out.println(str);
		//输出结果是：{"age":0,"job":"","userName":"Sogrey"}
	}
}
