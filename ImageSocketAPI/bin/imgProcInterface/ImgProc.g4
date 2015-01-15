grammar ImgProc;

file
:
	request+
;

request
:
	perform ';'
	| receive ';'
	| replace ';'
	| close ';'
;

perform
:
	PERFORM OPERATION
;

receive
:
	RECEIVE FILENAME
;

replace
:
	REPLACE FILENAME
;

close
:
	CLOSE
;

PERFORM
:
	'PERFORM'
;

RECEIVE
:
	'RECEIVE'
;

REPLACE
:
	'REPLACE'
;

CLOSE
:
	'CLOSE'
;

OPERATION
:
	'GAUSSIAN_BLUR'
	| 'SCALE_UP'
	| 'SCALE_DOWN'
	| 'BRIGHTNEN'
	| 'DARKEN'
	| 'SHARPEN'
	| 'INVERT_COLOR'
;

FILENAME
:
	'"'.*? '"'
;

WS
:
	[ \t\r\n]+ -> skip
;