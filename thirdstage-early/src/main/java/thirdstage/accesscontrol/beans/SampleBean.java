/*
 * SampleBean.java
 *
 * Created on 2005-03-13
 */

package thirdstage.accesscontrol.beans;

import java.beans.*;
import java.io.Serializable;

/**
 * @author 3rdstage
 */
public class SampleBean extends Object implements Serializable {
	
	public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
	
	private String sampleProperty;
	
	private PropertyChangeSupport propertySupport;
	
	public SampleBean() {
		propertySupport = new PropertyChangeSupport(this);
	}
	
	public String getSampleProperty() {
		return sampleProperty;
	}
	
	public void setSampleProperty(String value) {
		String oldValue = sampleProperty;
		sampleProperty = value;
		propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
	}
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}
	
}
