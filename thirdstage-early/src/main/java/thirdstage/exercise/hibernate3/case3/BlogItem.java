package thirdstage.exercise.hibernate3.case3;


import java.util.Calendar;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-30, 3rdstage
 * @since 2005-12-30
 *
 * @hibernate.class table="BlogItem3"
 */
public class BlogItem {
	
	private Long id = null;
	private String title = null;
	private String text = null;
	private Calendar dateTime = null;
	private Blog blog = null;
	
	/**
	 * Creates a new instance of BlogItem
	 */
	public BlogItem() {
	}

	/**
	 * @hibernate.id column="id" generator-class="native"
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @hibernate.property column="title" type="string" length="100"
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @hibernate.property column="text" type="string" length="2000"
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @hibernate.property column="dateTime"
	 */
	public Calendar getDateTime() {
		return dateTime;
	}

	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @hibernate.many-to-one column="bolgId"
	 *                        foreign-key="fk_blogitem_1"
	 *                        not-null="true"
	 */
	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
}
