/**
 * 
 */
package thirdstage.exercise.jdbc.number;

/**
 * Get data for the 1-dimensional line entity.<br/><br/>
 * Line entity should at least include columns of <code>id</code>,
 * <code>start point</code> and <code>end point</code>.
 * The <code>id</code> column should be integer type. The <code>start point</code>
 * and <code>end point</code> column could be number type or string type.
 * <br/><br/>
 * The possible structure of the line entities are :
 * <pre><code class='sql'>
 * create table tb_line1(
 *    id number(10,0) not null,
 *    x number not null,
 *    y number not null,
 *    primary key (id)
 * )
 * </code></pre>
 * <br/><br/>
 * <pre><code class='sql'>
 * create table tb_line2(
 *    id number(10,0) not null,
 *    x varchar2(100) not null,
 *    y varchar2(100) not null,
 *    primary key (id)
 * )
 * </code></pre>
 * 
 * @author 3rdstage
 *
 */
public interface LineDao {
	
	
	/**
	 * Gets the length of the line which has given ID.<br/><br/>
	 * Be careful that the return is not number type but string type. It's 
	 * to get the precise value of the length regardless of the types
	 * used by the implementations (float, double or big decimal).
	 * 
	 * @param id
	 * @return
	 */
	public String getLength(int id);

}
