package thirdstage.project2.process;

import java.util.List;

/**
 *
 * @author 3rdstage
 * @version 0.1, 3rdstage, 2006-10-30
 * @since 2006-10-30
 *
 * @spring.bean id="project2.processManager2" autowire="no" lazy-init="true" singleton="true"
 * @spring.property name="sessionFactory" ref="hibernateSessionFactory2"
 */
public class ProcessManagerHibernateImplAllDataLoaded implements ProcessManager{
	
	/** Creates a new instance of ProcessManagerHibernateImplAllDataLoaded */
	public ProcessManagerHibernateImplAllDataLoaded() {
		
	}

	public Process getProcessById(String id) throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}

	public void createProcess(Process process) throws Exception {
	}

	public void createProcesses(List<Process> processes) throws Exception {
	}

	public Process getProcess(Long no) throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}

	public List<ProcessMinValue> getAllProcessesInMinValue() throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}

	public List<Process> getAllProcesses() throws Exception {
		//@todo 3rdstage, 2006-11-01, not yet implemented
		return null;
	}
	
	
	
	
}
