package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JButtonFormat extends JButton{

	private static final long serialVersionUID = 1L;
	public JButtonFormat(ActionListener actionListener, String actionCommand, String text) {
		addActionListener(actionListener);
		setActionCommand(actionCommand);
		setText(text);
		setBackground(Color.LIGHT_GRAY);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
