public class Point {
    int x;
    int y;

    Point(int i, int j) {
        this.x = i;
        this.y = j;
    }

    /**
     * getter for the x point
     */
    public int getX() {
        return x;
    }
    /**
     * getter for the y point
     */
    public int getY() {
        return y;
    }

    /**
     * distance return the distance from the origin to the point 
     * @return double distance to the user
     */
    public double distance() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
