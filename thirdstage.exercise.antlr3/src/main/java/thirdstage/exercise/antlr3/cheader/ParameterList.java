package thirdstage.exercise.antlr3.cheader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParameterList {
	
	private List<Parameter> parameters = new ArrayList<Parameter>();
	
	private boolean hasOptionalParams = false;
	
	public ParameterList(List<Parameter> params, boolean hasOptionalParams){
		if(params != null){
			for(Parameter p : params) this.parameters.add(p);
		}
		
		this.hasOptionalParams = hasOptionalParams;
	}
	
	public Parameter getParameter(int i){
		return this.parameters.get(i);
	}
	
	public int size(){
		return this.parameters.size();
	}
	
	public boolean hasOptionalParams(){
		return this.hasOptionalParams;
	}
	

}
