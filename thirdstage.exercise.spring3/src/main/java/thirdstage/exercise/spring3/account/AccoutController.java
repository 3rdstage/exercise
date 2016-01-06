package thirdstage.exercise.spring3.account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/account")
public class AccoutController {
	
	private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();

	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model){
		model.addAttribute("account", new Account());
		return "account/CreateForm";
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Account account, BindingResult result){
		if(result.hasErrors()){
			return "account/CreateForm";
		}
		this.accounts.put(account.assignId(), account);
		return "redirect:/account/" + account.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String findById(@PathVariable Long id, Model model){
		Account account = this.accounts.get(id);
		if(account == null) throw new IllegalArgumentException();
		model.addAttribute("account", account);
		return "account/View";
	}
	
}
