/**
 * 
 */
package thirdstage.exercise.jersey.spring3;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
public abstract class BaseResource{

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Will be INJECTED automatically by container
	 */
	@Context
	protected ResourceContext resourceContext;

	/**
	 * This method logs exception and returns proper {@code WebApplicationException} according to JAX-RS based
	 * on the specified exception.  The log follows {@link org.slf4j.Logger.html#error(java.lang.String, java.lang.Object...)}
	 * using {@code ex}, {@code msgPattern} and {@code msgArgs}.
	 *
	 * The returned {@code WebApplicationException} contains proper status code like 4xx or 5xx.
	 *
	 * @param headers
	 * @param ex
	 * @param msgFormat
	 * @param msgArgs
	 * @return an @@WebApplicationException@ exception containing proper status code and status message.
	 * @see org.slf4j.Logger.html#error(java.lang.String, java.lang.Object...)
	 * @see javax.ws.rs.WebApplicationException
	 */
	//@todo need more detail on Javadoc
	protected WebApplicationException handleException(@Nullable HttpHeaders headers,
		@Nonnull Exception ex, @Nullable String msgPattern, @Nullable Object... msgArgs){
		//refer http://www.slf4j.org/apidocs/index.html?org/slf4j/Logger.html

		String msg = "";
		if(msgPattern != null){ msg = MessageFormatter.arrayFormat(msgPattern, msgArgs).getMessage(); }
		else{ msg = (ex != null) ? ex.getMessage() : ""; }

		logger.error(msg, ex);

		if(ex instanceof IllegalArgumentException){
			throw new WebApplicationException(ex, Response.Status.BAD_REQUEST);
		}else{
			throw new WebApplicationException(ex, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
