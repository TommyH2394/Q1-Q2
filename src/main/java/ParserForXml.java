import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.*;

/**
 * Java Class that parses the XML file resources/inputDocument.xml.
 * Extract the RefText values for the following RefCodes:   ‘MWB’, ‘TRV’ and ‘CAR’
 *
 */
public class ParserForXml {

    final static String REF_CODE = "RefCode";
    final static String REFERENCE = "Reference";
    final static String MWB = "MWB";
    final static String TRV = "TRV";
    final static String CAR = "CAR";
    final static String EMPTY_STRING = "";

    /**
     * Method that reads the complete file, with some logic too extract the RefText values for the following RefCodes:   ‘MWB’, ‘TRV’ and ‘CAR’.
     *
     * @param fileInputPath
     *   the path of the file to parse
     *
     * @throws XMLStreamException
     * @throws FileNotFoundException
     */
    public void parseXML(String fileInputPath) throws XMLStreamException, IOException {

        File file = new File(fileInputPath);
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader =
                factory.createXMLEventReader(new FileReader(file));

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            QName refCodeName = new QName(EMPTY_STRING,REF_CODE,EMPTY_STRING);

            if (event.isStartElement() && event.asStartElement().getName().toString().equals(REFERENCE)) {
                if(event.asStartElement().getAttributeByName(refCodeName).getValue().equals(MWB)
                        || event.asStartElement().getAttributeByName(refCodeName).getValue().equals(TRV)
                        || event.asStartElement().getAttributeByName(refCodeName).getValue().equals(CAR)) {
                    eventReader.nextEvent();
                    eventReader.nextEvent();
                    System.out.println(eventReader.nextEvent());
                }
            }
        }
    }
}