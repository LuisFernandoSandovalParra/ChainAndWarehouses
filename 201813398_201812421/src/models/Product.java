package models;

public class Product {
	private int code;
	private String nameProduct;
	private int quantity;
	private int unitValue;

	public Product(int code, String name, int quantity, int unitValue) {
		this.code = code;
		this.nameProduct = name;
		this.quantity = quantity;
		this.unitValue = unitValue;
	}

	public Product(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return nameProduct;
	}

	public void setName(String name) {
		this.nameProduct = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(int unitValue) {
		this.unitValue = unitValue;
	}

	@Override
	public String toString() {
		return "Codigo: " + code + " | Nombre producto: " + nameProduct + " | Cantidad: " + quantity + " | Valor(c/u): "
				+ unitValue + "\n";
	}
}