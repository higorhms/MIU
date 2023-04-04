package prog61address_form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {
    private JTextField nameField = new JTextField(12),
            stField = new JTextField(12),
            cityField = new JTextField(12),
            stateField = new JTextField(12),
            zipField = new JTextField(12);

    public MyFrame() {
        JPanel mainPanel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520,180);
        setResizable(false);
        setTitle("Lab6 - Address Form");
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(initTop(), BorderLayout.NORTH);
        mainPanel.add(initMiddle(), BorderLayout.CENTER);
        mainPanel.add(initBottom(), BorderLayout.SOUTH);
        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private JPanel initTop(){
        JPanel topPanel = new JPanel();
        topPanel.add(createBlock("Name", this.nameField));
        topPanel.add(createBlock("Street", this.stField));
        topPanel.add(createBlock("City", this.cityField));
        return topPanel;
    }

    private JPanel initMiddle(){
        JPanel middlePanel = new JPanel();
        middlePanel.add(createBlock("State", this.stateField));
        middlePanel.add(createBlock("Zip", this.zipField));
        return middlePanel;
    }

    private JPanel initBottom(){
        JPanel bottomPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener((e) -> buttonListener(e));
        bottomPanel.add(submitButton);
        return bottomPanel;
    }

    private JPanel createBlock(String labelName, JTextField field){
        JPanel blockPanel = new JPanel(new BorderLayout());
        JLabel blockLabel = new JLabel(labelName);
        blockPanel.add(field, BorderLayout.SOUTH);
        blockPanel.add(blockLabel, BorderLayout.NORTH);

        return blockPanel;
    }

    private void buttonListener(ActionEvent e){
        String output = String.format("%s\n%s\n%s, %s %s",
                this.nameField.getText(),
                this.stField.getText(),
                this.cityField.getText(),
                this.stateField.getText(),
                this.zipField.getText()
        );

        System.out.println(output);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
