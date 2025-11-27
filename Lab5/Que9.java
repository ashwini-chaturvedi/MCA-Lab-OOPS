package Lab5;

interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Credit card payment"+amount);
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paypal payment "+amount);
    }
}

class OnlineStore{
    OnlineStore(PaymentMethod paymentMethod) {
        paymentMethod.pay(10);
    }

}

public class Que9 {
}
