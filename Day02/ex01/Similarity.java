package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Similarity {
    private final String input1;
    private final String input2;
    private final TreeSet<String> dictionary;
    private final ArrayList<String> fileA;
    private final ArrayList<String> fileB;

    public Similarity(String s1, String s2) {
        input1 = s1;
        input2 = s2;
        dictionary = new TreeSet<>();
        fileA = new ArrayList<>();
        fileB = new ArrayList<>();
    }
    public void start() {
        try {
            FileInputStream inputStreamA = new FileInputStream(input1);
            FileInputStream inputStreamB = new FileInputStream(input2);

            Scanner scan = new Scanner(inputStreamA);

            while (scan.hasNext()) {
                String strA = scan.next();
                String[] arrA = strA.split(" ");
                fileA.addAll(Arrays.asList(arrA));
            }
            scan.close();
            inputStreamA.close();
            dictionary.addAll(fileA);
            scan = new Scanner(inputStreamB);
            while (scan.hasNext()) {
                String strB = scan.next();
                String[] arrB = strB.split(" ");
                fileB.addAll(Arrays.asList(arrB));
            }
            scan.close();
            inputStreamB.close();
            dictionary.addAll(fileB);
            FileOutputStream fileDic = new FileOutputStream("/Users/esobchak/Desktop/day02/src/ex01/dictionary.txt");
            for (Iterator<String> it = dictionary.iterator(); it.hasNext(); ) {
                byte[] bytes = (it.next() + " ").getBytes();
                fileDic.write(bytes);
            }
            fileDic.close();
            String str = String.format("%.3f", calculateSimilarity());
            if (str.substring(0, str.length() - 1).equals("Na"))
                System.out.println("Similarity = 0");
            else
                System.out.println("Similarity = " + str.substring(0, str.length() - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int findNumerator(ArrayList<Integer> arrA, ArrayList<Integer> arrB) {
        int sum = 0;
        for (int i = 0; i < dictionary.size(); i++)
            sum += arrA.get(i) * arrB.get(i);
        return sum;
    }

    public double findDenominator(ArrayList<Integer> arrA, ArrayList<Integer> arrB) {
        double sumA = 0;
        for (Integer x : arrA)
            sumA += x * x;
        double sumB = 0;
        for (Integer x : arrB)
            sumB += x * x;
        return Math.sqrt(sumA) * Math.sqrt(sumB);

    }

    public double calculateSimilarity() {
        ArrayList<Integer> frequencyOfiInA = new ArrayList<>(dictionary.size());
        ArrayList<Integer> frequencyOfiInB = new ArrayList<>(dictionary.size());

        fillFrequencyOfOccurencesArrays(frequencyOfiInA, frequencyOfiInB);
        int numerator = findNumerator(frequencyOfiInA, frequencyOfiInB);
        double denominator = findDenominator(frequencyOfiInA, frequencyOfiInB);
        return numerator / denominator;
    }

    public void fillFrequencyOfOccurencesArrays(ArrayList<Integer> arrA, ArrayList<Integer> arrB) {
        int countA = 0;
        int i = 0;
        for (String elem : dictionary) {
            for (String elemFromA : fileA)
                if (elem.equals(elemFromA))
                    countA++;
            arrA.add(i, countA);
            countA = 0;
            i++;
        }
        i = 0;
        for (String elem : dictionary) {
            for (String elemFromB : fileB)
                if (elem.equals(elemFromB))
                    countA++;
            arrB.add(i, countA);
            countA = 0;
            i++;
        }
    }
}
