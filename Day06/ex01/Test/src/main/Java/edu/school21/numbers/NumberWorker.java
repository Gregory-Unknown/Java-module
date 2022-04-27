package edu.school21.numbers;

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String message) {
        super(message);
    }
}

public class NumberWorker {
    boolean isPrime(int num) {
        if (num < 2 )
            throw new IllegalNumberException("Not natural number!");
        for (int i = 2; i <= (int) Math.sqrt(num); ++i) {
            if (num % i == 0)
                 return false;
        }
        return true;
    }

    public int digitsSum(int num) {
        int res = 0;
        while (num > 0) {
            res = res + (num % 10);
            num /= 10;
        }
        return res;
    }
}
