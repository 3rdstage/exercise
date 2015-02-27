package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCard2")
@org.hibernate.annotations.AccessType("property")
public class CreditCard2 extends BillingDetails2{

	@Column(name = "cardNumber", nullable = false)
	private String cardNumber;

	@Column(name = "expiryMonth", nullable = false)
	private String expiryMonth;

	@Column(name = "expiryYear", nullable = false)
	private String expiryYear;
}
