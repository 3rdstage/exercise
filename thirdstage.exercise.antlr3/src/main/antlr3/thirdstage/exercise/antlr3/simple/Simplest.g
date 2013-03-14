grammar Simplest;

options {
  language = Java;

}

@header{
  package thirdstage.exercise.antlr3.simple;
}

@lexer::header{
  package thirdstage.exercise.antlr3.simple;
}



header
  : (preprocessingDirective | functionDeclaration)+ 
  ;

preprocessingDirective
  : NUMBER_SIGN ('if' | 'ifdef' | 'ifndef' | 'elif' | 'else' | 'endif') ID* NEWLINE;

functionDeclaration
  : 'extern'? returnType functionName LEFT_PAREN parameterList RIGHT_PAREN ';'
  ;

returnType
  : (dataType | ID) ASTERISK?
  ;

dataType
  : (INTEGER_TYPE_SPECIFIER | 'void')
  ;
  
functionName
  : ID
  ;

parameterList
  : parameter*
  ;

parameter
  : parameterType parameterName?
  ;

parameterType
  : 'const'? (dataType | ID) ASTERISK?
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
ID : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;



