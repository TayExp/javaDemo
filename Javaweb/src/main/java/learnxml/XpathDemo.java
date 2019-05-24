package learnxml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathDemo {

	public static void main(String[] args) throws DocumentException {
		// 加载dom树，合二为一
		Document doc = new SAXReader().read("./xml/web.xml");
		//获取节点
		List<Element> list = doc.selectNodes("/web-app/servlet/servlet-name");
		System.out.println(list.get(1).getText());
		Element ele = (Element) doc.selectSingleNode("//servlet/servlet-name");
		System.out.println(ele.getText());

	}

}
