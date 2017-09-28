package thirdstage.project2.process;

/**
 * @author 3rdstage
 * @version 0.7, 3rdstage, --, not yet
 * @since 2006-10-30
 */
public interface ProcessManager {
	
	public void createProcess(Process process) throws Exception;
	
	public void createProcesses(java.util.List<Process> processes) throws Exception;
	
	public Process getProcess(Long no) throws Exception;
	
	public Process getProcessById(String id) throws Exception;
	
	public java.util.List<ProcessMinValue> getAllProcessesInMinValue() throws Exception;
	
	public java.util.List<Process> getAllProcesses() throws Exception;
	
	
}
