// Generated from CustomDrawingParser.g4 by ANTLR 4.5

	package com.baselet.element.facet.common.CustomDrawingParser;

	import com.baselet.control.enums.AlignHorizontal;
	import com.baselet.control.enums.LineType;
	import com.baselet.diagram.draw.DrawHandler;
	import com.baselet.diagram.draw.helper.ColorOwn;
	import com.baselet.diagram.draw.helper.ColorOwn.Transparency;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CustomDrawingParserLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "A", "B", "C", "D", 
		"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
		"S", "T", "U", "V", "W", "X", "Y", "Z", "WIDTH", "HEIGHT", "TRUE", "FALSE", 
		"LEFT", "RIGHT", "CENTER", "DIGIT", "HEX_DIGIT", "UNSIGNED_DOUBLE_CONSTANT", 
		"COLOR_OWN_HEX", "COLOR_OWN_NAME", "WS", "SIMPLE_STRING", "COMMENT", "ILLEGAL"
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


	public CustomDrawingParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CustomDrawingParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u01aa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3;\3"+
		";\5;\u016b\n;\3<\6<\u016e\n<\r<\16<\u016f\3<\3<\6<\u0174\n<\r<\16<\u0175"+
		"\5<\u0178\n<\3=\3=\3=\3=\3=\3=\3=\3=\3>\6>\u0183\n>\r>\16>\u0184\3?\6"+
		"?\u0188\n?\r?\16?\u0189\3?\3?\3@\3@\3@\3@\7@\u0192\n@\f@\16@\u0195\13"+
		"@\3@\3@\3A\3A\3A\3A\7A\u019d\nA\fA\16A\u01a0\13A\3A\3A\3A\5A\u01a5\nA"+
		"\3A\3A\3B\3B\2\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2"+
		"\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c"+
		"\2e\32g\33i\34k\35m\36o\37q s\2u\2w!y\"{#}$\177%\u0081&\u0083\'\3\2#\4"+
		"\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKk"+
		"k\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2"+
		"TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\|"+
		"|\3\2\62;\4\2CHch\4\2C\\c|\5\2\13\f\17\17\"\"\6\2\f\f\17\17$$^^\4\2$$"+
		"^^\4\2\f\f\17\17\u0198\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3"+
		"\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\3\u0085\3\2\2\2\5"+
		"\u008f\3\2\2\2\7\u0091\3\2\2\2\t\u0093\3\2\2\2\13\u00a2\3\2\2\2\r\u00b6"+
		"\3\2\2\2\17\u00c2\3\2\2\2\21\u00cf\3\2\2\2\23\u00d8\3\2\2\2\25\u00e2\3"+
		"\2\2\2\27\u00e6\3\2\2\2\31\u00ea\3\2\2\2\33\u00ee\3\2\2\2\35\u00f0\3\2"+
		"\2\2\37\u00f2\3\2\2\2!\u00f5\3\2\2\2#\u00f7\3\2\2\2%\u00f9\3\2\2\2\'\u00fc"+
		"\3\2\2\2)\u0100\3\2\2\2+\u0102\3\2\2\2-\u0104\3\2\2\2/\u0106\3\2\2\2\61"+
		"\u0108\3\2\2\2\63\u010a\3\2\2\2\65\u010c\3\2\2\2\67\u010e\3\2\2\29\u0110"+
		"\3\2\2\2;\u0112\3\2\2\2=\u0114\3\2\2\2?\u0116\3\2\2\2A\u0118\3\2\2\2C"+
		"\u011a\3\2\2\2E\u011c\3\2\2\2G\u011e\3\2\2\2I\u0120\3\2\2\2K\u0122\3\2"+
		"\2\2M\u0124\3\2\2\2O\u0126\3\2\2\2Q\u0128\3\2\2\2S\u012a\3\2\2\2U\u012c"+
		"\3\2\2\2W\u012e\3\2\2\2Y\u0130\3\2\2\2[\u0132\3\2\2\2]\u0134\3\2\2\2_"+
		"\u0136\3\2\2\2a\u0138\3\2\2\2c\u013a\3\2\2\2e\u013c\3\2\2\2g\u0142\3\2"+
		"\2\2i\u0149\3\2\2\2k\u014e\3\2\2\2m\u0154\3\2\2\2o\u0159\3\2\2\2q\u015f"+
		"\3\2\2\2s\u0166\3\2\2\2u\u016a\3\2\2\2w\u016d\3\2\2\2y\u0179\3\2\2\2{"+
		"\u0182\3\2\2\2}\u0187\3\2\2\2\177\u018d\3\2\2\2\u0081\u0198\3\2\2\2\u0083"+
		"\u01a8\3\2\2\2\u0085\u0086\7f\2\2\u0086\u0087\7t\2\2\u0087\u0088\7c\2"+
		"\2\u0088\u0089\7y\2\2\u0089\u008a\7N\2\2\u008a\u008b\7k\2\2\u008b\u008c"+
		"\7p\2\2\u008c\u008d\7g\2\2\u008d\u008e\7*\2\2\u008e\4\3\2\2\2\u008f\u0090"+
		"\7.\2\2\u0090\6\3\2\2\2\u0091\u0092\7+\2\2\u0092\b\3\2\2\2\u0093\u0094"+
		"\7f\2\2\u0094\u0095\7t\2\2\u0095\u0096\7c\2\2\u0096\u0097\7y\2\2\u0097"+
		"\u0098\7T\2\2\u0098\u0099\7g\2\2\u0099\u009a\7e\2\2\u009a\u009b\7v\2\2"+
		"\u009b\u009c\7c\2\2\u009c\u009d\7p\2\2\u009d\u009e\7i\2\2\u009e\u009f"+
		"\7n\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7*\2\2\u00a1\n\3\2\2\2\u00a2\u00a3"+
		"\7f\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7y\2\2\u00a6"+
		"\u00a7\7T\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7e\2\2\u00a9\u00aa\7v\2\2"+
		"\u00aa\u00ab\7c\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7i\2\2\u00ad\u00ae"+
		"\7n\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7T\2\2\u00b0\u00b1\7q\2\2\u00b1"+
		"\u00b2\7w\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7f\2\2\u00b4\u00b5\7*\2\2"+
		"\u00b5\f\3\2\2\2\u00b6\u00b7\7f\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7c"+
		"\2\2\u00b9\u00ba\7y\2\2\u00ba\u00bb\7E\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd"+
		"\7t\2\2\u00bd\u00be\7e\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"\u00c1\7*\2\2\u00c1\16\3\2\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7t\2\2\u00c4"+
		"\u00c5\7c\2\2\u00c5\u00c6\7y\2\2\u00c6\u00c7\7G\2\2\u00c7\u00c8\7n\2\2"+
		"\u00c8\u00c9\7n\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc"+
		"\7u\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7*\2\2\u00ce\20\3\2\2\2\u00cf\u00d0"+
		"\7f\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7y\2\2\u00d3"+
		"\u00d4\7C\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7*\2\2"+
		"\u00d7\22\3\2\2\2\u00d8\u00d9\7f\2\2\u00d9\u00da\7t\2\2\u00da\u00db\7"+
		"c\2\2\u00db\u00dc\7y\2\2\u00dc\u00dd\7V\2\2\u00dd\u00de\7g\2\2\u00de\u00df"+
		"\7z\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7*\2\2\u00e1\24\3\2\2\2\u00e2\u00e3"+
		"\7h\2\2\u00e3\u00e4\7i\2\2\u00e4\u00e5\7?\2\2\u00e5\26\3\2\2\2\u00e6\u00e7"+
		"\7d\2\2\u00e7\u00e8\7i\2\2\u00e8\u00e9\7?\2\2\u00e9\30\3\2\2\2\u00ea\u00eb"+
		"\7n\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7?\2\2\u00ed\32\3\2\2\2\u00ee\u00ef"+
		"\7/\2\2\u00ef\34\3\2\2\2\u00f0\u00f1\7\60\2\2\u00f1\36\3\2\2\2\u00f2\u00f3"+
		"\7\60\2\2\u00f3\u00f4\7\60\2\2\u00f4 \3\2\2\2\u00f5\u00f6\7?\2\2\u00f6"+
		"\"\3\2\2\2\u00f7\u00f8\7<\2\2\u00f8$\3\2\2\2\u00f9\u00fa\7<\2\2\u00fa"+
		"\u00fb\7<\2\2\u00fb&\3\2\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7y\2\2\u00fe"+
		"\u00ff\7?\2\2\u00ff(\3\2\2\2\u0100\u0101\7-\2\2\u0101*\3\2\2\2\u0102\u0103"+
		"\7,\2\2\u0103,\3\2\2\2\u0104\u0105\7\61\2\2\u0105.\3\2\2\2\u0106\u0107"+
		"\7*\2\2\u0107\60\3\2\2\2\u0108\u0109\t\2\2\2\u0109\62\3\2\2\2\u010a\u010b"+
		"\t\3\2\2\u010b\64\3\2\2\2\u010c\u010d\t\4\2\2\u010d\66\3\2\2\2\u010e\u010f"+
		"\t\5\2\2\u010f8\3\2\2\2\u0110\u0111\t\6\2\2\u0111:\3\2\2\2\u0112\u0113"+
		"\t\7\2\2\u0113<\3\2\2\2\u0114\u0115\t\b\2\2\u0115>\3\2\2\2\u0116\u0117"+
		"\t\t\2\2\u0117@\3\2\2\2\u0118\u0119\t\n\2\2\u0119B\3\2\2\2\u011a\u011b"+
		"\t\13\2\2\u011bD\3\2\2\2\u011c\u011d\t\f\2\2\u011dF\3\2\2\2\u011e\u011f"+
		"\t\r\2\2\u011fH\3\2\2\2\u0120\u0121\t\16\2\2\u0121J\3\2\2\2\u0122\u0123"+
		"\t\17\2\2\u0123L\3\2\2\2\u0124\u0125\t\20\2\2\u0125N\3\2\2\2\u0126\u0127"+
		"\t\21\2\2\u0127P\3\2\2\2\u0128\u0129\t\22\2\2\u0129R\3\2\2\2\u012a\u012b"+
		"\t\23\2\2\u012bT\3\2\2\2\u012c\u012d\t\24\2\2\u012dV\3\2\2\2\u012e\u012f"+
		"\t\25\2\2\u012fX\3\2\2\2\u0130\u0131\t\26\2\2\u0131Z\3\2\2\2\u0132\u0133"+
		"\t\27\2\2\u0133\\\3\2\2\2\u0134\u0135\t\30\2\2\u0135^\3\2\2\2\u0136\u0137"+
		"\t\31\2\2\u0137`\3\2\2\2\u0138\u0139\t\32\2\2\u0139b\3\2\2\2\u013a\u013b"+
		"\t\33\2\2\u013bd\3\2\2\2\u013c\u013d\5]/\2\u013d\u013e\5A!\2\u013e\u013f"+
		"\5\67\34\2\u013f\u0140\5W,\2\u0140\u0141\5? \2\u0141f\3\2\2\2\u0142\u0143"+
		"\5? \2\u0143\u0144\59\35\2\u0144\u0145\5A!\2\u0145\u0146\5=\37\2\u0146"+
		"\u0147\5? \2\u0147\u0148\5W,\2\u0148h\3\2\2\2\u0149\u014a\5W,\2\u014a"+
		"\u014b\5S*\2\u014b\u014c\5Y-\2\u014c\u014d\59\35\2\u014dj\3\2\2\2\u014e"+
		"\u014f\5;\36\2\u014f\u0150\5\61\31\2\u0150\u0151\5G$\2\u0151\u0152\5U"+
		"+\2\u0152\u0153\59\35\2\u0153l\3\2\2\2\u0154\u0155\5G$\2\u0155\u0156\5"+
		"9\35\2\u0156\u0157\5;\36\2\u0157\u0158\5W,\2\u0158n\3\2\2\2\u0159\u015a"+
		"\5S*\2\u015a\u015b\5A!\2\u015b\u015c\5=\37\2\u015c\u015d\5? \2\u015d\u015e"+
		"\5W,\2\u015ep\3\2\2\2\u015f\u0160\5\65\33\2\u0160\u0161\59\35\2\u0161"+
		"\u0162\5K&\2\u0162\u0163\5W,\2\u0163\u0164\59\35\2\u0164\u0165\5S*\2\u0165"+
		"r\3\2\2\2\u0166\u0167\t\34\2\2\u0167t\3\2\2\2\u0168\u016b\5s:\2\u0169"+
		"\u016b\t\35\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016bv\3\2\2\2"+
		"\u016c\u016e\5s:\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u016d"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0177\3\2\2\2\u0171\u0173\7\60\2\2"+
		"\u0172\u0174\5s:\2\u0173\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0173"+
		"\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0171\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178x\3\2\2\2\u0179\u017a\7%\2\2\u017a\u017b\5u;\2\u017b"+
		"\u017c\5u;\2\u017c\u017d\5u;\2\u017d\u017e\5u;\2\u017e\u017f\5u;\2\u017f"+
		"\u0180\5u;\2\u0180z\3\2\2\2\u0181\u0183\t\36\2\2\u0182\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185|\3\2\2\2"+
		"\u0186\u0188\t\37\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0187"+
		"\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\b?\2\2\u018c"+
		"~\3\2\2\2\u018d\u0193\7$\2\2\u018e\u0192\n \2\2\u018f\u0190\7^\2\2\u0190"+
		"\u0192\t!\2\2\u0191\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0195\3\2"+
		"\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0196\3\2\2\2\u0195"+
		"\u0193\3\2\2\2\u0196\u0197\7$\2\2\u0197\u0080\3\2\2\2\u0198\u0199\7\61"+
		"\2\2\u0199\u019a\7\61\2\2\u019a\u019e\3\2\2\2\u019b\u019d\n\"\2\2\u019c"+
		"\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2"+
		"\2\2\u019f\u01a4\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a5\t\"\2\2\u01a2"+
		"\u01a3\7\17\2\2\u01a3\u01a5\7\f\2\2\u01a4\u01a1\3\2\2\2\u01a4\u01a2\3"+
		"\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\bA\2\2\u01a7"+
		"\u0082\3\2\2\2\u01a8\u01a9\13\2\2\2\u01a9\u0084\3\2\2\2\r\2\u016a\u016f"+
		"\u0175\u0177\u0184\u0189\u0191\u0193\u019e\u01a4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}