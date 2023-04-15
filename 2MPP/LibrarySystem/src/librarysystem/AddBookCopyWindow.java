package librarysystem;

import business.Book;
import business.SystemController;

import javax.swing.*;
import java.awt.*;

public class AddBookCopyWindow extends JFrame implements LibWindow{
    public static final AddBookCopyWindow INSTANCE = new AddBookCopyWindow();
    private boolean isInitialized = false;
    private JPanel mainPanel = new JPanel();
    private JPanel upperHalf = new JPanel();
    private JPanel middleHalf = new JPanel();
    private JPanel lowerHalf = new JPanel();
    private JPanel middlePanel = new JPanel();
    private JPanel isbnTextPanel = new JPanel();
    private JTextField isbnField = new JTextField(10);
    private JLabel isbnLabel = new JLabel("ISBN");
    private JButton submitButton = new JButton("Add");

    private AddBookCopyWindow() {
        isInitialized(true);
    }

    public void init() {
        setTitle("Add Book Copy");

        defineTop();
        defineMiddle();
        defineBottom();

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(upperHalf, BorderLayout.NORTH);
        mainPanel.add(middleHalf, BorderLayout.CENTER);
        mainPanel.add(lowerHalf, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        pack();
    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    @Override
    public void isInitialized(boolean val) {
        isInitialized = val;
    }

    private void defineTop() {
        upperHalf.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(isbnLabel);
        bottomPanel.add(isbnField);
        isbnTextPanel.setLayout(new BorderLayout());
        isbnTextPanel.add(topPanel, BorderLayout.CENTER);
        isbnTextPanel.add(bottomPanel, BorderLayout.SOUTH);
        middlePanel.add(isbnTextPanel);

        submitButton.addActionListener(e -> submit());
        bottomPanel.add(submitButton);
        upperHalf.add(topPanel, BorderLayout.NORTH);
        upperHalf.add(middlePanel, BorderLayout.CENTER);
        upperHalf.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void defineMiddle(){
        middleHalf.setLayout(new BorderLayout());
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        middleHalf.add(s, BorderLayout.SOUTH);
    }

    private void defineBottom() {
        lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("<-");
        backButton.addActionListener(e -> LibrarySystem.backToMain());
        lowerHalf.add(backButton);
    }

    private void submit() {
        Book book = SystemController.getInstance().addNewBookCopy(isbnField.getText());
        if (book != null) {
            JOptionPane.showMessageDialog(submitButton, "Success");
        } else
            JOptionPane.showMessageDialog(submitButton, "Fail");
    }
}
