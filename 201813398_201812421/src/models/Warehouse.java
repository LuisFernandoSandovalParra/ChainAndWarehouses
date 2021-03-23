package models;

import java.util.Comparator;
import java.util.Iterator;

import structures.DoubleList;

public class Warehouse {
	private DoubleList<Product> inventary;
	private String warehouseName;
	private int inventaryTotalValue;

	public Warehouse(String nameWarehouse, String address) {
		this.inventaryTotalValue = 0;
		this.warehouseName = nameWarehouse;
		this.inventary = new DoubleList<>(new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				return p1.getCode() - p2.getCode();
			}
		}, new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				return p1.getCode() < p2.getCode() ? 0 : 1;
			}

		});
	}

	public Warehouse(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public void addProductInOrder(Product product) {
		inventary.insertInOrder(product);
		insertTotalInventaryValue(product);
	}

	public boolean checkAddProduct(Product product) {
		if (inventary.exist(product)) {
			return false;
		} else {
			addProductInOrder(product);
			return true;
		}
	}

	private void insertTotalInventaryValue(Product product) {
		inventaryTotalValue += product.getUnitValue() * product.getQuantity();
	}

	public Product getProduct(int code) {
		return inventary.getNode(new Product(code)).getValue();
	}

	public int getNumDifferentProduct() {
		return inventary.lengthDoubleList();
	}

	public void registerProductSale(int code, int quantity) throws Exception {
		if (getProduct(code).getQuantity() - quantity < 0) {
			throw new Exception();
		} else {
			this.getProduct(code).setQuantity(getProduct(code).getQuantity() - quantity);
			substractSaleValue(getProduct(code), quantity);
		}
	}

	private void substractSaleValue(Product product, int quantity) {
		inventaryTotalValue -= product.getUnitValue() * quantity;
	}

	public void deleteRangeProduct(int initCode, int lastCode) {
		Iterator<Product> list = inventary.iterator();
		while (list.hasNext()) {
			Product actualProduct = list.next();
			int actualCode = actualProduct.getCode();
			if (actualCode >= initCode && actualCode <= lastCode) {
				inventary.remove(actualProduct);
				substractSaleValue(actualProduct, actualProduct.getQuantity());
			}
		}
	}

	public String showListProduct() {
		return inventary.showForward();
	}

	public String getNameWarehouse() {
		return warehouseName;
	}

	public int getInventaryTotalValue() {
		return inventaryTotalValue;
	}

	@Override
	public String toString() {
		return "Nombre almacen|:  " + warehouseName + "\n";
	}
}