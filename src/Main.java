import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Liner l1 = new Liner(1, 2, 15);
        System.out.println(l1.sum());
        Exponential e1 = new Exponential(2, 2, 13);
        System.out.println(e1.sum());
        try {
            l1.writeToFile("output.txt", false);
            e1.writeToFile("output.txt", true);
        }
        catch (IOException e){
            System.out.println("file doesn`t exist");
        }
    }
}
