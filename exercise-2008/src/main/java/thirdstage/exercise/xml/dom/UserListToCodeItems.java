/**
 * 
 */
package thirdstage.exercise.xml.dom;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * <p>
 * Nexbuild server의 사용자 목록 XML 파일로 부터 SKF_CODE_ITEM 테이블에 개발자별 연습용 업무코드를 등록할 
 * <code>INSERT</code> 문장을 생성한다.
 * <br/><br/>
 * 사용자 목록 XML 파일은 <code><i>nexbuild-server-home<i>/data/db/nexcore-user.dbdata</code>
 * 에 위치하며, 이 class를 적용하기 위해서는 encoding을 EUC-KR로 고쳐주도록 한다. 
 * </p>
 * 
 * @version 1.0, 2010-04-30, Sangmoon Oh, Initial 
 * @since 2010-04-30
 */
public class UserListToCodeItems{

	public static void echoXmlRelatedSystemProperties(){

		List<String> keys = new ArrayList<String>();

		keys.add("javax.xml.parsers.SAXParserFactory");
		keys.add("javax.xml.parsers.DocumentBuilderFactory");
		keys.add("javax.xml.transform.TransformerFactory");

		for(String key : keys){
			System.out.println(key + " : " + System.getProperty(key));
		}
	}

	public static void main(String[] arg){
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");

		echoXmlRelatedSystemProperties();

		try{

			String path = "thirdstage/exercise/xml/dom/user-list.xml";
			InputStream is = ClassLoader.getSystemResourceAsStream(path);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			// Document doc = builder.parse(is);
			Document doc = builder.parse(new InputSource(new InputStreamReader(is, "EUC-KR")));

			XPath xpath = XPathFactory.newInstance().newXPath();
			String expr = "/user-list/user/userName";
			NodeList nodes = (NodeList) xpath.evaluate(expr, doc, XPathConstants.NODESET);

			org.w3c.dom.Node node = null;
			String userName = null;
			String userId = null;
			StringBuilder sql = null;

			Map<String, String> users = new HashMap(); 
			for(int i = 0, n = nodes.getLength(); i < n; i++){
				node = nodes.item(i);
				//@todo correct node.getTextContent()
				//userName = node.getTextContent();
				userId = node.getParentNode().getAttributes().getNamedItem("userId").getNodeValue();

				users.put(userId, userName);
			}

			Set<String> keys = users.keySet();
			List<String> keyList = new ArrayList(keys);
			java.util.Collections.sort(keyList);

			int i = 0;
			for(String key : keyList){
				userId = key;
				userName = users.get(key);

				sql = new StringBuilder(300)
						.append(
								"insert into skf_code_item (code_xd, locale_xd, code_group_id, code_name, code_short_name, display_index, use_able_flag_xd, attr_value01, attr_value02, use_from_date, use_to_date)\n")
						.append("values ('exercise-").append(userId).append("', 'ko_KR', 'SKF0091', '").append(userName)
						.append("', '").append(userName).append("', ").append((i++) * 10).append(", '1', '").append(userId)
						.append("', 'exercise', '20010101', '99991231');\n\n");

				System.out.print(sql.toString());
			}

		}catch(Exception e){
			e.printStackTrace(System.err);
		}
	}
}
