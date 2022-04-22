package ex03;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Reserve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String week = scan.nextLine();
        int countWeek = 1;
        long blockChain = 0;
        while (!week.equals("42")) {
            if (!week.equals("Week " + countWeek) || countWeek > 18) {
                scan.close();
                System.err.println("\nIllegal Argument");
                System.exit(-1);
            }
            int min = 9;
            for (int i = 0; i < 5; ++i) {
                if (!scan.hasNextInt()) {
                    scan.close();
                    System.err.println("Illegal Argument");
                    System.exit(-1);
                }
                int num = scan.nextInt();
                if (num < 1 || num > 9) {
                    scan.close();
                    System.err.println("Illegal Argument");
                    System.exit(-1);
                }
                if (min > num)
                    min = num;
            }
            scan.nextLine();
            if (countWeek > 1)
                blockChain += (long)(min * pow(10, countWeek - 1));
            else
                blockChain += min;
            ++countWeek;
            week = scan.nextLine();
        }
        scan.close();
        int i = 1;
        while (blockChain > 0) {
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
}
