package thirdstage.project3.daos;

import java.util.List;
import org.springframework.dao.DataAccessException;
import thirdstage.project3.entities.Process;

public interface ProcessDao{
	
	Process getProcess(long id) throws DataAccessException;

	Process getProces(String code) throws DataAccessException;

	List<Process> getAllProcesses() throws DataAccessException;
	
	

}
