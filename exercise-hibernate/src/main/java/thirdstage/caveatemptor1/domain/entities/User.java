package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import thirdstage.caveatemptor1.domain.values.Address;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@org.hibernate.annotations.AccessType("property")
@Table(name = "User")
public class User{

	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "homeCity")),
			@AttributeOverride(name = "street", column = @Column(name = "homeStreet")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "homeZipcode"))})
	private Address homeAddress;

}
