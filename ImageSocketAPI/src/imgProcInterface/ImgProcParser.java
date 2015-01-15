// Generated from ImgProc.g4 by ANTLR 4.1
package imgProcInterface;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImgProcParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PERFORM=2, RECEIVE=3, REPLACE=4, CLOSE=5, OPERATION=6, FILENAME=7, 
		WS=8;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "'PERFORM'", "'RECEIVE'", "'REPLACE'", "'CLOSE'", 
		"OPERATION", "FILENAME", "WS"
	};
	public static final int
		RULE_file = 0, RULE_request = 1, RULE_perform = 2, RULE_receive = 3, RULE_replace = 4, 
		RULE_close = 5;
	public static final String[] ruleNames = {
		"file", "request", "perform", "receive", "replace", "close"
	};

	@Override
	public String getGrammarFileName() { return "ImgProc.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImgProcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public List<RequestContext> request() {
			return getRuleContexts(RequestContext.class);
		}
		public RequestContext request(int i) {
			return getRuleContext(RequestContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImgProcVisitor ) return ((ImgProcVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); request();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PERFORM) | (1L << RECEIVE) | (1L << REPLACE) | (1L << CLOSE))) != 0) );
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

	public static class RequestContext extends ParserRuleContext {
		public PerformContext perform() {
			return getRuleContext(PerformContext.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public ReplaceContext replace() {
			return getRuleContext(ReplaceContext.class,0);
		}
		public ReceiveContext receive() {
			return getRuleContext(ReceiveContext.class,0);
		}
		public RequestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_request; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).enterRequest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).exitRequest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImgProcVisitor ) return ((ImgProcVisitor<? extends T>)visitor).visitRequest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequestContext request() throws RecognitionException {
		RequestContext _localctx = new RequestContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_request);
		try {
			setState(29);
			switch (_input.LA(1)) {
			case PERFORM:
				enterOuterAlt(_localctx, 1);
				{
				setState(17); perform();
				setState(18); match(1);
				}
				break;
			case RECEIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(20); receive();
				setState(21); match(1);
				}
				break;
			case REPLACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(23); replace();
				setState(24); match(1);
				}
				break;
			case CLOSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(26); close();
				setState(27); match(1);
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

	public static class PerformContext extends ParserRuleContext {
		public TerminalNode OPERATION() { return getToken(ImgProcParser.OPERATION, 0); }
		public TerminalNode PERFORM() { return getToken(ImgProcParser.PERFORM, 0); }
		public PerformContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perform; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).enterPerform(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).exitPerform(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImgProcVisitor ) return ((ImgProcVisitor<? extends T>)visitor).visitPerform(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerformContext perform() throws RecognitionException {
		PerformContext _localctx = new PerformContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_perform);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(PERFORM);
			setState(32); match(OPERATION);
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

	public static class ReceiveContext extends ParserRuleContext {
		public TerminalNode RECEIVE() { return getToken(ImgProcParser.RECEIVE, 0); }
		public TerminalNode FILENAME() { return getToken(ImgProcParser.FILENAME, 0); }
		public ReceiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).enterReceive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).exitReceive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImgProcVisitor ) return ((ImgProcVisitor<? extends T>)visitor).visitReceive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiveContext receive() throws RecognitionException {
		ReceiveContext _localctx = new ReceiveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_receive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); match(RECEIVE);
			setState(35); match(FILENAME);
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

	public static class ReplaceContext extends ParserRuleContext {
		public TerminalNode REPLACE() { return getToken(ImgProcParser.REPLACE, 0); }
		public TerminalNode FILENAME() { return getToken(ImgProcParser.FILENAME, 0); }
		public ReplaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_replace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).enterReplace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).exitReplace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImgProcVisitor ) return ((ImgProcVisitor<? extends T>)visitor).visitReplace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReplaceContext replace() throws RecognitionException {
		ReplaceContext _localctx = new ReplaceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_replace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(REPLACE);
			setState(38); match(FILENAME);
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

	public static class CloseContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(ImgProcParser.CLOSE, 0); }
		public CloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_close; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).enterClose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImgProcListener ) ((ImgProcListener)listener).exitClose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ImgProcVisitor ) return ((ImgProcVisitor<? extends T>)visitor).visitClose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CloseContext close() throws RecognitionException {
		CloseContext _localctx = new CloseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_close);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(CLOSE);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\n-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\7\3\7\3\7\2\b\2\4\6\b\n\f\2\2*\2\17\3\2\2\2\4\37\3"+
		"\2\2\2\6!\3\2\2\2\b$\3\2\2\2\n\'\3\2\2\2\f*\3\2\2\2\16\20\5\4\3\2\17\16"+
		"\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24"+
		"\5\6\4\2\24\25\7\3\2\2\25 \3\2\2\2\26\27\5\b\5\2\27\30\7\3\2\2\30 \3\2"+
		"\2\2\31\32\5\n\6\2\32\33\7\3\2\2\33 \3\2\2\2\34\35\5\f\7\2\35\36\7\3\2"+
		"\2\36 \3\2\2\2\37\23\3\2\2\2\37\26\3\2\2\2\37\31\3\2\2\2\37\34\3\2\2\2"+
		" \5\3\2\2\2!\"\7\4\2\2\"#\7\b\2\2#\7\3\2\2\2$%\7\5\2\2%&\7\t\2\2&\t\3"+
		"\2\2\2\'(\7\6\2\2()\7\t\2\2)\13\3\2\2\2*+\7\7\2\2+\r\3\2\2\2\4\21\37";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}