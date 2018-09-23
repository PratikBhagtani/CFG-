import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import org.apache.commons.cli.*;
public class CfgGen {

	private static CfgGraph graph;
	
	public static void main(String[] args) throws org.apache.commons.cli.ParseException, ParseException {
		
		graph = new CfgGraph();
		
		if (args.length < 1){
			System.err.println("You must supply an input file");
			System.exit(1);
		}

		Options options = new Options();
		options.addOption("d", false, "Print debug output"); 
		options.addOption("o", true, "PNG output path"); 
		
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		cmd = parser.parse(options, args);
 
		
		readSource(args[args.length-1]);
		
		
		if (cmd.hasOption("d")) graph.setDebug(true);
		
		String pngpath = "C:\\Users\\Pratik\\Downloads\\CFG\\src\\out.png";
		
		if (cmd.hasOption("o")) pngpath = cmd.getOptionValue("o");
			
		graph.build();
			
		graph.writePng(pngpath);
		

		
	}

	private static void readSource(String path){
		
		FileInputStream fstream = null;		
		
		try{
			fstream = new FileInputStream("C:\\Users\\Pratik\\Downloads\\CFG\\src\\test2.txt");
		}
		catch (IOException e){
			System.err.println("Unable opening file "+path+".\n"+e.getMessage());
			System.exit(1);
		}
		
		Scanner s = new Scanner(fstream);
		
		while (s.hasNextLine()){
			graph.AddSrcLine(s.nextLine());
		}
		s.close();
		try{			
			fstream.close();	
		}		
		catch (IOException e){			
			System.err.println("Error closing file "+path+".\n"+e.getMessage());
		}
		
	}
	
}
