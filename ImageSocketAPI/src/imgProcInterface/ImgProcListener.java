// Generated from ImgProc.g4 by ANTLR 4.1
package imgProcInterface;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImgProcParser}.
 */
public interface ImgProcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImgProcParser#replace}.
	 * @param ctx the parse tree
	 */
	void enterReplace(@NotNull ImgProcParser.ReplaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImgProcParser#replace}.
	 * @param ctx the parse tree
	 */
	void exitReplace(@NotNull ImgProcParser.ReplaceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImgProcParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull ImgProcParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImgProcParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull ImgProcParser.FileContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImgProcParser#request}.
	 * @param ctx the parse tree
	 */
	void enterRequest(@NotNull ImgProcParser.RequestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImgProcParser#request}.
	 * @param ctx the parse tree
	 */
	void exitRequest(@NotNull ImgProcParser.RequestContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImgProcParser#perform}.
	 * @param ctx the parse tree
	 */
	void enterPerform(@NotNull ImgProcParser.PerformContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImgProcParser#perform}.
	 * @param ctx the parse tree
	 */
	void exitPerform(@NotNull ImgProcParser.PerformContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImgProcParser#receive}.
	 * @param ctx the parse tree
	 */
	void enterReceive(@NotNull ImgProcParser.ReceiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImgProcParser#receive}.
	 * @param ctx the parse tree
	 */
	void exitReceive(@NotNull ImgProcParser.ReceiveContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImgProcParser#close}.
	 * @param ctx the parse tree
	 */
	void enterClose(@NotNull ImgProcParser.CloseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImgProcParser#close}.
	 * @param ctx the parse tree
	 */
	void exitClose(@NotNull ImgProcParser.CloseContext ctx);
}