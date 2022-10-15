import javax.swing.JFrame;
import java.awt.*;

public class GUIMain {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Simple Swing");
        frame.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - frame.getWidth() / 2, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - frame.getHeight() / 2);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
