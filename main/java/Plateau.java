
public class Plateau {

    public final int horizontalBoundary;
    public final int verticalBoundary;

    public Plateau(int horizontalBoundary, int verticalBoundary) {

        if(horizontalBoundary <= 0) {
            throw new IllegalArgumentException("Horizontal Boundary must be grater than 0");
        }

        if(verticalBoundary <= 0) {
            throw new IllegalArgumentException("Vertical Boundary must be grater than 0");
        }

        this.horizontalBoundary = horizontalBoundary;
        this.verticalBoundary = verticalBoundary;
    }
}
