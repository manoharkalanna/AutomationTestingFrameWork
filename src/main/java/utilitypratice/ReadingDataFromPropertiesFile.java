package utilitypratice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingDataFromPropertiesFile {
	
	public static void main(String[] args)throws Throwable {
		
		String path ="C:\\Users\\Dell\\eclipse-workspace\\MavenFrameWorkSelenium\\TestData\\config.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("Browser"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("date"));
				
	}

}
