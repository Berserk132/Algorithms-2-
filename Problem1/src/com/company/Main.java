package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Tree t = new Tree();
//        t.root = new Node<>(1);
//        t.root.right = new Node<>(2);
//        t.root.left = new Node<>(2);
//        t.root.right.right = new Node<>(3);
//        t.root.right.left = new Node<>(4);
//        t.root.left.right = new Node<>(4);
//        t.root.left.left = new Node<>(3);
//        t.root.right.right.right = new Node<>(3);
//        t.root.right.left.right = new Node<>(4);
//        t.root.left.right.left = new.Node<>(4);
//        t.root.left.left.left = new Node<>(3);
        
//        System.out.println(t.myDFS());
        System.out.println("enter the root ");
        Scanner sc = new Scanner(System.in);
        
        String res= sc.next();
        t.root=new Node<>(Integer.parseInt(res));
        Queue<Node> q = new LinkedList<>();
        q.add(t.root);
        while(!q.isEmpty()) {
        	Node tmp=q.poll();
        	System.out.println(tmp.data +" left is ");
        	res=sc.next();
        	if(res.equals("exit")) break;
        	if(!res.equals("skip")) {
	        	tmp.left=new Node<>(Integer.parseInt(res));
	        	q.add(tmp.left);
        	}
        	System.out.println(tmp.data +" right is ");
        	res=sc.next();
        	if(!res.equals("skip")) {
	        	tmp.right=new Node<>(Integer.parseInt(res));
	        	q.add(tmp.right);
        	}
        	
        }
        
        
        System.out.println(t.check());
    }
}
