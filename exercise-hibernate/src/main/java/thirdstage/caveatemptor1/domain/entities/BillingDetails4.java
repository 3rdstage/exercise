package thirdstage.caveatemptor1.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@org.hibernate.annotations.AccessType("property")
public abstract class BillingDetails4{



}
