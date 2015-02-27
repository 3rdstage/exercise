package thirdstage.caveatemptor1.model.domain;

import java.util.Date;


/**
 * @uml.dependency   supplier="thirdstage.caveatemptor1.model.domain.Item"
 */
public class Comment {

	/** 
	 * @uml.property name="item"
	 * @uml.associationEnd inverse="comment:thirdstage.caveatemptor1.model.domain.Item"
	 */
	private Item item;

	/** 
	 * Getter of the property <tt>item</tt>
	 * @return  Returns the item.
	 * @uml.property  name="item"
	 */
	public Item getItem() {
		return item;
	}

	/** 
	 * Setter of the property <tt>item</tt>
	 * @param item  The item to set.
	 * @uml.property  name="item"
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @uml.property  name="rating"
	 */
	private Rating rating;

	/**
	 * Getter of the property <tt>rating</tt>
	 * @return  Returns the rating.
	 * @uml.property  name="rating"
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * Setter of the property <tt>rating</tt>
	 * @param rating  The rating to set.
	 * @uml.property  name="rating"
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * @uml.property  name="text"
	 */
	private String text = "";

	/**
	 * Getter of the property <tt>text</tt>
	 * @return  Returns the text.
	 * @uml.property  name="text"
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setter of the property <tt>text</tt>
	 * @param text  The text to set.
	 * @uml.property  name="text"
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @uml.property  name="created"
	 */
	private Date created;

	/**
	 * Getter of the property <tt>created</tt>
	 * @return  Returns the created.
	 * @uml.property  name="created"
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Setter of the property <tt>created</tt>
	 * @param created  The created to set.
	 * @uml.property  name="created"
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/** 
	 * @uml.property name="writer"
	 * @uml.associationEnd inverse="comment:thirdstage.caveatemptor1.model.domain.User"
	 * @uml.association name="from"
	 */
	private User writer;

	/** 
	 * Getter of the property <tt>writer</tt>
	 * @return  Returns the writer.
	 * @uml.property  name="writer"
	 */
	public User getWriter() {
		return writer;
	}

	/** 
	 * Setter of the property <tt>writer</tt>
	 * @param writer  The writer to set.
	 * @uml.property  name="writer"
	 */
	public void setWriter(User writer) {
		this.writer = writer;
	}

}
