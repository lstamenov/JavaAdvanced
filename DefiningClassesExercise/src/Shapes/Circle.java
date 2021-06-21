package Shapes;

public class Circle implements Shape{
    float radius;

    Circle(float radius){
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (3.14 * Math.pow(radius, 2));
    }

    @Override
    public float getPerimeter() {
        float d = 2 * radius;
        return (float) (3.14 * d);
    }

    @Override
    public String toString() {
        return String.format("Circle = [radius: %.1f, area: %.2f, perimeter: %.2f]"
        , radius, getArea(), getPerimeter());
    }
}
