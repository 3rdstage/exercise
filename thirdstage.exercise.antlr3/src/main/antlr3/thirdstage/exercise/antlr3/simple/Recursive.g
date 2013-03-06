grammar Recursive;

options {
  language = Java;

}

@header{
  package thirdstage.exercise.antlr3.simple;
}

@lexer::header{
  package thirdstage.exercise.antlr3.simple;
}


functionDef : 'function()' BLOCK;

CHAR 
  : 'a'..'z'
  ;
BLOCK 
  : '(' (BLOCK|CHAR)* ')'
  ;

