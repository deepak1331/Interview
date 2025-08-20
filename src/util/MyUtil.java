package src.util;

public class MyUtil {



    public static String currentThread() {
        return Thread.currentThread().getName();
    }

    public static long getTimeTaken(long startTime) {
        return System.currentTimeMillis() - startTime;
    }
}
