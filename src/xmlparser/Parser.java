/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.util.ArrayList;

/**
 *
 * @author jasminetan
 */
public class Parser {
    private ArrayList<Node> nodes;
    
    public Parser() {
        nodes = new ArrayList<>();
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }
     public void addNode(Node node) {
        nodes.add(node);
    }
    
}
