/**
 * 
 */
package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductValue {

	public ProductValue(){}
	
}
