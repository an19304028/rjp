package properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class CreateDataBaseInstance {


	public static Object getInstance(String key) {
		Object o = null;
		try {
			Properties p = new Properties();
			//if(instance.containsKey(key)==false) {
				InputStream file = CreateDataBaseInstance.class.getClassLoader().getResourceAsStream("instance.properties");
				p.load(file);
				//p.load(new FileInputStream("instance.properties"));
				String name = p.getProperty(key);
				
				Class c = Class.forName(name);
				o = c.newInstance();
				//instance.put(key,o);
			//}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(o);
		
		return o;
		
		
	}
}
