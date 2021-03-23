package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Event;

public class JMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanelChain panelChain;
	private JPanelChainForm panelChainForm;
	private JPanelWarehouse panelWarehouse;
	private JPanelProductForm panelProductForm;
	private JPanelProductShowInfo panelProductShowInfo;
	private JPanelWarehouseQuantifier panelWarehouseQuantifier;
	private JPanelWarehouseShowTotal panelWarehouseShowTotal;
	private JPanelProductSold panelProductSold;
	private JPanelDeleteProducts panelDeleteProducts;
	private JPanelShowAllProduct panelShowAllProduct;

	public JMainPanel(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBackground(ConstantsGUI.BLUE_CODE_BASE);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createMainFirstPanel(actionListener);
	}

	public void createMainFirstPanel(ActionListener actionListener) {
		removeAll();
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));

		JButtonFormat btnChain = new JButtonFormat(actionListener, Event.BTN_CHAIN.name(), ConstantsGUI.TEXT_BTN_CHAIN);
		buttonsPanel.add(btnChain);

		JButtonFormat btnWarehouse = new JButtonFormat(actionListener, Event.BTN_WAREHOUSE.name(),
				ConstantsGUI.TEXT_BTN_WAREHOUSE);
		buttonsPanel.add(btnWarehouse);

		add(buttonsPanel, BorderLayout.NORTH);
		
		JLabel mainImage = new JLabel(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_IMG_MAIN_IMAGE)));
		add(mainImage, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public void createPanelChain(ActionListener actionListener) {
		removeAll();
		add(panelChain = new JPanelChain(actionListener), BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public int getSpaceOptionChain() {
		return panelChain.getSpaceOptionChain();
	}

	public void createPanelChainForm(ActionListener actionListener) {
		removeAll();
		add(panelChainForm = new JPanelChainForm(actionListener));
		revalidate();
		repaint();
	}

	public String getNameChainForm() {
		return panelChainForm.getNameChainForm();
	}

	public String getAddressChainForm() {
		return panelChainForm.getAddressChainForm();
	}

	public void createPanelChainStats(ActionListener actionListener, int totalChainValue) {
		removeAll();
		add(new JPanelChainStats(actionListener, totalChainValue));
		revalidate();
		repaint();
	}

	public void createPanelWarehouse(ActionListener actionListener) {
		removeAll();
		add(panelWarehouse = new JPanelWarehouse(actionListener));
		revalidate();
		repaint();
	}

	public int getSpaceOptionWarehouse() {
		return panelWarehouse.getSpaceOptionWarehouse();
	}

	public void createPanelProductForm(ActionListener actionListener, String warehouseInfo) {
		removeAll();
		add(panelProductForm = new JPanelProductForm(actionListener, warehouseInfo));
		revalidate();
		repaint();
	}

	public String getNameWarehouseField() {
		return panelProductForm.getNameWarehouseField();
	}

	public int getCodeProductField() {
		return panelProductForm.getCodeProductField();
	}

	public String getNameProductField() {
		return panelProductForm.getNameProductField();
	}

	public int getQuantityProductField() {
		return panelProductForm.getQuantityProductField();
	}

	public int getValueProductField() {
		return panelProductForm.getValueProductField();
	}

	public void createPanelProductInfo(ActionListener actionListener, String nameWarehouse) {
		removeAll();
		add(panelProductShowInfo = new JPanelProductShowInfo(actionListener, nameWarehouse));
		revalidate();
		repaint();
	}

	public int getCodeProduct() {
		return panelProductShowInfo.getCodeProduct();
	}

	public String getNameWarehouseProduct() {
		return panelProductShowInfo.getWarehouseName();
	}

	public void setProductInfo(String productInfo) {
		panelProductShowInfo.setProductInfo(productInfo);
	}

	public void createPanelQuantifiedProduct(ActionListener actionListener, String warehouseName) {
		removeAll();
		add(panelWarehouseQuantifier = new JPanelWarehouseQuantifier(actionListener, warehouseName));
		revalidate();
		repaint();
	}

	public void setProductListSpaceWQ(String productList) {
		panelWarehouseQuantifier.setProductListSpace(productList);
	}

	public String getNameWarehouseQF() {
		return panelWarehouseQuantifier.getNameWarehouse();
	}

	public void setTotalQuantifiedProduct(int quantity) {
		panelWarehouseQuantifier.setTotalQuantifiedProduct(quantity);
	}

	public void createPanelShowTotalInventary(ActionListener actionListener, String warehouseName) {
		removeAll();
		add(panelWarehouseShowTotal = new JPanelWarehouseShowTotal(actionListener, warehouseName));
		revalidate();
		repaint();
	}

	public String getNameWarehouseSTI() {
		return panelWarehouseShowTotal.getNameWarehouse();
	}

	public void setTotalInventaryValue(int quantity) {
		panelWarehouseShowTotal.setTotalInventaryValue(quantity);
	}

	public void createPanelProductSold(ActionListener actionListener, String warehouseName) {
		removeAll();
		add(panelProductSold = new JPanelProductSold(actionListener, warehouseName));
		revalidate();
		repaint();
	}

	public void setProductListSpacePS(String productList) {
		panelProductSold.setProductListSpace(productList);
	}

	public String getNameWarehousePS() {
		return panelProductSold.getNameWarehouse();
	}

	public int getCodeProductFieldPS() {
		return panelProductSold.getCodeProductField();
	}

	public int getQuantityProductFieldPS() {
		return panelProductSold.getQuantityProductField();
	}

	public void createPanelDeleteProduct(ActionListener actionListener, String warehouseName) {
		removeAll();
		add(panelDeleteProducts = new JPanelDeleteProducts(actionListener, warehouseName));
		revalidate();
		repaint();
	}

	public void setProductListSpaceDP(String productList) {
		panelDeleteProducts.setProductListSpaceDP(productList);
	}

	public String getNameWarehouseDP() {
		return panelDeleteProducts.getNameWarehouseDP();
	}

	public int getInitCode() {
		return panelDeleteProducts.getInitCode();
	}

	public int getLastCode() {
		return panelDeleteProducts.getLastCode();
	}

	public void createPanelShowAllProduct(ActionListener actionListener, String warehouseList) {
		removeAll();
		add(panelShowAllProduct = new JPanelShowAllProduct(actionListener, warehouseList));
		revalidate();
		repaint();
	}

	public void setProductListSpaceSAP(String productList) {
		panelShowAllProduct.setProductListSpaceSAP(productList);
	}

	public String getNameWarehouseSAP() {
		return panelShowAllProduct.getNameWarehouseSAP();
	}
}