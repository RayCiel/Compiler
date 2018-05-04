grammar test;

DZZ : 'dzz';
XZZ : 'xzz';
PLUS : '+';
SHARP : '#';
Digit : [0-9]+;

expr
    : id
    | expr '+' expr
    | '#' expr
    ;
id
    : 'dzz'
    | 'xzz'
    | Digit
    ;
