import javax.xml.stream.XMLStreamException;
import java.io.*;

public class Main {

    final static String USER_DIRECTORY = System.getProperty("user.dir");
    final static String PROJECT_PATH = "\\src\\main\\resources\\";
    final static String XML_FILE_NAME = "inputDocument.xml";
    final static String TXT_FILE_NAME = "EDIFACT_message.txt";

    public static void main (String[] args) throws IOException, XMLStreamException {

        System.out.println("Q1");
        System.out.println(" ");
        System.out.println("Taking the following EDIFACT message text, \n" +
                "write some code to parse out the all the LOC segments \n" +
                "and populate an array with the 2nd and 3rd element of each segment. ");
        System.out.println(" ");
        System.out.println("All the LOC segments:");
        System.out.println(" ");

        ParserForText parserForText = new ParserForText();
        parserForText.parseText(USER_DIRECTORY + PROJECT_PATH + TXT_FILE_NAME);

        System.out.println(" ");
        System.out.println("Q2");
        System.out.println(" ");
        System.out.println("Taking the following XML document, \n" +
                "write code to extract the RefText values for the following RefCodes:   ‘MWB’, ‘TRV’ and ‘CAR’");
        System.out.println(" ");

        ParserForXml parserForXml = new ParserForXml();
        parserForXml.parseXML(USER_DIRECTORY + PROJECT_PATH + XML_FILE_NAME);
    }
}

