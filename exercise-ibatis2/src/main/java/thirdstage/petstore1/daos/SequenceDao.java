package thirdstage.petstore1.daos;

import java.sql.SQLException;

public interface SequenceDao{

	int getNextId(String name) throws SQLException;
}
