package thirdstage.exercise.xml.dom.case1;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.*;

/**
 * Example from the book "Processing XML with Java" chapter 10
 *
 * @version 1.0, 2007-09-06, 3rdstage
 * @author 3rdstage
 */
public class SimpleCreationXML2 {
	
	public static void main(String[] args) {
		
		try {
			
			// Find the implementation
			DOMImplementation domImpl = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation();

			
			Document doc = domImpl.createDocument(null, "processes", null);
			Node rootElement = doc.getDocumentElement();
			
			Node processElement = doc.createElement("process");
			rootElement.appendChild(processElement);
		
			Text str = doc.createTextNode("Test Text");
			processElement.appendChild(str);
			
			
			// Serialize the document onto System.out
			TransformerFactory xformFactory
					= TransformerFactory.newInstance();
			Transformer idTransform = xformFactory.newTransformer();
			Source input = new DOMSource(doc);
			Result output = new StreamResult(System.out);
			idTransform.transform(input, output);
			
		} catch (FactoryConfigurationError e) {
			System.out.println("Could not locate a JAXP factory class");
		} catch (ParserConfigurationException e) {
			System.out.println(
					"Could not locate a JAXP DocumentBuilder class"
					);
		} catch (DOMException e) {
			System.err.println(e);
		} catch (TransformerConfigurationException e) {
			System.err.println(e);
		} catch (TransformerException e) {
			System.err.println(e);
		}
		
	}
	
}

