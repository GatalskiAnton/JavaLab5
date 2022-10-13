import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {

    Series(double firstElement, double step, double n) {
        this.firstElement = firstElement;
        this.step = step;
        this.n = n;
    }

    public abstract double getJElement(int j);

    public double sum() {
        double sum = 0;
        for (int i = 1; i <= n; ++i)
            sum += getJElement(i);
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; ++i)
            res.append(getJElement(i) + " ");
        return "[ " + res.toString() + "]";
    }

    public void writeToFile(String fileName, boolean append) {
        try (FileWriter out = new FileWriter(fileName, append)) {
            out.write(toString() + '\n');
        } catch (IOException e) {
            System.err.println("file does not exist");
        }
    }

    protected double firstElement;
    protected double n;
    protected double step;
}
