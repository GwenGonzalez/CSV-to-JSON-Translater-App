// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Driver 
{
	
	public static void main(String[] args) throws Exception 
	{

		// create a CharStream that reads from standard input
		CharStream input = CharStreams.fromStream(System.in);

		// create a lexer that feeds off of input CharStream
		GrammarLexer lexer = new GrammarLexer(input);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds off the tokens buffer
		GrammarParser parser = new GrammarParser(tokens);

        // begin parsing at prog rule
		ParseTree tree = parser.format_Line();

        //Create a formatter that organizes the JSON File
        JSONFormatter formatter = new JSONFormatter();

		// Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();

        // Walk down the tree and pass the args into the formatter
        walker.walk(formatter, tree);

        //Create the JSON File
        formatter.createFile();
	}
}