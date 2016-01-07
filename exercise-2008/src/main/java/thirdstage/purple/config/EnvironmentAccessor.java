/**
 * 
 */
package thirdstage.purple.config;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author 3rdstage
 * 
 */
public class EnvironmentAccessor{

	public void printEnv(OutputStream os) throws Exception{

		Map<String, String> map = System.getenv();
		Set<String> keys = map.keySet();
		PrintWriter pw = null;

		try{
			pw = new PrintWriter(os, true);

			for(String key : keys){
				pw.println("" + key + "=" + map.get(key));
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(pw != null && os != (OutputStream)(System.out)) pw.close();
		}
	}

	public void printSystemProperties(OutputStream os) throws Exception{
		Map props = System.getProperties();

		Set keys = props.keySet();
		List keyList = new ArrayList(keys);
		Collections.sort(keyList);
		PrintWriter pw = null;

		try{
			pw = new PrintWriter(os, true);

			String key = null;
			for(Iterator itr = keyList.iterator(); itr.hasNext();){ // for JDK 1.4
				key = (String) (itr.next());
				pw.println("" + key + "=" + props.get(key));
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(pw != null && os != (OutputStream)(System.out)){
				pw.close();
			}
		}

	}

	public void printAvailableCharsets(OutputStream os) throws Exception{
		Map<String, Charset> charsets = Charset.availableCharsets();

		Set<String> keys = charsets.keySet();
		List<String> keyList = new ArrayList(keys);
		Collections.sort(keyList);
		
		Set<String> aliases = null;
		PrintWriter pw = null;

		try{
			pw = new PrintWriter(os, true);
			pw.println("# of available charsets : " + charsets.size());
			
			for(String key : keyList){ // from JDK 5
				aliases = charsets.get(key).aliases();
				pw.print(charsets.get(key).displayName() + " : ");
				for(String alias : aliases){
					pw.print(alias + ", ");
				}
				pw.println("");
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(pw != null && os != (OutputStream)(System.out)) pw.close();
		}

	}

	public void printAvailableLocales(OutputStream os) throws Exception{
		Locale[] locales = Locale.getAvailableLocales();

		String name = null, country = null, lang = null, currencySb = null;
		String countryCd = null, langCd = null, currencyCd = null;
		Currency currency = null;

		PrintWriter pw = null;

		try{
			pw = new PrintWriter(os, true);

			for(Locale locale : locales){
				name = locale.getDisplayName();
				country = locale.getDisplayCountry();
				countryCd = locale.getISOCountries()[0];
				lang = locale.getDisplayLanguage();
				langCd = locale.getISOLanguages()[0];

				try{
					currency = Currency.getInstance(locale);
					currencySb = currency.getSymbol();
					currencyCd = currency.getCurrencyCode();
				}catch(IllegalArgumentException ex){
					currencySb = "";
					currencyCd = "";
				}

				pw.print("name : " + name + ", ");
				pw.print("country : " + country + "(" + countryCd + "), ");
				pw.print("lang : " + lang + "(" + langCd + "), ");
				pw.println("currency : " + currencySb + "(" + currencyCd + ")");
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(pw != null && os != (OutputStream)(System.out)) pw.close();
		}

	}

	public void monitorMemory(int intervalInMilliSec, int count) throws Exception{
	// MemoryMonitor monitor = new MemoryMonitor(intervalInMilliSec, count);
	// monitor.start();

	}

}

class MemoryMonitor extends Thread{

	private static final int INTERVAL_MIN = 1000;

	private Runtime runtime = Runtime.getRuntime();

	private int interval = INTERVAL_MIN;

	private int count = 0;

	public MemoryMonitor(int intervalInMilliSec, int count){
		if(intervalInMilliSec < INTERVAL_MIN) throw new IllegalArgumentException();

		this.interval = intervalInMilliSec;
		this.count = count;
	}

	public void run(){
		long max = 0l, total = 0l, free = 0l;
		for(int i = 0; i < this.count; i++){
			max = this.runtime.maxMemory();
			total = this.runtime.totalMemory();
			free = this.runtime.freeMemory();

			System.out.println("max : " + max + ", total : " + total + ", free : " + free);

			try{
				Thread.currentThread().sleep(interval);
			}catch(Exception ex){
				break;
			}
		}
	}
}
