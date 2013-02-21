package thirdstage.exercise.ejb3.catalog;
import javax.ejb.Remote;

@Remote
public interface CategoryServiceRemote {

	Category findCategory(String id);

	
}
