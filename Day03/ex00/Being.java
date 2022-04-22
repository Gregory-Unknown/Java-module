package ex00;
public class Being extends Thread {
    private int count;
    private String mess;
    public Being(int c, String m) {
        count = c;
        mess = m;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; ++i) {
            System.out.println(mess);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
