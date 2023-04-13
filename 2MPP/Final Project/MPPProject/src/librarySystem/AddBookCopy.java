package librarySystem;

import javax.swing.JFrame;
import javax.swing.JPanel;

import business.IController;
import business.SystemController;

public class AddBookCopy extends JFrame implements LibWindow{
	public static final AddBookCopy INSTANCE = new AddBookCopy();
	private AddBookCopy() {}
	@Override
	public void init() {
		JPanel panelbookFields = new JPanel();
		panelbookFields.setLayout(null);	
		this.setTitle("Create Book Copy");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420,420);
		this.setVisible(true);
	}

	@Override
	public boolean isInitialized() {
		return false;
	}

	@Override
	public void isInitialized(boolean val) {
	}
}
