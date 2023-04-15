package librarysystem;

import business.Address;
import business.ControllerInterface;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMemberWindow extends JFrame implements LibWindow {
    public static final AddMemberWindow INSTANCE = new AddMemberWindow();
    private boolean isInitialized = false;
    private JPanel mainPanel =  new JPanel();
    private JPanel upperHalf =  new JPanel();
    private JPanel middleHalf =  new JPanel();
    private JPanel lowerHalf =  new JPanel();
    private JPanel topPanel =  new JPanel();
    private JPanel middlePanel =  new JPanel();
    private JPanel lowerPanel =  new JPanel();
    private JPanel leftTextPanel1 =  new JPanel();
    private JPanel rightTextPanel1 =  new JPanel();
    private JPanel leftTextPanel2 =  new JPanel();
    private JPanel rightTextPanel2 =  new JPanel();
    private JPanel leftTextPanel3 =  new JPanel();
    private JPanel rightTextPanel3 =  new JPanel();
    private JPanel leftTextPanel4 =  new JPanel();
    private JPanel rightTextPanel4 =  new JPanel();

    private JLabel loginLabel = new JLabel("Add Member");

    private JLabel memberId = new JLabel("Member Id");
    private JTextField idText;
    private JLabel firstName = new JLabel("First Name");
    private JTextField firstNameText;
    private JLabel lastName = new JLabel("Last Name");
    private JTextField lastNameText;
    private JLabel street;
    private JTextField streetText;
    private JLabel city =  new JLabel("City");
    private JTextField cityText;
    private JLabel state;
    private JTextField stateText;
    private JLabel zip;
    private JTextField zipText;
    private JLabel telNumber;
    private JTextField telNumberText;
    private JButton submitButton;
    private JButton backButton;

    private JPanel topText = new JPanel();
    private JPanel bottomText = new JPanel();

    private JPanel topText1 = new JPanel();
    private JPanel bottomText1 = new JPanel();

    public boolean isInitialized() {
        return isInitialized;
    }

    public void isInitialized(boolean val) {
        isInitialized = val;
    }

    private JTextField messageBar = new JTextField();

    private AddMemberWindow() {
    }

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
        //setSize(660, 500);


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

        backButton = new JButton("<= Back to Main");
        backButton.addActionListener(new BackToMainListener());
        lowerHalf.add(backButton);

        lowerHalf.setLayout(new FlowLayout(FlowLayout.RIGHT));

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitListener());
        lowerHalf.add(submitButton);

    }

    private void defineTopPanel() {
        topPanel = new JPanel();
        JPanel intPanel = new JPanel(new BorderLayout());
        intPanel.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
        intPanel.add(loginLabel, BorderLayout.CENTER);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(intPanel);
    }

    private void defineMiddlePanel() {
        middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        defineLeftTextPanel();
        defineRightTextPanel();
        middlePanel.add(leftTextPanel1);
        middlePanel.add(rightTextPanel1);
        middlePanel.add(leftTextPanel2);
        middlePanel.add(rightTextPanel2);
        middlePanel.add(leftTextPanel3);
        middlePanel.add(rightTextPanel3);
        middlePanel.add(leftTextPanel4);
        middlePanel.add(rightTextPanel4);
    }

    private void defineLowerPanel() {
        lowerPanel = new JPanel();
    }

    private void defineLeftTextPanel() {
        topText1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        idText = new JTextField(10);

        memberId.setFont(Util.makeSmallFont(memberId.getFont()));
        topText1.add(memberId);
        bottomText1.add(idText);
        leftTextPanel1.setLayout(new BorderLayout());
        leftTextPanel1.add(topText1, BorderLayout.NORTH);
        leftTextPanel1.add(bottomText1, BorderLayout.CENTER);

        JPanel topText2 = new JPanel();
        JPanel bottomText2 = new JPanel();
        topText2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        firstNameText = new JTextField(10);

        firstName.setFont(Util.makeSmallFont(firstName.getFont()));
        topText2.add(firstName);
        bottomText2.add(firstNameText);
        leftTextPanel2.setLayout(new BorderLayout());
        leftTextPanel2.add(topText2, BorderLayout.NORTH);
        leftTextPanel2.add(bottomText2, BorderLayout.CENTER);
        JPanel topText3 = new JPanel();
        JPanel bottomText3 = new JPanel();
        topText3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        lastNameText = new JTextField(10);

        memberId.setFont(Util.makeSmallFont(lastName.getFont()));
        topText3.add(lastName);
        bottomText3.add(lastNameText);
        leftTextPanel3.setLayout(new BorderLayout());
        leftTextPanel3.add(topText3, BorderLayout.NORTH);
        leftTextPanel3.add(bottomText3, BorderLayout.CENTER);
        JPanel topText4 = new JPanel();
        JPanel bottomText4 = new JPanel();
        topText4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        telNumberText = new JTextField(10);
        telNumber = new JLabel("Telephone Number");
        telNumber.setFont(Util.makeSmallFont(telNumber.getFont()));
        topText4.add(telNumber);
        bottomText4.add(telNumberText);
        leftTextPanel4.setLayout(new BorderLayout());
        leftTextPanel4.add(topText4, BorderLayout.NORTH);
        leftTextPanel4.add(bottomText4, BorderLayout.CENTER);
    }

    private void defineRightTextPanel() {
        rightTextPanel1 = new JPanel();
        rightTextPanel2 = new JPanel();
        rightTextPanel3 = new JPanel();
        rightTextPanel4 = new JPanel();
        //createLabelAndTextField(memberId, idText, "Member Id", leftTextPanel1);
        JPanel topText1 = new JPanel();
        JPanel bottomText1 = new JPanel();
        topText1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        streetText = new JTextField(10);
        street = new JLabel("Street");
        street.setFont(Util.makeSmallFont(street.getFont()));
        topText1.add(street);
        bottomText1.add(streetText);
        rightTextPanel1.setLayout(new BorderLayout());
        rightTextPanel1.add(topText1, BorderLayout.NORTH);
        rightTextPanel1.add(bottomText1, BorderLayout.CENTER);

        //createLabelAndTextField(firstName, firstNameText, "First Name", leftTextPanel2);
        JPanel topText2 = new JPanel();
        JPanel bottomText2 = new JPanel();
        topText2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        cityText = new JTextField(10);

        city.setFont(Util.makeSmallFont(city.getFont()));
        topText2.add(city);
        bottomText2.add(cityText);
        rightTextPanel2.setLayout(new BorderLayout());
        rightTextPanel2.add(topText2, BorderLayout.NORTH);
        rightTextPanel2.add(bottomText2, BorderLayout.CENTER);
        //createLabelAndTextField(lastName, lastNameText, "Last Name", leftTextPanel3);
        JPanel topText3 = new JPanel();
        JPanel bottomText3 = new JPanel();
        topText3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        stateText = new JTextField(10);
        state = new JLabel("State");
        state.setFont(Util.makeSmallFont(state.getFont()));
        topText3.add(state);
        bottomText3.add(stateText);
        rightTextPanel3.setLayout(new BorderLayout());
        rightTextPanel3.add(topText3, BorderLayout.NORTH);
        rightTextPanel3.add(bottomText3, BorderLayout.CENTER);
        //createLabelAndTextField(telNumber, telNumberText, "Telephone Number", leftTextPanel4);
        JPanel topText4 = new JPanel();
        JPanel bottomText4 = new JPanel();
        topText4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        zipText = new JTextField(10);
        zip = new JLabel("Zip Code");
        zip.setFont(Util.makeSmallFont(zip.getFont()));
        topText4.add(zip);
        bottomText4.add(zipText);
        rightTextPanel4.setLayout(new BorderLayout());
        rightTextPanel4.add(topText4, BorderLayout.NORTH);
        rightTextPanel4.add(bottomText4, BorderLayout.CENTER);
    }

    class BackToMainListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            LibrarySystem.hideAllWindows();
            LibrarySystem.INSTANCE.setVisible(true);
        }
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (idText.getText().isBlank() || firstNameText.getText().isBlank() || firstNameText.getText().isBlank() || telNumberText.getText().isBlank()
                    || streetText.getText().isBlank() || cityText.getText().isBlank() || stateText.getText().isBlank() || zipText.getText().isBlank())
                JOptionPane.showMessageDialog(submitButton, "please, fill out all fields");
            else {
                Address address = new Address(streetText.getText(), cityText.getText(), stateText.getText(), zipText.getText());
                ControllerInterface controller = SystemController.getInstance();
                controller.addNewMember(idText.getText(), firstNameText.getText(), lastNameText.getText(), telNumberText.getText(), address);
                JOptionPane.showMessageDialog(submitButton, "new member information submitted");

                resetFields();
            }
        }
    }

    public void resetFields() {
        idText.setText("");
        firstNameText.setText("");
        lastNameText.setText("");
        telNumberText.setText("");
        streetText.setText("");
        cityText.setText("");
        stateText.setText("");
        zipText.setText("");
    }
}
