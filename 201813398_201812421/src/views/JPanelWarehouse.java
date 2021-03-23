package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Event;

public class JPanelWarehouse extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField spaceOptionWarehouse;

	public JPanelWarehouse(ActionListener actionListener) {
		setLayout(new BorderLayout());
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createBackBtnAndTitlePanel(actionListener);
		createMenuArea();
		createSpaceAndBtnPanel(actionListener);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel
				.add(new JButtonFormat(actionListener, Event.BTN_BACK_MAIN_PANEL.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_WAREHOUSE);
		title.setFont(ConstantsGUI.FONT_SUBTITLES);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createMenuArea() {
		JTextArea areaMenu = new JTextArea(ConstantsGUI.STRING_MENU_WAREHOUSE);
		areaMenu.setOpaque(false);
		areaMenu.setEditable(false);
		areaMenu.setFont(ConstantsGUI.FONT_MENUS);
		areaMenu.setBorder(ConstantsGUI.BORDER_AREA_MENU_WAREHOUSE);
		add(areaMenu, BorderLayout.CENTER);
	}

	private void createSpaceAndBtnPanel(ActionListener actionListener) {
		JPanel spaceAndButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 25));
		spaceAndButtonPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		spaceOptionWarehouse = new JTextField(25);
		spaceOptionWarehouse.setBorder(ConstantsGUI.BORDER_JTEXTFIELD_OPTIONS);
		spaceAndButtonPanel.add(spaceOptionWarehouse);

		JButtonFormat btnContinue = new JButtonFormat(actionListener, Event.BTN_WAREHOUSE_CONTINUE.name(),
				ConstantsGUI.TEXT_BTN_CONTINUE);
		spaceAndButtonPanel.add(btnContinue);

		add(spaceAndButtonPanel, BorderLayout.SOUTH);
	}

	public int getSpaceOptionWarehouse() {
		return Integer.parseInt(spaceOptionWarehouse.getText());
	}
}