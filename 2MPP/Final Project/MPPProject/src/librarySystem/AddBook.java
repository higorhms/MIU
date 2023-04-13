package librarySystem;

import business.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddBook extends JFrame implements LibWindow {
    public static final AddBook INSTANCE = new AddBook();
    IController ci = new SystemController();
    JTextField txtISBN, txtTitle, txtCheckoutLength, txtCopyNumber;
    JComboBox<Author> cmbAuthors;
    List<Author> authors = new ArrayList<>();
    DefaultListModel<Author> listModel = new DefaultListModel<Author>();
    JList<Author> lstAuthors;
    List<BookCopy> lstBookCopies = new ArrayList<>();
    DefaultListModel<String> modelBookCopies = new DefaultListModel<String>();
    JList<String> bookCopies;
    JTable jt;

    private AddBook() {
    }

    @Override
    public void init() {

        JPanel panelbookFields = new JPanel();
        panelbookFields.setLayout(null);

        JLabel lblISBN = new JLabel("ISBN");
        lblISBN.setBounds(20, 20, 100, 20);

        txtISBN = new JTextField(10);
        txtISBN.setBounds(130, 20, 100, 20);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(20, 50, 100, 20);

        txtTitle = new JTextField(10);
        txtTitle.setBounds(130, 50, 100, 20);

        JLabel lblCheckOutLenght = new JLabel("Checkout Lenght");
        lblCheckOutLenght.setBounds(20, 80, 100, 20);

        txtCheckoutLength = new JTextField(10);
        txtCheckoutLength.setBounds(130, 80, 100, 20);


        JLabel lblAuthors = new JLabel("Book Authors");
        lblAuthors.setBounds(20, 110, 100, 20);

        lstAuthors = new JList<>();

        lstAuthors.setModel(listModel);
        lstAuthors.setBounds(130, 110, 150, 80);

        cmbAuthors = new JComboBox<Author>();
        cmbAuthors.setBounds(130, 200, 110, 20);

        List<Author> dbAuthors = ci.getAllAuthors();
        for (Author a : dbAuthors) {
            cmbAuthors.addItem(a);
        }

        cmbAuthors.setRenderer(new AuthorRenderer());

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(250, 200, 30, 20);
        addOkButtonListener(btnOk);

        JLabel lblBookCopy = new JLabel("Book Copies");
        lblBookCopy.setBounds(20, 230, 100, 20);

        bookCopies = new JList<String>();
        bookCopies.setModel(modelBookCopies);
        bookCopies.setBounds(130, 230, 150, 80);

        txtCopyNumber = new JTextField();
        txtCopyNumber.setBounds(130, 320, 60, 20);
        JButton btnCreateCopy = new JButton("Create");
        btnCreateCopy.setBounds(200, 320, 80, 20);
        createCopyListener(btnCreateCopy);


        JButton btnBackToMain = new JButton("<< Back to Main");
        addBackButtonListener(btnBackToMain);

        JButton btnSave = new JButton("Save Book");
        addBtnSaveListener(btnSave);

        JPanel pnlButtonSave = new JPanel();
        pnlButtonSave.add(btnBackToMain);
        pnlButtonSave.add(btnSave);
        pnlButtonSave.setBounds(20, 370, 670, 35);
        pnlButtonSave.setBackground(Color.green);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ISBN");
        model.addColumn("Copy Number");
        model.addColumn("Book Title");
        model.addColumn("Availability");

        jt = new JTable(model);

        jt.getColumnModel().getColumn(0).setPreferredWidth(20);
        jt.getColumnModel().getColumn(1).setPreferredWidth(27);
        jt.getColumnModel().getColumn(3).setPreferredWidth(70);
        jt.getColumnModel().getColumn(3).setPreferredWidth(22);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(310, 20, 375, 340);
        panelbookFields.add(sp);

        List<Book> data = ci.getAllBooks();

        for (Book lm : data) {
            String isbn = lm.getIsbn();
            String title = lm.getTitle();

            for (BookCopy bc : lm.getCopies()) {
                model.addRow(new Object[]{isbn, bc.getCopyNum(), title, bc.isAvailable()});
            }
        }

        panelbookFields.add(lblISBN);
        panelbookFields.add(txtISBN);

        panelbookFields.add(lblTitle);
        panelbookFields.add(txtTitle);

        panelbookFields.add(lblCheckOutLenght);
        panelbookFields.add(txtCheckoutLength);

        panelbookFields.add(lblAuthors);
        panelbookFields.add(lstAuthors);

        panelbookFields.add(cmbAuthors);

        panelbookFields.add(btnOk);

        panelbookFields.add(lblBookCopy);
        panelbookFields.add(bookCopies);

        panelbookFields.add(txtCopyNumber);
        panelbookFields.add(btnCreateCopy);

        panelbookFields.add(pnlButtonSave, BorderLayout.CENTER);

        this.setTitle("Add Library Book");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 460);
        this.setVisible(true);
        this.add(panelbookFields);
    }

    @Override
    public boolean isInitialized() {
        return false;
    }

    @Override
    public void isInitialized(boolean val) {

    }

    private void addBackButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            LibrarySystem.hideAllWindows();
            LibrarySystem.INSTANCE.setVisible(true);
        });
    }

    private void addOkButtonListener(JButton button) {
        button.addActionListener(evt -> {

            authors.add((Author) cmbAuthors.getSelectedItem());
            listModel.addElement((Author) cmbAuthors.getSelectedItem());
            lstAuthors.setCellRenderer(new AuthorRenderer());

        });
    }

    private void createCopyListener(JButton butn) {
        butn.addActionListener(evt -> {
            modelBookCopies.addElement(txtCopyNumber.getText().trim());
            txtCopyNumber.setText("");
        });
    }

    private void addBtnSaveListener(JButton butn) {
        butn.addActionListener(evt -> {
            if (txtISBN.getText().equals("") || txtTitle.getText().equals("") || txtCheckoutLength.getText().equals("") ||
                    listModel.size() == 0 || modelBookCopies.size() == 0) {
                JOptionPane.showMessageDialog(this, "Fields can not be left blank", "Required fields can not be empty", JOptionPane.ERROR_MESSAGE);
            }
            try {
                ci.addBook(txtISBN.getText().trim(), txtTitle.getText().trim(), Integer.parseInt(txtCheckoutLength.getText().trim()), authors);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Save Failed", JOptionPane.ERROR_MESSAGE);
            }

            DefaultTableModel model = (DefaultTableModel) jt.getModel();
            model.setRowCount(0);
            List<Book> dataa = ci.getAllBooks();

            for (Book lm : dataa) {
                String isbn = lm.getIsbn();
                String title = lm.getTitle();

                for (BookCopy bc : lm.getCopies()) {
                    model.addRow(new Object[]{isbn, bc.getCopyNum(), title, bc.isAvailable()});
                }
            }

            JOptionPane.showMessageDialog(this, "Save successful");
            authors.clear();
            txtISBN.setText("");
            txtTitle.setText("");
            txtCheckoutLength.setText("");
            listModel.clear();
            modelBookCopies.clear();
        });
    }

    public class AuthorRenderer extends JLabel implements ListCellRenderer<Author> {
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Author> list,
                Author author,
                int index,
                boolean isSelected, boolean cellHasFocus
        ) {
            setText(author.getFirstName() + " " + author.getLastName());

            return this;
        }
    }

}
