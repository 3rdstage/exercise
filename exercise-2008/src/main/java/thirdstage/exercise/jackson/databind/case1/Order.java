/**
 * 
 */
package thirdstage.exercise.jackson.databind.case1;

import javax.annotation.RegEx;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author 3rdstage
 *
 */
@XmlRootElement(name="order")
@XmlType(name="", propOrder={"id", "poNo", "createDate"})
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"id", "poNo", "createDate"})
public class Order {
	
	@XmlElement(name="id")
	@JsonProperty("id")
	private String id;
	
	@XmlElement(name="create-date")
	@JsonProperty
	private String createDate;

	@XmlElement(name="po-no")
	@JsonProperty("poNo")
	private String poNo;
	
	public Order(){}
	
	public String getId(){ return this.id; }
	public void setId(String id){ this.id = id; }
	
	public String getCreateDate(){ return this.createDate; }
	public void setCreateDate(String date){ this.createDate = date; }
	
	public String getPoNo(){ return this.poNo; }
	public void setPoNo(String no){ this.poNo = no; }
	
	

}
