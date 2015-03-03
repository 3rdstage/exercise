package thirdstage.exercise.spring.hibernate3.case1;

/**
 *
 * @author 3rdstage
 */
public interface GenericDao<T, PK extends java.io.Serializable> {
	
	PK create(T newInstance);
	
	T read(PK id);
	
	void update(T transientObject);
	
	void delete(T persistentObject);
	
	
}
