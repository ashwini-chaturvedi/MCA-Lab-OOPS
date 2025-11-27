package Lab6;

import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Que2 {
    public static void main(String[] args) throws InvalidAgeException {
        Scanner sc = new Scanner(System.in);

        int age = sc.nextInt();
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid Age");

        }

    }
}
