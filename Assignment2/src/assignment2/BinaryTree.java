/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author ahmed
 */
// Problem 2 i will use BFS

import java.util.ArrayList;
import java.util.Collections;
import javafx.print.Collation;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class BinaryTree {

    Tree root;
    ArrayList<Integer> encoded = new ArrayList<>();

    // ...


    /*private Tree addRecursive(Tree current, int value) {

        if (current == null) {
            return new Tree(value);
        }

        if (value < current.value) {

            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {

            current.right = addRecursive(current.right, value);
        } else {

            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {

        root = addRecursive(root, value);
    }*/
    
    Tree newNode(int data)  
    {  
        Tree Node = new Tree(data);    
        return(Node);  
    } 

    /*private BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(2);
        bt.add(1);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        
        bt.root.value = -1;
        bt.root.left.value = 5;
        bt.root.right.value = 7;
        bt.root.right.right.value = 1;

        return bt;
    }*/
    
    int height(Tree node)  
    {  
        if (node == null)  
            return 0;  
        else
        {  
            /* compute the height of each subtree */
            int lheight = height(node.left);  
            int rheight = height(node.right);  

            /* use the larger one */
            if (lheight > rheight)  
                
                return(lheight + 1);  
            
            else 
                
                return(rheight + 1);  
        }  
    }
    
    void pathshelper(Tree node){
        
        int[] path = new int [1000];
        pathRecur(node, path, 0);
    }
    
    void pathRecur(Tree node, int[] path, int index){
        
        if (node == null){
            
            return;
        }
        
        path[index] = node.value;
        index++;
        
        if (node.left == null && node.right == null){
            
            addencodedinteger(path, index);
        }
        else{
            
            pathRecur(node.left, path, index);
            pathRecur(node.right, path, index);
        }
        
        
    }
    
    void addencodedinteger(int[] path,int index){
         
        String num = "";
        for (int i = 0; i < index; i++){
            
            num += path[i];
        }
        encoded.add(Integer.parseInt(num));
    }
    
    long digitSum(){
        
        pathshelper(root);
        long res = 0;
        for (int i = 0; i < encoded.size(); i++){
            
            res += encoded.get(i);
        }
        
        return res;
    }

    ArrayList<Integer> printLevelOrder() 
    { 
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int h = height(root); 
        int i; 
        
        for (i=0; i<h; i++) {
            num = new ArrayList<>();
            printGivenLevel(root, i + 1, num); 
            res.add(Collections.max(num));
        }
        
        return res;
    } 
    
    void printGivenLevel (Tree root ,int level,ArrayList<Integer> num) 
    { 
        if (root == null) 
            return;
        if (level == 1) {
            System.out.print(root.value + " "); 
            num.add(root.value);
        }
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1, num); 
            printGivenLevel(root.right, level-1, num); 
        } 
        

    }
  

    public static void main(String[] args) {
       
        ArrayList<Integer> res = new ArrayList<>();
        BinaryTree tree = new BinaryTree(); 
        tree.root= new Tree(1); 
        tree.root.left= new Tree(0); 
        tree.root.right= new Tree(4);  
        tree.root.left.left= new Tree(3);
        tree.root.left.right= new Tree(1); 
        
        
        res = tree.printLevelOrder();
         
        System.out.println(" ");
        for (int i = 0; i < res.size(); i++){
            
            System.out.println(res.get(i));
        }
        
        System.out.println("The output = " + tree.digitSum());
    
    }
}
