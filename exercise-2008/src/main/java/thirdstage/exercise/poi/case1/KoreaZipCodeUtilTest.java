package thirdstage.exercise.poi.case1;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KoreaZipCodeUtilTest {

  @Test
  public void parseFromExcel() throws Exception{
	  
	  String path = "D:\\temp\\우편번호파일\\20131008_우편번호(기존형태).xls";
	  
	  List<KoreaZipCode> codes = KoreaZipCodeUtil.parseFromExcel(path);
	  
	  Assert.assertTrue((codes != null) && (codes.size() > 1000));
  }
  
  
}
