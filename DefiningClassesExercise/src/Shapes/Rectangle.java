package Shapes;

public class Rectangle implements Shape{
    float length;
    float width;

    Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }

    @Override
    public float getArea() {
        return length * width;
    }

    @Override
    public float getPerimeter() {
        return 2 * length + 2 * width;
    }

    @Override
    public String toString() {
        return String.format("Rectangle = [length: %.1f, width: %.1f, area: %.1f, perimeter: %.1f]",
                length, width, getArea(), getPerimeter());
    }
}
