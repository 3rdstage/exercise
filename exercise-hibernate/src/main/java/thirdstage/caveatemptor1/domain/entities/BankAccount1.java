package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AttributeOverride(name = "owner", column = @Column(name = "bankAccountOwner", nullable = false))
@Table(name = "BankAccount1")
@org.hibernate.annotations.AccessType("property")
public class BankAccount1 extends BillingDetails1{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bankAccountId", nullable = false)
	private Long id;

	@Column(name = "accountNumber", nullable = false)
	private String accountNumber;

	@Column(name = "bankName", nullable = false)
	private String bankName;

	@Column(name = "swift", nullable = true)
	private String swift;

}
