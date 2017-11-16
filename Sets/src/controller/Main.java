package controller;

import SetsClasses.MySets;
import SetsClasses.Set;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String univrse;
        System.out.print("Enter the univrse : ");
        univrse = input.nextLine();
        System.out.print("Enter number of subsets : ");
        int num = Integer.parseInt(input.nextLine());
        Set U = new Set(univrse);
        Set [] sets = new Set [num + 1];
        for (int i = 1; i <= num; i ++) {
            System.out.print("Enter set " + i + " : ");
            String set = input.nextLine();
            sets[i] = new Set(set);
        }
        System.out.print("Enter an action (U for union, I for intersection, C for complement, E for Exit : ");
        char in = input.next().charAt(0);
        while (in != 'E') {
            if (in == 'U') {
                System.out.print("Enter index of first set : ");
                int setA = input.nextInt();
                System.out.print("Enter index of second set : ");
                int setB = input.nextInt();
                MySets tmp = new MySets(sets[setA], sets[setB]);
                System.out.println(tmp.setsUnion());
            } else if (in == 'I') {
                System.out.print("Enter index of first set : ");
                int setA = input.nextInt();
                System.out.print("Enter index of second set : ");
                int setB = input.nextInt();
                MySets tmp = new MySets(sets[setA], sets[setB]);
                System.out.println(tmp.setsIntersection());
            } else if (in == 'C') {
                System.out.print("Enter index of one set (1 for first set, ..) : ");
                int setA = input.nextInt();
                MySets complement = new MySets(U, sets[setA]);
                System.out.println(complement.setComplement());
            } else {
                break;
            }
            System.out.print("Enter an action (U for union, I for intersection, C for complement, E for Exit : ");
            in = input.next().charAt(0);
        }
    }
}