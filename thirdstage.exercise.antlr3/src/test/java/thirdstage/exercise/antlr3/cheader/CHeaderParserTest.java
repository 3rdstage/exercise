package thirdstage.exercise.antlr3.cheader;

import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CHeaderParserTest {
 
  @Test
  public void header() throws Exception{
    
	String inputFile = ClassLoader.getSystemResource("thirdstage/exercise/antlr3/cheader/simple-header1.h").getFile();
    @SuppressWarnings("unused")
	CharStream input = new ANTLRFileStream(inputFile);
    
    CHeaderLexer lex = new CHeaderLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lex);
    CHeaderParser parser = new CHeaderParser(tokens);
    parser.header();
    
    List<FunctionDecl> functions = parser.getFunctions();
    Assert.assertEquals(3, functions.size());
    

    
  }
}
