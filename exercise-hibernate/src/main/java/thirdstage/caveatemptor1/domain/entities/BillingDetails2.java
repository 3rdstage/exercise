package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@org.hibernate.annotations.AccessType("property")
public abstract class BillingDetails2{

	@Id
	@GeneratedValue
	@Column(name = "billingDetailId")
	private Long id;

	@Column(name = "owner", nullable = false)
	private String owner;
}
