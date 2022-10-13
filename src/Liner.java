public class Liner extends Series {

    Liner(double firstElement, double difference, double n) {
        super(firstElement, difference, n);
    }

    @Override
    public double getJElement(int j) {
        return firstElement + step * (j - 1);
    }
}

