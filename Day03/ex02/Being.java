package ex02;

public class Being extends Thread {

    private final int[] arr;
    private final int id;
    private final int start;
    private final int end;
    private long sum;

    private static int lastId = 0;

    public Being(int arr[], int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        id = lastId++;
    }

    public long getSum() {
        return sum;
    }

    public long setSum() {
        sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    @Override
    public void run() {
        setSum();
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Thread " + id + ": from " + start + " to " + end + " sum is " + sum;
    }
}
