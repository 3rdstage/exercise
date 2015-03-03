package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
@org.hibernate.annotations.AccessType("property")
public class BankAccount3 extends BillingDetails3{

	@Column(name = "bankAccountNumber", nullable = true)
	private String accountNumber;

	@Column(name = "bankName", nullable = true)
	private String bankName;

	@Column(name = "bankSwift", nullable = true)
	private String swift;

}
