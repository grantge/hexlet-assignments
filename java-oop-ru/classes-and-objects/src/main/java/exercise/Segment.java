package exercise;

// BEGIN
public class Segment {
    private Point start;
    private Point end;
    Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getBeginPoint() {
        return start;
    }

    public Point getEndPoint() {
        return end;
    }

    public Point getMidPoint() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }
}
// END
