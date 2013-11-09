
package thirdstage.platform.mail;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.event.*;
import javax.activation.*;

/**
 * This class implements a simple <code>DataSource</code> object that encapsulates
 * a byte array.
 *
 * @see javax.activation.DataSource javax.activation.DataSource
 */
public class ByteArrayDataSource implements DataSource {
	
	/**
	 * the byte array format data of this data source
	 */
	private byte data[] = null;
	
	/**
	 * the MIME type of the data
	 */
	private String type = null;
	
	/**
	 * Constructs an byte array data source from the specified string.
	 *
	 * @param data the string containing the data for this data source
	 * @param type the MIME type of the data
	 */
	public ByteArrayDataSource(String data, String type) {
		this.type = type;
		try{
			this.data = data.getBytes();
		} catch(Exception ex){}
	}
	
	/**
	 * Constructs an byte array data source from the specified byte array.
	 *
	 * @param data the byte array containing the data for this data source
	 * @param type the MIME type of the data for this data source
	 */
	public ByteArrayDataSource(byte[] data, String type) {
		this.type = type;
		this.data = data;
	}
	
	/**
	 * Constructs an byte array data source from the specified input stream.
	 *
	 * @param is the input stream containing the data for this data source
	 * @param type the MIME type of the data for this data source
	 */
	public ByteArrayDataSource(InputStream is, String type) {
		this.type = type;
		try{
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			int ch;
			while((ch = is.read()) != -1) os.write(ch);
			data = os.toByteArray();
		} catch(IOException ex){}
	}
	
	/**
	 * @return java.io.InputStream
	 * @throws java.io.IOException
	 */
	public InputStream getInputStream() throws IOException {
		if(data == null) throw new IOException("no data");
		return new ByteArrayInputStream(data);
	}
	
	/**
	 * @return java.io.OutputStream
	 * @throws java.io.IOException
	 */
	public OutputStream getOutputStream() throws IOException {
		throw new IOException("cannot do this");
	}
	
	/**
	 * Gets the MIME type of the data in this data source.
	 *
	 * @return the MIME type of the data in this data source
	 */
	public String getContentType() {
		return type;
	}
	
	/**
	 * Returns always "Byte Array".
	 *
	 * @return "Byte Array" always
	 */
	public String getName() {
		return "Byte Array";
	}
}
