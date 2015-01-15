package imgProcInterface;

import java.io.File;

import imgProcAPI.ImgProcClient;
import imgProcInterface.ImgProcParser.CloseContext;
import imgProcInterface.ImgProcParser.PerformContext;
import imgProcInterface.ImgProcParser.ReceiveContext;
import imgProcInterface.ImgProcParser.ReplaceContext;
/*
 * RequestProc contains functionality for the visitor functions
 * to parse and perform the requests
 */
public class RequestProc extends ImgProcBaseVisitor<String>{
	
	//Defining the ImgProcClient
	ImgProcClient ipc;
	public RequestProc(ImgProcClient i){
		ipc=i;
	}
	@Override
	//Performing the REPLACE Request
	public String visitReplace(ReplaceContext ctx) {
		// TODO Auto-generated method stub
		String file = ctx.FILENAME().getText();
		file = file.substring(1, file.length()-1);
		try {
			ipc.replace(new File(file));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return super.visitReplace(ctx);
	}
	@Override
	//Performing the PERFORM Request
	public String visitPerform(PerformContext ctx) {
		// TODO Auto-generated method stub
		ipc.perform(ctx.OPERATION().getText());
		return super.visitPerform(ctx);
	}
	@Override
	//Performing the RECEIVE Request
	public String visitReceive(ReceiveContext ctx) {
		// TODO Auto-generated method stub
		String file = ctx.FILENAME().getText();
		file = file.substring(1, file.length()-1);
		try {
			ipc.saveProcImageAs(file);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return super.visitReceive(ctx);
	}
	@Override
	//Performing the CLOSE Request
	public String visitClose(CloseContext ctx) {
		// TODO Auto-generated method stub
		ipc.close();
		return super.visitClose(ctx);
	}
	
	
}
