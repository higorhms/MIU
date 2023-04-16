package librarysystem;

import business.Book;
import business.SystemController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CheckoutBookWindow extends JFrame implements LibWindow {
    public static final CheckoutBookWindow INSTANCE = new CheckoutBookWindow();
    private JPanel contentPane = new JPanel();
    private JTextField memberIdField = new JTextField();
    private JTextField isbnBookField = new JTextField();
    private JLabel memberIdLabel = new JLabel("Member Id");
    private JButton showRecordButton = new JButton("Show Records");
    private JButton checkAvailabilityButton = new JButton("Check Availability");
    private JButton checkoutButton = new JButton("Checkout");
    private JButton resetButton = new JButton("Reset");
    private JLabel bookAvailabilityLabel = new JLabel("");
    private JLabel bookIdLabel = new JLabel("");
    private JLabel bookISBNLabel = new JLabel("Book ISBN number");

    public CheckoutBookWindow() {
        setForeground(Color.CYAN);
        setTitle("Data checking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 527, 289);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        memberIdLabel.setBounds(27, 24, 87, 40);
        bookIdLabel.setBounds(268, 34, 188, 14);
        memberIdField.setBounds(134, 34, 124, 20);
        bookISBNLabel.setBounds(27, 75, 108, 20);
        isbnBookField.setBounds(134, 75, 124, 20);
        bookAvailabilityLabel.setBounds(268, 75, 188, 14);
        checkAvailabilityButton.setBounds(268, 151, 135, 23);
        resetButton.setBounds(134, 151, 89, 23);
        checkoutButton.setBounds(206, 185, 124, 23);
        showRecordButton.setBounds(206, 216, 124, 23);

        memberIdField.setColumns(10);
        isbnBookField.setColumns(10);

        //listeners
        memberIdField.addFocusListener(new MemberIdFieldListener());
        resetButton.addActionListener(e -> resetFields());
        isbnBookField.addFocusListener(new ISBFieldListener());
        checkoutButton.addActionListener(e -> checkoutBook());
        showRecordButton.addActionListener(e -> showCheckoutRecordTable());

        contentPane.add(checkAvailabilityButton);
        contentPane.add(checkoutButton);
        contentPane.add(showRecordButton);
        contentPane.add(resetButton);
        contentPane.add(bookAvailabilityLabel);
        contentPane.add(isbnBookField);
        contentPane.add(bookISBNLabel);
        contentPane.add(memberIdField);
        contentPane.add(bookIdLabel);
        contentPane.add(memberIdLabel);
    }

    private void checkoutBook() {
        try{
            SystemController.getInstance().checkoutBook(memberIdField.getText(), isbnBookField.getText());
            JOptionPane.showMessageDialog(checkoutButton, "Record created!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(checkoutButton, e.getMessage());
        }
    }

    private void showCheckoutRecordTable() {
        CheckoutRecordTableWindow window = CheckoutRecordTableWindow.INSTANCE;
        window.setVisible(true);
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isInitialized() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void isInitialized(boolean val) {
        // TODO Auto-generated method stub

    }

    private void resetFields() {
        isbnBookField.setText("");
        bookAvailabilityLabel.setText("");
        memberIdField.setText("");
        bookIdLabel.setText("");
    }

    class ISBFieldListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            isbnBookField.setText("");
            bookAvailabilityLabel.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
            Book foundedBook = SystemController.getInstance().getBook(isbnBookField.getText());
            if (foundedBook != null) {
                if (!foundedBook.isAvailable())
                    bookAvailabilityLabel.setText("This Book is not available");
            } else bookAvailabilityLabel.setText("Book not found");
        }
    }

    class MemberIdFieldListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            memberIdField.setText("");
            bookIdLabel.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (!SystemController.getInstance().isAValidMember(memberIdField.getText()))
                bookIdLabel.setText("Member ID not found");
        }
    }
}
