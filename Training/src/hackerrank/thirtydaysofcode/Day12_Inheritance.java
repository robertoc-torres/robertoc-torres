package hackerrank.thirtydaysofcode;

import java.util.*;

/*

    Day 12: Inheritance
    src:https://www.hackerrank.com/challenges/30-inheritance/problem?h_r=next-challenge&h_v=zen

 */

class Person2 {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person2(String firstName, String lastName, int identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson() {
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + "\nID: " + idNumber);
    }

}

class Student extends Person2 {

    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    Student(String firstName, String lastName, int id, int[] scores) {
        super(firstName, lastName, id);
        this.testScores = scores;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    char calculate() {
        int avg = 0;
        for(int i : testScores){
            avg += i;
        }
        avg = avg / testScores.length;
        if(avg >= 90){
            return 'O';
        }
        if(avg >= 80) {
            return 'E';
        }
        if(avg >= 70) {
            return 'A';
        }
        if(avg >= 55) {
            return 'P';
        }
        if(avg >= 40) {
            return 'D';
        }
        return 'T';
    }
}

public class Day12_Inheritance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }
}

