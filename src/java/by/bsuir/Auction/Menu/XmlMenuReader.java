/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Menu;


import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author User
 */
public class XmlMenuReader {
    public static PageMenu readMenuFromFile(String fileName)
    {
        PageMenu menu = new PageMenu();
        
        
        File file = new File(fileName);
        
        Document doc = createDocument(file);
        
        NodeList nodeList = doc.getElementsByTagName("item");
        String str = "";
        for(int i=0; i<nodeList.getLength(); i++)
        {
           NodeList items =  nodeList.item(i).getChildNodes();

           String title="";
           String url="";
           String className="";
           
           for(int j=0; j<items.getLength(); j++)
           {
               String sss = items.item(j).getNodeName();
               if(items.item(j).getNodeName() == "title")
                   title = items.item(j).getTextContent();
               if(items.item(j).getNodeName() == "url")
                   url = items.item(j).getTextContent();
               if(items.item(j).getNodeName() == "class")
                   className = items.item(j).getTextContent();
           }
           
           menu.addMenuItem(new MenuItem(title, url, className));
           
        }
        
        
        return menu;
    }
    
   private static Document createDocument(File file) {
        Document doc = null;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            // Считывание документа из файла
            doc = builder.parse(file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }
   
   static public void main()
   {
       XmlMenuReader.readMenuFromFile("MainPage.xml");
   }
}
