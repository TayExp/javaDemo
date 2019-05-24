package learnxml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

// 导入jar包
public class Dom4jDemo {
	public static void main(String[] args) throws DocumentException {
		// 创建一个核心对象SAXReader
		SAXReader reader = new SAXReader();
		// 将xml文档加载到内存中形成一棵树
		Document doc = reader.read("./xml/web.xml");
		// 获取根节点 
		Element root = (Element) doc.getRootElement();
		// 获取所有子元素.elements()
		List<Element> list = root.elements();
		for(Element e : list){
			//servlet-name的标签体elementText("子标签名")
			String text = e.elementText("servlet-name"); 
			System.out.println(text);
		}
		// 获取root的version属性值attributeValue("属性名")
		String value = root.attributeValue("version");
		System.out.println(value);
	}
}
