// Generated from /home/rayciel/Programs/Compiler/src/com/Parser/Mx.g4 by ANTLR 4.7
package com.Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, Plus=16, Minus=17, 
		Mul=18, Div=19, Mod=20, Less=21, Greater=22, Equal=23, NotEqual=24, LessEqual=25, 
		GreaterEqual=26, PlusPlus=27, MinusMinus=28, Dot=29, AndAnd=30, OrOr=31, 
		Not=32, And=33, Or=34, Tilde=35, Xor=36, LeftShift=37, RightShift=38, 
		If=39, Else=40, Elseif=41, While=42, For=43, Break=44, Continue=45, Return=46, 
		ConstNull=47, ConstString=48, ConstBool=49, ConstInt=50, Id=51, LineComment=52, 
		WhiteSpace=53, BlockComment=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "Plus", "Minus", 
		"Mul", "Div", "Mod", "Less", "Greater", "Equal", "NotEqual", "LessEqual", 
		"GreaterEqual", "PlusPlus", "MinusMinus", "Dot", "AndAnd", "OrOr", "Not", 
		"And", "Or", "Tilde", "Xor", "LeftShift", "RightShift", "If", "Else", 
		"Elseif", "While", "For", "Break", "Continue", "Return", "Letter", "Digit", 
		"ConstNull", "ConstString", "ConstBool", "ConstInt", "Id", "LineComment", 
		"WhiteSpace", "BlockComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'}'", "'('", "','", "')'", "';'", "'='", "'['", 
		"']'", "'bool'", "'int'", "'string'", "'void'", "'new'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", "'++'", 
		"'--'", "'.'", "'&&'", "'||'", "'!'", "'&'", "'|'", "'~'", "'^'", "'<<'", 
		"'>>'", "'if'", "'else'", "'else if'", "'while'", "'for'", "'break'", 
		"'continue'", "'return'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "Plus", "Minus", "Mul", "Div", "Mod", "Less", 
		"Greater", "Equal", "NotEqual", "LessEqual", "GreaterEqual", "PlusPlus", 
		"MinusMinus", "Dot", "AndAnd", "OrOr", "Not", "And", "Or", "Tilde", "Xor", 
		"LeftShift", "RightShift", "If", "Else", "Elseif", "While", "For", "Break", 
		"Continue", "Return", "ConstNull", "ConstString", "ConstBool", "ConstInt", 
		"Id", "LineComment", "WhiteSpace", "BlockComment"
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u0165\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&"+
		"\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+"+
		"\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3."+
		"\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\61\3\61\7\61\u0111\n\61\f\61\16\61"+
		"\u0114\13\61\3\61\5\61\u0117\n\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\7\63\u0122\n\63\f\63\16\63\u0125\13\63\3\63\3\63\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0132\n\64\3\65\3\65\7\65\u0136"+
		"\n\65\f\65\16\65\u0139\13\65\3\65\5\65\u013c\n\65\3\66\3\66\3\66\7\66"+
		"\u0141\n\66\f\66\16\66\u0144\13\66\3\67\3\67\3\67\3\67\7\67\u014a\n\67"+
		"\f\67\16\67\u014d\13\67\3\67\3\67\38\68\u0152\n8\r8\168\u0153\38\38\3"+
		"9\39\39\39\79\u015c\n9\f9\169\u015f\139\39\39\39\39\39\4\u0123\u015d\2"+
		":\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\2c\61e\62g\63i\64k\65m\66o"+
		"\67q8\3\2\b\5\2C\\aac|\3\2\63;\3\2\62;\5\2$$^^pp\4\2\f\f\17\17\5\2\13"+
		"\f\17\17\"\"\2\u016e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\3s\3\2\2\2\5y\3\2\2\2\7{\3\2\2\2\t}\3\2\2\2\13"+
		"\177\3\2\2\2\r\u0081\3\2\2\2\17\u0083\3\2\2\2\21\u0085\3\2\2\2\23\u0087"+
		"\3\2\2\2\25\u0089\3\2\2\2\27\u008b\3\2\2\2\31\u0090\3\2\2\2\33\u0094\3"+
		"\2\2\2\35\u009b\3\2\2\2\37\u00a0\3\2\2\2!\u00a4\3\2\2\2#\u00a6\3\2\2\2"+
		"%\u00a8\3\2\2\2\'\u00aa\3\2\2\2)\u00ac\3\2\2\2+\u00ae\3\2\2\2-\u00b0\3"+
		"\2\2\2/\u00b2\3\2\2\2\61\u00b5\3\2\2\2\63\u00b8\3\2\2\2\65\u00bb\3\2\2"+
		"\2\67\u00be\3\2\2\29\u00c1\3\2\2\2;\u00c4\3\2\2\2=\u00c6\3\2\2\2?\u00c9"+
		"\3\2\2\2A\u00cc\3\2\2\2C\u00ce\3\2\2\2E\u00d0\3\2\2\2G\u00d2\3\2\2\2I"+
		"\u00d4\3\2\2\2K\u00d6\3\2\2\2M\u00d9\3\2\2\2O\u00dc\3\2\2\2Q\u00df\3\2"+
		"\2\2S\u00e4\3\2\2\2U\u00ec\3\2\2\2W\u00f2\3\2\2\2Y\u00f6\3\2\2\2[\u00fc"+
		"\3\2\2\2]\u0105\3\2\2\2_\u010c\3\2\2\2a\u0116\3\2\2\2c\u0118\3\2\2\2e"+
		"\u011d\3\2\2\2g\u0131\3\2\2\2i\u013b\3\2\2\2k\u013d\3\2\2\2m\u0145\3\2"+
		"\2\2o\u0151\3\2\2\2q\u0157\3\2\2\2st\7e\2\2tu\7n\2\2uv\7c\2\2vw\7u\2\2"+
		"wx\7u\2\2x\4\3\2\2\2yz\7}\2\2z\6\3\2\2\2{|\7\177\2\2|\b\3\2\2\2}~\7*\2"+
		"\2~\n\3\2\2\2\177\u0080\7.\2\2\u0080\f\3\2\2\2\u0081\u0082\7+\2\2\u0082"+
		"\16\3\2\2\2\u0083\u0084\7=\2\2\u0084\20\3\2\2\2\u0085\u0086\7?\2\2\u0086"+
		"\22\3\2\2\2\u0087\u0088\7]\2\2\u0088\24\3\2\2\2\u0089\u008a\7_\2\2\u008a"+
		"\26\3\2\2\2\u008b\u008c\7d\2\2\u008c\u008d\7q\2\2\u008d\u008e\7q\2\2\u008e"+
		"\u008f\7n\2\2\u008f\30\3\2\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092"+
		"\u0093\7v\2\2\u0093\32\3\2\2\2\u0094\u0095\7u\2\2\u0095\u0096\7v\2\2\u0096"+
		"\u0097\7t\2\2\u0097\u0098\7k\2\2\u0098\u0099\7p\2\2\u0099\u009a\7i\2\2"+
		"\u009a\34\3\2\2\2\u009b\u009c\7x\2\2\u009c\u009d\7q\2\2\u009d\u009e\7"+
		"k\2\2\u009e\u009f\7f\2\2\u009f\36\3\2\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2"+
		"\7g\2\2\u00a2\u00a3\7y\2\2\u00a3 \3\2\2\2\u00a4\u00a5\7-\2\2\u00a5\"\3"+
		"\2\2\2\u00a6\u00a7\7/\2\2\u00a7$\3\2\2\2\u00a8\u00a9\7,\2\2\u00a9&\3\2"+
		"\2\2\u00aa\u00ab\7\61\2\2\u00ab(\3\2\2\2\u00ac\u00ad\7\'\2\2\u00ad*\3"+
		"\2\2\2\u00ae\u00af\7>\2\2\u00af,\3\2\2\2\u00b0\u00b1\7@\2\2\u00b1.\3\2"+
		"\2\2\u00b2\u00b3\7?\2\2\u00b3\u00b4\7?\2\2\u00b4\60\3\2\2\2\u00b5\u00b6"+
		"\7#\2\2\u00b6\u00b7\7?\2\2\u00b7\62\3\2\2\2\u00b8\u00b9\7>\2\2\u00b9\u00ba"+
		"\7?\2\2\u00ba\64\3\2\2\2\u00bb\u00bc\7@\2\2\u00bc\u00bd\7?\2\2\u00bd\66"+
		"\3\2\2\2\u00be\u00bf\7-\2\2\u00bf\u00c0\7-\2\2\u00c08\3\2\2\2\u00c1\u00c2"+
		"\7/\2\2\u00c2\u00c3\7/\2\2\u00c3:\3\2\2\2\u00c4\u00c5\7\60\2\2\u00c5<"+
		"\3\2\2\2\u00c6\u00c7\7(\2\2\u00c7\u00c8\7(\2\2\u00c8>\3\2\2\2\u00c9\u00ca"+
		"\7~\2\2\u00ca\u00cb\7~\2\2\u00cb@\3\2\2\2\u00cc\u00cd\7#\2\2\u00cdB\3"+
		"\2\2\2\u00ce\u00cf\7(\2\2\u00cfD\3\2\2\2\u00d0\u00d1\7~\2\2\u00d1F\3\2"+
		"\2\2\u00d2\u00d3\7\u0080\2\2\u00d3H\3\2\2\2\u00d4\u00d5\7`\2\2\u00d5J"+
		"\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8\7>\2\2\u00d8L\3\2\2\2\u00d9\u00da"+
		"\7@\2\2\u00da\u00db\7@\2\2\u00dbN\3\2\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de"+
		"\7h\2\2\u00deP\3\2\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2"+
		"\7u\2\2\u00e2\u00e3\7g\2\2\u00e3R\3\2\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6"+
		"\7n\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7\"\2\2\u00e9"+
		"\u00ea\7k\2\2\u00ea\u00eb\7h\2\2\u00ebT\3\2\2\2\u00ec\u00ed\7y\2\2\u00ed"+
		"\u00ee\7j\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7g\2\2"+
		"\u00f1V\3\2\2\2\u00f2\u00f3\7h\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7t\2"+
		"\2\u00f5X\3\2\2\2\u00f6\u00f7\7d\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7"+
		"g\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7m\2\2\u00fbZ\3\2\2\2\u00fc\u00fd"+
		"\7e\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7v\2\2\u0100"+
		"\u0101\7k\2\2\u0101\u0102\7p\2\2\u0102\u0103\7w\2\2\u0103\u0104\7g\2\2"+
		"\u0104\\\3\2\2\2\u0105\u0106\7t\2\2\u0106\u0107\7g\2\2\u0107\u0108\7v"+
		"\2\2\u0108\u0109\7w\2\2\u0109\u010a\7t\2\2\u010a\u010b\7p\2\2\u010b^\3"+
		"\2\2\2\u010c\u010d\t\2\2\2\u010d`\3\2\2\2\u010e\u0112\t\3\2\2\u010f\u0111"+
		"\t\4\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0117\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\7\62"+
		"\2\2\u0116\u010e\3\2\2\2\u0116\u0115\3\2\2\2\u0117b\3\2\2\2\u0118\u0119"+
		"\7p\2\2\u0119\u011a\7w\2\2\u011a\u011b\7n\2\2\u011b\u011c\7n\2\2\u011c"+
		"d\3\2\2\2\u011d\u0123\7$\2\2\u011e\u011f\7^\2\2\u011f\u0122\t\5\2\2\u0120"+
		"\u0122\13\2\2\2\u0121\u011e\3\2\2\2\u0121\u0120\3\2\2\2\u0122\u0125\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0127\7$\2\2\u0127f\3\2\2\2\u0128\u0129\7v\2\2\u0129"+
		"\u012a\7t\2\2\u012a\u012b\7w\2\2\u012b\u0132\7g\2\2\u012c\u012d\7h\2\2"+
		"\u012d\u012e\7c\2\2\u012e\u012f\7n\2\2\u012f\u0130\7u\2\2\u0130\u0132"+
		"\7g\2\2\u0131\u0128\3\2\2\2\u0131\u012c\3\2\2\2\u0132h\3\2\2\2\u0133\u0137"+
		"\t\3\2\2\u0134\u0136\t\4\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013c\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u013a\u013c\7\62\2\2\u013b\u0133\3\2\2\2\u013b\u013a\3\2\2\2\u013c"+
		"j\3\2\2\2\u013d\u0142\5_\60\2\u013e\u0141\5_\60\2\u013f\u0141\5a\61\2"+
		"\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0143l\3\2\2\2\u0144\u0142\3\2\2\2\u0145"+
		"\u0146\7\61\2\2\u0146\u0147\7\61\2\2\u0147\u014b\3\2\2\2\u0148\u014a\n"+
		"\6\2\2\u0149\u0148\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\b\67"+
		"\2\2\u014fn\3\2\2\2\u0150\u0152\t\7\2\2\u0151\u0150\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0156\b8\2\2\u0156p\3\2\2\2\u0157\u0158\7\61\2\2\u0158\u0159\7,\2\2\u0159"+
		"\u015d\3\2\2\2\u015a\u015c\13\2\2\2\u015b\u015a\3\2\2\2\u015c\u015f\3"+
		"\2\2\2\u015d\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0160\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u0160\u0161\7,\2\2\u0161\u0162\7\61\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0164\b9\2\2\u0164r\3\2\2\2\17\2\u0112\u0116\u0121\u0123\u0131"+
		"\u0137\u013b\u0140\u0142\u014b\u0153\u015d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}