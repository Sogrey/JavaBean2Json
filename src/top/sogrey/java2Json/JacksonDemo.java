package top.sogrey.java2Json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import top.sogrey.java2Json.bean.User;

/**
 * jackson�汾 1.9.13
 * @author Administrator
 *
 */
public class JacksonDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		User user = new User();
		user.setUserName("Sogrey");
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(user);
		System.out.println(str);
		//�����{"job":null,"userName":"Sogrey","age":0}
		//jackson Ĭ�����л� null
		
		
		//��Ҫ�����л�nullҲ�ǿ��Ե�
		
	}

}
