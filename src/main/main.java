package main;

import Vista.Ventana_Main;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;

public class main {

    public static void main(String args[]) throws Docx4JException, JAXBException, IOException {
        Ventana_Main ventana = new Ventana_Main();
        ventana.setVisible(true);
        
        /*File doc = new File("C:\\Users\\Sociograph\\Desktop\\prueba.docx");
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(doc);

        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
        String textNodesXPath = "//w:t";
        List<Object> textNodes = mainDocumentPart.getJAXBNodesViaXPath(textNodesXPath, true);
        for (Object obj : textNodes) {
            Text text = (Text) ((JAXBElement) obj).getValue();
            String textValue = text.getValue();
            System.out.println(textValue);
        }
        */
        
        
        //Runtime runTime = Runtime.getRuntime();
        //Process process = runTime.exec("winword C:\\Users\\Sociograph\\Desktop\\prueba.docx");

    }

}
