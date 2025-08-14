package src.java8;

public class MyUtil {

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++) {
             if(n % i ==0)
                 return false;
        }
        return true;
    }

    public static boolean isPrimeOpt(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n % i ==0)
                return false;
        }
        return true;
    }
}
