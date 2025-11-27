package Lab6;

public class Que5 {
    public static void methodA() {
        try {
            System.out.println("Inside methodA");
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in methodA: " + e);
        }
        System.out.println("methodA ends");
    }

    public static void methodB() {
        System.out.println("Inside methodB");
        methodC();
        System.out.println("methodB ends");
    }
    public static void methodC() {
        System.out.println("Inside methodC");
        int x = 10 / 0;
        System.out.println("methodC ends");
    }


    public static void main(String[] args) {
        methodA();
        System.out.println("Program continues after handling exception.");
    }
}


