package ex04;

import java.util.Scanner;


public class Program {
    static int map[] = new int[65536];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        iligalPrintScan(scan);

        char arr[] = scan.nextLine().toCharArray();

        if (arr.length == 0)
            System.exit(0);
        for (char c : arr)
            map[c]++;
        int indexs[] = new int[10];

        fillMap(indexs);
        sortMap(indexs);
        printDiagram(indexs, scan);
    }
    private static void fillMap(int[] indexs) {
        int min = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0 || map[i] < map[indexs[min]])
                continue;
            indexs[min] = i;
            min = 0;
            for (int j = 1; j < 10 && map[indexs[min]] > 0; ++j) {
                if (map[indexs[min]] >= map[indexs[j]]) {
                    min = j;
                }
            }
        }
    }
    private static void sortMap(int[] indexs) {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (map[indexs[j]] < map[indexs[j + 1]]) {
                    int tmp = indexs[j + 1];
                    indexs[j + 1] = indexs[j];
                    indexs[j] = tmp;
                }
            }
        }
    }
    private static void printDiagram(int[] indexs, Scanner scan) {
        int size = getCount(indexs);
        int max = map[indexs[0]];
        iligalPrintScan(max, scan);
        for (int i = 11; i > 0; i--) {
            int height = (max * i);
            int heightNext = (max * (i - 1));

            for (int j = 0; j < size; j++) {
                if (map[indexs[j]] * 10 >= height) {
                    System.out.print("  #");
                } else if (map[indexs[j]] * 10 >= heightNext) {
                    System.out.printf("% 3d", map[indexs[j]]);
                } else {
                    break;
                }
            }
            System.out.println("");
        }

        for (int i = 0; i < size; i++) {
            System.out.printf("  %c", (char) indexs[i]);
        }
        System.out.println("");
    }
    private static int getCount(int[] indexs) {
        int size = 1;
        for (int i = 0; i < 10; ++i) {
            if (map[indexs[i]] == 0) {
                break;
            }
            size = i + 1;
        }
        return (size);
    }
    private static void iligalPrintScan(Scanner scan) {
        if (!scan.hasNextLine()) {
            scan.close();
            System.err.println("\nIllegal Argument");
            System.exit(-1);
        }
    }
    private static void iligalPrintScan(int num, Scanner scan) {
        if (num > 999) {
            scan.close();
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }
}
