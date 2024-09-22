This CSV to JSON translation application uses ANTLR4, to generate a parser given a grammar.
AS the title sugests, this application can translate a CSV into JSON format, which can be
useful in many business settings where the need occurs.

To set up and run the application on Windows using the command prompt, the following 
instructions should be helpful.

Please note, we are using antlr 4.9.3 for this project, and you must first download the 
jar file, which instructions can be found on the ANTLR website.

Setting Up ANTLR4 on Windows Command Propmt
*Replace <path> on the instruction down below with where your antlr jar file is on your computer.*
SET CLASSPATH=.;<path>;%CLASSPATH%
doskey antlr4=java org.antlr.v4.Tool $*
doskey grun =java org.antlr.v4.gui.TestRig $*

Creating Necessary Files
*Make sure to run instructions in the directory where the application files are.*
java org.antlr.v4.Tool Grammar.g4
javac *.java

Running the Application
*You may choose to run the application with any of the given test inputs located inside the
Test_Inputs folder, or create your own, as long as it has the same specified fields.*
java Driver < Test_Inputs/TestInput1.in
