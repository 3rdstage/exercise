package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@org.hibernate.annotations.AccessType("property")
public abstract class BillingDetails1{

	@Column(name = "owner", nullable = false)
	private String owner;

}
