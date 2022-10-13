public class Main {
    public static void main(String[] args) {
        Liner l1 = new Liner(1, 2, 15);
        l1.writeToFile("output.txt", false);
        System.out.println(l1.sum());
        Exponential e1 = new Exponential(2, 2, 13);
        e1.writeToFile("output.txt", true);
        System.out.println(e1.sum());
    }
}
