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
import javax.swing.border.TitledBorder;

import controller.Event;

public class JPanelDeleteProducts extends JPanel {

	private static final long serialVersionUID = 1037088471184130582L;
	private JTextArea productListSpace;
	private JTextField nameWarehouseField, initCode, lastCode;

	public JPanelDeleteProducts(ActionListener actionListener, String warehouseName) {
		setLayout(new BorderLayout());
		initComponents(actionListener, warehouseName);
	}

	private void initComponents(ActionListener actionListener, String warehouseName) {
		createBackBtnAndTitlePanel(actionListener);
		createGeneralVisorPanel(actionListener, warehouseName);
		createRegisterSpaces(actionListener);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel.add(
				new JButtonFormat(actionListener, Event.BTN_BACK_MENU_WAREHOUSE.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_DELETE_PRODUCT);
		title.setFont(ConstantsGUI.FONT_DELETE_PRODUCT);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createGeneralVisorPanel(ActionListener actionListener, String warehouseName) {
		JPanel generalVisor = new JPanel(new BorderLayout());
		createVisorWarehouse(generalVisor, warehouseName);
		createVisorProduct(generalVisor);
		createSpaceRegister(actionListener, generalVisor);
		add(generalVisor, BorderLayout.CENTER);
	}

	private void createVisorWarehouse(JPanel generalVisor, String warehouseName) {
		JTextArea warehouseInfo = new JTextArea(warehouseName);
		warehouseInfo.setRows(3);
		warehouseInfo.setOpaque(false);
		warehouseInfo.setEditable(false);
		warehouseInfo.setBorder(null);
		warehouseInfo.setFont(ConstantsGUI.FONT_MENUS);
		JScrollPane scrollPane = new JScrollPane(warehouseInfo);
		scrollPane.setBorder(ConstantsGUI.BORDER_AREA_WAREHOUSES);
		generalVisor.add(scrollPane, BorderLayout.NORTH);
	}

	private void createVisorProduct(JPanel generalVisor) {
		productListSpace = new JTextArea();
		productListSpace.setRows(3);
		productListSpace.setOpaque(false);
		productListSpace.setEditable(false);
		productListSpace.setBorder(null);
		productListSpace.setFont(ConstantsGUI.FONT_MENUS);
		JScrollPane scrollPane = new JScrollPane(productListSpace);
		scrollPane.setBorder(ConstantsGUI.BORDER_AREA_PRODUCTS);
		generalVisor.add(scrollPane, BorderLayout.CENTER);
	}

	private void createSpaceRegister(ActionListener actionListener, JPanel generalVisor) {
		JPanel warehouseNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		warehouseNamePanel.setBorder(ConstantsGUI.BORDER_ZONE_NAME);

		nameWarehouseField = new JTextField(18);
		nameWarehouseField.setBorder(BorderFactory.createTitledBorder(null, ConstantsGUI.TEXT_BORDER_JTEXTFIELD_NAME,
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
		warehouseNamePanel.add(nameWarehouseField);

		JButtonFormat btnShowProducts = new JButtonFormat(actionListener, Event.BTN_SHOW_PRODUCTS_DP.name(),
				ConstantsGUI.BTN_TEXT_SEE);
		warehouseNamePanel.add(btnShowProducts);

		generalVisor.add(warehouseNamePanel, BorderLayout.SOUTH);
	}

	public void createRegisterSpaces(ActionListener actionListener) {
		JPanel spacesRegister = new JPanel(new GridLayout(3, 2, 0, 0));
		spacesRegister.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		spacesRegister.setBorder(ConstantsGUI.BORDER_SPACE_REGISTER_DELETE);

		JLabel initCodeLabel = new JLabel(ConstantsGUI.TEXT_INITIAL_CODE);
		spacesRegister.add(initCodeLabel);

		initCode = new JTextField();
		spacesRegister.add(initCode);

		JLabel lastCodeLabel = new JLabel(ConstantsGUI.TEXT_LAST_CODE);
		spacesRegister.add(lastCodeLabel);

		lastCode = new JTextField();
		spacesRegister.add(lastCode);

		JButtonFormat btnRemove = new JButtonFormat(actionListener, Event.BTN_DELETE_RANGE_PRODUCT.name(),
				ConstantsGUI.BTN_TEXT_DELETE_PRODUCT);
		spacesRegister.add(btnRemove);

		add(spacesRegister, BorderLayout.SOUTH);
	}

	public void setProductListSpaceDP(String productList) {
		productListSpace.setText(productList);
	}

	public String getNameWarehouseDP() {
		return nameWarehouseField.getText();
	}

	public int getInitCode() {
		return Integer.parseInt(initCode.getText());
	}

	public int getLastCode() {
		return Integer.parseInt(lastCode.getText());
	}
}