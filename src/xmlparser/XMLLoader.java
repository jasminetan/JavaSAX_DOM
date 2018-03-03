/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.io.File;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author jasminetan
 */
public class XMLLoader {
        public static Parser load(File xmlFile) throws Exception {
        Parser parser = new Parser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                
                private Stack<Node> stack = new Stack<>();
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    Node node = new Node();
                    node.setType(qName);
                    if(stack.empty()) {
                        
                        stack.push(node);
                        parser.addNode(node);
                    }
                    else {
                        stack.peek().addChild(node);
                        stack.push(node);
                    }
                    
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    stack.pop();
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    stack.peek().setContent(new String(ch, start, length).trim());
                }
            };
            
            saxParser.parse(xmlFile.getAbsoluteFile(), handler);
            
        } catch (Exception e) {
            throw e;
        }
        
      return parser; 
    }
}
    
