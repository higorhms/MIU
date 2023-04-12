package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel bottomPanel;

    private JPanel JSplitPane;

    public MainFrame(){
        this.mainPanel = new JPanel();
        setSize(600, 500);
        setResizable(true);
        setLayout(new CardLayout());
        setTitle("Book Club");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.add(initCenterPanel());
        mainPanel.add(initBottomPanel());

        getContentPane().add(this.mainPanel);
        setVisible(true);
    }

    private Component initCenterPanel() {
        String[] items = {"Login", "aaa"};
        JList myList = new JList(items);
        JSplitPane centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        centerPanel.setDividerLocation(80);
        centerPanel.add(myList);
        return centerPanel;
    }

    private JPanel initBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("aaaa"));

        return bottomPanel;
    }


}
