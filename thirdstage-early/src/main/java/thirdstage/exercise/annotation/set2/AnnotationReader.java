package thirdstage.exercise.annotation.set2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 *
 * @author 3rdstage
 * @version 0.7, 2007-09-04, 3rdstage
 * @since 2007-09-04
 */
public class AnnotationReader {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AnnotationReader.class);
	
	/** Creates a new instance of AnnotationReader */
	public AnnotationReader() {
	}
	
	public String[] getProcessIds(java.lang.Class controller) throws Exception{
		
		String[] ids = null;
		
		try{
			Class annotationClass = Class.forName("thirdstage.exercise.annotation.set2.Process");
			Process annotation = (Process)controller.getAnnotation(annotationClass);
			
			if(annotation != null) ids = annotation.ids();
			else ids = new String[]{};	//if the controller has no annotation of Process type
		} catch(Exception ex){
			//log exception or not ?
			System.err.println("catch block is executed.");
			throw ex;
		}
		
		return ids;
	}
	
	
	public org.w3c.dom.Document getProcessControllerMapXML(java.lang.Class controller) throws Exception{
		
		String[] ids = null;
		Document doc = null;
		
		try{
			DOMImplementation domImpl = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation();
			
			doc = domImpl.createDocument(null, "processes", null);
			Node rootElement = doc.getDocumentElement();
			
			Node processElement = doc.createElement("process");
			rootElement.appendChild(processElement);
			
			Text str = doc.createTextNode("Test Text");
			processElement.appendChild(str);
			
			
			Transformer trans = TransformerFactory.newInstance().newTransformer();
			Source input = new DOMSource(doc);
			Result output = new StreamResult(System.out);
			
			trans.transform(input, output);
			
		} catch(Exception ex){
			throw ex;
		}
		
		return null;
	}
}
