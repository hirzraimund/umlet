// Generated from CustomDrawingParser.g4 by ANTLR 4.5

	package com.baselet.element.facet.common.CustomDrawingParser;

	import com.baselet.control.enums.AlignHorizontal;
	import com.baselet.control.enums.LineType;
	import com.baselet.diagram.draw.DrawHandler;
	import com.baselet.diagram.draw.helper.ColorOwn;
	import com.baselet.diagram.draw.helper.ColorOwn.Transparency;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CustomDrawingParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, WIDTH=24, 
		HEIGHT=25, TRUE=26, FALSE=27, LEFT=28, RIGHT=29, CENTER=30, UNSIGNED_DOUBLE_CONSTANT=31, 
		COLOR_OWN_HEX=32, COLOR_OWN_NAME=33, WS=34, SIMPLE_STRING=35, COMMENT=36, 
		ILLEGAL=37;
	public static final int
		RULE_parse = 0, RULE_drawLine = 1, RULE_drawRectangle = 2, RULE_drawRectangleRound = 3, 
		RULE_drawCircle = 4, RULE_drawEllipse = 5, RULE_drawArc = 6, RULE_drawText = 7, 
		RULE_fg = 8, RULE_bg = 9, RULE_colorOwn = 10, RULE_lt = 11, RULE_lineType = 12, 
		RULE_lw = 13, RULE_simpleString = 14, RULE_booleanConstant = 15, RULE_horizontalAlignment = 16, 
		RULE_doubleTerm = 17, RULE_doubleProduct = 18, RULE_doubleValue = 19, 
		RULE_unsignedDoubleConstant = 20;
	public static final String[] ruleNames = {
		"parse", "drawLine", "drawRectangle", "drawRectangleRound", "drawCircle", 
		"drawEllipse", "drawArc", "drawText", "fg", "bg", "colorOwn", "lt", "lineType", 
		"lw", "simpleString", "booleanConstant", "horizontalAlignment", "doubleTerm", 
		"doubleProduct", "doubleValue", "unsignedDoubleConstant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'drawLine('", "','", "')'", "'drawRectangle('", "'drawRectangleRound('", 
		"'drawCircle('", "'drawEllipse('", "'drawArc('", "'drawText('", "'fg='", 
		"'bg='", "'lt='", "'-'", "'.'", "'..'", "'='", "':'", "'::'", "'lw='", 
		"'+'", "'*'", "'/'", "'('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"WIDTH", "HEIGHT", "TRUE", "FALSE", "LEFT", "RIGHT", "CENTER", "UNSIGNED_DOUBLE_CONSTANT", 
		"COLOR_OWN_HEX", "COLOR_OWN_NAME", "WS", "SIMPLE_STRING", "COMMENT", "ILLEGAL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CustomDrawingParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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


	public CustomDrawingParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CustomDrawingParserParser.EOF, 0); }
		public DrawLineContext drawLine() {
			return getRuleContext(DrawLineContext.class,0);
		}
		public DrawRectangleContext drawRectangle() {
			return getRuleContext(DrawRectangleContext.class,0);
		}
		public DrawRectangleRoundContext drawRectangleRound() {
			return getRuleContext(DrawRectangleRoundContext.class,0);
		}
		public DrawCircleContext drawCircle() {
			return getRuleContext(DrawCircleContext.class,0);
		}
		public DrawEllipseContext drawEllipse() {
			return getRuleContext(DrawEllipseContext.class,0);
		}
		public DrawArcContext drawArc() {
			return getRuleContext(DrawArcContext.class,0);
		}
		public DrawTextContext drawText() {
			return getRuleContext(DrawTextContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(42);
				drawLine();
				}
				break;
			case T__3:
				{
				setState(43);
				drawRectangle();
				}
				break;
			case T__4:
				{
				setState(44);
				drawRectangleRound();
				}
				break;
			case T__5:
				{
				setState(45);
				drawCircle();
				}
				break;
			case T__6:
				{
				setState(46);
				drawEllipse();
				}
				break;
			case T__7:
				{
				setState(47);
				drawArc();
				}
				break;
			case T__8:
				{
				setState(48);
				drawText();
				}
				break;
			case EOF:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawLineContext extends ParserRuleContext {
		public RecRunnable callStack =  null;;
		public DoubleTermContext x1;
		public DoubleTermContext y1;
		public DoubleTermContext x2;
		public DoubleTermContext y2;
		public FgContext fg;
		public LtContext lt;
		public LwContext lw;
		public List<DoubleTermContext> doubleTerm() {
			return getRuleContexts(DoubleTermContext.class);
		}
		public DoubleTermContext doubleTerm(int i) {
			return getRuleContext(DoubleTermContext.class,i);
		}
		public List<FgContext> fg() {
			return getRuleContexts(FgContext.class);
		}
		public FgContext fg(int i) {
			return getRuleContext(FgContext.class,i);
		}
		public List<LtContext> lt() {
			return getRuleContexts(LtContext.class);
		}
		public LtContext lt(int i) {
			return getRuleContext(LtContext.class,i);
		}
		public List<LwContext> lw() {
			return getRuleContexts(LwContext.class);
		}
		public LwContext lw(int i) {
			return getRuleContext(LwContext.class,i);
		}
		public DrawLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDrawLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDrawLine(this);
		}
	}

	public final DrawLineContext drawLine() throws RecognitionException {
		DrawLineContext _localctx = new DrawLineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_drawLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			((DrawLineContext)_localctx).x1 = doubleTerm();
			setState(55);
			match(T__1);
			setState(56);
			((DrawLineContext)_localctx).y1 = doubleTerm();
			setState(57);
			match(T__1);
			setState(58);
			((DrawLineContext)_localctx).x2 = doubleTerm();
			setState(59);
			match(T__1);
			setState(60);
			((DrawLineContext)_localctx).y2 = doubleTerm();
			setState(61);
			match(T__2);

					final double x1 = ((DrawLineContext)_localctx).x1.value;
					final double y1 = ((DrawLineContext)_localctx).y1.value;
					final double x2 = ((DrawLineContext)_localctx).x2.value;
					final double y2 = ((DrawLineContext)_localctx).y2.value;
					((DrawLineContext)_localctx).callStack =  new RecRunnable(null) { public void run(){
						System.out.println(String.format("drawLine(%f, %f, %f, %f);", x1,y1,x2,y2));
						getDrawHandler().drawLine(x1, y1, x2, y2);
					}};
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__11) | (1L << T__18))) != 0)) {
				{
				setState(72);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(63);
					((DrawLineContext)_localctx).fg = fg(_localctx.callStack);
					((DrawLineContext)_localctx).callStack =  ((DrawLineContext)_localctx).fg.callStack;
					}
					break;
				case T__11:
					{
					setState(66);
					((DrawLineContext)_localctx).lt = lt(_localctx.callStack);
					((DrawLineContext)_localctx).callStack =  ((DrawLineContext)_localctx).lt.callStack;
					}
					break;
				case T__18:
					{
					setState(69);
					((DrawLineContext)_localctx).lw = lw(_localctx.callStack);
					((DrawLineContext)_localctx).callStack =  ((DrawLineContext)_localctx).lw.callStack;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			 _localctx.callStack.run(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawRectangleContext extends ParserRuleContext {
		public RecRunnable callStack =  null;;
		public DoubleTermContext x;
		public DoubleTermContext y;
		public DoubleTermContext width;
		public DoubleTermContext height;
		public FgContext fg;
		public BgContext bg;
		public LtContext lt;
		public LwContext lw;
		public List<DoubleTermContext> doubleTerm() {
			return getRuleContexts(DoubleTermContext.class);
		}
		public DoubleTermContext doubleTerm(int i) {
			return getRuleContext(DoubleTermContext.class,i);
		}
		public List<FgContext> fg() {
			return getRuleContexts(FgContext.class);
		}
		public FgContext fg(int i) {
			return getRuleContext(FgContext.class,i);
		}
		public List<BgContext> bg() {
			return getRuleContexts(BgContext.class);
		}
		public BgContext bg(int i) {
			return getRuleContext(BgContext.class,i);
		}
		public List<LtContext> lt() {
			return getRuleContexts(LtContext.class);
		}
		public LtContext lt(int i) {
			return getRuleContext(LtContext.class,i);
		}
		public List<LwContext> lw() {
			return getRuleContexts(LwContext.class);
		}
		public LwContext lw(int i) {
			return getRuleContext(LwContext.class,i);
		}
		public DrawRectangleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawRectangle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDrawRectangle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDrawRectangle(this);
		}
	}

	public final DrawRectangleContext drawRectangle() throws RecognitionException {
		DrawRectangleContext _localctx = new DrawRectangleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_drawRectangle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__3);
			setState(78);
			((DrawRectangleContext)_localctx).x = doubleTerm();
			{
			}
			setState(80);
			match(T__1);
			setState(81);
			((DrawRectangleContext)_localctx).y = doubleTerm();
			{
			}
			setState(83);
			match(T__1);
			setState(84);
			((DrawRectangleContext)_localctx).width = doubleTerm();
			{
			}
			setState(86);
			match(T__1);
			setState(87);
			((DrawRectangleContext)_localctx).height = doubleTerm();
			{
			}
			setState(89);
			match(T__2);

					final double x = ((DrawRectangleContext)_localctx).x.value;
					final double y = ((DrawRectangleContext)_localctx).y.value;
					final double width = ((DrawRectangleContext)_localctx).width.value;
					final double height = ((DrawRectangleContext)_localctx).height.value;
					((DrawRectangleContext)_localctx).callStack =  new RecRunnable(null) { public void run() { 
						//System.out.println(String.format("drawRectangle(%f, %f, %f, %f);", x,y,width,height));
						getDrawHandler().drawRectangle(x, y, width, height);
					}};
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__18))) != 0)) {
				{
				setState(103);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(91);
					((DrawRectangleContext)_localctx).fg = fg(_localctx.callStack);
					((DrawRectangleContext)_localctx).callStack =  ((DrawRectangleContext)_localctx).fg.callStack;
					}
					break;
				case T__10:
					{
					setState(94);
					((DrawRectangleContext)_localctx).bg = bg(_localctx.callStack);
					((DrawRectangleContext)_localctx).callStack =  ((DrawRectangleContext)_localctx).bg.callStack;
					}
					break;
				case T__11:
					{
					setState(97);
					((DrawRectangleContext)_localctx).lt = lt(_localctx.callStack);
					((DrawRectangleContext)_localctx).callStack =  ((DrawRectangleContext)_localctx).lt.callStack;
					}
					break;
				case T__18:
					{
					setState(100);
					((DrawRectangleContext)_localctx).lw = lw(_localctx.callStack);
					((DrawRectangleContext)_localctx).callStack =  ((DrawRectangleContext)_localctx).lw.callStack;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			 _localctx.callStack.run(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawRectangleRoundContext extends ParserRuleContext {
		public RecRunnable callStack =  null;;
		public DoubleTermContext x;
		public DoubleTermContext y;
		public DoubleTermContext width;
		public DoubleTermContext height;
		public DoubleTermContext radius;
		public FgContext fg;
		public BgContext bg;
		public LtContext lt;
		public LwContext lw;
		public List<DoubleTermContext> doubleTerm() {
			return getRuleContexts(DoubleTermContext.class);
		}
		public DoubleTermContext doubleTerm(int i) {
			return getRuleContext(DoubleTermContext.class,i);
		}
		public List<FgContext> fg() {
			return getRuleContexts(FgContext.class);
		}
		public FgContext fg(int i) {
			return getRuleContext(FgContext.class,i);
		}
		public List<BgContext> bg() {
			return getRuleContexts(BgContext.class);
		}
		public BgContext bg(int i) {
			return getRuleContext(BgContext.class,i);
		}
		public List<LtContext> lt() {
			return getRuleContexts(LtContext.class);
		}
		public LtContext lt(int i) {
			return getRuleContext(LtContext.class,i);
		}
		public List<LwContext> lw() {
			return getRuleContexts(LwContext.class);
		}
		public LwContext lw(int i) {
			return getRuleContext(LwContext.class,i);
		}
		public DrawRectangleRoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawRectangleRound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDrawRectangleRound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDrawRectangleRound(this);
		}
	}

	public final DrawRectangleRoundContext drawRectangleRound() throws RecognitionException {
		DrawRectangleRoundContext _localctx = new DrawRectangleRoundContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_drawRectangleRound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__4);
			setState(109);
			((DrawRectangleRoundContext)_localctx).x = doubleTerm();
			{
			}
			setState(111);
			match(T__1);
			setState(112);
			((DrawRectangleRoundContext)_localctx).y = doubleTerm();
			{
			}
			setState(114);
			match(T__1);
			setState(115);
			((DrawRectangleRoundContext)_localctx).width = doubleTerm();
			{
			}
			setState(117);
			match(T__1);
			setState(118);
			((DrawRectangleRoundContext)_localctx).height = doubleTerm();
			{
			}
			setState(120);
			match(T__1);
			setState(121);
			((DrawRectangleRoundContext)_localctx).radius = doubleTerm();
			{
			}
			setState(123);
			match(T__2);

					final double x = ((DrawRectangleRoundContext)_localctx).x.value;
					final double y = ((DrawRectangleRoundContext)_localctx).y.value;
					final double width = ((DrawRectangleRoundContext)_localctx).width.value;
					final double height = ((DrawRectangleRoundContext)_localctx).height.value;
					final double radius = ((DrawRectangleRoundContext)_localctx).radius.value;
					((DrawRectangleRoundContext)_localctx).callStack =  new RecRunnable(null) { public void run() { 
						//System.out.println(String.format("drawRectangleRound(%f, %f, %f, %f, %f);", x,y,width,height,radius));
						getDrawHandler().drawRectangleRound(x, y, width, height, radius);
					}};
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__18))) != 0)) {
				{
				setState(137);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(125);
					((DrawRectangleRoundContext)_localctx).fg = fg(_localctx.callStack);
					((DrawRectangleRoundContext)_localctx).callStack =  ((DrawRectangleRoundContext)_localctx).fg.callStack;
					}
					break;
				case T__10:
					{
					setState(128);
					((DrawRectangleRoundContext)_localctx).bg = bg(_localctx.callStack);
					((DrawRectangleRoundContext)_localctx).callStack =  ((DrawRectangleRoundContext)_localctx).bg.callStack;
					}
					break;
				case T__11:
					{
					setState(131);
					((DrawRectangleRoundContext)_localctx).lt = lt(_localctx.callStack);
					((DrawRectangleRoundContext)_localctx).callStack =  ((DrawRectangleRoundContext)_localctx).lt.callStack;
					}
					break;
				case T__18:
					{
					setState(134);
					((DrawRectangleRoundContext)_localctx).lw = lw(_localctx.callStack);
					((DrawRectangleRoundContext)_localctx).callStack =  ((DrawRectangleRoundContext)_localctx).lw.callStack;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			 _localctx.callStack.run(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawCircleContext extends ParserRuleContext {
		public RecRunnable callStack =  null;;
		public DoubleTermContext x;
		public DoubleTermContext y;
		public DoubleTermContext radius;
		public FgContext fg;
		public BgContext bg;
		public LtContext lt;
		public LwContext lw;
		public List<DoubleTermContext> doubleTerm() {
			return getRuleContexts(DoubleTermContext.class);
		}
		public DoubleTermContext doubleTerm(int i) {
			return getRuleContext(DoubleTermContext.class,i);
		}
		public List<FgContext> fg() {
			return getRuleContexts(FgContext.class);
		}
		public FgContext fg(int i) {
			return getRuleContext(FgContext.class,i);
		}
		public List<BgContext> bg() {
			return getRuleContexts(BgContext.class);
		}
		public BgContext bg(int i) {
			return getRuleContext(BgContext.class,i);
		}
		public List<LtContext> lt() {
			return getRuleContexts(LtContext.class);
		}
		public LtContext lt(int i) {
			return getRuleContext(LtContext.class,i);
		}
		public List<LwContext> lw() {
			return getRuleContexts(LwContext.class);
		}
		public LwContext lw(int i) {
			return getRuleContext(LwContext.class,i);
		}
		public DrawCircleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawCircle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDrawCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDrawCircle(this);
		}
	}

	public final DrawCircleContext drawCircle() throws RecognitionException {
		DrawCircleContext _localctx = new DrawCircleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_drawCircle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__5);
			setState(143);
			((DrawCircleContext)_localctx).x = doubleTerm();
			{
			}
			setState(145);
			match(T__1);
			setState(146);
			((DrawCircleContext)_localctx).y = doubleTerm();
			{
			}
			setState(148);
			match(T__1);
			setState(149);
			((DrawCircleContext)_localctx).radius = doubleTerm();
			{
			}
			setState(151);
			match(T__2);

					final double x = ((DrawCircleContext)_localctx).x.value;
					final double y = ((DrawCircleContext)_localctx).y.value;
					final double radius = ((DrawCircleContext)_localctx).radius.value;
					((DrawCircleContext)_localctx).callStack =  new RecRunnable(null) { public void run() {
						getDrawHandler().drawCircle(x, y, radius);
					}};
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__18))) != 0)) {
				{
				setState(165);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(153);
					((DrawCircleContext)_localctx).fg = fg(_localctx.callStack);
					((DrawCircleContext)_localctx).callStack =  ((DrawCircleContext)_localctx).fg.callStack;
					}
					break;
				case T__10:
					{
					setState(156);
					((DrawCircleContext)_localctx).bg = bg(_localctx.callStack);
					((DrawCircleContext)_localctx).callStack =  ((DrawCircleContext)_localctx).bg.callStack;
					}
					break;
				case T__11:
					{
					setState(159);
					((DrawCircleContext)_localctx).lt = lt(_localctx.callStack);
					((DrawCircleContext)_localctx).callStack =  ((DrawCircleContext)_localctx).lt.callStack;
					}
					break;
				case T__18:
					{
					setState(162);
					((DrawCircleContext)_localctx).lw = lw(_localctx.callStack);
					((DrawCircleContext)_localctx).callStack =  ((DrawCircleContext)_localctx).lw.callStack;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			 _localctx.callStack.run(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawEllipseContext extends ParserRuleContext {
		public RecRunnable callStack =  null;;
		public DoubleTermContext x;
		public DoubleTermContext y;
		public DoubleTermContext width;
		public DoubleTermContext height;
		public FgContext fg;
		public BgContext bg;
		public LtContext lt;
		public LwContext lw;
		public List<DoubleTermContext> doubleTerm() {
			return getRuleContexts(DoubleTermContext.class);
		}
		public DoubleTermContext doubleTerm(int i) {
			return getRuleContext(DoubleTermContext.class,i);
		}
		public List<FgContext> fg() {
			return getRuleContexts(FgContext.class);
		}
		public FgContext fg(int i) {
			return getRuleContext(FgContext.class,i);
		}
		public List<BgContext> bg() {
			return getRuleContexts(BgContext.class);
		}
		public BgContext bg(int i) {
			return getRuleContext(BgContext.class,i);
		}
		public List<LtContext> lt() {
			return getRuleContexts(LtContext.class);
		}
		public LtContext lt(int i) {
			return getRuleContext(LtContext.class,i);
		}
		public List<LwContext> lw() {
			return getRuleContexts(LwContext.class);
		}
		public LwContext lw(int i) {
			return getRuleContext(LwContext.class,i);
		}
		public DrawEllipseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawEllipse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDrawEllipse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDrawEllipse(this);
		}
	}

	public final DrawEllipseContext drawEllipse() throws RecognitionException {
		DrawEllipseContext _localctx = new DrawEllipseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_drawEllipse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__6);
			setState(171);
			((DrawEllipseContext)_localctx).x = doubleTerm();
			{
			}
			setState(173);
			match(T__1);
			setState(174);
			((DrawEllipseContext)_localctx).y = doubleTerm();
			{
			}
			setState(176);
			match(T__1);
			setState(177);
			((DrawEllipseContext)_localctx).width = doubleTerm();
			{
			}
			setState(179);
			match(T__1);
			setState(180);
			((DrawEllipseContext)_localctx).height = doubleTerm();
			{
			}
			setState(182);
			match(T__2);

					final double x = ((DrawEllipseContext)_localctx).x.value;
					final double y = ((DrawEllipseContext)_localctx).y.value;
					final double width = ((DrawEllipseContext)_localctx).width.value;
					final double height = ((DrawEllipseContext)_localctx).height.value;
					((DrawEllipseContext)_localctx).callStack =  new RecRunnable(null) { public void run() {
						getDrawHandler().drawEllipse(x, y, width, height);
					}};
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__18))) != 0)) {
				{
				setState(196);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(184);
					((DrawEllipseContext)_localctx).fg = fg(_localctx.callStack);
					((DrawEllipseContext)_localctx).callStack =  ((DrawEllipseContext)_localctx).fg.callStack;
					}
					break;
				case T__10:
					{
					setState(187);
					((DrawEllipseContext)_localctx).bg = bg(_localctx.callStack);
					((DrawEllipseContext)_localctx).callStack =  ((DrawEllipseContext)_localctx).bg.callStack;
					}
					break;
				case T__11:
					{
					setState(190);
					((DrawEllipseContext)_localctx).lt = lt(_localctx.callStack);
					((DrawEllipseContext)_localctx).callStack =  ((DrawEllipseContext)_localctx).lt.callStack;
					}
					break;
				case T__18:
					{
					setState(193);
					((DrawEllipseContext)_localctx).lw = lw(_localctx.callStack);
					((DrawEllipseContext)_localctx).callStack =  ((DrawEllipseContext)_localctx).lw.callStack;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			 _localctx.callStack.run(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawArcContext extends ParserRuleContext {
		public RecRunnable callStack =  null;;
		public DoubleTermContext x;
		public DoubleTermContext y;
		public DoubleTermContext width;
		public DoubleTermContext height;
		public DoubleTermContext myStart;
		public DoubleTermContext extent;
		public BooleanConstantContext booleanConstant;
		public FgContext fg;
		public BgContext bg;
		public LtContext lt;
		public LwContext lw;
		public BooleanConstantContext booleanConstant() {
			return getRuleContext(BooleanConstantContext.class,0);
		}
		public List<DoubleTermContext> doubleTerm() {
			return getRuleContexts(DoubleTermContext.class);
		}
		public DoubleTermContext doubleTerm(int i) {
			return getRuleContext(DoubleTermContext.class,i);
		}
		public List<FgContext> fg() {
			return getRuleContexts(FgContext.class);
		}
		public FgContext fg(int i) {
			return getRuleContext(FgContext.class,i);
		}
		public List<BgContext> bg() {
			return getRuleContexts(BgContext.class);
		}
		public BgContext bg(int i) {
			return getRuleContext(BgContext.class,i);
		}
		public List<LtContext> lt() {
			return getRuleContexts(LtContext.class);
		}
		public LtContext lt(int i) {
			return getRuleContext(LtContext.class,i);
		}
		public List<LwContext> lw() {
			return getRuleContexts(LwContext.class);
		}
		public LwContext lw(int i) {
			return getRuleContext(LwContext.class,i);
		}
		public DrawArcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawArc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDrawArc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDrawArc(this);
		}
	}

	public final DrawArcContext drawArc() throws RecognitionException {
		DrawArcContext _localctx = new DrawArcContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_drawArc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__7);
			setState(202);
			((DrawArcContext)_localctx).x = doubleTerm();
			setState(203);
			match(T__1);
			setState(204);
			((DrawArcContext)_localctx).y = doubleTerm();
			setState(205);
			match(T__1);
			setState(206);
			((DrawArcContext)_localctx).width = doubleTerm();
			setState(207);
			match(T__1);
			setState(208);
			((DrawArcContext)_localctx).height = doubleTerm();
			setState(209);
			match(T__1);
			setState(210);
			((DrawArcContext)_localctx).myStart = doubleTerm();
			setState(211);
			match(T__1);
			setState(212);
			((DrawArcContext)_localctx).extent = doubleTerm();
			setState(213);
			match(T__1);
			setState(214);
			((DrawArcContext)_localctx).booleanConstant = booleanConstant();
			setState(215);
			match(T__2);

					final double x = ((DrawArcContext)_localctx).x.value;
					final double y = ((DrawArcContext)_localctx).y.value;
					final double width = ((DrawArcContext)_localctx).width.value;
					final double height = ((DrawArcContext)_localctx).height.value;
					final double start = ((DrawArcContext)_localctx).myStart.value;
					final double extent = ((DrawArcContext)_localctx).extent.value;
					final boolean open = ((DrawArcContext)_localctx).booleanConstant.value;
					((DrawArcContext)_localctx).callStack =  new RecRunnable(null) { public void run() {
						System.out.println(String.format("drawArc(%f, %f, %f, %f, %f, %f, %b);",x, y, width, height, start, extent, open));
						getDrawHandler().drawArc(x, y, width, height, start, extent, open);
					}};
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__18))) != 0)) {
				{
				setState(229);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(217);
					((DrawArcContext)_localctx).fg = fg(_localctx.callStack);
					((DrawArcContext)_localctx).callStack =  ((DrawArcContext)_localctx).fg.callStack;
					}
					break;
				case T__10:
					{
					setState(220);
					((DrawArcContext)_localctx).bg = bg(_localctx.callStack);
					((DrawArcContext)_localctx).callStack =  ((DrawArcContext)_localctx).bg.callStack;
					}
					break;
				case T__11:
					{
					setState(223);
					((DrawArcContext)_localctx).lt = lt(_localctx.callStack);
					((DrawArcContext)_localctx).callStack =  ((DrawArcContext)_localctx).lt.callStack;
					}
					break;
				case T__18:
					{
					setState(226);
					((DrawArcContext)_localctx).lw = lw(_localctx.callStack);
					((DrawArcContext)_localctx).callStack =  ((DrawArcContext)_localctx).lw.callStack;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			 _localctx.callStack.run(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrawTextContext extends ParserRuleContext {
		public RecRunnable callStack =  null;;
		public SimpleStringContext simpleString;
		public DoubleTermContext x;
		public DoubleTermContext y;
		public HorizontalAlignmentContext horizontalAlignment;
		public FgContext fg;
		public SimpleStringContext simpleString() {
			return getRuleContext(SimpleStringContext.class,0);
		}
		public HorizontalAlignmentContext horizontalAlignment() {
			return getRuleContext(HorizontalAlignmentContext.class,0);
		}
		public List<DoubleTermContext> doubleTerm() {
			return getRuleContexts(DoubleTermContext.class);
		}
		public DoubleTermContext doubleTerm(int i) {
			return getRuleContext(DoubleTermContext.class,i);
		}
		public List<FgContext> fg() {
			return getRuleContexts(FgContext.class);
		}
		public FgContext fg(int i) {
			return getRuleContext(FgContext.class,i);
		}
		public DrawTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDrawText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDrawText(this);
		}
	}

	public final DrawTextContext drawText() throws RecognitionException {
		DrawTextContext _localctx = new DrawTextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_drawText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__8);
			setState(235);
			((DrawTextContext)_localctx).simpleString = simpleString();
			{
			}
			setState(237);
			match(T__1);
			setState(238);
			((DrawTextContext)_localctx).x = doubleTerm();
			{
			}
			setState(240);
			match(T__1);
			setState(241);
			((DrawTextContext)_localctx).y = doubleTerm();
			{
			}
			setState(243);
			match(T__1);
			setState(244);
			((DrawTextContext)_localctx).horizontalAlignment = horizontalAlignment();
			{
			}
			setState(246);
			match(T__2);

					final String text = ((DrawTextContext)_localctx).simpleString.value;
					final double x = ((DrawTextContext)_localctx).x.value;
					final double y = ((DrawTextContext)_localctx).y.value;
					final AlignHorizontal alignment = ((DrawTextContext)_localctx).horizontalAlignment.alignment;
					((DrawTextContext)_localctx).callStack =  new RecRunnable(null) { public void run() {
						System.out.println(String.format("drawText(%s, %f, %f, %s);", text,x,y,alignment.toString()));
						getDrawHandler().print(text, x, y, alignment);
					}};
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(248);
				((DrawTextContext)_localctx).fg = fg(_localctx.callStack);
				((DrawTextContext)_localctx).callStack =  ((DrawTextContext)_localctx).fg.callStack;
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			 _localctx.callStack.run(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FgContext extends ParserRuleContext {
		public RecRunnable inner;
		public RecRunnable callStack;
		public ColorOwnContext colorOwn;
		public ColorOwnContext colorOwn() {
			return getRuleContext(ColorOwnContext.class,0);
		}
		public FgContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FgContext(ParserRuleContext parent, int invokingState, RecRunnable inner) {
			super(parent, invokingState);
			this.inner = inner;
		}
		@Override public int getRuleIndex() { return RULE_fg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterFg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitFg(this);
		}
	}

	public final FgContext fg(RecRunnable inner) throws RecognitionException {
		FgContext _localctx = new FgContext(_ctx, getState(), inner);
		enterRule(_localctx, 16, RULE_fg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(T__9);
			setState(257);
			((FgContext)_localctx).colorOwn = colorOwn(Transparency.FOREGROUND);

					final ColorOwn newColor = ((FgContext)_localctx).colorOwn.value;
					((FgContext)_localctx).callStack =  new RecRunnable(_localctx.inner) {
					public void run(){
						//System.out.println("pre FG");
						ColorOwn oldColor = getDrawHandler().getForegroundColor();
						getDrawHandler().setForegroundColor(newColor);
						runInner();
						getDrawHandler().setForegroundColor(oldColor);
						//System.out.println("post FG");
					}
				};
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BgContext extends ParserRuleContext {
		public RecRunnable inner;
		public RecRunnable callStack;
		public ColorOwnContext colorOwn;
		public ColorOwnContext colorOwn() {
			return getRuleContext(ColorOwnContext.class,0);
		}
		public BgContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BgContext(ParserRuleContext parent, int invokingState, RecRunnable inner) {
			super(parent, invokingState);
			this.inner = inner;
		}
		@Override public int getRuleIndex() { return RULE_bg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterBg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitBg(this);
		}
	}

	public final BgContext bg(RecRunnable inner) throws RecognitionException {
		BgContext _localctx = new BgContext(_ctx, getState(), inner);
		enterRule(_localctx, 18, RULE_bg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__10);
			setState(261);
			((BgContext)_localctx).colorOwn = colorOwn(Transparency.BACKGROUND);

					final ColorOwn newColor = ((BgContext)_localctx).colorOwn.value;
					((BgContext)_localctx).callStack =  new RecRunnable(_localctx.inner) {
					public void run(){
						//System.out.println("pre BG");
						ColorOwn oldColor = getDrawHandler().getBackgroundColor();
						getDrawHandler().setBackgroundColor(newColor);
						runInner();
						getDrawHandler().setBackgroundColor(oldColor);
						//System.out.println("post BG");
					}
				};
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColorOwnContext extends ParserRuleContext {
		public Transparency transparency;
		public ColorOwn value;
		public Token COLOR_OWN_NAME;
		public Token COLOR_OWN_HEX;
		public TerminalNode COLOR_OWN_NAME() { return getToken(CustomDrawingParserParser.COLOR_OWN_NAME, 0); }
		public TerminalNode COLOR_OWN_HEX() { return getToken(CustomDrawingParserParser.COLOR_OWN_HEX, 0); }
		public ColorOwnContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ColorOwnContext(ParserRuleContext parent, int invokingState, Transparency transparency) {
			super(parent, invokingState);
			this.transparency = transparency;
		}
		@Override public int getRuleIndex() { return RULE_colorOwn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterColorOwn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitColorOwn(this);
		}
	}

	public final ColorOwnContext colorOwn(Transparency transparency) throws RecognitionException {
		ColorOwnContext _localctx = new ColorOwnContext(_ctx, getState(), transparency);
		enterRule(_localctx, 20, RULE_colorOwn);
		try {
			setState(268);
			switch (_input.LA(1)) {
			case COLOR_OWN_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				((ColorOwnContext)_localctx).COLOR_OWN_NAME = match(COLOR_OWN_NAME);
				 ((ColorOwnContext)_localctx).value =  ColorOwn.forString((((ColorOwnContext)_localctx).COLOR_OWN_NAME!=null?((ColorOwnContext)_localctx).COLOR_OWN_NAME.getText():null), _localctx.transparency); 
				}
				break;
			case COLOR_OWN_HEX:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				((ColorOwnContext)_localctx).COLOR_OWN_HEX = match(COLOR_OWN_HEX);
				 ((ColorOwnContext)_localctx).value =  ColorOwn.forString((((ColorOwnContext)_localctx).COLOR_OWN_HEX!=null?((ColorOwnContext)_localctx).COLOR_OWN_HEX.getText():null), _localctx.transparency); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LtContext extends ParserRuleContext {
		public RecRunnable inner;
		public RecRunnable callStack;
		public LineTypeContext lineType;
		public LineTypeContext lineType() {
			return getRuleContext(LineTypeContext.class,0);
		}
		public LtContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LtContext(ParserRuleContext parent, int invokingState, RecRunnable inner) {
			super(parent, invokingState);
			this.inner = inner;
		}
		@Override public int getRuleIndex() { return RULE_lt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitLt(this);
		}
	}

	public final LtContext lt(RecRunnable inner) throws RecognitionException {
		LtContext _localctx = new LtContext(_ctx, getState(), inner);
		enterRule(_localctx, 22, RULE_lt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__11);
			setState(271);
			((LtContext)_localctx).lineType = lineType();

					final LineType newLineType = ((LtContext)_localctx).lineType.value;
					if(newLineType != null) {
						((LtContext)_localctx).callStack =  new RecRunnable(_localctx.inner) {
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
						((LtContext)_localctx).callStack =  _localctx.inner;
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineTypeContext extends ParserRuleContext {
		public LineType value;
		public LineTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterLineType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitLineType(this);
		}
	}

	public final LineTypeContext lineType() throws RecognitionException {
		LineTypeContext _localctx = new LineTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lineType);
		try {
			setState(286);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(T__12);
				((LineTypeContext)_localctx).value =  LineType.SOLID;
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(T__13);
				((LineTypeContext)_localctx).value =  LineType.DASHED;
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				match(T__14);
				((LineTypeContext)_localctx).value =  LineType.DOTTED;
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(280);
				match(T__15);
				((LineTypeContext)_localctx).value =  LineType.DOUBLE;
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(282);
				match(T__16);
				((LineTypeContext)_localctx).value =  LineType.DOUBLE_DASHED;
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
				match(T__17);
				((LineTypeContext)_localctx).value =  LineType.DOUBLE_DOTTED;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LwContext extends ParserRuleContext {
		public RecRunnable inner;
		public RecRunnable callStack;
		public UnsignedDoubleConstantContext unsignedDoubleConstant;
		public UnsignedDoubleConstantContext unsignedDoubleConstant() {
			return getRuleContext(UnsignedDoubleConstantContext.class,0);
		}
		public LwContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LwContext(ParserRuleContext parent, int invokingState, RecRunnable inner) {
			super(parent, invokingState);
			this.inner = inner;
		}
		@Override public int getRuleIndex() { return RULE_lw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterLw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitLw(this);
		}
	}

	public final LwContext lw(RecRunnable inner) throws RecognitionException {
		LwContext _localctx = new LwContext(_ctx, getState(), inner);
		enterRule(_localctx, 26, RULE_lw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__18);
			setState(289);
			((LwContext)_localctx).unsignedDoubleConstant = unsignedDoubleConstant();

					final double newLineWidth = ((LwContext)_localctx).unsignedDoubleConstant.value;
					((LwContext)_localctx).callStack =  new RecRunnable(inner) {
					public void run() {
						//System.out.println("pre LW");
						double oldLineWidth = getDrawHandler().getLineWidth();
						getDrawHandler().setLineWidth(newLineWidth);
						runInner();
						getDrawHandler().setLineWidth(oldLineWidth);
						//System.out.println("post LW");
					}
				};
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleStringContext extends ParserRuleContext {
		public String value;
		public Token SIMPLE_STRING;
		public TerminalNode SIMPLE_STRING() { return getToken(CustomDrawingParserParser.SIMPLE_STRING, 0); }
		public SimpleStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterSimpleString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitSimpleString(this);
		}
	}

	public final SimpleStringContext simpleString() throws RecognitionException {
		SimpleStringContext _localctx = new SimpleStringContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			((SimpleStringContext)_localctx).SIMPLE_STRING = match(SIMPLE_STRING);
			 ((SimpleStringContext)_localctx).value =  (((SimpleStringContext)_localctx).SIMPLE_STRING!=null?((SimpleStringContext)_localctx).SIMPLE_STRING.getText():null).substring(1,(((SimpleStringContext)_localctx).SIMPLE_STRING!=null?((SimpleStringContext)_localctx).SIMPLE_STRING.getText():null).length()-1).replace("\\\"", "\"");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanConstantContext extends ParserRuleContext {
		public boolean value;
		public TerminalNode FALSE() { return getToken(CustomDrawingParserParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(CustomDrawingParserParser.TRUE, 0); }
		public BooleanConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterBooleanConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitBooleanConstant(this);
		}
	}

	public final BooleanConstantContext booleanConstant() throws RecognitionException {
		BooleanConstantContext _localctx = new BooleanConstantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_booleanConstant);
		try {
			setState(299);
			switch (_input.LA(1)) {
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(FALSE);
				 ((BooleanConstantContext)_localctx).value =  false;
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(TRUE);
				 ((BooleanConstantContext)_localctx).value =  true;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HorizontalAlignmentContext extends ParserRuleContext {
		public AlignHorizontal alignment;
		public TerminalNode LEFT() { return getToken(CustomDrawingParserParser.LEFT, 0); }
		public TerminalNode CENTER() { return getToken(CustomDrawingParserParser.CENTER, 0); }
		public TerminalNode RIGHT() { return getToken(CustomDrawingParserParser.RIGHT, 0); }
		public HorizontalAlignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_horizontalAlignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterHorizontalAlignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitHorizontalAlignment(this);
		}
	}

	public final HorizontalAlignmentContext horizontalAlignment() throws RecognitionException {
		HorizontalAlignmentContext _localctx = new HorizontalAlignmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_horizontalAlignment);
		try {
			setState(307);
			switch (_input.LA(1)) {
			case LEFT:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				match(LEFT);
				 ((HorizontalAlignmentContext)_localctx).alignment =  AlignHorizontal.LEFT;
				}
				break;
			case CENTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(CENTER);
				 ((HorizontalAlignmentContext)_localctx).alignment =  AlignHorizontal.CENTER;
				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(RIGHT);
				 ((HorizontalAlignmentContext)_localctx).alignment =  AlignHorizontal.RIGHT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoubleTermContext extends ParserRuleContext {
		public double value;
		public double tmp;
		public DoubleProductContext v1;
		public DoubleProductContext tmp1;
		public DoubleProductContext tmp2;
		public List<DoubleProductContext> doubleProduct() {
			return getRuleContexts(DoubleProductContext.class);
		}
		public DoubleProductContext doubleProduct(int i) {
			return getRuleContext(DoubleProductContext.class,i);
		}
		public DoubleTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDoubleTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDoubleTerm(this);
		}
	}

	public final DoubleTermContext doubleTerm() throws RecognitionException {
		DoubleTermContext _localctx = new DoubleTermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_doubleTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			((DoubleTermContext)_localctx).v1 = doubleProduct();
			{
			}
			 ((DoubleTermContext)_localctx).value =  ((DoubleTermContext)_localctx).v1.value;
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==T__19) {
				{
				setState(322);
				switch (_input.LA(1)) {
				case T__19:
					{
					setState(312);
					match(T__19);
					setState(313);
					((DoubleTermContext)_localctx).tmp1 = doubleProduct();
					{
					}
					 ((DoubleTermContext)_localctx).value =  _localctx.value + ((DoubleTermContext)_localctx).tmp1.value; 
					}
					break;
				case T__12:
					{
					setState(317);
					match(T__12);
					setState(318);
					((DoubleTermContext)_localctx).tmp2 = doubleProduct();
					{
					}
					 ((DoubleTermContext)_localctx).value =  _localctx.value - ((DoubleTermContext)_localctx).tmp2.value; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoubleProductContext extends ParserRuleContext {
		public double value;
		public double tmp;
		public DoubleValueContext v1;
		public DoubleValueContext tmp1;
		public DoubleValueContext tmp2;
		public List<DoubleValueContext> doubleValue() {
			return getRuleContexts(DoubleValueContext.class);
		}
		public DoubleValueContext doubleValue(int i) {
			return getRuleContext(DoubleValueContext.class,i);
		}
		public DoubleProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleProduct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDoubleProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDoubleProduct(this);
		}
	}

	public final DoubleProductContext doubleProduct() throws RecognitionException {
		DoubleProductContext _localctx = new DoubleProductContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_doubleProduct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			((DoubleProductContext)_localctx).v1 = doubleValue();
			{
			}
			 ((DoubleProductContext)_localctx).value =  ((DoubleProductContext)_localctx).v1.value;
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20 || _la==T__21) {
				{
				setState(340);
				switch (_input.LA(1)) {
				case T__20:
					{
					setState(330);
					match(T__20);
					setState(331);
					((DoubleProductContext)_localctx).tmp1 = doubleValue();
					{
					}
					 ((DoubleProductContext)_localctx).value =  _localctx.value * ((DoubleProductContext)_localctx).tmp1.value; 
					}
					break;
				case T__21:
					{
					setState(335);
					match(T__21);
					setState(336);
					((DoubleProductContext)_localctx).tmp2 = doubleValue();
					{
					}
					 ((DoubleProductContext)_localctx).value =  _localctx.value / ((DoubleProductContext)_localctx).tmp2.value; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoubleValueContext extends ParserRuleContext {
		public double value;
		public UnsignedDoubleConstantContext unsignedDoubleConstant;
		public DoubleTermContext doubleTerm;
		public TerminalNode WIDTH() { return getToken(CustomDrawingParserParser.WIDTH, 0); }
		public TerminalNode HEIGHT() { return getToken(CustomDrawingParserParser.HEIGHT, 0); }
		public UnsignedDoubleConstantContext unsignedDoubleConstant() {
			return getRuleContext(UnsignedDoubleConstantContext.class,0);
		}
		public DoubleTermContext doubleTerm() {
			return getRuleContext(DoubleTermContext.class,0);
		}
		public DoubleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterDoubleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitDoubleValue(this);
		}
	}

	public final DoubleValueContext doubleValue() throws RecognitionException {
		DoubleValueContext _localctx = new DoubleValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_doubleValue);
		try {
			setState(361);
			switch (_input.LA(1)) {
			case WIDTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				match(WIDTH);
				 ((DoubleValueContext)_localctx).value =  getWidth(); 
				}
				break;
			case HEIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(HEIGHT);
				 ((DoubleValueContext)_localctx).value =  getHeight(); 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				match(T__12);
				setState(350);
				((DoubleValueContext)_localctx).unsignedDoubleConstant = unsignedDoubleConstant();
				((DoubleValueContext)_localctx).value =  - ((DoubleValueContext)_localctx).unsignedDoubleConstant.value;
				}
				break;
			case UNSIGNED_DOUBLE_CONSTANT:
				enterOuterAlt(_localctx, 4);
				{
				setState(353);
				((DoubleValueContext)_localctx).unsignedDoubleConstant = unsignedDoubleConstant();
				((DoubleValueContext)_localctx).value =  ((DoubleValueContext)_localctx).unsignedDoubleConstant.value;
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 5);
				{
				setState(356);
				match(T__22);
				setState(357);
				((DoubleValueContext)_localctx).doubleTerm = doubleTerm();
				setState(358);
				match(T__2);
				 ((DoubleValueContext)_localctx).value =  ((DoubleValueContext)_localctx).doubleTerm.value;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedDoubleConstantContext extends ParserRuleContext {
		public double value;
		public Token UNSIGNED_DOUBLE_CONSTANT;
		public TerminalNode UNSIGNED_DOUBLE_CONSTANT() { return getToken(CustomDrawingParserParser.UNSIGNED_DOUBLE_CONSTANT, 0); }
		public UnsignedDoubleConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedDoubleConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).enterUnsignedDoubleConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomDrawingParserListener ) ((CustomDrawingParserListener)listener).exitUnsignedDoubleConstant(this);
		}
	}

	public final UnsignedDoubleConstantContext unsignedDoubleConstant() throws RecognitionException {
		UnsignedDoubleConstantContext _localctx = new UnsignedDoubleConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unsignedDoubleConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			((UnsignedDoubleConstantContext)_localctx).UNSIGNED_DOUBLE_CONSTANT = match(UNSIGNED_DOUBLE_CONSTANT);
			 ((UnsignedDoubleConstantContext)_localctx).value =  Double.parseDouble((((UnsignedDoubleConstantContext)_localctx).UNSIGNED_DOUBLE_CONSTANT!=null?((UnsignedDoubleConstantContext)_localctx).UNSIGNED_DOUBLE_CONSTANT.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u0171\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5"+
		"\2\64\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4j\n\4\f\4\16\4m\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\5\u008c\n\5\f\5\16\5\u008f\13\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6\u00a8\n\6\f\6\16\6\u00ab\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"\u00c7\n\7\f\7\16\7\u00ca\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\7\b\u00e8\n\b\f\b\16\b\u00eb\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00fe\n\t\f\t\16\t\u0101\13\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u010f\n\f\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0121\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\5\21\u012e\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0136\n\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0145"+
		"\n\23\f\23\16\23\u0148\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\7\24\u0157\n\24\f\24\16\24\u015a\13\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\5\25\u016c\n\25\3\26\3\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*\2\2\u018b\2\63\3\2\2\2\4\67\3\2\2\2\6O\3\2\2\2"+
		"\bn\3\2\2\2\n\u0090\3\2\2\2\f\u00ac\3\2\2\2\16\u00cb\3\2\2\2\20\u00ec"+
		"\3\2\2\2\22\u0102\3\2\2\2\24\u0106\3\2\2\2\26\u010e\3\2\2\2\30\u0110\3"+
		"\2\2\2\32\u0120\3\2\2\2\34\u0122\3\2\2\2\36\u0126\3\2\2\2 \u012d\3\2\2"+
		"\2\"\u0135\3\2\2\2$\u0137\3\2\2\2&\u0149\3\2\2\2(\u016b\3\2\2\2*\u016d"+
		"\3\2\2\2,\64\5\4\3\2-\64\5\6\4\2.\64\5\b\5\2/\64\5\n\6\2\60\64\5\f\7\2"+
		"\61\64\5\16\b\2\62\64\5\20\t\2\63,\3\2\2\2\63-\3\2\2\2\63.\3\2\2\2\63"+
		"/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65"+
		"\3\2\2\2\65\66\7\2\2\3\66\3\3\2\2\2\678\7\3\2\289\5$\23\29:\7\4\2\2:;"+
		"\5$\23\2;<\7\4\2\2<=\5$\23\2=>\7\4\2\2>?\5$\23\2?@\7\5\2\2@L\b\3\1\2A"+
		"B\5\22\n\2BC\b\3\1\2CK\3\2\2\2DE\5\30\r\2EF\b\3\1\2FK\3\2\2\2GH\5\34\17"+
		"\2HI\b\3\1\2IK\3\2\2\2JA\3\2\2\2JD\3\2\2\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2"+
		"\2LM\3\2\2\2M\5\3\2\2\2NL\3\2\2\2OP\7\6\2\2PQ\5$\23\2QR\3\2\2\2RS\7\4"+
		"\2\2ST\5$\23\2TU\3\2\2\2UV\7\4\2\2VW\5$\23\2WX\3\2\2\2XY\7\4\2\2YZ\5$"+
		"\23\2Z[\3\2\2\2[\\\7\5\2\2\\k\b\4\1\2]^\5\22\n\2^_\b\4\1\2_j\3\2\2\2`"+
		"a\5\24\13\2ab\b\4\1\2bj\3\2\2\2cd\5\30\r\2de\b\4\1\2ej\3\2\2\2fg\5\34"+
		"\17\2gh\b\4\1\2hj\3\2\2\2i]\3\2\2\2i`\3\2\2\2ic\3\2\2\2if\3\2\2\2jm\3"+
		"\2\2\2ki\3\2\2\2kl\3\2\2\2l\7\3\2\2\2mk\3\2\2\2no\7\7\2\2op\5$\23\2pq"+
		"\3\2\2\2qr\7\4\2\2rs\5$\23\2st\3\2\2\2tu\7\4\2\2uv\5$\23\2vw\3\2\2\2w"+
		"x\7\4\2\2xy\5$\23\2yz\3\2\2\2z{\7\4\2\2{|\5$\23\2|}\3\2\2\2}~\7\5\2\2"+
		"~\u008d\b\5\1\2\177\u0080\5\22\n\2\u0080\u0081\b\5\1\2\u0081\u008c\3\2"+
		"\2\2\u0082\u0083\5\24\13\2\u0083\u0084\b\5\1\2\u0084\u008c\3\2\2\2\u0085"+
		"\u0086\5\30\r\2\u0086\u0087\b\5\1\2\u0087\u008c\3\2\2\2\u0088\u0089\5"+
		"\34\17\2\u0089\u008a\b\5\1\2\u008a\u008c\3\2\2\2\u008b\177\3\2\2\2\u008b"+
		"\u0082\3\2\2\2\u008b\u0085\3\2\2\2\u008b\u0088\3\2\2\2\u008c\u008f\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\t\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u0090\u0091\7\b\2\2\u0091\u0092\5$\23\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\7\4\2\2\u0094\u0095\5$\23\2\u0095\u0096\3\2\2\2\u0096\u0097\7\4"+
		"\2\2\u0097\u0098\5$\23\2\u0098\u0099\3\2\2\2\u0099\u009a\7\5\2\2\u009a"+
		"\u00a9\b\6\1\2\u009b\u009c\5\22\n\2\u009c\u009d\b\6\1\2\u009d\u00a8\3"+
		"\2\2\2\u009e\u009f\5\24\13\2\u009f\u00a0\b\6\1\2\u00a0\u00a8\3\2\2\2\u00a1"+
		"\u00a2\5\30\r\2\u00a2\u00a3\b\6\1\2\u00a3\u00a8\3\2\2\2\u00a4\u00a5\5"+
		"\34\17\2\u00a5\u00a6\b\6\1\2\u00a6\u00a8\3\2\2\2\u00a7\u009b\3\2\2\2\u00a7"+
		"\u009e\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a8\u00ab\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\13\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ad\7\t\2\2\u00ad\u00ae\5$\23\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\7\4\2\2\u00b0\u00b1\5$\23\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\4"+
		"\2\2\u00b3\u00b4\5$\23\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\4\2\2\u00b6"+
		"\u00b7\5$\23\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\5\2\2\u00b9\u00c8\b\7"+
		"\1\2\u00ba\u00bb\5\22\n\2\u00bb\u00bc\b\7\1\2\u00bc\u00c7\3\2\2\2\u00bd"+
		"\u00be\5\24\13\2\u00be\u00bf\b\7\1\2\u00bf\u00c7\3\2\2\2\u00c0\u00c1\5"+
		"\30\r\2\u00c1\u00c2\b\7\1\2\u00c2\u00c7\3\2\2\2\u00c3\u00c4\5\34\17\2"+
		"\u00c4\u00c5\b\7\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00ba\3\2\2\2\u00c6\u00bd"+
		"\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\r\3\2\2\2\u00ca\u00c8\3\2\2\2"+
		"\u00cb\u00cc\7\n\2\2\u00cc\u00cd\5$\23\2\u00cd\u00ce\7\4\2\2\u00ce\u00cf"+
		"\5$\23\2\u00cf\u00d0\7\4\2\2\u00d0\u00d1\5$\23\2\u00d1\u00d2\7\4\2\2\u00d2"+
		"\u00d3\5$\23\2\u00d3\u00d4\7\4\2\2\u00d4\u00d5\5$\23\2\u00d5\u00d6\7\4"+
		"\2\2\u00d6\u00d7\5$\23\2\u00d7\u00d8\7\4\2\2\u00d8\u00d9\5 \21\2\u00d9"+
		"\u00da\7\5\2\2\u00da\u00e9\b\b\1\2\u00db\u00dc\5\22\n\2\u00dc\u00dd\b"+
		"\b\1\2\u00dd\u00e8\3\2\2\2\u00de\u00df\5\24\13\2\u00df\u00e0\b\b\1\2\u00e0"+
		"\u00e8\3\2\2\2\u00e1\u00e2\5\30\r\2\u00e2\u00e3\b\b\1\2\u00e3\u00e8\3"+
		"\2\2\2\u00e4\u00e5\5\34\17\2\u00e5\u00e6\b\b\1\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00db\3\2\2\2\u00e7\u00de\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e4\3\2"+
		"\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\17\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7\13\2\2\u00ed\u00ee\5\36"+
		"\20\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\7\4\2\2\u00f0\u00f1\5$\23\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\7\4\2\2\u00f3\u00f4\5$\23\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f6\7\4\2\2\u00f6\u00f7\5\"\22\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00f9\7\5\2\2\u00f9\u00ff\b\t\1\2\u00fa\u00fb\5\22\n\2\u00fb\u00fc\b"+
		"\t\1\2\u00fc\u00fe\3\2\2\2\u00fd\u00fa\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\21\3\2\2\2\u0101\u00ff\3\2\2"+
		"\2\u0102\u0103\7\f\2\2\u0103\u0104\5\26\f\2\u0104\u0105\b\n\1\2\u0105"+
		"\23\3\2\2\2\u0106\u0107\7\r\2\2\u0107\u0108\5\26\f\2\u0108\u0109\b\13"+
		"\1\2\u0109\25\3\2\2\2\u010a\u010b\7#\2\2\u010b\u010f\b\f\1\2\u010c\u010d"+
		"\7\"\2\2\u010d\u010f\b\f\1\2\u010e\u010a\3\2\2\2\u010e\u010c\3\2\2\2\u010f"+
		"\27\3\2\2\2\u0110\u0111\7\16\2\2\u0111\u0112\5\32\16\2\u0112\u0113\b\r"+
		"\1\2\u0113\31\3\2\2\2\u0114\u0115\7\17\2\2\u0115\u0121\b\16\1\2\u0116"+
		"\u0117\7\20\2\2\u0117\u0121\b\16\1\2\u0118\u0119\7\21\2\2\u0119\u0121"+
		"\b\16\1\2\u011a\u011b\7\22\2\2\u011b\u0121\b\16\1\2\u011c\u011d\7\23\2"+
		"\2\u011d\u0121\b\16\1\2\u011e\u011f\7\24\2\2\u011f\u0121\b\16\1\2\u0120"+
		"\u0114\3\2\2\2\u0120\u0116\3\2\2\2\u0120\u0118\3\2\2\2\u0120\u011a\3\2"+
		"\2\2\u0120\u011c\3\2\2\2\u0120\u011e\3\2\2\2\u0121\33\3\2\2\2\u0122\u0123"+
		"\7\25\2\2\u0123\u0124\5*\26\2\u0124\u0125\b\17\1\2\u0125\35\3\2\2\2\u0126"+
		"\u0127\7%\2\2\u0127\u0128\b\20\1\2\u0128\37\3\2\2\2\u0129\u012a\7\35\2"+
		"\2\u012a\u012e\b\21\1\2\u012b\u012c\7\34\2\2\u012c\u012e\b\21\1\2\u012d"+
		"\u0129\3\2\2\2\u012d\u012b\3\2\2\2\u012e!\3\2\2\2\u012f\u0130\7\36\2\2"+
		"\u0130\u0136\b\22\1\2\u0131\u0132\7 \2\2\u0132\u0136\b\22\1\2\u0133\u0134"+
		"\7\37\2\2\u0134\u0136\b\22\1\2\u0135\u012f\3\2\2\2\u0135\u0131\3\2\2\2"+
		"\u0135\u0133\3\2\2\2\u0136#\3\2\2\2\u0137\u0138\5&\24\2\u0138\u0139\3"+
		"\2\2\2\u0139\u0146\b\23\1\2\u013a\u013b\7\26\2\2\u013b\u013c\5&\24\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013e\b\23\1\2\u013e\u0145\3\2\2\2\u013f\u0140\7"+
		"\17\2\2\u0140\u0141\5&\24\2\u0141\u0142\3\2\2\2\u0142\u0143\b\23\1\2\u0143"+
		"\u0145\3\2\2\2\u0144\u013a\3\2\2\2\u0144\u013f\3\2\2\2\u0145\u0148\3\2"+
		"\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147%\3\2\2\2\u0148\u0146"+
		"\3\2\2\2\u0149\u014a\5(\25\2\u014a\u014b\3\2\2\2\u014b\u0158\b\24\1\2"+
		"\u014c\u014d\7\27\2\2\u014d\u014e\5(\25\2\u014e\u014f\3\2\2\2\u014f\u0150"+
		"\b\24\1\2\u0150\u0157\3\2\2\2\u0151\u0152\7\30\2\2\u0152\u0153\5(\25\2"+
		"\u0153\u0154\3\2\2\2\u0154\u0155\b\24\1\2\u0155\u0157\3\2\2\2\u0156\u014c"+
		"\3\2\2\2\u0156\u0151\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\'\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\7\32\2"+
		"\2\u015c\u016c\b\25\1\2\u015d\u015e\7\33\2\2\u015e\u016c\b\25\1\2\u015f"+
		"\u0160\7\17\2\2\u0160\u0161\5*\26\2\u0161\u0162\b\25\1\2\u0162\u016c\3"+
		"\2\2\2\u0163\u0164\5*\26\2\u0164\u0165\b\25\1\2\u0165\u016c\3\2\2\2\u0166"+
		"\u0167\7\31\2\2\u0167\u0168\5$\23\2\u0168\u0169\7\5\2\2\u0169\u016a\b"+
		"\25\1\2\u016a\u016c\3\2\2\2\u016b\u015b\3\2\2\2\u016b\u015d\3\2\2\2\u016b"+
		"\u015f\3\2\2\2\u016b\u0163\3\2\2\2\u016b\u0166\3\2\2\2\u016c)\3\2\2\2"+
		"\u016d\u016e\7!\2\2\u016e\u016f\b\26\1\2\u016f+\3\2\2\2\31\63JLik\u008b"+
		"\u008d\u00a7\u00a9\u00c6\u00c8\u00e7\u00e9\u00ff\u010e\u0120\u012d\u0135"+
		"\u0144\u0146\u0156\u0158\u016b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}