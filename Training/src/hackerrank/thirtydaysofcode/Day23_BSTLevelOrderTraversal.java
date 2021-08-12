package hackerrank.thirtydaysofcode;

import java.util.*;
import java.io.*;

/*

    Day 23: BST Level-Order Traversal
    src:https://www.hackerrank.com/challenges/30-binary-trees/problem

 */

class Node23 {
    Node23 left, right;
    int data;

    Node23(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day23_BSTLevelOrderTraversal {

    static void levelOrder(Node23 root) {
        //Write your code here
        Queue<Node23> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node23 currentNode = q.poll();
            System.out.print(currentNode.data + " ");
            if(currentNode.left != null) q.add(currentNode.left);
            if(currentNode.right != null) q.add(currentNode.right);
        }
    }


    public static Node23 insert(Node23 root, int data) {
        if (root == null) {
            return new Node23(data);
        } else {
            Node23 cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node23 root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}