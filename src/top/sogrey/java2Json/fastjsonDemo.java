package top.sogrey.java2Json;

import top.sogrey.java2Json.bean.User;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * fastjson �汾�� 1.2.54
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
		String str = JSONObject.toJSONString(user);// fastjsonĬ��ת���ǲ����л�nullֵ��Ӧ��key��
		System.out.println(str);
		// �������ǣ�{"age":0,"userName":"Sogrey"}

		// �����Ҫ���л�null��Ӧ��key
		str = JSONObject
				.toJSONString(
						user,
						new SerializerFeature[] { SerializerFeature.WriteMapNullValue });
		System.out.println(str);
		// �������ǣ� {"age":0,"job":null,"userName":"Sogrey"}

		/**
		 * ����WriteMapNullValue���У� QuoteFieldNames������-���keyʱ�Ƿ�ʹ��˫����,Ĭ��Ϊtrue
		 * WriteMapNullValue�����C�Ƿ����ֵΪnull���ֶ�,Ĭ��Ϊfalse
		 * WriteNullNumberAsZero��-��ֵ�ֶ����Ϊnull,���Ϊ0,����null
		 * WriteNullListAsEmpty���CList�ֶ����Ϊnull,���Ϊ[],����null
		 * WriteNullStringAsEmpty���ַ������ֶ����Ϊnull,���Ϊ����,����null
		 * WriteNullBooleanAsFalse�CBoolean�ֶ����Ϊnull,���Ϊfalse,����null
		 */

		// ���ַ������ֶ����Ϊnull,ת�����Ϊ"",����null ����Ҫ���һ��������WriteNullStringAsEmpty
		str = JSONObject.toJSONString(user, new SerializerFeature[] {
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullStringAsEmpty });
		System.out.println(str);
		//�������ǣ�{"age":0,"job":"","userName":"Sogrey"}
	}
}
