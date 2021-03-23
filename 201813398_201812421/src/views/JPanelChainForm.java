package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Event;

public class JPanelChainForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameField, addressField;

	public JPanelChainForm(ActionListener actionListener) {
		setLayout(new BorderLayout());
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createBackBtnAndTitlePanel(actionListener);
		createFormularyPanel();
		createButtonCreate(actionListener);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 115, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel
				.add(new JButtonFormat(actionListener, Event.BTN_BACK_MENU_CHAIN.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_REGISTER_WAREHOUSE);
		title.setFont(ConstantsGUI.FONT_REGISTE_WAREHOUSE);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createFormularyPanel() {
		JPanel formularyPanel = new JPanel(new GridLayout(2, 2, 5, 25));
		formularyPanel.setBorder(ConstantsGUI.BORDER_AREA_FORM_CHAIN);
		JLabel nameLabel = new JLabel(ConstantsGUI.TEXT_CHAIN_NAME_LABEL);
		formularyPanel.add(nameLabel);

		nameField = new JTextField();
		formularyPanel.add(nameField);

		JLabel addressLabel = new JLabel(ConstantsGUI.TEXT_CHAIN_ADDRESS_LABEL);
		formularyPanel.add(addressLabel);

		addressField = new JTextField();
		formularyPanel.add(addressField);

		add(formularyPanel, BorderLayout.CENTER);
	}

	private void createButtonCreate(ActionListener actionListener) {
		JPanel btnCreatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 25));
		btnCreatePanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		JButtonFormat btnCreate = new JButtonFormat(actionListener, Event.BTN_CHAIN_CREATE.name(),
				ConstantsGUI.TEXT_BTN_CREATE);
		btnCreatePanel.add(btnCreate);

		add(btnCreatePanel, BorderLayout.SOUTH);
	}

	public String getNameChainForm() {
		return nameField.getText();
	}

	public String getAddressChainForm() {
		return addressField.getText();
	}
}