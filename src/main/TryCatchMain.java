package src.main;

public class TryCatchMain {

    public static void main(String[] args) {


        int i=0,j=10;

        try{
            System.out.println("i/j = "+ (j/i));
        }catch (ArithmeticException ae){
            System.out.println(ae.getLocalizedMessage());
            throw new RuntimeException("Trying to divide by Zero");
        }finally {
            System.out.println("Finally block executed");
        }

    }
}
