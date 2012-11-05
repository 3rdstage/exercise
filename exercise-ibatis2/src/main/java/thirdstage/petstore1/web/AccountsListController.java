package thirdstage.petstore1.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import thirdstage.petstore1.domain.entities.Account;
import thirdstage.petstore1.services.PetStoreFacade;

public final class AccountsListController extends AbstractController{
	
	private PetStoreFacade petStore;


	public AccountsListController(){
		this.setRequireSession(true);
		this.setSupportedMethods(new String[]{METHOD_GET});
	}

	@Required
	public void setPetStore(PetStoreFacade petStore){
		this.petStore = petStore;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception{
		List<Account> accounts = new ArrayList<Account>();
		List<String> usernames = this.petStore.getAllUsernames();
		
		for(String username : usernames){
			accounts.add(this.petStore.getAccount(username));
		}
		
		ModelAndView mav = new ModelAndView("account/AccountsList");
		mav.addObject("accounts", accounts);
		
		return mav;
	}

}
