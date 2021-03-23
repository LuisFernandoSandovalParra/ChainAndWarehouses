package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Event;

public class JPanelShowAllProduct extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea productListSpace;
	private JTextField nameWarehouseField;

	public JPanelShowAllProduct(ActionListener actionListener, String WarehouseList) {
		setLayout(new BorderLayout());
		initComponents(actionListener, WarehouseList);
	}

	private void initComponents(ActionListener actionListener, String WarehouseList) {
		createBackBtnAndTitlePanel(actionListener);
		createGeneralVisorPanel(actionListener, WarehouseList);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel.add(
				new JButtonFormat(actionListener, Event.BTN_BACK_MENU_WAREHOUSE.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_ALL_PRODUCT_LIST);
		title.setFont(ConstantsGUI.FONT_ALL_PRODUCT_LIST);
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
		warehouseNamePanel.setBorder(ConstantsGUI.BORDER_SPACE_WH_NAME);
		warehouseNamePanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);

		nameWarehouseField = new JTextField(18);
		nameWarehouseField.setBorder(BorderFactory.createTitledBorder(null, ConstantsGUI.TEXT_BORDER_JTEXTFIELD_NAME,
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
		warehouseNamePanel.add(nameWarehouseField);

		JButtonFormat btnShowProducts = new JButtonFormat(actionListener, Event.BTN_SHOW_PRODUCT_WAREHOUSE_PS.name(),
				ConstantsGUI.BTN_TEXT_SEE);
		warehouseNamePanel.add(btnShowProducts);

		generalVisor.add(warehouseNamePanel, BorderLayout.SOUTH);
	}

	public void setProductListSpaceSAP(String productList) {
		productListSpace.setText(productList);
	}

	public String getNameWarehouseSAP() {
		return nameWarehouseField.getText();
	}
}