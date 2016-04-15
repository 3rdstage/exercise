package thirdstage.exercise.spring.case12;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;

public class FlightServiceDummyImpl implements FlightService {

	public List<Flight> findFlights(FlightSearchCriteria criteria) {
		List<Flight> flights = new ArrayList<Flight>();
		
		Airport a1 = new Airport("New York City", "100");
		Airport b1 = new Airport("Baltimore", "200");
		FlightLeg leg1 = new  FlightLeg(a1, new Date(2008, 3, 5), b1, new Date(2008, 3, 6));
		
		Airport a2 = new Airport("Baltimore", "200");
		Airport b2 = new Airport("Honolulu", "400");
		FlightLeg leg2 = new FlightLeg(a2, new Date(2008, 3, 6), b2, new Date(2008, 3, 9));
		
		List<FlightLeg> legs = new ArrayList<FlightLeg>();
		legs.add(leg1);
		legs.add(leg2);
		
		flights.add(new Flight(legs, new BigDecimal(1200.0)));	
		
		return flights;
	}

	public List<SpecialDeal> getSpecialDeals() {
		// TODO Auto-generated method stub
		
		List<SpecialDeal> deals = new ArrayList<SpecialDeal>();
		
		Airport a = new Airport("New York City", "100");
		Airport b = new Airport("Baltimore", "200");
		
		SpecialDeal sd = new SpecialDeal(a, b, 
				new BigDecimal(250.0), new Date(2008, 2, 25), new Date(2008, 2, 27));
		
		deals.add(sd);
		
		a = new Airport("Orlando", "300");
		b = new Airport("Honolulu", "400");
		sd = new SpecialDeal(a, b, new BigDecimal(500.0), new Date(2008, 3, 1),
				new Date(2008, 3, 1));
	
		deals.add(sd);
		
		a = new Airport("San Francisco", "500");
		b = new Airport("Tokyo", "600");
		sd = new SpecialDeal(a, b, new BigDecimal(700.0), new Date(2008, 3, 15),
				new Date(2008, 3, 17));
		
		deals.add(sd);
		
		return deals;
		
	}

}
