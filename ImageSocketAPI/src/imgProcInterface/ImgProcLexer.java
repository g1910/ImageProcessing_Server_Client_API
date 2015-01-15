// Generated from ImgProc.g4 by ANTLR 4.1
package imgProcInterface;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImgProcLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PERFORM=2, RECEIVE=3, REPLACE=4, CLOSE=5, OPERATION=6, FILENAME=7, 
		WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"';'", "'PERFORM'", "'RECEIVE'", "'REPLACE'", "'CLOSE'", "OPERATION", 
		"FILENAME", "WS"
	};
	public static final String[] ruleNames = {
		"T__0", "PERFORM", "RECEIVE", "REPLACE", "CLOSE", "OPERATION", "FILENAME", 
		"WS"
	};


	public ImgProcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ImgProc.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 7: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\n\u0086\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7u\n\7\3\b\3\b\7\by\n\b\f\b\16\b|\13\b\3"+
		"\b\3\b\3\t\6\t\u0081\n\t\r\t\16\t\u0082\3\t\3\t\3z\n\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\2\3\2\3\5\2\13\f\17\17\"\"\u008d\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\25\3\2\2\2\7\35\3\2\2\2\t%\3\2"+
		"\2\2\13-\3\2\2\2\rt\3\2\2\2\17v\3\2\2\2\21\u0080\3\2\2\2\23\24\7=\2\2"+
		"\24\4\3\2\2\2\25\26\7R\2\2\26\27\7G\2\2\27\30\7T\2\2\30\31\7H\2\2\31\32"+
		"\7Q\2\2\32\33\7T\2\2\33\34\7O\2\2\34\6\3\2\2\2\35\36\7T\2\2\36\37\7G\2"+
		"\2\37 \7E\2\2 !\7G\2\2!\"\7K\2\2\"#\7X\2\2#$\7G\2\2$\b\3\2\2\2%&\7T\2"+
		"\2&\'\7G\2\2\'(\7R\2\2()\7N\2\2)*\7C\2\2*+\7E\2\2+,\7G\2\2,\n\3\2\2\2"+
		"-.\7E\2\2./\7N\2\2/\60\7Q\2\2\60\61\7U\2\2\61\62\7G\2\2\62\f\3\2\2\2\63"+
		"\64\7I\2\2\64\65\7C\2\2\65\66\7W\2\2\66\67\7U\2\2\678\7U\2\289\7K\2\2"+
		"9:\7C\2\2:;\7P\2\2;<\7a\2\2<=\7D\2\2=>\7N\2\2>?\7W\2\2?u\7T\2\2@A\7U\2"+
		"\2AB\7E\2\2BC\7C\2\2CD\7N\2\2DE\7G\2\2EF\7a\2\2FG\7W\2\2Gu\7R\2\2HI\7"+
		"U\2\2IJ\7E\2\2JK\7C\2\2KL\7N\2\2LM\7G\2\2MN\7a\2\2NO\7F\2\2OP\7Q\2\2P"+
		"Q\7Y\2\2Qu\7P\2\2RS\7D\2\2ST\7T\2\2TU\7K\2\2UV\7I\2\2VW\7J\2\2WX\7V\2"+
		"\2XY\7P\2\2YZ\7G\2\2Zu\7P\2\2[\\\7F\2\2\\]\7C\2\2]^\7T\2\2^_\7M\2\2_`"+
		"\7G\2\2`u\7P\2\2ab\7U\2\2bc\7J\2\2cd\7C\2\2de\7T\2\2ef\7R\2\2fg\7G\2\2"+
		"gu\7P\2\2hi\7K\2\2ij\7P\2\2jk\7X\2\2kl\7G\2\2lm\7T\2\2mn\7V\2\2no\7a\2"+
		"\2op\7E\2\2pq\7Q\2\2qr\7N\2\2rs\7Q\2\2su\7T\2\2t\63\3\2\2\2t@\3\2\2\2"+
		"tH\3\2\2\2tR\3\2\2\2t[\3\2\2\2ta\3\2\2\2th\3\2\2\2u\16\3\2\2\2vz\7$\2"+
		"\2wy\13\2\2\2xw\3\2\2\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3\2"+
		"\2\2}~\7$\2\2~\20\3\2\2\2\177\u0081\t\2\2\2\u0080\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\b\t\2\2\u0085\22\3\2\2\2\6\2tz\u0082";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}