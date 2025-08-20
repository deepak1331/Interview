package src.Mutlithreading.synchronize;

public class DataHolder {

    private int data;

    public int getData() {
        return data;
    }

    public void increment() {
        synchronized (this) {
            data++;
        }
    }
}
