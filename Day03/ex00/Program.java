package ex00;

public class Program {
    private static int param;
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Bad argument ! You need put: program name --count=Int");
            System.exit(-1);
        }
        String[] s = args[0].split("=");
        if (s.length != 2) {
            System.err.println("Bad argument ! You need put: program name --count=Int");
            System.exit(-1);
        }

        try {
            param = Integer.parseInt(s[1]);
        } catch (Exception e) {
            System.err.println("Bad argument ! You need put: program name --count=Int");
            System.exit(-1);
        }
        if (param <= 0) {
            System.err.println("Bad argument ! You need put: program name --count=Int");
            System.exit(-1);
        }

        Thread thread1 = new Thread(new Being(param, "Egg"));
        Thread thread2 = new Thread(new Being(param, "Hen"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < param; ++i)
            System.out.println("Human");
    }
}
