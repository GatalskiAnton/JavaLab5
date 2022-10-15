public class Liner extends Series {

    Liner(double firstElement, double difference, int n) {
        super(firstElement, difference, n);
    }

    Liner()
    {
        super();
    }
    @Override
    public double getJElement(int j) {
        return firstElement + step * (j - 1);
    }
}

