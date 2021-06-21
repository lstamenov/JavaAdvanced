package Shapes;

public class Square extends Rectangle{

    Square(float side) {
        super(side, side);
    }

    @Override
    public float getArea() {
        return super.getArea();
    }

    @Override
    public float getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return String.format("Square = [side: %.1f, area: %.1f, perimeter: %.1f]",
                length, getArea(), getPerimeter());
    }
}
