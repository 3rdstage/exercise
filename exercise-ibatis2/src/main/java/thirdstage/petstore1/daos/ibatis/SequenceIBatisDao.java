/**
 * 
 */
package thirdstage.petstore1.daos.ibatis;

import java.sql.SQLException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ibatis.sqlmap.client.SqlMapClient;
import thirdstage.petstore1.daos.Sequence;
import thirdstage.petstore1.daos.SequenceDao;

/**
 * IMPORTANT Key generation table
 * Primary key generation by table is very difficult task.
 * Should consider the followings
 * 
 * - possibility of same value generation and it's workaround
 * - synch with long-term transaction and resulted locking
 * - usage of "SELECT ~ FOR UPDATE ~ " clause
 * - applying READ_UNCOMMITTED or SERIALIZABLE isolation level 
 * 
 * 
 * @author 3rdstage
 * 
 */
public class SequenceIBatisDao implements SequenceDao{

	private SqlMapClient sqlMapClient;

	public SequenceIBatisDao(){
		super();
	}

	protected SqlMapClient getSqlMapClient(){
		return this.sqlMapClient;
	}

	@org.springframework.beans.factory.annotation.Required
	public void setSqlMapClient(SqlMapClient sqlMapClient){
		this.sqlMapClient = sqlMapClient;
	}

	/*
	 *  
	 * 
	 * @see thirdstage.petstore1.daos.SequenceDao#getNextId(java.lang.String)
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = false)
	public int getNextId(String name) throws SQLException{
		/* IMPORTANT Duplicate next id when using sequence table
		 * 
		 * With the following code, two concurrent thread may get same 
		 * next id in high thread congestion.
		 * 
		 * To guarantee no same next id, getting id should be locked until 
		 * the table is updated. This can be implemented using SELECT ...
		 * FOR UPDATE clause in case of Oracle.  In case of MySQL, what
		 * can be used?
		 * 
		 * Try to illustrate this case with sequence diagram using UML 2.x syntax.
		 */
		
		Sequence seq = new Sequence(name, -1);
		seq = (Sequence)(this.getSqlMapClient().queryForObject("getSequence", seq));
		if(seq == null){
			throw new SQLException("Could not get next value of sequence " + name + " : sequence doesn't exist");
		}

		this.getSqlMapClient().update("updateSequence", new Sequence(name, seq.getNextId() + 1));
		return seq.getNextId();
	}

}
