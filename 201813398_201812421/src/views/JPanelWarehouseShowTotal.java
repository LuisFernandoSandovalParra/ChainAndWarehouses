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

public class JPanelWarehouseShowTotal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel totalInventaryValue;
	private JTextField nameWarehouseField;

	public JPanelWarehouseShowTotal(ActionListener actionListener, String warehouseName) {
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
		backBtnPanel.add(
				new JButtonFormat(actionListener, Event.BTN_BACK_MENU_WAREHOUSE.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_TOTAL_INVENTARY_VALUE);
		title.setFont(ConstantsGUI.FONT_TOTAL_INVENTARY_VALUE);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createGeneralVisorPanel(ActionListener actionListener, String warehouseName) {
		JPanel generalVisor = new JPanel(new BorderLayout());
		createVisorWarehouse(generalVisor, warehouseName);
		createDisplayQuantity(generalVisor);
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

	private void createDisplayQuantity(JPanel generalVisor) {
		JPanel statusPanel = new JPanel(new GridLayout(2, 1));
		statusPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25),
				BorderFactory.createEmptyBorder(0, 25, 0, 25)));
		JLabel instruction = new JLabel(ConstantsGUI.TEXT_INSTRUCTION_TOTAL_VALUE_WH);
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		instruction.setVerticalAlignment(SwingConstants.CENTER);
		statusPanel.add(instruction);

		totalInventaryValue = new JLabel(ConstantsGUI.PESOS_SYMBOL + ConstantsGUI.INITIAL_INDEX_VALUE);
		totalInventaryValue.setHorizontalAlignment(SwingConstants.CENTER);
		totalInventaryValue.setVerticalAlignment(SwingConstants.CENTER);
		totalInventaryValue.setFont(ConstantsGUI.FONT_SUBTITLES);
		statusPanel.add(totalInventaryValue);

		generalVisor.add(statusPanel);
	}

	private void createNameWarehouseSpace(ActionListener actionListener) {
		JPanel warehouseNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 25));
		warehouseNamePanel.setBackground(ConstantsGUI.BLUE_CODE_BASE);
		warehouseNamePanel.setBorder(ConstantsGUI.BORDER_ZONE_NAME);

		nameWarehouseField = new JTextField(18);
		nameWarehouseField.setBorder(BorderFactory.createTitledBorder(null, ConstantsGUI.TEXT_BORDER_JTEXTFIELD_NAME,
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
		warehouseNamePanel.add(nameWarehouseField);

		JButtonFormat btnContinue = new JButtonFormat(actionListener, Event.BTN_CALCULATE_INVENTARY_VALUE.name(),
				ConstantsGUI.TEXT_BTN_CALCULATE);
		warehouseNamePanel.add(btnContinue);

		add(warehouseNamePanel, BorderLayout.SOUTH);
	}

	public String getNameWarehouse() {
		return nameWarehouseField.getText();
	}

	public void setTotalInventaryValue(int quantity) {
		totalInventaryValue.setText(ConstantsGUI.PESOS_SYMBOL + String.valueOf(quantity));
	}
}
