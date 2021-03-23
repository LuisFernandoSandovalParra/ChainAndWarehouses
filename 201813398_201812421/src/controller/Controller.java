package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Chain;
import models.Product;
import models.Warehouse;
import views.JMainFrame;

public class Controller implements ActionListener {
	
	private Chain chain;
	private JMainFrame mainFrame;

	public Controller() {
		chain = new Chain();
		burnedData(chain);
		mainFrame = new JMainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case BTN_CHAIN:
			mainFrame.createPanelChain(this);
			break;
		case BTN_WAREHOUSE:
			mainFrame.createPanelWarehouse(this);
			break;
		case BTN_BACK_MAIN_PANEL:
			mainFrame.createPanelMain(this);
			break;
		case BTN_CHAIN_CONTINUE:
			createChainContinue();
			break;
		case BTN_BACK_MENU_CHAIN:
			mainFrame.createPanelChain(this);
			break;
		case BTN_CHAIN_CREATE:
			createWarehouse();
			break;
		case BTN_WAREHOUSE_CONTINUE:
			createWarehouseContinue();
			break;
		case BTN_BACK_MENU_WAREHOUSE:
			mainFrame.createPanelWarehouse(this);
			break;
		case BTN_CREATE_PRODUCT:
			createProduct();
			break;
		case BTN_SEARCH_PRODUCTO:
			searchProductInfo();
			break;
		case BTN_QUANTIFIED_PRODUCTS:
			showNumDifferentProduct();
			break;
		case BTN_CALCULATE_INVENTARY_VALUE:
			showTotalInvetaryValue();
			break;
		case BTN_SHOW_PRODUCTS_PS:
			showProductsPS();
			break;
		case BTN_REGISTER_SOLD_PRODUCT:
			registerSoldProduct();
			break;
		case BTN_DELETE_RANGE_PRODUCT:
			deleteRangeProduct();
			break;
		case BTN_SHOW_PRODUCTS_DP:
			showProductsDP();
			break;
		case BTN_SHOW_PRODUCT_WAREHOUSE_PS:
			showProductPerWarehouse();
		default:
			break;
		}
	}

	private void createChainContinue() {
		try {
			switch (mainFrame.getSpaceOptionChain()) {
			case 1:
				mainFrame.createPanelChainForm(this);
				break;
			case 2:
				mainFrame.createPanelChainStats(this, chain.getTotalWarehouseValue());
				break;
			default:
				JOptionPane.showMessageDialog(null, ConstantsCNT.INVALID_OPTION);
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.INPUT_ONLY_NUMBERS);
		}
	}

	private void createWarehouse() {
		if (chain
				.checkCreationWarehouse(new Warehouse(mainFrame.getNameChainForm(), mainFrame.getAddressChainForm()))) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.PROCESS_SUCCESSFUL_CREATION);
			mainFrame.createPanelChain(this);
		} else {
			JOptionPane.showMessageDialog(null, ConstantsCNT.WAREHOUSE_ALREADY_EXIST);
			mainFrame.createPanelChain(this);
		}

	}

	private void createWarehouseContinue() {
		try {
			switch (mainFrame.getSpaceOptionWarehouse()) {
			case 1:
				mainFrame.createPanelProductForm(this, chain.showListWarehouse());
				break;
			case 2:
				mainFrame.createPanelProductInfo(this, chain.showListWarehouse());
				break;
			case 3:
				mainFrame.createPanelQuantifiedProduct(this, chain.showListWarehouse());
				break;
			case 4:
				mainFrame.createPanelShowTotalInventary(this, chain.showListWarehouse());
				break;
			case 5:
				mainFrame.createPanelProductSold(this, chain.showListWarehouse());
				break;
			case 6:
				mainFrame.createPanelDeleteProduct(this, chain.showListWarehouse());
				break;
			case 7:
				mainFrame.createPanelShowAllProduct(this, chain.showListWarehouse());
				break;
			default:
				JOptionPane.showMessageDialog(null, ConstantsCNT.INVALID_OPTION);
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.INPUT_ONLY_NUMBERS);
		}

	}

	private void createProduct() {
		try {
			if (chain.checkAddProduct(new Warehouse(mainFrame.getNameWarehouseField()),
					new Product(mainFrame.getCodeProductField(), mainFrame.getNameProductField(),
							mainFrame.getQuantityProductField(), mainFrame.getValueProductField()))) {
				JOptionPane.showMessageDialog(null, ConstantsCNT.PROCESS_SUCCESSFUL_CREATION);
				mainFrame.createPanelWarehouse(this);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCNT.CODE_PRODUCT_ALREADY_EXIST);
				mainFrame.createPanelWarehouse(this);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.INPUT_ONLY_NUMBERS);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.PROCESS_FAILED_CREATION);
		}

	}

	private void searchProductInfo() {
		try {
			mainFrame
					.setProductInfo(chain.showProduct(mainFrame.getNameWarehouseProduct(), mainFrame.getCodeProduct()));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.INPUT_ONLY_NUMBERS);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.NOT_FOUND_PRODUCT);
		}
	}

	private void showNumDifferentProduct() {
		try {
			mainFrame.setProductListSpaceWQ(chain.showListProduct(mainFrame.getNameWarehouseQF()));
			mainFrame.setTotalQuantifiedProduct(chain.getNumDifferentProduct(mainFrame.getNameWarehouseQF()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.INPUT_NAME_WAREHOUSE);
		}

	}

	private void showTotalInvetaryValue() {
		try {
			mainFrame.setTotalInventaryValue(chain.getTotalInventaryWhValue(mainFrame.getNameWarehouseSTI()));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.WAREHOUSE_NOT_EXIST);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showProductsPS() {
		try {
			mainFrame.setProductListSpacePS(chain.showListProduct(mainFrame.getNameWarehousePS()));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.PRODUCTS_NOT_EXIST);
		}
	}

	private void registerSoldProduct() {
		try {
			chain.registerProductSale(new Warehouse(mainFrame.getNameWarehousePS()), mainFrame.getCodeProductFieldPS(),
					mainFrame.getQuantityProductFieldPS());
			showProductsPS();
			JOptionPane.showMessageDialog(null, ConstantsCNT.SOLD_HAS_REGISTER_SUCCESSFUL);
			mainFrame.createPanelWarehouse(this);
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.PRODUCT_DONT_EXIST);
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.INPUT_ONLY_NUMBERS);
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.QUANTITY_NOT_AVAILABLE);
		}
	}

	private void deleteRangeProduct() {
		try {
			int confirm = JOptionPane.showConfirmDialog(null, ConstantsCNT.MESSAGE_CONFIRM_ACTION,
					"ELIMINAR PRODUCTO", JOptionPane.YES_NO_OPTION);
			chain.deleteRangeProduct(mainFrame.getNameWarehouseDP(), mainFrame.getInitCode(), mainFrame.getLastCode());
			switch (confirm) {
			case 0: {
				showProductsDP();
				JOptionPane.showMessageDialog(null, ConstantsCNT.PROCESS_SUCCESSFUL);
				mainFrame.createPanelWarehouse(this);
				break;
			}
			default:
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.INPUT_ONLY_NUMBERS);
		}

	}

	private void showProductsDP() {
		try {
			mainFrame.setProductListSpaceDP(chain.showListProduct(mainFrame.getNameWarehouseDP()));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.PRODUCTS_NOT_EXIST);
		}
	}
	

	private void showProductPerWarehouse() {
		try {
			mainFrame.setProductListSpaceSAP(chain.showListProduct(mainFrame.getNameWarehouseSAP()));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.WAREHOUSE_NOT_EXIST);
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCNT.PRODUCTS_NOT_EXIST);
		}
	}
	
	private void burnedData(Chain chain) {
		chain.checkCreationWarehouse(new Warehouse("Makro", "Carrera 2 #5-46"));
		chain.checkCreationWarehouse(new Warehouse("Olimpica", "Diag 4ta, calle 80"));
		chain.checkCreationWarehouse(new Warehouse("Carrefour", "Carrera 10 #4b-52"));
		chain.checkCreationWarehouse(new Warehouse("Metro", "Calle 5 #12-43e"));
		chain.checkCreationWarehouse(new Warehouse("Alkosto", "Avda circunvalar 2A"));
		chain.checkCreationWarehouse(new Warehouse("Katronix", "Carrera 6 #12-45 Sur"));
		chain.checkCreationWarehouse(new Warehouse("Viva", "Calle 52 # 12C-32"));
		chain.checkAddProduct(new Warehouse("makro"), new Product(2, "Sal", 20, 1000));
		chain.checkAddProduct(new Warehouse("makro"), new Product(1, "Arroz", 20, 1200));
		chain.checkAddProduct(new Warehouse("makro"), new Product(4, "Menudo", 10, 2800));
		chain.checkAddProduct(new Warehouse("makro"), new Product(7, "Frijol", 20, 1100));
		chain.checkAddProduct(new Warehouse("makro"), new Product(3, "Azucar", 25, 900));
		chain.checkAddProduct(new Warehouse("makro"), new Product(15, "Huevos", 70, 350));
		chain.checkAddProduct(new Warehouse("makro"), new Product(21, "Mojarra", 15, 8000));
		chain.checkAddProduct(new Warehouse("Olimpica"), new Product(1, "Arroz", 20, 1250));
		chain.checkAddProduct(new Warehouse("Olimpica"), new Product(2, "Sal", 10, 1100));
		chain.checkAddProduct(new Warehouse("Olimpica"), new Product(3, "Azucar", 30, 850));
		chain.checkAddProduct(new Warehouse("Olimpica"), new Product(17, "Aceite", 12, 3500));
	}
}