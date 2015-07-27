package com.cadre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 *
 * Print nodes on a given level of binary tree 1 by 1 starting from root and ending with leaf level
 * Find common ancestor of 2 nodes
 */

class CommonAncestor {
  

    private static class Node
    {
        int mData;
        Node parent;
        Node mLeftNode;
        Node mRightNode;
      
        public String toString()
        {
           return String.valueOf(mData); 
        }
    };

    public void printLevelOrder(Node rootNode)
    {
       //System.out.println("printLevelOrder");
       int level = 1;
       LinkedList<Node> list = new LinkedList<>();
       list.add(rootNode);
      
       while(!list.isEmpty())
       {
         Node node = list.remove();
         System.out.println(node.mData);
         if(node.mLeftNode != null && node.mRightNode == null)
         {
             list.add(node.mLeftNode);
             level++;
         }
         else if(node.mLeftNode == null && node.mRightNode != null)
         {
             list.add(node.mRightNode);
             level++;
         }
         else if(node.mLeftNode != null && node.mRightNode != null) {
             list.add(node.mLeftNode);
             list.add(node.mRightNode);
             level++;         
         }         
       }       
    }
  
    public Node getClosestCommonAncestor(Node a, Node b)
    {
      List<Node> path1 = createPath(a);
      List<Node> path2 = createPath(b);
      
      System.out.println(path1);
      System.out.println(path2);
      
      for(int i = path1.size()-1; i >= 0; i--)
      {
         Node node1 = path1.get(i); 
         Node node2 = path2.get(i);
         if(node1.mData != node2.mData)
           return node1.parent;
      }
      return null;
    }
  
    private List<Node> createPath(Node node)
    {
      List<Node> path = new ArrayList<>();      
      while(node != null)
      {
         path.add(node);
         node = node.parent;
      }      
      return path;
    }
  
  
    public Node constructTree() {
      
      return makeNode(1, 
              makeNode(2, 
                makeNode(4, null, null), 
                makeNode(5, null, null)), 
              makeNode(3,
                makeNode(6, null, null),
                makeNode(7, null, null)));
    }
  
    public static Node makeNode(int mData, Node mLeftNode, Node mRightNode) {
    
      Node node = new Node();
      node.mData = mData;
      node.mLeftNode = mLeftNode;
      node.mRightNode = mRightNode;
      if(node.mLeftNode != null) {
        node.mLeftNode.parent = node;
      }
      if(node.mRightNode != null) {
        node.mRightNode.parent = node;
      }
      
      return node;
      
    }

    
    public static void main(String[] args) {
      System.out.println("Starting...");
      CommonAncestor solution = new CommonAncestor();
      solution.printLevelOrder(solution.constructTree());
      Node root = solution.constructTree();
      Node node1 = root.mLeftNode.mRightNode;
      Node node2 = root.mRightNode.mLeftNode;
      Node common = solution.getClosestCommonAncestor(node1,node2);
      System.out.println(common.mData);
      System.out.println("Done!");
    }
}






