/**
 * This grammar is for header file of C language
 * 
 * References
 *   ANSI C Specification, ISO/IEC 9899:TC3 : http://www.open-std.org/jtc1/sc22/WG14/www/docs/n1256.pdf
 *   ANSI C Specification, ISO/IEC 9899:201x : http://www.open-std.org/jtc1/sc22/wg14/www/docs/n1570.pdf
 *   The GNU C Reference Manual : http://www.gnu.org/software/gnu-c-manual/gnu-c-manual.html
 *   GNU C Library headers : http://sourceware.org/git/?p=glibc.git;a=tree;f=include;h=5b35353b033540d0727a1ab7e214bb5672154e0f;hb=HEAD 
 */
grammar CHeader;

options{
	//output=AST;
	language= Java ; 
}

@header{
	package thirdstage.exercise.antlr3.cheader;
}

@lexer::header{
	package thirdstage.exercise.antlr3.cheader;
}

@members{
	
	private List<FunctionDecl> functions = new ArrayList<FunctionDecl>();
	
	public List<FunctionDecl> getFunctions(){
		return this.functions;
	}
}

header
  : (preprocessingDirective | functionDeclaration)+ 
  ;

preprocessingDirective
  : NUMBER_SIGN ('if' | 'ifdef' | 'ifndef' | 'elif' | 'else' | 'endif') ID* NEWLINE;

functionDeclaration returns [String returnType, String name]
	: 'extern'? returnType functionName LEFT_PAREN parameterList? RIGHT_PAREN ';' NEWLINE?
		{
			functions.add(new FunctionDecl($functionName.text));
		}
	;

returnType
  : (dataType | ID) ASTERISK*
  ;
  
dataType
  : (INTEGER_TYPE_SPECIFIER | 'void')
  ;
  
functionName
  : ID
  ;

parameterList returns [ParameterList paramList]
@init{ 
	List<Parameter> params = new ArrayList<Parameter>();
}
  : (a=parameter {params.add($a.param);}) (',' (b=parameter {params.add($b.param);}))* (',' (e=ELLIPSIS))?
  	{
  		$paramList = new ParameterList(params, $e != null ? true : false);
  		for(Parameter p : params){ System.out.println(p);}
  	}
  ;

parameter returns [Parameter param]
  : t=parameterType r=('__restrict'?) n=ID
  	{
  		$param = new Parameter($t.text, ($n != null) ? $n.text : "", ($r != null) ? true : false);
  	}
  ;

parameterType
  : 'const'? (dataType | ID) ASTERISK*
  ;

parameterName
  : ID
  ;


STORAGE_CLASS_SPECIFIER : ('typedef' | 'extern' | 'static' | '_Thread_local' | 'auto' | 'register');
INTEGER_TYPE_SPECIFIER
  : 'signed char'    //-128 ~ 127
  | 'unsigned char'  //0 ~ 255
  | 'char'           //signed or unsigned depending on system
  | 'short' | 'short int' | 'signed short' | 'signed short int'  //-32,768 to 32,767
  | 'unsigned short int'  //0 to 65,535
  | 'int'                 //
  ;
NEWLINE : '\r'? '\n';
WS : (' '|'\t'|'\n'|'\r'|'\f')+ {$channel=HIDDEN;};
NUMBER_SIGN : '#';
AMPERSAND : '&';
ASTERISK : '*';
LEFT_PAREN : '('; //left parentheses
RIGHT_PAREN : ')'; //right parentheses
LT_SIGN : '<'; //less-than sign, left angle bracket, \u003C
EQ_SIGN : '='; //equals sign, \u003D
GT_SIGN : '>'; //greater-than sign, right angle bracket, \u003E
ELLIPSIS : '...';
ID : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
