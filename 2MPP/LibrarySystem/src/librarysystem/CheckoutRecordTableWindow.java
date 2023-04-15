package librarysystem;

import business.CheckoutRecord;
import business.CheckoutRecordEntry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class CheckoutRecordTableWindow extends JFrame {
    private JPanel contentPane = new JPanel();
    private String[] headers = new String[]{"ISBN", "Title", "Checkout Date", "Due date", "Member Id"};
    private JTable table;
    JLabel lblNewLabel = new JLabel("CHECKOUTS");
    JScrollPane scrollPane = new JScrollPane();

    public CheckoutRecordTableWindow() {
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckoutRecordTableWindow frame = new CheckoutRecordTableWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
