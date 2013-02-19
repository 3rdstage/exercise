grammar Intermediate;

options {
  language = Java;

}

@header{
  package thirdstage.exercise.antlr3;
}

@lexer::header{
  package thirdstage.exercise.antlr3;
}

functionDef : 'function' ID '()' BLOCK;

BLOCK : '{' ( BLOCK | ~[{}] )* '}';
ID : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
WS : (' '|'\t'|'\n'|'\r')+ {$channel=HIDDEN};

