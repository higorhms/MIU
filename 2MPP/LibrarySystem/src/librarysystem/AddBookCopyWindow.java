package librarysystem;

import business.Book;
import business.ControllerInterface;
import business.SystemController;

import javax.swing.*;
import java.awt.*;

public class AddBookCopyWindow extends JFrame {
    public static final AddBookCopyWindow INSTANCE = new AddBookCopyWindow();
    private boolean isInitialized = false;
    private JPanel mainPanel;
    private JPanel upperHalf;
    private JPanel middleHalf;
    private JPanel lowerHalf;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel lowerPanel;
    private JPanel leftTextPanel;
    private JTextField  isbnText;
    private JLabel isbn;
    private JButton addButton;

    public void isInitialized(boolean val) {
        isInitialized = val;
    }
    private JTextField messageBar = new JTextField();
    private AddBookCopyWindow () {}

    public void init() {
        mainPanel = new JPanel();
        defineUpperHalf();
        defineMiddleHalf();
        defineLowerHalf();
        BorderLayout bl = new BorderLayout();
        bl.setVgap(30);
        mainPanel.setLayout(bl);

        mainPanel.add(upperHalf, BorderLayout.NORTH);
        mainPanel.add(middleHalf, BorderLayout.CENTER);
        mainPanel.add(lowerHalf, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);
        isInitialized(true);
        pack();
    }
    private void defineUpperHalf() {

        upperHalf = new JPanel();
        upperHalf.setLayout(new BorderLayout());
        defineTopPanel();
        defineMiddlePanel();
        defineLowerPanel();
        upperHalf.add(topPanel, BorderLayout.NORTH);
        upperHalf.add(middlePanel, BorderLayout.CENTER);
        upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    }

    private void defineMiddleHalf() {
        middleHalf = new JPanel();
        middleHalf.setLayout(new BorderLayout());
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        middleHalf.add(s, BorderLayout.SOUTH);
    }

    private void defineLowerHalf() {
        lowerHalf = new JPanel();
        lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("<= Back to Main");
        addBackButtonListener(backButton);
        lowerHalf.add(backButton);
    }

    private void defineTopPanel() {
        topPanel = new JPanel();
        JPanel intPanel = new JPanel(new BorderLayout());
        intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
        JLabel isbnLabel = new JLabel("Add Book Copy");
        Util.adjustLabelFont(isbnLabel, Color.BLUE.darker(), true);
        intPanel.add(isbnLabel, BorderLayout.CENTER);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(intPanel);
    }

    private void defineMiddlePanel() {
        middlePanel=new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        defineLeftTextPanel();
        middlePanel.add(leftTextPanel);
    }

    private void defineLowerPanel() {
        lowerPanel = new JPanel();
        addButton = new JButton("add");
        addButtonListener(addButton);
        lowerPanel.add(addButton);
    }

    private void defineLeftTextPanel() {
        JPanel topText = new JPanel();
        JPanel bottomText = new JPanel();
        topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
        bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));

        isbnText = new JTextField(10);
        isbn = new JLabel("isbn");
        isbn.setFont(Util.makeSmallFont(isbn.getFont()));
        topText.add(isbn);
        bottomText.add(isbnText);

        leftTextPanel = new JPanel();
        leftTextPanel.setLayout(new BorderLayout());
        leftTextPanel.add(topText,BorderLayout.NORTH);
        leftTextPanel.add(bottomText,BorderLayout.CENTER);
    }

    private void addBackButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            LibrarySystem.hideAllWindows();
            LibrarySystem.INSTANCE.setVisible(true);
        });
    }

    private void addButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            ControllerInterface ci = SystemController.getInstance();
            Book book = ci.addNewBookCopy(isbnText.getText());
            if (book != null){
                JOptionPane.showMessageDialog(butn, "The copy added successfully");
            }else
                JOptionPane.showMessageDialog(butn, "The book not found");
        });
    }
}
