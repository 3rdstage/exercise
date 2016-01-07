/**
 * 
 */
package thirdstage.model.webservices.wsdl;

/** 
 * @author 3rdstage
 */
public class Operation {

	/**
	 * @uml.property  name="input"
	 * @uml.associationEnd  inverse="operation:thirdstage.model.webservices.wsdl.Input"
	 */
	private Input input;

	/**
	 * Getter of the property <tt>input</tt>
	 * @return  Returns the input.
	 * @uml.property  name="input"
	 */
	public Input getInput() {
		return input;
	}

	/**
	 * Setter of the property <tt>input</tt>
	 * @param input  The input to set.
	 * @uml.property  name="input"
	 */
	public void setInput(Input input) {
		this.input = input;
	}

	/**
	 * @uml.property  name="output"
	 * @uml.associationEnd  inverse="operation:thirdstage.model.webservices.wsdl.Output"
	 */
	private Output output;

	/**
	 * Getter of the property <tt>output</tt>
	 * @return  Returns the output.
	 * @uml.property  name="output"
	 */
	public Output getOutput() {
		return output;
	}

	/**
	 * Setter of the property <tt>output</tt>
	 * @param output  The output to set.
	 * @uml.property  name="output"
	 */
	public void setOutput(Output output) {
		this.output = output;
	}

}
