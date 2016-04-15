package thirdstage.exercise.ejb3.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;
import org.jboss.annotation.ejb.TransactionTimeout;

/**
 * Session Bean implementation class CategoryServiceBean
 */
@Stateless(mappedName="ejb/CategoryService",name="CategoryService")
@Local({thirdstage.exercise.ejb3.catalog.CategoryService.class})
@Remote({thirdstage.exercise.ejb3.catalog.CategoryServiceRemote.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@LocalBinding(jndiBinding="ejb/CategoryService/local")
@RemoteBinding(jndiBinding="ejb/CategoryService/remote")
@TransactionTimeout(value=300)
public class CategoryServiceBean implements CategoryServiceRemote, CategoryService {

	
    /**
     * Default constructor. 
     */
    public CategoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see thirdstage.sample.shop4.catalog.category.CategoryService#findCategoriesByNamePart(java.lang.String)
	 */
	public List<Category> findCategoriesByNamePart(String namePart) {
		// TODO Auto-generated method stub
		List<Category> cats = new ArrayList<Category>();
		Category cat = new Category();
		cat.setId("100");
		cat.setName("Electronics");
		
		cats.add(cat);
		
		cat = new Category();
		cat.setId("200");
		cat.setName("Computer");
		
		cats.add(cat);
		
		cat = new Category();
		cat.setId("300");
		cat.setName("Apperal");
		cats.add(cat);
		
		return cats;
	}

	/* (non-Javadoc)
	 * @see thirdstage.sample.shop4.catalog.category.CategoryServiceRemote#findCategory(java.lang.String)
	 */
	public Category findCategory(String id) {
		// TODO Auto-generated method stub
		Category cat = new Category();
		cat.setId("100");
		cat.setName("Electronics");
		
		return cat;
	}

    
}
