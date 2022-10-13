public class Exponential extends Series {

    Exponential(double firstElement, double difference, double n) {
        super(firstElement, difference, n);
    }

    @Override
    public double getJElement(int j) {
        return firstElement * Math.pow(step, j - 1);
    }
}
