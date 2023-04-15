package librarysystem;

import business.SystemController;

import javax.swing.*;
import java.awt.*;

public class AddMemberWindow extends JFrame implements LibWindow {
    public static final AddMemberWindow INSTANCE = new AddMemberWindow();
    private boolean isInitialized = false;
    private JPanel mainPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel memberIdPanel = new JPanel();
    private JPanel streetPanel = new JPanel();
    private JPanel firstNamePanel = new JPanel();
    private JPanel cityPanel = new JPanel();
    private JPanel lastNamePanel = new JPanel();
    private JPanel statePanel = new JPanel();
    private JPanel phoneNumberPanel = new JPanel();
    private JPanel zipCodePanel = new JPanel();
    private JLabel memberId = new JLabel("Member Id");
    private JTextField memberIdField = new JTextField(10);
    private JLabel firstName = new JLabel("First Name");
    private JTextField firstNameField = new JTextField(10);
    private JLabel lastName = new JLabel("Last Name");
    private JTextField lastNameField = new JTextField(10);
    private JLabel street = new JLabel("Street");
    private JTextField streetField = new JTextField(10);
    private JLabel city = new JLabel("City");
    private JTextField cityField = new JTextField(10);
    private JLabel state = new JLabel("State");
    private JTextField stateField = new JTextField(10);
    private JLabel zipCode = new JLabel("ZipCode");
    private JTextField zipCodeField = new JTextField(10);
    private JLabel phoneNumber = new JLabel("Phone Number");
    private JTextField phoneNumberField = new JTextField(10);
    private JButton submitButton = new JButton("Submit");
    private JButton backButton = new JButton("<-");

    public boolean isInitialized() {
        return isInitialized;
    }

    public void isInitialized(boolean val) {
        isInitialized = val;
    }

    private AddMemberWindow() {
    }

    public void init() {
        setTitle("Add New Member");
        setSize(500, 500);
        defineForm();
        defineBottom();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);
        isInitialized(true);
    }


    private void defineBottom() {
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButton.addActionListener(e -> LibrarySystem.backToMain());
        bottomPanel.add(backButton);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        submitButton.addActionListener(e -> Submit());
        bottomPanel.add(submitButton);
    }

    private void defineForm() {
        createBlock(memberId, memberIdField, memberIdPanel);
        createBlock(firstName, firstNameField, firstNamePanel);
        createBlock(lastName, lastNameField, lastNamePanel);
        createBlock(phoneNumber, phoneNumberField, phoneNumberPanel);
        createBlock(street, streetField, streetPanel);
        createBlock(city, cityField, cityPanel);
        createBlock(state, stateField, statePanel);
        createBlock(zipCode, zipCodeField, zipCodePanel);

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(memberIdPanel);
        topPanel.add(firstNamePanel);
        topPanel.add(lastNamePanel);
        topPanel.add(phoneNumberPanel);
        topPanel.add(streetPanel);
        topPanel.add(cityPanel);
        topPanel.add(statePanel);
        topPanel.add(zipCodePanel);
    }

    private void createBlock(JLabel label, JTextField field, JPanel panel) {
        JPanel upPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        upPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        upPanel.add(label);
        bottomPanel.add(field);
        panel.setLayout(new BorderLayout());
        panel.add(upPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.CENTER);
    }

    public boolean hasEmptyFields() {
        if (
                memberIdField.getText().isBlank()
                        || firstNameField.getText().isBlank()
                        || firstNameField.getText().isBlank()
                        || phoneNumberField.getText().isBlank()
                        || streetField.getText().isBlank()
                        || cityField.getText().isBlank()
                        || stateField.getText().isBlank()
                        || zipCodeField.getText().isBlank()
        ) {
            return true;
        }

        return false;
    }

    private void Submit() {
        if (hasEmptyFields()) {
            JOptionPane.showMessageDialog(submitButton, "You have to fill all the fields");
        } else {
            SystemController.getInstance().addNewMember(
                    memberIdField.getText(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    phoneNumberField.getText(),
                    streetField.getText(),
                    cityField.getText(),
                    stateField.getText(),
                    zipCodeField.getText()
            );

            JOptionPane.showMessageDialog(submitButton, "Member created");
            resetFields();
        }
    }

    public void resetFields() {
        memberIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        phoneNumberField.setText("");
        streetField.setText("");
        cityField.setText("");
        stateField.setText("");
        zipCodeField.setText("");
    }
}
