package org.myeducation.taskexecuter.examples;

import java.util.Scanner;

/**
 * @author Andrey Frolov
 * @since  28.02.13
 */
public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a * a);

    }
}
