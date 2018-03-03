/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.util.ArrayList;
import org.xml.sax.Attributes;

/**
 *
 * @author jasminetan
 */
public class Node {
    private ArrayList<Node> children;
    private String type;
    private String content;
    private Attributes attributes;
    
    public Node() {
        children = new ArrayList<>();
    }

    public ArrayList<Node> getChildren()
    {
        return children;
    }

    public Attributes getAttributes()
    {
        return attributes;
    }
    public String getType()
    {
        return type;
    }

    public String getContent()
    {
        return content;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
    
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    
    public void addChild(Node child) {
        children.add(child);
    }
    
}
