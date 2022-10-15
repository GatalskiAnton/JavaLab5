public class Exponential extends Series {

    Exponential(double firstElement, double difference, int n) {
        super(firstElement, difference, n);
    }

    Exponential(){super();};
    @Override
    public double getJElement(int j) {
        return firstElement * Math.pow(step, j - 1);
    }
}
