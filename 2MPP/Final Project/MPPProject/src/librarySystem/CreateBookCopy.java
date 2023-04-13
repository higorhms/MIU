package librarySystem;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.IController;
import business.SystemController;

public class CreateBookCopy extends JFrame implements LibWindow {

	public static final CreateBookCopy INSTANCE = new CreateBookCopy();
    IController ci = new SystemController();
	private boolean isInitialized = false;
	
	private JTextField txtISBN, txtCopyNumber;
	@Override
	public void init() {
		JPanel panelCreateCopyField = new JPanel();
		panelCreateCopyField.setLayout(null);
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setBounds(20,20,100,20);
		
		txtISBN = new JTextField(10);
		txtISBN.setBounds(110,20,100,20);
		
		JLabel lblCopyNumber = new JLabel("Copy Number:");
		lblCopyNumber.setBounds(20,50,100,20);
		
		txtCopyNumber = new JTextField(10);
		txtCopyNumber.setBounds(110,50,100,20);
		
		JPanel pnlButtonSave = new JPanel();
		
		JButton btnSave = new JButton("Save");
		addCreateCopyButtonListener(btnSave) ;
		
		JButton btnBacktoMain = new JButton("<< Back to Main");
		addBackButtonListener(btnBacktoMain);
		
		pnlButtonSave.add(btnBacktoMain);
		pnlButtonSave.add(btnSave);
		pnlButtonSave.setBounds(20, 100, 360, 35);
		pnlButtonSave.setBackground(Color.green);
		
		panelCreateCopyField.add(lblISBN);
		panelCreateCopyField.add(txtISBN);
		
		panelCreateCopyField.add(lblCopyNumber);
		panelCreateCopyField.add(txtCopyNumber);
		
		panelCreateCopyField.add(pnlButtonSave, BorderLayout.CENTER);
		
		
		 this.setTitle("Create Book Copy");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(420,220);
			this.setVisible(true);
			this.add(panelCreateCopyField);
	}

	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		});
	}
	
	private void addCreateCopyButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			
			if(txtISBN.getText().trim().equals("") || txtCopyNumber.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this,"Required Fields can not be left empty","Save Failed", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				ci.addCopyOfBook(txtISBN.getText().trim());
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,e.getMessage(),"Save Failed", JOptionPane.ERROR_MESSAGE);
			}
			
			txtISBN.setText("");
			txtCopyNumber.setText(getName());
			
			JOptionPane.showMessageDialog(this,"Save successful");	
		});
	}
	
	@Override
	public boolean isInitialized() {
		return false;
	}

	@Override
	public void isInitialized(boolean val) {
		
	}

}
