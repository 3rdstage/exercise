package thirdstage.sample.event.managers;

import thirdstage.sample.event.entities.Event;
import thirdstage.sample.event.entities.EventApplicant;

public interface EventManager {
	
	public void makeEvent(Event ev);
	
	public Event getEvent(String eventId);
	
	public EventApplicant[] getApplicantOfEvent(String eventId);
	
	

}
