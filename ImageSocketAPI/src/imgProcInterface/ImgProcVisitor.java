// Generated from ImgProc.g4 by ANTLR 4.1
package imgProcInterface;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ImgProcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ImgProcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ImgProcParser#replace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplace(@NotNull ImgProcParser.ReplaceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ImgProcParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(@NotNull ImgProcParser.FileContext ctx);

	/**
	 * Visit a parse tree produced by {@link ImgProcParser#request}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequest(@NotNull ImgProcParser.RequestContext ctx);

	/**
	 * Visit a parse tree produced by {@link ImgProcParser#perform}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerform(@NotNull ImgProcParser.PerformContext ctx);

	/**
	 * Visit a parse tree produced by {@link ImgProcParser#receive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceive(@NotNull ImgProcParser.ReceiveContext ctx);

	/**
	 * Visit a parse tree produced by {@link ImgProcParser#close}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClose(@NotNull ImgProcParser.CloseContext ctx);
}