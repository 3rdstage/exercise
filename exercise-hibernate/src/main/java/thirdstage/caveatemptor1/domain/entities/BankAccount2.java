package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BankAccount2")
@org.hibernate.annotations.AccessType("property")
public class BankAccount2 extends BillingDetails2{

	@Column(name = "accountNumber", nullable = false)
	private String accountNumber;

	@Column(name = "bankName", nullable = false)
	private String bankName;

	@Column(name = "swift", nullable = true)
	private String swift;

}
