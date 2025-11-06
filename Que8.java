interface Flying{
    void fly();
}
interface Swimming{
    void swim();

}

class Duck implements Flying,Swimming{
    @Override
    public void fly() {
        System.out.println("Duck flying");
    }
    @Override
    public void swim() {
        System.out.println("Duck swimming");
    }
}
public class Que8 {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
    }
}
