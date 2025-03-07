class Area{
  private static double pi =3.14;
    public static void main(String[] args) {
    System.out.println("My name is Kanishk Pamecha ");

    }
   protected double Triangle(int height , int base)throws ArithmeticException
    { if(height<=0 || base<=0) throw new ArithmeticException("Arithmetic error");
         return 0.5*base*height;

    }
    protected double Rectangle(int height , int width)throws ArithmeticException
    {
        if(height<=0 || width<=0) throw new ArithmeticException("Arithmetic error");
        return height *width;
    }
   protected double Square(int side)throws ArithmeticException{
    if(side<=0) throw new ArithmeticException("Arithmetic error");  
    return side*side;
    }
   protected double Circle(int radius) throws ArithmeticException
    {
        if(radius<=0) throw new ArithmeticException("Arithmetic error");
        return pi*radius*radius;
    }
}