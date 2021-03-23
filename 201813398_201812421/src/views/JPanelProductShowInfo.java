package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Event;

public class JPanelProductShowInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField spaceCodeProduct, nameWarehouseField;
	private JTextArea productInfoSpace;

	public JPanelProductShowInfo(ActionListener actionListener, String nameWarehouse) {
		setLayout(new BorderLayout());
		initComponents(actionListener, nameWarehouse);
	}

	private void initComponents(ActionListener actionListener, String nameWarehouse) {
		createBackBtnAndTitlePanel(actionListener);
		createGeneralVisorPanel(actionListener, nameWarehouse);
		createSpaceAndBtnPanel(actionListener);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel.add(new JButtonFormat(actionListener, Event.BTN_BACK_MENU_WAREHOUSE.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_FIND_PRODUCT);
		title.setFont(ConstantsGUI.FONT_SUBTITLE_FIND_PRODUCT);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createGeneralVisorPanel(ActionListener actionListener, String warehouseName) {
		JPanel generalVisor = new JPanel(new BorderLayout());
		createVisorWarehouse(generalVisor, warehouseName);
		createVisorProduct(generalVisor);
		createNameWarehouseSpace(generalVisor);
		add(generalVisor, BorderLayout.CENTER);
	}

	private void createVisorWarehouse(JPanel generalVisor, String warehouseName) {
		JTextArea warehouseInfo = new JTextArea(warehouseName);
		warehouseInfo.setRows(5);
		warehouseInfo.setOpaque(false);
		warehouseInfo.setEditable(false);
		warehouseInfo.setBorder(null);
		warehouseInfo.setFont(ConstantsGUI.FONT_MENUS);
		JScrollPane scrollPane = new JScrollPane(warehouseInfo);
		scrollPane.setBorder(ConstantsGUI.BORDER_AREA_WAREHOUSES);
		generalVisor.add(scrollPane, BorderLayout.NORTH);
	}

	private void createVisorProduct(JPanel generalVisor) {
		productInfoSpace = new JTextArea();
		productInfoSpace.setRows(4);
		productInfoSpace.setOpaque(false);
		productInfoSpace.setEditable(false);
		productInfoSpace.setFont(ConstantsGUI.FONT_MENUS);
		productInfoSpace.setBorder(ConstantsGUI.BORDER_AREA_PRODUCTS);
		generalVisor.add(productInfoSpace, BorderLayout.CENTER);
	}

	private void createNameWarehouseSpace(JPanel generalVisor) {
		JPanel warehouseNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		JLabel nameWarenHouseLabel = new JLabel(ConstantsGUI.TEXT_NAME_WH_LABEL);
		warehouseNamePanel.add(nameWarenHouseLabel);

		nameWarehouseField = new JTextField(25);
		warehouseNamePanel.add(nameWarehouseField);

		generalVisor.add(warehouseNamePanel, BorderLayout.SOUTH);
	}

	private void createSpaceAndBtnPanel(ActionListener actionListener) {
		JPanel spaceAndButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 25));
		spaceAndButtonPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		spaceCodeProduct = new JTextField(25);
		spaceCodeProduct.setBorder(ConstantsGUI.BORDER_JTEXTFIELD_SEARCH);
		spaceAndButtonPanel.add(spaceCodeProduct);

		JButtonFormat btnContinue = new JButtonFormat(actionListener, Event.BTN_SEARCH_PRODUCTO.name(),
				ConstantsGUI.TEXT_BTN_SEARCH);
		spaceAndButtonPanel.add(btnContinue);

		add(spaceAndButtonPanel, BorderLayout.SOUTH);
	}

	public int getCodeProduct() {
		return Integer.parseInt(spaceCodeProduct.getText());
	}

	public String getWarehouseName() {
		return nameWarehouseField.getText();
	}

	public void setProductInfo(String productInfo) {
		productInfoSpace.setText(productInfo);
	}
}