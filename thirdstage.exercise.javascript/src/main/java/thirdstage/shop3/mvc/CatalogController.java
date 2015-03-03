package thirdstage.shop3.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import thirdstage.shop3.catalog.value.Product;

@Controller
public class CatalogController {

	@RequestMapping(value = "/whoru", 
			consumes = "application/json", produces = "application/json",
			method = RequestMethod.GET)
	@ResponseBody
	public String knock(Model model){
		String name = this.getClass().getCanonicalName();
		
		return "{\"controllerClass\" : \"" + name.trim() + "\"}";
		
	}
	
	
	@RequestMapping(value = "/categories/{categoryId}/products",
			method = RequestMethod.GET)
	public @ResponseBody List<Product> findProductsByCategory(){
		
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product("PRD0001", "LG Optimus G", null, ""));
		products.add(new Product("PRD0002", "iPhone 5S", null, ""));
		
		return products;
	}
	
}
