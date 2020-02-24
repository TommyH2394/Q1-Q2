import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Java Class that parses the text file resources/EDIFACT_message.txt and extracts LOC segments,
 * then extracts the second and third elements to an ArrayList.
 *
 */
public class ParserForText {

    final static String LOC = "LOC";

    /**
     * Method that reads the complete file, Prints out the LOC segments and iterates through each line with some logic too extract second and third elements.
     *
     * @param fileInputPath
     *      the path of the file to parse
     *
     * @throws IOException
     */
    public void parseText(String fileInputPath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileInputPath));

        ArrayList<String> secondElementsArray = new ArrayList<String>();
        ArrayList<String> thirdElementsArray = new ArrayList<String>();
        ArrayList<String> bothElementsArray = new ArrayList<String>();

        String currentLine;

        while ((currentLine = br.readLine()) != null) {
            if (currentLine.contains(LOC)) {
                System.out.println(currentLine);
                secondElementsArray.add(currentLine);
                thirdElementsArray.add(currentLine);
            }
        }

        for(int i = 0; i < 5; i++){
            String secondElement = secondElementsArray.get(i).replace("LOC+","");
            String thirdElement = thirdElementsArray.get(i).replace("LOC+","");

            secondElement = secondElement.substring(0,3);

            thirdElement = thirdElement.substring(3, thirdElement.length());
            thirdElement = thirdElement.replace("+","");

            if (secondElement.contains("+")) {
                secondElement = secondElement.replace("+", "");
                bothElementsArray.add(secondElement);
            } else if (!secondElement.contains("+")) {
                bothElementsArray.add(secondElement);
            }
            bothElementsArray.add(thirdElement);
        }
        System.out.println(" ");
        System.out.println("Array with the 2nd and 3rd element of each segment");
        System.out.println(" ");
        System.out.println(bothElementsArray);
    }
}