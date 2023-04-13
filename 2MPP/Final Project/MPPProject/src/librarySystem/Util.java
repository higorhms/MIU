package librarySystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class Util {
	public static final Color DARK_BLUE = Color.BLUE.darker();

	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }
	
	public static void adjustLabelFont(JLabel label, Color color, boolean bigger) {
		if(bigger) {
			Font f = new Font(label.getFont().getName(), 
					label.getFont().getStyle(), (label.getFont().getSize()+2));
			label.setFont(f);
		} else {
			Font f = new Font(label.getFont().getName(), 
					label.getFont().getStyle(), (label.getFont().getSize()-2));
			label.setFont(f);
		}
		label.setForeground(color);
		
	}
	/** Sorts a list of numeric strings in natural number order */

	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}
}
