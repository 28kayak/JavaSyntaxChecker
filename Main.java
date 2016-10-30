/**
 * Created by kaya on 10/24/16.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;


public class Main
{
    public static void main(String args[])
    {
        //System.out.println("Hello world");
        String inputFileName = "/Users/kaya/IdeaProjects/JavaSampleCompiler/src/test1.txt";
        File inputFile = new File(inputFileName);
        String[] statement;

        try
        {
            //creating instances of input-stream
            FileInputStream fis = new FileInputStream(inputFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            //read data from text-file
            String line;
            int lineNum = 0;

            line = br.readLine();//read the first row
            lineNum++;
            System.out.println("line = " + line);

            while (!line.contains("class"))
            {//lines are package declaration or import declaration
                //before class declaration
                statement = line.split(" ");
                System.out.println("statement[0] = " + statement[0]);
                if(statement[0].equals("import"))
                {
                    //check if package or import statement is correct
                    //importCheckr(statement[1], lineNum);

                    System.out.println("statement[1] = " + statement[1]);
                }
                else if (statement[0].equals("package"))
                {
                    packageChecker(statement[1],lineNum);

                }else if(statement[0].equalsIgnoreCase("import") || statement[0].equalsIgnoreCase("package"))
                {
                    System.out.println("ERROR: java is case sensitive: @ "+ lineNum );
                }
                else
                {
                    System.out.println("deadcode: " + statement[0] +"!!");
                    System.out.println("Something wrong: this should be dead code");
                }
                line = br.readLine();
                lineNum++;

            }//while
            System.out.println("end while");
            while(line!=null)
            {
                //class declaration starts
                //for now infinite loop
                //System.out.println("class");
            }
            System.out.println("the last line");
            System.out.println(lineNum);




        }
        catch(FileNotFoundException err404)
        {
           // System.out.print(err);
            err404.getMessage();
        }
        catch(IOException ioerr)
        {
            ioerr.getMessage();
        }
        catch (Exception err)
        {
            err.getStackTrace();
        }
    }//main

    static boolean packageChecker(String candidate, int linenum)
    {
        boolean validity = false;
        System.out.println("candidate = "+candidate);
        //String[] splited = candidate.split(".");
        //System.out.println("spliet = " + splited[0]);
        if(candidate.endsWith(";"))
        {
            System.out.println("end with ; " + candidate);
            validity = true;
        }
        else
        {
            System.out.println("ERROR: forget ; at the end of package statement: @ " + linenum);
            validity = false;
        }






        return validity;

    }//packageChecker
    static  boolean importChecker(String candidate, int lineNum)
    {
        boolean validity = false;




        return validity;

    }
}//class
