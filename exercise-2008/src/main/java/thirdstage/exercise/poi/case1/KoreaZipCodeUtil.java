/**
 * 
 */
package thirdstage.exercise.poi.case1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author 3rdstage
 *
 */
public class KoreaZipCodeUtil{
	
	
	public static List<KoreaZipCode> parseFromExcel(@Nonnull String path) throws Exception{
		
		InputStream is = null;
		Workbook wb = null;
		
		try{
			is = new FileInputStream(path);
			wb = new HSSFWorkbook(is);
		}catch(Exception ex){
			throw ex;
		}finally{
			if(is != null){
				try{ is.close(); }
				catch(Exception ex){}
			}
		}
		
		Sheet sh = wb.getSheetAt(0);
		int rows = sh.getLastRowNum();
		
		List<KoreaZipCode> result = new ArrayList<KoreaZipCode>(rows - 1); //leading 2 lines are headings
		Row row = null;
		KoreaZipCode zip = null;
		for(int i = 2; i < rows + 1; i++){
			row = sh.getRow(i);
			zip = new KoreaZipCode();
			zip.code = row.getCell(0).getStringCellValue();
			zip.sequence = row.getCell(1).getStringCellValue();
			zip.state = row.getCell(2).getStringCellValue();
			zip.city = row.getCell(3).getStringCellValue();
			zip.town = row.getCell(4).getStringCellValue();
			
			result.add(zip);
		}
		
		return result;
	}
	

}
