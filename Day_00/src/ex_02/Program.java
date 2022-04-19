package ex_02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        iligalPrintScan(scan);
        int num = scan.nextInt();
        iligalPrintNum(num, scan);
        int count = 0;
        while (num != 42) {
            if (isPrime(sumDigits(num)))
                    ++count;
            iligalPrintScan(scan);
            num = scan.nextInt();
            iligalPrintNum(num, scan);
        }
        scan.close();
        System.out.println("Count of coffee-request - " + count);
    }
    private static int sumDigits(int num) {
        int res = 0;
        while (num > 0) {
            res = res + (num % 10);
            num /= 10;
        }
        return (res);
    }
    private static boolean isPrime(int num) {
        boolean prime = true;

        for (int i = 2; i * i <= num && prime; ++i) {
            if (num % i == 0)
                prime = false;
        }
        return (prime);
    }
    private static void iligalPrintScan(Scanner scan) {
        if (!scan.hasNextInt()) {
            scan.close();
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }
    private static void iligalPrintNum(int num, Scanner scan) {
        if (num < 2) {
            scan.close();
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }
}
