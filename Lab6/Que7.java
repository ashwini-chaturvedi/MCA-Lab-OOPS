package Lab6;

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

public class Que7 {

    public static void validatePassword(String password) throws WeakPasswordException {
        if (password.length() < 8) {
            throw new WeakPasswordException("Password is too weak! Minimum 8 characters required.");
        }
        System.out.println("Password is valid!");
    }

    // Main method for testing
    public static void main(String[] args) {
        String pass1 = "abc123";
        String pass2 = "StrongPass1";

        try {
            System.out.println("Validating: " + pass1);
            validatePassword(pass1);
        } catch (WeakPasswordException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println();

        try {
            System.out.println("Validating: " + pass2);
            validatePassword(pass2);
        } catch (WeakPasswordException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }


}
