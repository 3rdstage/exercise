package thirdstage.exercise.spring3.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/services/")
public final class ProcessController {
	
		private Object requestLogger;

		private Object requestDecryptor;
		
		private Object requestAuthenticator;
		
		private Object resquestAuthorizor;
		
		private List<?> commonPreprocesses;
		
		private Object requestParser;

		//@Required
		public void setRequestLogger(Object logger){
			this.requestLogger = logger;
		}
		
		@RequestMapping(value="{serviceId}")
		public String process(@PathVariable String serviceId, Model model){

			/*
			   1. Accept request.
			   2. Log request, if necessary.
			   3. Decrypt request, if necessary.
			   4. Parse request header into header object.
			   5. Validate request header.
			   6. Decrypt request body, if necessary.
			   7. Parse request body into request object and context object.
			   8. Validate request body, if necessary.
			   9. Resolve routing target.
			  10. Access locater and get processor.
			  11. Execute processor and get response object and context object.
			  12. Validate response object and context object, if necessary.
			  13. Resolve response code or message code.
			  14. Build response.
			  15. Encrypt response, if necessary
			  16. Return response.

			 */			

			this.decryptRequest();
			this.logRequest();
			

			
			
			return "process/ProcessResponse";
		}
		
		private void logRequest(){}
		
		private void decryptRequest(){}
		
		
		
	

}
