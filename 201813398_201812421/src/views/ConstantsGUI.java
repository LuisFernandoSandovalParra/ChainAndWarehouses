package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ConstantsGUI {
	
	//	General
	public static final Color BLUE_CODE_BASE = Color.decode("#C4E6FF");
	public static final String PATH_IMG_MAIN_IMAGE = "/img/mainImage.png";
	
	// JMainFrame
	public static final String TITLE_FRAME = "CADENA DE ALMACENES";
	public static final int HEIGHT_FRAME = 400;
	public static final int WIDTH_FRAME = 500;
	public static final String PATH_IMG_ICON = "/img/mainIcon.png";
	
	// JMainPanel
	public static final String TEXT_BTN_WAREHOUSE = "Almacen";
	public static final String TEXT_BTN_CHAIN = "Cadena";
	
	// JPanelChain
	public static final TitledBorder BORDER_JTEXTFIELD_JPC = BorderFactory.createTitledBorder(null,
			"Ingrese el numero de la opcion deseada", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
	public static final String STRING_MENU_CHAIN = "Escriba el numero de opcion deseada y pulse 'Continue'. \n \n  1. Crear un nuevo almacen. \n  2. Visualizar valor total del inventario (todos los almacenes).";
	public static final CompoundBorder BORDER_AREA_MENU_CHAIN = BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(0, 25, 0, 25),
			BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "MENU CADENA"));
	public static final String CONTINUE_BTN_CHAIN = "Continue";
	public static final Font FONT_SUBTITLES = new Font("Roboto", Font.BOLD, 25);
	public static final String TEXT_SUBTITLE_CHAIN = "CADENA";
	public static final String BACK_TEXT_BTN = "Atras";
	public static final Font FONT_MENUS = new Font("Roboto", Font.PLAIN, 13);
	
	// JPanelChainForm
	public static final Font FONT_REGISTE_WAREHOUSE = new Font("Roboto", Font.BOLD, 16);
	public static final String SUBTITLE_REGISTER_WAREHOUSE = "REGISTRAR ALMACEN";
	public static final String TEXT_BTN_CREATE = "Crear";
	public static final String TEXT_CHAIN_ADDRESS_LABEL = "Direccion nuevo almacen:";
	public static final String TEXT_CHAIN_NAME_LABEL = "Nombre nuevo almacen:";
	public static final CompoundBorder BORDER_AREA_FORM_CHAIN = BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(25, 25, 25, 25), BorderFactory.createEmptyBorder(25, 25, 25, 25));

	// JPanelChainStats
	public static final Font FONT_TOTAL_VALUE_CHAIN = new Font("Roboto", Font.BOLD, 20);
	public static final String SUBTITLE_TOTAL_VALUE_CHAIN = "VALOR TOTAL";
	public static final String PESOS_SYMBOL = "$ ";
	public static final String TEXT_INSTRUCTION_TOTAL_VALUE_CHAIN = "Valor total del inventario de la cadena";
	
	// JPanelWarehouse
	public static final TitledBorder BORDER_JTEXTFIELD_OPTIONS = BorderFactory.createTitledBorder(null,
			"Ingrese el numero de la opcion deseada", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
	public static final String TEXT_BTN_CONTINUE = "Continue";
	public static final String SUBTITLE_WAREHOUSE = "ALMACEN";
	public static final String STRING_MENU_WAREHOUSE = "Escriba el numero de opcion deseada y pulse 'Continue'. \n \n  1. Registrar un nuevo producto. \n  2. Ver info de producto (por codigo) \n  3. Ver numero de productos registrados. \n  4. Ver valor total de productos (por almacen).  \n  5. Registrar venta de producto.  \n  6. Eliminar productos (rango de codigos).  \n  7. Ver lista de productos por almacen. ";
	public static final CompoundBorder BORDER_AREA_MENU_WAREHOUSE = BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(0, 25, 0, 25),
			BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "MENU ALMACEN"));

	// JPanelProductForm
	public static final Font FONT_SUBTITLE_REGISTER_PRODUCT = new Font("Roboto", Font.BOLD, 20);
	public static final String SUBTITLE_REGISTER_PRODUCT = "REGISTRAR PRODUCTO";
	public static final String TEXT_VALUE_PR_LABEL = "Valor(c/u): (Ej: 500)";
	public static final String TEXT_QUANTITY_PR_LABEL = "Cantidad producto: (Ej: 123...)";
	public static final String TEXT_NAME_PR_LABEL = "Nombre producto:";
	public static final String TEXT_CODE_PR_LABEL = "Codigo producto: (Ej: 123...)";
	public static final String TEXT_NAME_WH_LABEL = "Nombre almacen:";
	public static final String TEXT_BTN_REGISTER = "Registrar";
	public static final CompoundBorder BORDER_AREA_WAREHOUSES = BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(0, 25, 0, 25),
			BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Almacenes"));
	public static final String SUBTITLE_PRODUCT = "PRODUCTO";
	
	// JPanelProductShowInfo
	public static final Font FONT_SUBTITLE_FIND_PRODUCT = new Font("Roboto", Font.BOLD, 20);
	public static final String SUBTITLE_FIND_PRODUCT = "BUSCAR PRODUCTO";
	public static final TitledBorder BORDER_JTEXTFIELD_SEARCH = BorderFactory.createTitledBorder(null,
			"Ingrese el codigo del producto que busca", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
	public static final String TEXT_BTN_SEARCH = "Buscar";
	public static final CompoundBorder BORDER_AREA_PRODUCTS = BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(0, 25, 0, 25),
			BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Producto"));
	
	// JPanelWarehouseQuantifier
	public static final Font FONT_SUBTITLE_NUM_PRODUCTS = new Font("Roboto", Font.BOLD, 20);
	public static final String SUBTITLE_NUM_PRODUCTS = "NUMERO DE PRODUCTOS";
	public static final String TEXT_BTN_CALCULATE = "Calcular";
	public static final String TEXT_BORDER_JTEXTFIELD_NAME = "Ingrese el nombre de almacen";
	public static final EmptyBorder BORDER_ZONE_NAME = new EmptyBorder(0, 2, 0, 20);
	public static final String INITIAL_INDEX_VALUE = "0";
	public static final String TEXT_INDEX_QUANTIFIER = "Productos";
	
	// JPanelWarehouseShowTotal
	public static final String TEXT_INSTRUCTION_TOTAL_VALUE_WH = "Valor total";
	public static final Font FONT_TOTAL_INVENTARY_VALUE = new Font("Roboto", Font.BOLD, 18);
	public static final String SUBTITLE_TOTAL_INVENTARY_VALUE = "VALOR TOTAL INVENTARIO";
	
	// JPanelProductSold
	public static final String BTN_TEXT_REGISTER_SALE = "Registrar venta";
	public static final EmptyBorder BORDER_SPACE_REGISTER_SALE = new EmptyBorder(0, 50, 25, 50);
	public static final Font FONT_SUBTITLE_REGISTER_SALE = new Font("Roboto", Font.BOLD, 20);
	public static final String SUBTITLE_REGISTER_SALE = "REGISTRAR VENTA";
	
	// JPanelDeleteProducts
	public static final String BTN_TEXT_SEE = "Ver";
	public static final EmptyBorder BORDER_SPACE_REGISTER_DELETE = new EmptyBorder(0, 50, 25, 50);
	public static final String BTN_TEXT_DELETE_PRODUCT = "Eliminar";
	public static final String TEXT_LAST_CODE = "Codigo final: ";
	public static final String TEXT_INITIAL_CODE = "Codigo inicial: ";
	public static final Font FONT_DELETE_PRODUCT = new Font("Roboto", Font.BOLD, 20);
	public static final String SUBTITLE_DELETE_PRODUCT = "ELIMINAR PRODUCTO";
	
	//JPanelShowAllProducts
	public static final EmptyBorder BORDER_SPACE_WH_NAME = new EmptyBorder(0, 50, 25, 50);
	public static final Font FONT_ALL_PRODUCT_LIST = new Font("Roboto", Font.BOLD, 20);
	public static final String SUBTITLE_ALL_PRODUCT_LIST = "LISTA DE PRODUCTOS";
}
