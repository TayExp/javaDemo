package cCollections;

import java.util.Properties;

public class Main1 {
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
		props.load(Main1.class.getResourceAsStream("/cSet/setting.properties"));
		String url = props.getProperty("url");
		String lang = props.getProperty("lauguage");
		String title = props.getProperty("title");
		String description = props.getProperty("course.description", "default");
		System.out.println(url);
		System.out.println(lang);
		System.out.println(title);
		System.out.println(description);
	}
}
