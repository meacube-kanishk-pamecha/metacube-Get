class Area {
    private static double pi = 3.14;
   
    /**
     *  triangle  area of the triangle
     * @param int height non zero and positive value height of the triangle
     * @param int base non zero and positive base of the triangle 
     * @return double value of the area of the trianglr 
     * @throws ArithmeticException if height or base is zero 
     */
    protected double triangle(int height, int base) throws ArithmeticException {
        if (height <= 0 || base <= 0)
            throw new ArithmeticException("Arithmetic error"); // throwing Arithmetic Exception if height or width is 0.
        return 0.5 * base * height; // returning the area of the triangle.

    }
 
    /**
     * rectangle area of the rectangle
     * @param int  height positive value height of the rectangle
     * @param int  width positive value width of the rectangle
     * @return double area of the rectangle
     * @throws ArithmeticException if height or width is zero
     */
    protected double rectangle(int height, int width) throws ArithmeticException {
        if (height <= 0 || width <= 0)
            throw new ArithmeticException("Arithmetic error"); // throws exception
        return height * width; // returning area 
    }

    /**
     * square area of the square 
     * @param int side non zero and non negative side of the square 
     * @return double area of the square 
     * @throws ArithmeticException if side is zero
     */
    protected double square(int side) throws ArithmeticException {
        if (side <= 0)
            throw new ArithmeticException("Arithmetic error"); // throws exception
        return side * side; // returning area 
    }

    /**
     * circle areanof the circle 
     * @param int radius non zero and non negative radius of the circle 
     * @return double area of the circle
     * @throws ArithmeticException if radius is zero 
     */
    protected double circle(int radius) throws ArithmeticException {
        if (radius <= 0)
            throw new ArithmeticException("Arithmetic error");// throws exception if radius is zero o
        return pi * radius * radius; // returning area 
    }
}