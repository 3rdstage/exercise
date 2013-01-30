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
  : DATA_TYPE
  ;
  
functionName
  : IDENT
  ;

parameterList
  : (parameterType parameterName?)*
  ;

parameterType
  : 'const'? DATA_TYPE
  ;

parameterName
  : IDENT
  ;


DATA_TYPE
  : ('char' | 'int' | 'void' | IDENT)
  ;

IDENT
  : ('a'..'z' | 'A'..'Z' | '_')('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*
  ;

WS : (' '|'\t'|'\n'|'\r'|'\f')+ {$channel=HIDDEN};


