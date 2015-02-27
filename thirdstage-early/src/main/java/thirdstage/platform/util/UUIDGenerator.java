package thirdstage.platform.util;

import java.text.*;
import java.security.SecureRandom;

/**
 * UUID(Universal Unique IDentifier) Generator<br>  
 * The algorith of this class is based on UUID spec. from Network Working Group 
 * but is slightly modified.
 * 
 * @author Sang-Moon Oh
 * @version 1.0
 * @since 2002/11/07
 */
public class UUIDGenerator {
	
	/**
	 * singleton object of this class
	 */
	private static UUIDGenerator singleton = null;
	
	/**
	 * UUID의 두번째 부분; 두번째 부분은 machine의 IP address에 의해서 결정된다.
	 */
	private String mSecondPart = "";
	
	/**
	 * UUID의 세번째 부분; 세번째 부분은 이 object의 hash code에 의해서 결정된다.
	 */
	private String mThirdPart = null;
	
	/**
	 * UUID의 첫번째 부분을 구하기 위한 date formatter
	 */
	private java.text.DateFormat mDateFormatter = null;
	
	/**
	 * UUID의 네번째 부분을 구하기 위한 random number generator
	 */
	private java.security.SecureRandom mRandom = null;
	
	/**
	 * sole constructor; Singleton class를 위해서 private이다.
	 * 
	 * @throws java.lang.Exception
	 */
	private UUIDGenerator() throws Exception {
		
	}
	
	/**
	 * UUIDGenerator type의 singleton instance를 제공한다.
	 * UUIDGenerator type의 instance를 얻기 위한 유일한 방법이다.
	 * 
	 * @return com.insungids.util.UUIDGenerator
	 * @throws java.lang.Exception
	 */
	public static UUIDGenerator getSingleton() throws Exception {
		return null;
	}
	
	/**
	 * 41자리로 구성된 Universal Unique ID를 얻어온다.
	 *
	 * @return java.lang.String
	 */
	public String getUUID() {
		return null;
	}
	
	/**
	 * UUID의 첫번째 부분을 가져온다.
	 * 
	 * @return java.lang.String
	 */
	protected String getFirstPart() {
		return null;
	}
	
	/**
	 * UUID의 두번째 부분을 가져온다.
	 * 
	 * @return java.lang.String
	 */
	protected String getSecondPart() {
		return null;
	}
	
	/**
	 * UUID의 세번째 부분을 가져온다.
	 * 
	 * @return java.lang.String
	 */
	protected String getThirdPart() {
		return null;
	}
	
	/**
	 * UUID의 마지막(네번째) 부분을 가져온다.
	 * 
	 * @return java.lang.String
	 */
	protected String getLastPart() {
		return null;
	}
	
	/**
	 * @param n
	 * @param minLen
	 * @return java.lang.String
	 */
	protected String formatHexWithMinLength(int n, int minLen) {
		return null;
	}
}