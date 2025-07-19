package utils;

import java.util.Properties;
import java.io.*;

public class ConfigRead {
	
	public static Properties readConfigProperties(String filename) throws Exception{
		
		filename = filename.trim();
		
		Properties configProp = new Properties();
		
		InputStream inStream = new FileInputStream(filename);
		
		configProp.load(inStream);
		
		return configProp;
	}

}
