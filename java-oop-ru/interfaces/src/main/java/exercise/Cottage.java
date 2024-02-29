package exercise;

// BEGIN
public class Cottage implements Home {

    private double area;

    private int floorCount;

    Cottage(double area, int floorCount ) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return area;
    }

    public String toString() {

        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

    public int compareTo(Home another) {
        return getArea() > another.getArea() ? 1 : -1;

    }


}
// END
