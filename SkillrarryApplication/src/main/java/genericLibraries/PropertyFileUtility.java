package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	private Properties property;
	public void propertyConfig(String filepath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
public String fetchProperty(String key) {
	return property.getProperty(key);
}
public void setDataToProperties(String key, String value,String filepath, String message) {
	property.put(key, value);
	try {
		property.store(new FileOutputStream(filepath),message);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
}
	