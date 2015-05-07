grammar CustomDrawingParser;

@header {
	package com.baselet.element.facet.common.CustomDrawingParser;

	import com.baselet.control.enums.AlignHorizontal;
	import com.baselet.control.enums.LineType;
	import com.baselet.diagram.draw.DrawHandler;
	import com.baselet.diagram.draw.helper.ColorOwn;
	import com.baselet.diagram.draw.helper.ColorOwn.Transparency;
}

@parser::members {
	// JavaCC doesn't support user enriched constructors (adding additional parameters)
	// therefore we use abstract getters
	public abstract double getWidth();
	public abstract double getHeight();
	public abstract DrawHandler getDrawHandler();
	
	/***
	 * Is used to implement nested tasks.
	 * This is used to support the different setting commands after the drawing command.
	 * These need to store the old value and afterwards reset it to this value.
	 */
	private abstract class RecRunnable {
		private RecRunnable inner;
		
		public RecRunnable(RecRunnable inner){
			this.inner = inner;
		}
		
		public abstract void run();
		
		protected void runInner() {
			if(inner != null)
				inner.run();
		}
	}

}

//case insensitive tokens http://stackoverflow.com/a/22160240
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');



WIDTH: W I D T H;
HEIGHT: H E I G H T;
TRUE: T R U E;
FALSE: F A L S E;
LEFT: L E F T;
RIGHT: R I G H T;
CENTER: C E N T E R;

fragment DIGIT: [0-9];
fragment HEX_DIGIT: DIGIT | [a-fA-F];
UNSIGNED_DOUBLE_CONSTANT: DIGIT+ ( '.' DIGIT+ )?;

COLOR_OWN_HEX: '#' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT;
COLOR_OWN_NAME: [a-zA-Z]+;

WS : [ \r\t\n]+ -> skip ;


SIMPLE_STRING : '"'
   ( 
	   ( ~["\\\n\r]) // everything except the specified chars
	   | ('\\' [\\"])
   )*
   '"'
   ;
/*
	 <  SIMPLE_STRING : "\""
   ( 
	   ( ~["\"","\\","\n","\r"]) // everything except the specified chars
	   | ("\\" ["\\","'","\""])
   )*
   "\"" >

*/

//rules

/**
 * The main function which parses a line.
 * Whitespaces and comments are skipped (see Tokens)
 */
parse :
	( drawLine
	| drawRectangle
	| drawRectangleRound
	| drawCircle
	| drawEllipse
	| drawArc
	| drawText
	)?
	EOF;


drawLine locals[ RecRunnable callStack = null;]
	@after { $callStack.run(); }
	:
	'drawLine('
	x1 = doubleTerm ','
	y1 = doubleTerm ','
	x2 = doubleTerm ','
	y2 = doubleTerm
	')' {
		final double x1 = $x1.value;
		final double y1 = $y1.value;
		final double x2 = $x2.value;
		final double y2 = $y2.value;
		$callStack = new RecRunnable(null) { public void run(){
			System.out.println(String.format("drawLine(%f, %f, %f, %f);", x1,y1,x2,y2));
			getDrawHandler().drawLine(x1, y1, x2, y2);
		}};}
	(
		fg[$callStack] {$callStack = $fg.callStack;}
		| lt[$callStack] {$callStack = $lt.callStack;}
		| lw[$callStack] {$callStack = $lw.callStack;}
	)*
	;
   
drawRectangle locals[ RecRunnable callStack = null;]
	@after { $callStack.run(); }
	:
	'drawRectangle('
	x = doubleTerm() ','
	y = doubleTerm() ','
	width = doubleTerm() ','
	height = doubleTerm()
	')' {
		final double x = $x.value;
		final double y = $y.value;
		final double width = $width.value;
		final double height = $height.value;
		$callStack = new RecRunnable(null) { public void run() { 
			//System.out.println(String.format("drawRectangle(%f, %f, %f, %f);", x,y,width,height));
			getDrawHandler().drawRectangle(x, y, width, height);
		}};}
	(
		fg[$callStack] {$callStack = $fg.callStack;}
		| bg[$callStack] {$callStack = $bg.callStack;}
		| lt[$callStack] {$callStack = $lt.callStack;}
		| lw[$callStack] {$callStack = $lw.callStack;}
	)*
	;

drawRectangleRound locals[ RecRunnable callStack = null;]
	@after { $callStack.run(); }
	:
	'drawRectangleRound('
	x = doubleTerm() ','
	y = doubleTerm() ','
	width = doubleTerm() ','
	height = doubleTerm() ','
	radius = doubleTerm()
	')' {
		final double x = $x.value;
		final double y = $y.value;
		final double width = $width.value;
		final double height = $height.value;
		final double radius = $radius.value;
		$callStack = new RecRunnable(null) { public void run() { 
			//System.out.println(String.format("drawRectangleRound(%f, %f, %f, %f, %f);", x,y,width,height,radius));
			getDrawHandler().drawRectangleRound(x, y, width, height, radius);
		}};}
	(
		fg[$callStack] {$callStack = $fg.callStack;}
		| bg[$callStack] {$callStack = $bg.callStack;}
		| lt[$callStack] {$callStack = $lt.callStack;}
		| lw[$callStack] {$callStack = $lw.callStack;}
	)*
	;

drawCircle locals[ RecRunnable callStack = null;]
	@after { $callStack.run(); }
	:
	'drawCircle('
	x = doubleTerm() ','
	y = doubleTerm() ','
	radius = doubleTerm()
	')' {
		final double x = $x.value;
		final double y = $y.value;
		final double radius = $radius.value;
		$callStack = new RecRunnable(null) { public void run() {
			getDrawHandler().drawCircle(x, y, radius);
		}};}
	(
		fg[$callStack] {$callStack = $fg.callStack;}
		| bg[$callStack] {$callStack = $bg.callStack;}
		| lt[$callStack] {$callStack = $lt.callStack;}
		| lw[$callStack] {$callStack = $lw.callStack;}
	)*
   ;

drawEllipse locals[ RecRunnable callStack = null;]
	@after { $callStack.run(); }
	:
	'drawEllipse('
	x = doubleTerm() ','
	y = doubleTerm() ','
	width = doubleTerm() ','
	height = doubleTerm()
	')' {
		final double x = $x.value;
		final double y = $y.value;
		final double width = $width.value;
		final double height = $height.value;
		$callStack = new RecRunnable(null) { public void run() {
			getDrawHandler().drawEllipse(x, y, width, height);
		}};}
	(
		fg[$callStack] {$callStack = $fg.callStack;}
		| bg[$callStack] {$callStack = $bg.callStack;}
		| lt[$callStack] {$callStack = $lt.callStack;}
		| lw[$callStack] {$callStack = $lw.callStack;}
	)*
   ;

drawArc locals [RecRunnable callStack = null;]
	@after { $callStack.run(); }
	:
	'drawArc('
	x = doubleTerm ','
	y = doubleTerm ','
	width = doubleTerm ','
	height = doubleTerm ','
	myStart = doubleTerm ',' //some weird problem with label "start", antlr doesn't produce valid java code for this
	extent = doubleTerm ','
	booleanConstant
	')' {
		final double x = $x.value;
		final double y = $y.value;
		final double width = $width.value;
		final double height = $height.value;
		final double start = $myStart.value;
		final double extent = $extent.value;
		final boolean open = $booleanConstant.value;
		$callStack = new RecRunnable(null) { public void run() {
			System.out.println(String.format("drawArc(%f, %f, %f, %f, %f, %f, %b);",x, y, width, height, start, extent, open));
			getDrawHandler().drawArc(x, y, width, height, start, extent, open);
		}};}
	(
		fg[$callStack] {$callStack = $fg.callStack;}
		| bg[$callStack] {$callStack = $bg.callStack;}
		| lt[$callStack] {$callStack = $lt.callStack;}
		| lw[$callStack] {$callStack = $lw.callStack;}
	)*
	;

drawText locals [RecRunnable callStack = null;]
	@after { $callStack.run(); }
	:
	'drawText('
	simpleString() ','
	x = doubleTerm() ','
	y = doubleTerm() ','
	horizontalAlignment()
	')' {
		final String text = $simpleString.value;
		final double x = $x.value;
		final double y = $y.value;
		final AlignHorizontal alignment = $horizontalAlignment.alignment;
		$callStack = new RecRunnable(null) { public void run() {
			System.out.println(String.format("drawText(%s, %f, %f, %s);", text,x,y,alignment.toString()));
			getDrawHandler().print(text, x, y, alignment);
		}};}
	(
		fg[$callStack] {$callStack = $fg.callStack;}
	)*
	;

/**
 * sets the foreground color
 */
fg[RecRunnable inner] returns [RecRunnable callStack]
	:
	'fg=' colorOwn[Transparency.FOREGROUND] {
		final ColorOwn newColor = $colorOwn.value;
		$callStack = new RecRunnable($inner) {
		public void run(){
			//System.out.println("pre FG");
			ColorOwn oldColor = getDrawHandler().getForegroundColor();
			getDrawHandler().setForegroundColor(newColor);
			runInner();
			getDrawHandler().setForegroundColor(oldColor);
			//System.out.println("post FG");
		}
	};}
	;

/**
 * sets the background color
 */
bg[RecRunnable inner] returns [RecRunnable callStack]
	:
	'bg=' colorOwn[Transparency.BACKGROUND] {
		final ColorOwn newColor = $colorOwn.value;
		$callStack = new RecRunnable($inner) {
		public void run(){
			//System.out.println("pre BG");
			ColorOwn oldColor = getDrawHandler().getBackgroundColor();
			getDrawHandler().setBackgroundColor(newColor);
			runInner();
			getDrawHandler().setBackgroundColor(oldColor);
			//System.out.println("post BG");
		}
	};}
	;

/**
 * represents a color name (e.g. "red")
 * or a hexadecimal color string 
 * starting with '#' and 
 * containing exactly 6 hexadecimal digits
 * (eg."#CAFFEE")
 */
colorOwn[Transparency transparency] returns [ColorOwn value]
	:
	COLOR_OWN_NAME { $value = ColorOwn.forString($COLOR_OWN_NAME.text, $transparency); } /* could be split up into color name Tokens */
	| COLOR_OWN_HEX { $value = ColorOwn.forString($COLOR_OWN_HEX.text, $transparency); }
	;

/**
 * sets the line type
 */
lt[RecRunnable inner] returns [RecRunnable callStack]
	:
	'lt=' lineType {
		final LineType newLineType = $lineType.value;
		if(newLineType != null) {
			$callStack = new RecRunnable($inner) {
				public void run() {
					//System.out.println("pre LT");
					LineType oldLineType = getDrawHandler().getLineType();
					getDrawHandler().setLineType(newLineType);
					runInner();
					getDrawHandler().setLineType(oldLineType);
					//System.out.println("post LT");
				}
			};
		} else {
			System.err.println("Wrong linetype!");
			$callStack = $inner;
		}
	}
	;

lineType returns [LineType value]
	:
	'-' {$value = LineType.SOLID;}
	| '.' {$value = LineType.DASHED;}
	| '..' {$value = LineType.DOTTED;}
	| '=' {$value = LineType.DOUBLE;}
	| ':' {$value = LineType.DOUBLE_DASHED;}
	| '::' {$value = LineType.DOUBLE_DOTTED;}
	;

/**
 * sets the line width
 */
lw[RecRunnable inner] returns [RecRunnable callStack]
	:
	'lw=' unsignedDoubleConstant {
		final double newLineWidth = $unsignedDoubleConstant.value;
		$callStack = new RecRunnable(inner) {
		public void run() {
			//System.out.println("pre LW");
			double oldLineWidth = getDrawHandler().getLineWidth();
			getDrawHandler().setLineWidth(newLineWidth);
			runInner();
			getDrawHandler().setLineWidth(oldLineWidth);
			//System.out.println("post LW");
		}
	};}
	;

simpleString returns [ String value]
	:
	SIMPLE_STRING { $value = $SIMPLE_STRING.text.substring(1,$SIMPLE_STRING.text.length()-1).replace("\\\"", "\"");} //remove the leading and trailing quotes, replace all escaped quotes \" with a normal quote "
	;

booleanConstant returns [ boolean value]
	:
	FALSE  { $value = false;}
	| TRUE { $value = true;}
	;

horizontalAlignment returns [AlignHorizontal alignment]
	:
		LEFT { $alignment = AlignHorizontal.LEFT;}
		| CENTER { $alignment = AlignHorizontal.CENTER;}
		| RIGHT { $alignment = AlignHorizontal.RIGHT;}
	;

// Start of the arithmetical interpreter

doubleTerm returns [double value] locals [ double tmp]
	:
	v1 = doubleProduct() { $value = $v1.value;}
	(
		'+' tmp1 = doubleProduct() { $value = $value + $tmp1.value; }
		| '-' tmp2 = doubleProduct() { $value = $value - $tmp2.value; }
	)*
	;

doubleProduct returns [double value] locals [ double tmp]
	:
	v1 = doubleValue() { $value = $v1.value;}
	(
		'*' tmp1 = doubleValue() { $value = $value * $tmp1.value; }
		| '/' tmp2 = doubleValue() { $value = $value / $tmp2.value; }
	)*
	;

doubleValue returns [double value]
	:
	WIDTH { $value = getWidth(); }
	| HEIGHT { $value = getHeight(); }
	| '-' unsignedDoubleConstant {$value = - $unsignedDoubleConstant.value;}
	| unsignedDoubleConstant {$value = $unsignedDoubleConstant.value;}
	| '(' doubleTerm ')' { $value = $doubleTerm.value;}
	;

unsignedDoubleConstant returns [double value] 
	:
	UNSIGNED_DOUBLE_CONSTANT { $value = Double.parseDouble($UNSIGNED_DOUBLE_CONSTANT.text); }
	;

COMMENT
    :   '//' ~('\r' | '\n')* ('\n'|'\r'|'\r\n')? -> skip
    ;

ILLEGAL: .;