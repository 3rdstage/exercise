package thirdstage.exercise.spring.case12;

public interface FlightService {
	
	public java.util.List<SpecialDeal> getSpecialDeals();
	
	public java.util.List<Flight> findFlights(FlightSearchCriteria criteria);
	
	

}
