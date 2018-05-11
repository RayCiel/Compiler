//语法分析antlr4

grammar Mx;


Plus        : '+';
Minus        : '-';
Mul         : '*';
Div         : '/';
Mod         : '%';
Less        : '<';
Greater       : '>';
Equal          : '==';
NotEqual         : '!=';
LessEqual      : '<=';
GreaterEqual     : '>=';
PlusPlus    : '++';
MinusMinus  : '--';
Dot         : '.';
AndAnd         : '&&';
OrOr          : '||';
Not         : '!';
And        : '&';
Or         : '|';
Tilde        : '~';
Xor        : '^';
LeftShift      : '<<';
RightShift      : '>>';

If          : 'if';
Else        : 'else';
While       : 'while';
For         : 'for';
Break       : 'break';
Continue    : 'continue';
Return      : 'return';

fragment
Letter:   [a-zA-Z];

fragment
LetterPlus: [a-zA-Z_];

fragment
Digit:   [1-9][0-9]*
         | '0'
         ;

ConstNull:       'null';
ConstString:     '"' ('\\'["\\n] | .)*? '"'; // . :匹配除“\n”之外的任何单个字符。
ConstBool:       'true' | 'false';
ConstInt:        [1-9][0-9]*
                 | '0'
                 ;

Id:         Letter (LetterPlus | Digit)*;
LineComment:       '//' ~[\r\n]* -> skip;
WhiteSpace:     [ \n\r\t]+ ->skip;
BlockComment:       '/*' .*? '*/' -> skip;


compilationUnit:    (variableDefinition | functionDefinition | classDefinition)* EOF;

classDefinition:    'class' name = Id '{' (functionDefinition | variableDefinition)* '}';

functionDefinition:     ret = typeType? name = Id '(' (parameter (',' parameter)*)? ')' block;

parameter:      typeType Id;

statement:  expression? ';'                                  #ExpressionStatement
            | block                                          #BlockStatement
            | ifStmt                                         #IfStatement
            | forStmt                                        #ForStatement
            | whileStmt                                      #WhileStatement
            | Return expression? ';'                         #ReturnStatement
            | operation = Break ';'                          #BreakStatement
            | operation = Continue ';'                       #ContinueStatement
            | variableDefinition                             #VariableDef
            ;

primaryExpression:    '(' expression ')'                     #primaryExpr
                      //| 'this'                               #thisExpr
                      ;

//this : 'this';

block:      '{' statement* '}';

ifStmt:     If primaryExpression statement (Else statement)?;

forStmt:    For '(' first = expression? ';' second = expression? ';' thirld = expression? ')'
            statement
            ;

whileStmt:      While primaryExpression
                statement
                ;

variableDefinition:     typeType Id ('=' expression)? ( ',' Id ('=' expression)? )*';';

typeType:       (Id | primitiveType) ('[' ']')*;

primitiveType:      type = ('bool' | 'int' | 'string' | 'void');

expression:       primaryExpression                                                                    #ExpressionPrimary
                  //|'this'                                                                              #ConstructorThis
                  | constant                                                                           #Const
                  | Id                                                                                 #ID
                  | 'new' creator                                                                      #New
                  | expression '(' expressionList? ')'                                                 #FunctionCall
                  | expression Dot Id                                                                  #Member
                  | expression '[' expression ']'                                                      #ArrayIndex
                  //| 'new' (Id | primitiveType) ('[' expression ']'('[' expression']')*('[' ']')*)?
                  //| 'new' Id '(' (parameter (',' parameter)*)? ')'                                     #NewClass
                  | operation = (Plus | Minus) expression                                              #PrefixOperation
                  | expression operation = (Mul | Div | Mod) expression                                #BinaryOperation
                  | expression operation = (Plus | Minus) expression                                   #BinaryOperation
                  | expression operation = (And | Xor | Or) expression                                 #BinaryOperation
                  | expression operation = (LeftShift | RightShift) expression                         #BinaryOperation
                  | expression operation = (Less | Greater | LessEqual | GreaterEqual) expression      #BinaryOperation
                  | expression operation = (Equal | NotEqual) expression                               #BinaryOperation
                  | expression operation = AndAnd expression                                           #AndandOperation
                  | expression operation = OrOr expression                                             #OrorOperation
                  | operation = (PlusPlus | MinusMinus) expression                                     #PrefixOperation
                  | expression operation = (PlusPlus | MinusMinus)                                     #SuffixOperation
                  | operation = Not expression                                                                     #PrefixOperation
                  | operation = Tilde expression                                                                   #PrefixOperation
                  | <assoc = right> expression '=' expression                                          #Assign
                  ;

creator
    : (Id | primitiveType) ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+       # ErrorCreator
    | (Id | primitiveType) ('[' expression ']')+ ('[' ']')*                             #ArrayCreator
    | Id  ('(' ')')?                                                                              #NonarrayCreator
    ;

constant:     ConstNull     #ConstNull
            | ConstInt      #ConstInt
            | ConstString   #ConstString
            | ConstBool     #ConstBool
            ;

expressionList:    expression? ( ',' expression )*  ;



