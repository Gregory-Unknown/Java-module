package ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String week = scan.nextLine();
        int countWeek = 1;
        long blockChain = 0;
        while (!week.equals("42")) {
            if (!week.equals("Week " + countWeek) || countWeek > 18)
                iligalPrintNum(-1, scan);
            int min = minNumber(scan);
            if (countWeek > 1)
                blockChain += (min * myPow(countWeek - 1));
            else
                blockChain += min;
            ++countWeek;
            week = scan.nextLine();
        }
        scan.close();
        int i = 1;
        while (blockChain > 0 && i <= countWeek) {
            System.out.print("Week " + i + ((i > 9) ? " " : "  "));
            long amount = blockChain % 10;
            while (amount > 0) {
                System.out.print("=");
                --amount;
            }
            System.out.println(">");
            blockChain /= 10;
            ++i;
        }
    }
    private static int minNumber(Scanner scan) {
        int res = 9;
        for (int i = 0; i < 5; ++i) {
            iligalPrintScan(scan);
            int num = scan.nextInt();
            iligalPrintNum(num, scan);
            if (res > num)
                res = num;
        }
        scan.nextLine();
        return (res);
    }
    private static long myPow(int b) {
        long result = 1;
        int a = 10;
        for (int i = 1; i <= b; ++i){
            result = result * a;
        }
        return result;
    }
    private static void iligalPrintScan(Scanner scan) {
        if (!scan.hasNextInt()) {
            scan.close();
            System.err.println("\nIllegal Argument");
            System.exit(-1);
        }
    }
    private static void iligalPrintNum(int num, Scanner scan) {
        if (num < 1 || num > 9) {
            scan.close();
            System.err.println("\nIllegal Argument");
            System.exit(-1);
        }
    }

}
