grammar Simplest;

options {
  language = Java;

}

@header{
  package thirdstage.exercise.antlr3;
}

@lexer::header{
  package thirdstage.exercise.antlr3;
}


header
  : functionDeclaration+ 
  ;

functionDeclaration
  : 'extern'? returnType functionName '(' parameterList ')' ';'
  ;

returnType
  : (DATA_TYPE | IDENT) ASTERISK?
  ;
  
functionName
  : IDENT
  ;

parameterList
  : parameter*
  ;

parameter
  : parameterType parameterName?
  ;

parameterType
  : 'const'? (DATA_TYPE | IDENT) ASTERISK?
  ;

parameterName
  : IDENT
  ;


STORAGE_CLASS_SPECIFIER : ('typedef' | 'extern' | 'static' | '_Thread_local' | 'auto' | 'register');
DATA_TYPE : (INTEGER_TYPE_SPECIFIER | 'void') ;
INTEGER_TYPE_SPECIFIER
  : 'signed char'    //-128 ~ 127
  | 'unsigned char'  //0 ~ 255
  | 'char'           //signed or unsigned depending on system
  | 'short' | 'short int' | 'signed short' | 'signed short int'  //-32,768 to 32,767
  | 'unsigned short int'  //0 to 65,535
  | 'int'                 //
  ;
IDENT : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
WS : (' '|'\t'|'\n'|'\r'|'\f')+ {$channel=HIDDEN};
AMPERSAND : '&';
ASTERISK : '*';
LEFT_PAREN : '('; //left parentheses
RIGHT_PAREN : ')'; //right parentheses
LT_SIGN : '<'; //less-than sign, left angle bracket, \u003C
EQ_SIGN : '='; //equals sign, \u003D
GT_SIGN : '>'; //greater-than sign, right angle bracket, \u003E



