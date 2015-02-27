grammar Intermediate;

options {
  language = Java;

}

@header{
  package thirdstage.exercise.antlr3.simple;
}

@lexer::header{
  package thirdstage.exercise.antlr3.simple;
}

functionDef : FUNCTION ID '()' block;

block : BLOCK_NAME? '{' (statement|block)* '}';

statement :  ID+ ';';


FUNCTION : 'function';
BLOCK_NAME : 'for' | 'if' | 'while';
ID : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
WS : (' '|'\t'|'\n'|'\r'|'\f')+ {$channel=HIDDEN;};

