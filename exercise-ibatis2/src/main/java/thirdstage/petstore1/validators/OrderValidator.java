package thirdstage.petstore1.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import thirdstage.petstore1.domain.entities.Order;

public class OrderValidator implements Validator{

	public boolean supports(Class clazz){
		return Order.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors){
		validateCreditCard((Order)obj, errors);
		validateBillingAddress((Order)obj, errors);
		validateShippingAddress((Order)obj, errors);
	}

	private void validateCreditCard(Order order, Errors errors){
		ValidationUtils.rejectIfEmpty(errors, "creditCard", "CCN_REQUIRED", "Credit-card number is required");
		ValidationUtils.rejectIfEmpty(errors, "expiryDate", "EXPIRY_DATE_REQUIRED", "Expiry date is required");
		ValidationUtils.rejectIfEmpty(errors, "cardType", "CARD_TYPE_REQUIRED", "Card type is required");
	}
	
	private void validateBillingAddress(Order order, Errors errors){
		ValidationUtils.rejectIfEmpty(errors, "billToFirstName", "FIRST_NAME_REQUIRED", "Billing Info : First name is required");
		ValidationUtils.rejectIfEmpty(errors, "billToLastName", "LAST_NAME_REQUIRED", "Billing Info : Last name is required");
		ValidationUtils.rejectIfEmpty(errors, "billAddress1", "ADDRESS_REQUIRED", "Billing Info : Address (1) is required");
		ValidationUtils.rejectIfEmpty(errors, "billCity", "CITY_REQUIRED", "Billing Info : City is required");
		ValidationUtils.rejectIfEmpty(errors, "billState", "STATE_REQUIRED", "Billing Info : State name is required");
		ValidationUtils.rejectIfEmpty(errors, "billZip", "ZIP_REQUIRED", "Billing Info : ZIP code is required");
		ValidationUtils.rejectIfEmpty(errors, "billCountry", "COUNTRY_REQUIRED", "Billing Info : Country is required");
	}
	
	private void validateShippingAddress(Order order, Errors errors){
		ValidationUtils.rejectIfEmpty(errors, "shipToFirstName", "FIRST_NAME_REQUIRED", "Shipping Info : First name is required");
		ValidationUtils.rejectIfEmpty(errors, "shipToLastName", "LAST_NAME_REQUIRED", "Shipping Info : Last name is required");
		ValidationUtils.rejectIfEmpty(errors, "shipAddress1", "ADDRESS_REQUIRED", "Shipping Info : Address (1) is required");
		ValidationUtils.rejectIfEmpty(errors, "shipCity", "CITY_REQUIRED", "Shipping Info : City is required");
		ValidationUtils.rejectIfEmpty(errors, "shipState", "STATE_REQUIRED", "Shipping Info : State name is required");
		ValidationUtils.rejectIfEmpty(errors, "shipZip", "ZIP_REQUIRED", "Shipping Info : ZIP code is required");
		ValidationUtils.rejectIfEmpty(errors, "shipCountry", "COUNTRY_REQUIRED", "Shipping Info : Country is required");		
	}
	
}
