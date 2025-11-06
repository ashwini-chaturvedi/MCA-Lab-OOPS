interface Shapes {
    double area();

    double perimeter();
}

class Circles implements Shapes {
    final double PI = 3.14;
    float radius;

    Circles(float radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return this.PI * this.radius * this.radius;
    }

    @Override
    public double perimeter() {
        return 2 * this.PI * this.radius;
    }
}

class Rectangles implements Shapes {
    int length;
    int breadth;
    Rectangles(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    public double area() {
        return this.length * this.breadth;
    }

    @Override
    public double perimeter() {
        return 2*(this.length + this.breadth);
    }
}

public class Que7 {
}
