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


functionDef : 'function()' BLOCK;

CHAR 
  : [a-z]
  ;
BLOCK 
  : '(' (BLOCK|CHAR)* ')'
  ;

