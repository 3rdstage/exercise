package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
@org.hibernate.annotations.AccessType("property")
public class CreditCard3 extends BillingDetails3{

	@Column(name = "cardNumber", nullable = true)
	private String cardNumber;

	@Column(name = "cardExpiryMonth", nullable = true)
	private String expiryMonth;

	@Column(name = "cardExpiryYear", nullable = true)
	private String expiryYear;


}
