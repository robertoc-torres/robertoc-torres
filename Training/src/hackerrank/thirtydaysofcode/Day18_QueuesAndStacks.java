package hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.*;

/*

    Day 18: Queues and Stacks
    src:https://www.hackerrank.com/challenges/30-queues-stacks/problem

 */

public class Day18_QueuesAndStacks {
}

class Solution18 {
    // Write your code here.

    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new LinkedList<>();

    void pushCharacter(char ch) {
        stack.push(ch);
    }

    void enqueueCharacter(char ch) {
        queue.add(ch);
    }

    char popCharacter() {
        return stack.pop();
    }

    char dequeueCharacter() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution18 p = new Solution18();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }
}