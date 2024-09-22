grammar Grammar;

//The line that heads the file
format_Line: 'NAME' SEPARATOR 'EMAIL' SEPARATOR 'PHONE NUMBER' SEPARATOR 'ADDRESS'  (EOL data_Line | EOF);

//Any entry within the body of the file
data_Line: NAME ',' EMAIL ',' PHONENUM ',' ADDRESS (EOL data_Line | EOL final_Line | EOF); 

//The last entry in the file
final_Line: NAME ',' EMAIL ',' PHONENUM ',' ADDRESS EOF;

//Grammar Rules
KEYWORD: 'NAME' | 'EMAIL' | 'PHONE NUMBER' | 'ADDRESS';

SEPARATOR: ',';

NAME: [a-zA-Z]+ ' ' [a-zA-Z]+ (' ' [a-zA-Z]+)*;

EMAIL: [a-z0-9]+ (('.'|'_'|'-'|) [a-z0-9]+)* '@' [a-z0-9]+ (('.'|'_'|'-'|) [a-z0-9]+)* ('.' [a-z][a-z]+);  //marcus02_d@m-g.com

PHONENUM: [0-9][0-9][0-9] '-' [0-9][0-9][0-9] '-' [0-9][0-9][0-9][0-9];

ADDRESS: [0-9]+ (' ' [a-zA-Z0-9]+)*;

EOL: '\r\n' ;
