package librarysystem;

import business.Book;
import business.ControllerInterface;
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
    private JTextField bookISBNFIeld = new JTextField();
    private JLabel memberIdLabel = new JLabel("Member Id");
    private JButton showRecordButton = new JButton("show records");
    private JButton checkAvailabilityButton = new JButton("Check availability");
    private JButton checkoutButton = new JButton("Checkout");
    JButton resetButton = new JButton("Reset");
    JLabel bookAvailabilityLabel = new JLabel("");
    JLabel bookIdLabel = new JLabel("");

    public CheckoutBookWindow() {
        setForeground(Color.CYAN);
        setTitle("Data checking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 527, 289);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        memberIdLabel.setBounds(27, 24, 87, 40);
        contentPane.add(memberIdLabel);

        bookIdLabel.setBounds(268, 34, 188, 14);
        contentPane.add(bookIdLabel);

        memberIdField.addFocusListener(new MemberIdFieldListener());

        memberIdField.setBounds(134, 34, 124, 20);
        contentPane.add(memberIdField);
        memberIdField.setColumns(10);

        JLabel lblBookISBN = new JLabel("Book ISBN number");
        lblBookISBN.setBounds(27, 75, 108, 20);
        contentPane.add(lblBookISBN);

        bookISBNFIeld.setBounds(134, 75, 124, 20);
        contentPane.add(bookISBNFIeld);
        bookISBNFIeld.setColumns(10);

        bookAvailabilityLabel.setBounds(268, 75, 188, 14);
        contentPane.add(bookAvailabilityLabel);

        bookISBNFIeld.addFocusListener(new ISBFieldListener());

        checkAvailabilityButton.setBounds(268, 151, 135, 23);
        contentPane.add(checkAvailabilityButton);

        resetButton.addActionListener(e -> resetFields());
        resetButton.setBounds(134, 151, 89, 23);
        contentPane.add(resetButton);
        checkoutButton.addActionListener(e -> checkoutBook());
        checkoutButton.setBounds(206, 185, 124, 23);
        contentPane.add(checkoutButton);

        showRecordButton.addActionListener(e -> showCheckoutRecordTable());
        showRecordButton.setBounds(206, 216, 124, 23);
        contentPane.add(showRecordButton);
    }

    private void checkoutBook() {
        SystemController.getInstance().checkoutBook(memberIdField.getText(), bookISBNFIeld.getText());
        JOptionPane.showMessageDialog(checkoutButton, "Record created!");
    }

    private void showCheckoutRecordTable() {
        CheckoutRecordTableWindow window = new CheckoutRecordTableWindow();
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
        bookISBNFIeld.setText("");
        bookAvailabilityLabel.setText("");
        memberIdField.setText("");
        bookIdLabel.setText("");
    }

    class ISBFieldListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // TODO Auto-generated method stub
            bookISBNFIeld.setText("");
            bookAvailabilityLabel.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
            ControllerInterface controller = SystemController.getInstance();
            Book foundedBook = controller.getBook(bookISBNFIeld.getText());
            if (foundedBook != null) {
                if (!foundedBook.isAvailable()) {
                    bookAvailabilityLabel.setText("This Book is not available");
                } else {
                    bookAvailabilityLabel.setText("This Book is available");
                }
            } else bookAvailabilityLabel.setText("The Book isn't found");
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
            if (SystemController.getInstance().isAValidMember(memberIdField.getText()))
                bookIdLabel.setText("The Id is found");
            else bookIdLabel.setText("The Id isn't found");
        }
    }
}
