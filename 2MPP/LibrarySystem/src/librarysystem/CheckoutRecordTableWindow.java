package librarysystem;

import business.CheckoutRecord;
import business.CheckoutRecordEntry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class CheckoutRecordTableWindow extends JFrame implements LibWindow {
    public static final CheckoutRecordTableWindow INSTANCE = new CheckoutRecordTableWindow();
    private boolean isInitialized = false;
    private JPanel contentPane = new JPanel();
    private String[] headers = new String[]{"ISBN", "Title", "Checkout Date", "Due date", "Member Id"};
    private JTable table;
    private JLabel lblNewLabel = new JLabel("CHECKOUTS");
    private JScrollPane scrollPane = new JScrollPane();

    private CheckoutRecordTableWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane.setBounds(10, 45, 424, 205);
        contentPane.add(scrollPane);
        table = new JTable(new DefaultTableModel(headers, CheckoutRecord.entries.size()));
        scrollPane.setViewportView(table);

        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(134, 11, 180, 23);
        contentPane.add(lblNewLabel);

        startHeaders();
        startTable();
        init();
    }

    @Override
    public void init() {
        isInitialized = true;
    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    @Override
    public void isInitialized(boolean val) {
        isInitialized = val;
    }

    private void startHeaders() {
        for (int i = 0; i < headers.length; i++) {
            TableColumn column = new TableColumn(i);
            column.setHeaderValue(headers[i]);
        }
    }

    private void startTable() {
        if (CheckoutRecord.entries.size() > 0) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.setRowCount(0);

            for (int index = 0; index < CheckoutRecord.entries.size(); index++) {
                CheckoutRecordEntry currentCheckoutEntry = CheckoutRecord.entries.get(index);
                String row[] = {
                        currentCheckoutEntry.getISBN(),
                        currentCheckoutEntry.getBookTitle(),
                        currentCheckoutEntry.getCheckoutDate().toString(),
                        currentCheckoutEntry.getCheckoutDate().toString(),
                        currentCheckoutEntry.getMemberId()
                };
                model.addRow(row);
            }

        }
    }
}
