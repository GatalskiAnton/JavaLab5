import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        series = new Liner();

        setLayout(new GridLayout(4,2));
        add(new JLabel("firstElement"));
        JTextField firstElementField = new JTextField();
        add(firstElementField);

        add(new JLabel("step"));
        JTextField stepField = new JTextField();
        add(stepField);

        add(new JLabel("n"));
        JTextField nField = new JTextField();
        add(nField);

        JButton calculateButton = new JButton("calculate");
        add(calculateButton);

        JTextField resultField = new JTextField();
        add(resultField);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                series.setFirstElement(Double.parseDouble(firstElementField.getText()));
                series.setStep(Double.parseDouble(stepField.getText()));
                series.setN(Integer.parseInt(nField.getText()));

                resultField.setText("" +series.sum());
            }
        });
    }

    private Series series;
}
