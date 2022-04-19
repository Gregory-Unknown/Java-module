package ex_01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNextInt()) {
            scan.close();
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        int num = scan.nextInt();
        if (num < 2) {
            scan.close();
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        boolean isPrime = true;
        int count = 1;
        for (int i = 2; i * i <= num; ++i, ++count) {
            if (num % i == 0) {
                isPrime = false;
                break ;
            }
        }
        scan.close();
        System.out.println(isPrime + " " + count);
    }
}
