package thirdstage.sample.event.entities;

public interface Event {
	
	public String getId();
	public void setId(String id);
	
	public String getName();
	public void setName(String name);
	
	public String getDescription();
	public void setDescription(String description);
	
	public boolean isOpen();
	public boolean isClosed();
	public boolean isWinned();
	
	public java.util.Calendar getStartDate();
	public java.util.Calendar getEndDate();
	
	public java.util.Calendar getWinnerAnnounceDate();

}
