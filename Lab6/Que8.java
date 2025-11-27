package Lab6;

public class Que8 {
    public static void main(String[] args) {

        try {
            System.out.println("Outer try block starts.");

            String num = "abc";
            int value = Integer.parseInt(num);

            System.out.println("Parsed number: " + value);


            try {
                System.out.println("Inner try block starts.");

                int result = value / 0;
                System.out.println("Result: " + result);

                System.out.println("Inner try block ends.");

            } catch (ArithmeticException e) {
                System.out.println("Caught inside inner catch: " + e);
            }

            System.out.println("Outer try block continues after inner try-catch.");

        } catch (NumberFormatException e) {
            System.out.println("Caught in outer catch: " + e);
        }

        System.out.println("Program continues after outer try-catch.");
    }
}
