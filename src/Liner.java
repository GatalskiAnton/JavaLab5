public class Liner extends Series{

    Liner(double a1, double d)
    {
        this.d = d;
        this.a1 = a1;
    }
    @Override
    public double getJElement(int j) {
        return a1 + d*(j - 1);
    }
   private double d;
   private double a1;
}
