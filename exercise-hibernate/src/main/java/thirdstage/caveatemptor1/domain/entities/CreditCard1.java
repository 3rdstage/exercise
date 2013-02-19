package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AttributeOverride(name = "owner", column = @Column(name = "cardOwner", nullable = false))
@Table(name = "CreditCard1")
@org.hibernate.annotations.AccessType("property")
public class CreditCard1 extends BillingDetails1{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "creditCardId")
	private Long id;

	@Column(name = "cardNumber", nullable = false)
	private String cardNumber;

	@Column(name = "expiryMonth", nullable = false)
	private String expiryMonth;

	@Column(name = "expiryYear", nullable = false)
	private String expiryYear;

}
