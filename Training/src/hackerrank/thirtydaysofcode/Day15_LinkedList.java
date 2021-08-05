package hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.*;

/*

    Day 15: Linked List
    src:https://www.hackerrank.com/challenges/30-linked-list/problem

 */

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Day15_LinkedList {

    public static Node insert(Node head, int data) {
        //Complete this method
        if(head == null){
            head = new Node(data);
        } else {
            Node n = new Node(data);
            Node t = head;
            while(t.next != null) {
                t = t.next;
            }
            t.next = n;
        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}