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
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Event;

public class JPanelWarehouseQuantifier extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea productListSpace;
	private JTextField nameWarehouseField;
	private JLabel totalValueLabel;

	public JPanelWarehouseQuantifier(ActionListener actionListener, String warehouseName) {
		setLayout(new BorderLayout());
		initComponents(actionListener, warehouseName);
	}

	private void initComponents(ActionListener actionListener, String warehouseName) {
		createBackBtnAndTitlePanel(actionListener);
		createGeneralVisorPanel(actionListener, warehouseName);
		createNameWarehouseSpace(actionListener);
	}

	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 25));
		backBtnPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		backBtnPanel.add(new JButtonFormat(actionListener, Event.BTN_BACK_MENU_WAREHOUSE  .name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_NUM_PRODUCTS);
		title.setFont(ConstantsGUI.FONT_SUBTITLE_NUM_PRODUCTS);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createGeneralVisorPanel(ActionListener actionListener, String warehouseName) {
		JPanel generalVisor = new JPanel(new BorderLayout());
		createVisorWarehouse(generalVisor, warehouseName);
		createVisorProduct(generalVisor);
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
		productListSpace.setRows(4);
		productListSpace.setOpaque(false);
		productListSpace.setEditable(false);
		productListSpace.setBorder(null);
		productListSpace.setFont(ConstantsGUI.FONT_MENUS);
		JScrollPane scrollPane = new JScrollPane(productListSpace);
		scrollPane.setBorder(ConstantsGUI.BORDER_AREA_PRODUCTS);
		generalVisor.add(scrollPane, BorderLayout.CENTER);
	}

	private void createDisplayQuantity(JPanel generalVisor) {
		JPanel statusPanel = new JPanel(new GridLayout(2, 1));
		statusPanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		statusPanel.setBorder(ConstantsGUI.BORDER_AREA_FORM_CHAIN);
		JLabel instruction = new JLabel(ConstantsGUI.TEXT_INDEX_QUANTIFIER);
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		instruction.setVerticalAlignment(SwingConstants.CENTER);
		statusPanel.add(instruction);

		totalValueLabel = new JLabel(ConstantsGUI.INITIAL_INDEX_VALUE);
		totalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalValueLabel.setVerticalAlignment(SwingConstants.CENTER);
		statusPanel.add(totalValueLabel);

		generalVisor.add(statusPanel);
	}

	private void createNameWarehouseSpace(ActionListener actionListener) {
		JPanel warehouseNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		warehouseNamePanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		warehouseNamePanel.setBorder(ConstantsGUI.BORDER_ZONE_NAME);

		createDisplayQuantity(warehouseNamePanel);

		nameWarehouseField = new JTextField(18);
		nameWarehouseField.setBorder(BorderFactory.createTitledBorder(null, ConstantsGUI.TEXT_BORDER_JTEXTFIELD_NAME,
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
		warehouseNamePanel.add(nameWarehouseField);

		JButtonFormat btnContinue = new JButtonFormat(actionListener, Event.BTN_QUANTIFIED_PRODUCTS.name(),
				ConstantsGUI.TEXT_BTN_CALCULATE);
		warehouseNamePanel.add(btnContinue);

		add(warehouseNamePanel, BorderLayout.SOUTH);
	}

	public void setProductListSpace(String productList) {
		productListSpace.setText(productList);
	}

	public String getNameWarehouse() {
		return nameWarehouseField.getText();
	}

	public void setTotalQuantifiedProduct(int quantity) {
		totalValueLabel.setText(String.valueOf(quantity));
	}
}