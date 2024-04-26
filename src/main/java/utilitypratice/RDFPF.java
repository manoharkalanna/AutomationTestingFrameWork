package utilitypratice;

import java.io.FileInputStream;
import java.util.Properties;

public class RDFPF {
	public static void main(String[] args)throws Throwable {
		
		String path = "C:\\Users\\Dell\\OneDrive\\Desktop\\AutomationSelenium\\New folder\\config.properties.txt";
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
