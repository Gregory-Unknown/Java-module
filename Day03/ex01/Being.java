package ex01;

public class Being extends Thread {
    private static String check = "Hen";
    private int count;
    private String mess;

    public Being(int c, String m) {
        count = c;
        mess = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; ) {
            synchronized (Being.class) {
                if (!check.equals(mess)) {
                    System.out.println(mess);
                    check = mess;
                    ++i;
                }
            }
        }
    }
}
