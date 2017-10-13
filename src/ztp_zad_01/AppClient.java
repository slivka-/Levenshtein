package ztp_zad_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michał Śliwa
 */
public class AppClient 
{
    private static final String REGEX = "^[\\s]*([a-zA-Z]+[\\s]+){1,2}[a-zA-Z]+[\\s]*$"; //constant regular expression
    private static List<String> namesFromFile;
    private static String inputToMatch;
    
    public static void main (String[] args)
    {
        //Check if specified file exist. If not, show error.
        //==========================================================
        try
        {
            Path inputFilePath = Paths.get(args[0]);
            namesFromFile = Files.readAllLines(inputFilePath);
        }
        catch(IOException ex)
        {
            System.err.println("Error! Specified file not found!");
            System.err.println(ex);
        }
        //==========================================================
        
        //Check if specified string matches regular expression. If not, show error. 
        //==========================================================
        Pattern regexPattern = Pattern.compile(REGEX);
        if(regexPattern.matcher(args[1]).matches())
            inputToMatch = args[1];
        else
            System.err.println("Error! Specified string does not match the pattern!");
        //==========================================================
        
        //If both file and input string are OK then proceed.
        if(namesFromFile!=null && inputToMatch!=null)
        {
            System.out.println("OK");
        }
    }
}
