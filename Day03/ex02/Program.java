package ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    private static int param;
    private static int count;
    private static int[] arr;
    private static int nod;

    public static void main(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.err.println("Bad argument ! You need put: program name --arraySize=Int --threadsCount=Int");
            System.exit(-1);
        }
        String[] s1 = args[0].split("=");
        String[] s2 = args[1].split("=");
        if (s1.length != 2) {
            System.err.println("Bad argument ! You need put: program name --arraySize=Int --threadsCount=Int");
            System.exit(-1);
        }
        if (s2.length != 2) {
            System.err.println("Bad argument ! You need put: program name --arraySize=Int --threadsCount=Int");
            System.exit(-1);
        }
        try {
            param = Integer.parseInt(s1[1]);
            count = Integer.parseInt(s2[1]);
        } catch (Exception e) {
            System.err.println("Bad argument ! You need put: program name --arraySize=Int --threadsCount=Int");
            System.exit(-1);
        }
        if (param > 2000000 || count <= 0 || count > 2000000 || count > param) {
            System.err.println("Bad argument ! You need put: program name --arraySize=Int --threadsCount=Int");
            System.exit(-1);
        }
        randomArray();
        searchNod();

        Being calc = new Being(arr, 0, (int) param - 1);
        System.out.println("Sum: " + calc.setSum());

        List<Being> calculators = create();

        try {
            System.out.println("Sum by threads: " + execute(calculators));
        } catch (Exception e) {
            System.err.println("Some errors");
        }
    }
    private static void randomArray() {
        arr = new int[param];
        Random rand = new Random();
        for (int i = 0; i < param; ++i)
            arr[i] = rand.nextInt(1000);
    }
    private static void searchNod() {
        if (count == 1)
            nod = param / count;
        else
            nod = (param - 1) / (count - 1);
    }
    private static List<Being> create() {
        List<Being> calculators = new ArrayList<>(param);
        int j = 0;
        for (int i = 0; i < count - 1 && j < param - 1; ++i, ++j) {
            int start = j;
            j += (nod - 1);
            int end = j;
            Being calc = new Being(arr, start, end);
            calculators.add(calc);
        }
        Being calc = new Being(arr, j, param - 1);
        calculators.add(calc);
        return calculators;
    }
    private static long execute(List<Being> calculators) throws InterruptedException {
        for (Being c : calculators)
            c.start();

        long answer = 0;
        for (Being c : calculators) {
            c.join();
            answer += c.getSum();
        }
        return answer;
    }
}
