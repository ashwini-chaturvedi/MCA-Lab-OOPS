package Lab2;

class BankAccount{
    public static int totalAccounts;
    static{
        totalAccounts=0;
        System.out.println("Static Block Executed");
    }

    BankAccount(){
        totalAccounts++;
    }

    public static void getTotalAccounts(){
        System.out.println("Total Accounts:"+totalAccounts);
    }
}
public class Que2 {
    public static void main(String[] args) {
        System.out.println("Initially:"+BankAccount.totalAccounts);
        BankAccount bankAccount1=new BankAccount();
        BankAccount bankAccount2=new BankAccount();
        BankAccount bankAccount3=new BankAccount();
        BankAccount bankAccount4=new BankAccount();
        BankAccount bankAccount5=new BankAccount();

        BankAccount.getTotalAccounts();
    }
}
