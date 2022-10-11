import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    public abstract double getJElement(int j);

    public double sum(int n)
    {
        double sum = 0;
        for (int i = 1; i < n + 1; ++i)
            sum += getJElement(i);
        return sum;
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < 10; ++i)
            res.append(getJElement(i) + " ");
        return "[ " + res.toString() + "... ]";
    }

    public void writeToFile(String fileName, boolean append)
    {
        try {
            FileWriter out = new FileWriter(fileName,append);
            out.write(toString() + '\n');
            out.close();
        }catch (IOException e)
        {
            System.err.println("file does not exist");
        }
    }
}
