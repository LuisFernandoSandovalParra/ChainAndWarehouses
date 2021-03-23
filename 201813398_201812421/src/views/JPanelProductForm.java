package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Event;

public class JPanelProductForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameWarehouseField, codeProductField, nameProductField, quantityProductField, valueProductField;

	public JPanelProductForm(ActionListener actionListener, String warehouseInfo) {
		setLayout(new BorderLayout());
		initComponents(actionListener, warehouseInfo);
	}

	private void initComponents(ActionListener actionListener, String warehouseInfo) {
		createBackBtnAndTitlePanel(actionListener);
		createFormPanel(warehouseInfo);
		createButtonCreate(actionListener);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel.add(
				new JButtonFormat(actionListener, Event.BTN_BACK_MENU_WAREHOUSE.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_REGISTER_PRODUCT);
		title.setFont(ConstantsGUI.FONT_SUBTITLE_REGISTER_PRODUCT);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createFormPanel(String warehouseInfo) {
		JPanel panelForm = new JPanel(new BorderLayout());

		createVisorWarehouse(panelForm, warehouseInfo);
		createInfoSpaces(panelForm);

		add(panelForm, BorderLayout.CENTER);
	}

	private void createButtonCreate(ActionListener actionListener) {
		JPanel btnRegister = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 25));
		btnRegister.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		JButtonFormat btnCreate = new JButtonFormat(actionListener, Event.BTN_CREATE_PRODUCT.name(),
				ConstantsGUI.TEXT_BTN_REGISTER);
		btnRegister.add(btnCreate);

		add(btnRegister, BorderLayout.SOUTH);
	}

	private void createVisorWarehouse(JPanel panelForm, String warehouseInfo) {
		JTextArea areaMenu = new JTextArea(warehouseInfo);
		areaMenu.setRows(3);
		areaMenu.setOpaque(false);
		areaMenu.setEditable(false);
		areaMenu.setBorder(null);
		areaMenu.setFont(ConstantsGUI.FONT_MENUS);
		JScrollPane scrollPane = new JScrollPane(areaMenu);
		scrollPane.setBorder(ConstantsGUI.BORDER_AREA_WAREHOUSES);
		panelForm.add(scrollPane, BorderLayout.NORTH);
	}

	private void createInfoSpaces(JPanel panelForm) {
		JPanel panelInfoSpaces = new JPanel(new GridLayout(5, 2));
		panelInfoSpaces.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));
		JLabel nameWarenHouseLabel = new JLabel(ConstantsGUI.TEXT_NAME_WH_LABEL);
		panelInfoSpaces.add(nameWarenHouseLabel);

		nameWarehouseField = new JTextField();
		panelInfoSpaces.add(nameWarehouseField);

		JLabel codeProductLabel = new JLabel(ConstantsGUI.TEXT_CODE_PR_LABEL);
		panelInfoSpaces.add(codeProductLabel);

		codeProductField = new JTextField();
		panelInfoSpaces.add(codeProductField);

		JLabel nameProductLabel = new JLabel(ConstantsGUI.TEXT_NAME_PR_LABEL);
		panelInfoSpaces.add(nameProductLabel);

		nameProductField = new JTextField();
		panelInfoSpaces.add(nameProductField);

		JLabel quantityProductLabel = new JLabel(ConstantsGUI.TEXT_QUANTITY_PR_LABEL);
		panelInfoSpaces.add(quantityProductLabel);

		quantityProductField = new JTextField();
		panelInfoSpaces.add(quantityProductField);

		JLabel valueProductLabel = new JLabel(ConstantsGUI.TEXT_VALUE_PR_LABEL);
		panelInfoSpaces.add(valueProductLabel);

		valueProductField = new JTextField();
		panelInfoSpaces.add(valueProductField);

		panelForm.add(panelInfoSpaces, BorderLayout.CENTER);
	}

	public String getNameWarehouseField() {
		return nameWarehouseField.getText();
	}

	public int getCodeProductField() {
		return Integer.parseInt(codeProductField.getText());
	}

	public String getNameProductField() {
		return nameProductField.getText();
	}

	public int getQuantityProductField() {
		return Integer.parseInt(quantityProductField.getText());
	}

	public int getValueProductField() {
		return Integer.parseInt(valueProductField.getText());
	}
}