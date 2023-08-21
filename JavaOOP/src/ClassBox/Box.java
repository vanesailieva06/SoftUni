package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (isItNotValid(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (isItNotValid(width)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (isItNotValid(height)) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    //surface area -> 2lw+2lh+2hw
    //lateral surface area -> 2lh + 2wh
    //volume ->  multiplying length x width x height.
    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * height * width;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        return length * height * width;
    }

    private boolean isItNotValid(double parameter) {
        return parameter <= 0;
    }
}
