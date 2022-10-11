public class Exponential extends Series {
    Exponential(double b1, double q) {
        this.b1 = b1;
        this.q = q;
    }

    @Override
    public double getJElement(int j) {
        return b1 * Math.pow(q, j - 1);
    }

    private double b1;
    private double q;
}
