import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarEntry;
import javax.swing.JFileChooser;
public class MyFrame extends JFrame {
    public MyFrame(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        series = new Liner();

        createMenu();
        createFrame();
    }

    private JPanel createTopPanel() {
        JPanel panel1 = new JPanel();
        panel1.setSize(100, 100);
        panel1.setPreferredSize(new Dimension(200, 50));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.add(linerButton);
        panel1.add(exponentialButton);

        JPanel panel2 = new JPanel();
        panel2.setSize(100, 100);
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel2.setMaximumSize(new Dimension(200, 50));

        JPanel firstElementPanel = new JPanel(new GridLayout(2, 1));
        firstElementPanel.add(new JLabel("first element"));
        firstElementPanel.add(firstElementField);
        panel2.add(firstElementPanel);

        panel2.add(Box.createHorizontalStrut(10));

        JPanel stepPanel = new JPanel(new GridLayout(2, 1));
        stepPanel.add(new JLabel("step"));
        stepPanel.add(stepField);
        panel2.add(stepPanel);

        panel2.add(Box.createHorizontalStrut(10));

        JPanel nPanel = new JPanel(new GridLayout(2, 1));
        nPanel.add(new JLabel("n"));
        nPanel.add(nField);
        panel2.add(nPanel);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(panel1);
        topPanel.add(panel2);
        return topPanel;
    }

    private JPanel createCentralPanel() {
        textArea = new JTextArea(23,43);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JPanel centralPanel = new JPanel();
        centralPanel.add(new JScrollPane(textArea));
        return centralPanel;
    }

    private JPanel createBottomPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(calculateButton);
        labelPanel.add(sumLabel);
        labelPanel.add(Box.createHorizontalStrut(10));
        labelPanel.add(lastElementLabel);
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(labelPanel);
        return bottomPanel;
    }

    private void createButton() {
        linerButton = new JRadioButton("Line", true);
        linerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                series = new Liner();
            }
        });
        exponentialButton = new JRadioButton("Exponential", false);
        exponentialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                series = new Exponential();
            }
        });
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(linerButton);
        radioGroup.add(exponentialButton);

        calculateButton = new JButton("calculate");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                series.setFirstElement(Double.parseDouble(firstElementField.getText()));
                series.setStep(Double.parseDouble(stepField.getText()));
                series.setN(Integer.parseInt(nField.getText()));

                textArea.setText(series.toString());

                sumLabel.setText("Sum - " + series.sum());
                lastElementLabel.setText("Last element - " + series.getJElement(series.getN()));
            }
        });
    }

    private void createTextField() {
        firstElementField = new JTextField();
        firstElementField.setColumns(10);
        stepField = new JTextField();
        stepField.setColumns(10);
        nField = new JTextField();
        nField.setColumns(10);
    }

    private void createFrame()
    {
        createButton();
        createTextField();
        createLabel();

        JPanel topPanel = createTopPanel();
        JPanel textArea = createCentralPanel();
        JPanel bottomPanel = createBottomPanel();

        this.setLayout(new BorderLayout());
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(textArea, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    private void createMenu()
    {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save as");
        JMenuItem clearItem = new JMenuItem("Clear");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setMultiSelectionEnabled(true);
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                file.setFileHidingEnabled(false);
                file.showOpenDialog(null);
                File f = file.getSelectedFile();
                try {
                    series.writeToFile(f, false);
                }catch (IOException err)
                {
                    System.err.println(err);
                }
            }
        });
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFrame();
            }
        });
        menu.add(saveItem);
        menu.add(clearItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void clearFrame()
    {
        series = null;
        textArea.setText(null);
        firstElementField.setText(null);
        stepField.setText(null);
        nField.setText(null);
        lastElementLabel.setText("Last element - ?");
        sumLabel.setText("Sum - ?");
    }

    private void createLabel()
    {
        lastElementLabel = new JLabel("Last element - ?" );
        sumLabel = new JLabel("Sum - ?");
    }
    JMenuBar menuBar;
    JMenu menu;
    private JRadioButton linerButton;
    private JRadioButton exponentialButton;
    private JTextField firstElementField;
    private JTextField stepField;
    private JTextField nField;
    private JButton calculateButton;
    private JTextArea textArea;
    private JLabel lastElementLabel;
    private JLabel sumLabel;
    private Series series;
}
