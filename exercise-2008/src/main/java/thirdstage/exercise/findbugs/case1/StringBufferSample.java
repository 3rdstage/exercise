/**
 * 
 */
package thirdstage.exercise.findbugs.case1;

import javax.annotation.Nonnull;

/**
 * @author 3rdstage
 *
 */
public class StringBufferSample{
	
	//NOT efficient method
	public static String concatWordInefficient(@Nonnull String[] words){
		
		if(words == null) throw new IllegalArgumentException("Null is not allowed.");

		//sb is local -> no concurrent access to sb
		//StringBuffer's methods are synchronized which is UNnecessary in this case.
		StringBuffer sb = new StringBuffer(words.length * 2 - 1);
		for(int i = 0, n = words.length - 1; i < n; i++){
			sb.append(words[i]).append(" ");
		}
		sb.append(words[words.length]);
		
		return sb.toString();
	}
	
	//MORE efficient method
	public static String concatWordEfficient(@Nonnull String[] words){
		
		if(words == null) throw new IllegalArgumentException("Null is not allowed.");

		//sb is local -> no concurrent access to sb
		//StringBuilder's methods are never synchronized which is enough in this case.
		StringBuilder sb = new StringBuilder(words.length * 2 - 1);
		for(int i = 0, n = words.length - 1; i < n; i++){
			sb.append(words[i]).append(" ");
		}
		sb.append(words[words.length]);
		
		return sb.toString();
	}
}
