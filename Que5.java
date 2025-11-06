abstract class Shape{
    String color;
    Shape(String color) {
        this.color = color;
    }
}
class Circle extends Shape{
    float radius;
    Circle(String color,float radius) {
        super(color);
        this.radius = radius;
    }
}
class Rectangle extends Shape{
    int length;
    int breadth;
    Rectangle(String color,int length,int breadth) {
        super(color);
        this.length = length;
        this.breadth = breadth;
    }
}

public class Que5 {
}
