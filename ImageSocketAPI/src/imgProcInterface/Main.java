package imgProcInterface;

import imgProcAPI.ImgProcClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			// Creating ImgProcClient
			ImgProcClient ipc;
			// Check for existence of IP/name of the server and image file to be
			// uploaded
			if (args.length < 3) {
				System.out
						.println("Error: Arguments not properly defined!\nPlease enter the server name/IP\nfollowed by a port number\nfollowed by a valid image file address as arguments!");
				return;
			}
			// Passing the server to connect and image file to process
			ipc = new ImgProcClient(args[0], Integer.parseInt(args[1]), new File(args[2]));
			InputStream is = System.in;
			// InputStream is = new
			// FileInputStream("E:\\4th Semester\\CSL-458 Special Topics in Computer Systems\\assn-1\\request_set.txt");
			// Linking the Input Stream(Char Stream) to ANTLRInputStream for
			// tokenizing of the input
			ANTLRInputStream input = new ANTLRInputStream(is);
			// Tokenizing the input using BuildingConfigLexer object
			ImgProcLexer lexer = new ImgProcLexer(input);
			// Creating a buffer of tokens from the lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// Creating a parser that feeds off the token buffer
			ImgProcParser parser = new ImgProcParser(tokens);
			// Beginning the parsing at config rule
			ParseTree tree = parser.file();
			// System.out.println(tree.toStringTree(parser));
			// Creating Request Processor
			RequestProc rp = new RequestProc(ipc);
			// Visiting the tree
			rp.visit(tree);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
